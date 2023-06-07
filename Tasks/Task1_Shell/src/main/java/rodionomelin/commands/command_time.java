package rodionomelin.commands;

import rodionomelin.Command;

import java.time.LocalTime;

public class command_time implements Command {
    @Override
    public void exec(String... args) {
        System.out.println(LocalTime.now());
    }
}
