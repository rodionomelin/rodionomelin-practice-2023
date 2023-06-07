package rodionomelin.commands;

import rodionomelin.Command;
import rodionomelin.commandParser;

public class command_commands implements Command {
    @Override
    public void exec(String... args) {
        System.out.println("Доступные комманды:\n" + String.join(", \n", commandParser.getCommands()) + ".");
    }
}
