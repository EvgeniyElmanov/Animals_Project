package main;

import animals.Animal;
import animals.Pet;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nДомашний зоорегистр");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Вывести список команд для животного");
            System.out.println("3. Обучить новой команде");
            System.out.println("4. Вывести список животных по дате рождения");
            System.out.println("5. Вывести общее количество животных");
            System.out.println("6. Выйти");

            System.out.print("Выберите опцию (1/2/3/4/5/6): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистить буфер после ввода числа

            switch (choice) {
                case 1:
                    addNewAnimal(registry, scanner);
                    break;
                case 2:
                    listCommandsForAnimal(registry, scanner);
                    break;
                case 3:
                    teachNewCommandToAnimal(registry, scanner);
                    break;
                case 4:
                    listAnimalsByBirthDate(registry);
                    break;
                case 5:
                    showTotalAnimalCount(registry);
                    break;
                case 6:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        }
    }

    private static void addNewAnimal(AnimalRegistry registry, Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения животного: ");
        String birthDate = scanner.nextLine();
        System.out.print("Является ли животное домашним питомцем? (да/нет): ");
        String isPet = scanner.nextLine().toLowerCase();

        if (isPet.equals("да")) {
            System.out.print("Введите команды, разделенные запятой (например, сидеть,лежать): ");
            String commandsInput = scanner.nextLine();
            String[] commands = commandsInput.split(",");
            Pet pet = new Pet(name, birthDate, commands);
            registry.addAnimal(pet);
        } else {
            Animal animal = new Animal(name, birthDate);
            registry.addAnimal(animal);
        }

        System.out.println("Животное добавлено в реестр.");
    }

    private static void listCommandsForAnimal(AnimalRegistry registry, Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        registry.listCommandsForAnimal(name);
    }

    private static void teachNewCommandToAnimal(AnimalRegistry registry, Scanner scanner) {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите новую команду для обучения: ");
        String newCommand = scanner.nextLine();
        registry.teachNewCommand(name, newCommand);
    }

    private static void listAnimalsByBirthDate(AnimalRegistry registry) {
        System.out.println("Вывод списка животных по дате рождения.");
        List<Animal> sortedAnimals = registry.getAnimalsSortedByBirthDate();
        for (Animal animal : sortedAnimals) {
            System.out.println("Имя: " + animal.getName() + ", Дата рождения: " + animal.getBirthDate());
        }
    }

    private static void showTotalAnimalCount(AnimalRegistry registry) {
        int totalAnimals = registry.getTotalAnimalCount();
        System.out.println("Общее количество животных в реестре: " + totalAnimals);
    }
}

