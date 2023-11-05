package animals;

public class Pet extends Animal {
    private String[] commands;

    public Pet(String name, String birthDate, String[] commands) {
        super(name, birthDate);
        this.commands = commands;
    }

    public String[] getCommands() {
        return commands;
    }

    public void addCommand(String newCommand) {
        String[] updatedCommands = new String[commands.length + 1];
        System.arraycopy(commands, 0, updatedCommands, 0, commands.length);
        updatedCommands[commands.length] = newCommand;
        commands = updatedCommands;
    }
}
