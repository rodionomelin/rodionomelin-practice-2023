package rodionomelin.commands;

import rodionomelin.Command;
import rodionomelin.Main;

import java.io.File;

public class command_cd implements Command {
    @Override
    public void exec(String... args) {
        if (args.length > 0) {
            File newDirectory;
            if ("..".equals(args[0])) {
                newDirectory = Main.CommandPrompt.getCurrentDirectory().getParentFile();
            } else {
                newDirectory = new File(Main.CommandPrompt.getCurrentDirectory(), args[0]);
            }

            if (newDirectory.exists() && newDirectory.isDirectory()) {
                Main.CommandPrompt.setCurrentDirectory(newDirectory);
                System.out.println("Смена директории на " + args[0]);
            } else {
                System.out.println("Указанная директория не существует");
            }
        } else {
            System.out.println("Не указана директория");
        }
    }
}
