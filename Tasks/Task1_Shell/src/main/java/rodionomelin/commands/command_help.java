package rodionomelin.commands;

import rodionomelin.Command;
import rodionomelin.commandParser;

public class command_help implements Command {
    @Override
    public void exec(String... args) {
        if (args.length > 0) {
            String commandDesc = commandParser.getCommandDesc(args[0]);
            if (commandDesc != null) {
                System.out.println(commandDesc);
            } else {
                System.out.println("Несуществующая команда");
            }
        } else {
            System.out.println("Не указана команда");
        }
    }
}
