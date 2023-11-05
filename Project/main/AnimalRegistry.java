package main;

import animals.Animal;
import animals.Pet;

import java.util.ArrayList;
import java.util.List;

public class AnimalRegistry {
    private List<Animal> animals;
    private int totalAnimalCount;

    public AnimalRegistry() {
        animals = new ArrayList<>();
        totalAnimalCount = 0;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        totalAnimalCount++;
    }

    public int getTotalAnimalCount() {
        return totalAnimalCount;
    }

    public void listCommandsForAnimal(String name) {
        Animal animal = findAnimalByName(name);
        if (animal instanceof Pet) {
            Pet pet = (Pet) animal;
            String[] commands = pet.getCommands();
            System.out.println("Команды для " + name + ":");
            for (String command : commands) {
                System.out.println(command);
            }
        } else {
            System.out.println("Животное не найдено или не является домашним питомцем.");
        }
    }

    private Animal findAnimalByName(String name) {
      return null;
    }

    public void teachNewCommand(String name, String newCommand) {
        Animal animal = findAnimalByName(name);
        if (animal instanceof Pet) {
            Pet pet = (Pet) animal;
            pet.addCommand(newCommand);
            System.out.println(name + " выучил(а) новую команду: " + newCommand);
        } else {
            System.out.println("Животное не найдено или не является домашним питомцем.");
        }
    }

    public List<Animal> getAnimalsSortedByBirthDate() {
        animals.sort((a1, a2) -> a1.getBirthDate().compareTo(a2.getBirthDate()));
        return animals;
    }
}
