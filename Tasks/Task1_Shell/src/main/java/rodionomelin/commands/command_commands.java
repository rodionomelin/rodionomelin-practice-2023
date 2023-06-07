package rodionomelin.commands;

import rodionomelin.Command;
import rodionomelin.commandParser;

public class command_commands implements Command {
    @Override
    public void exec(String... args) {
        System.out.println("Доступные комманды:");
        for (String command : commandParser.getCommands()) {
            System.out.println(command);
        }
    }
}
