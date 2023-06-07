package rodionomelin.commands;

import rodionomelin.Command;

import java.time.LocalDate;

public class command_date implements Command {
    @Override
    public void exec(String... args) {
        System.out.println(LocalDate.now());
    }
}
