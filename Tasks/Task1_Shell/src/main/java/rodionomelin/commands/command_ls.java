package rodionomelin.commands;

import rodionomelin.Command;
import rodionomelin.Main;



public class command_ls implements Command {
    @Override
    public void exec(String... args) {
        String[] files = Main.CommandPrompt.getCurrentDirectory().list();
        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}
