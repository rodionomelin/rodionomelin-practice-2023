package rodionomelin.commands;

import rodionomelin.Command;

public class command_exit implements Command {
    @Override
    public void exec(String... args) {
        System.out.println("Завершение работы программы...");
        System.exit(0);
    }
}
