package rodionomelin;

import java.io.File;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        CommandPrompt commandPrompt = new CommandPrompt();
        commandPrompt.start();
    }

    public static class CommandPrompt {
        private final commandParser commandParser;
        private static File currentDirectory;



        public static File getCurrentDirectory() {
            return currentDirectory;
        }

        public static void setCurrentDirectory(File newDirectory) {
            currentDirectory = newDirectory;
        }


        public CommandPrompt() {
            commandParser = new commandParser();
            executeCommand("commands");
            currentDirectory = new File(System.getProperty("user.dir"));
        }

        private void start() {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print(">");
                String line = scanner.nextLine();
                String[] parts = line.split("\\s+");
                String[] args = parts.length > 1
                        ? line.substring(parts[0].length()).trim().split(",")
                        : new String[0];
                executeCommand(parts[0], args);
            }
        }

        private void executeCommand(String commandName, String... args) {
            Command command = commandParser.getCommand(commandName);
            if (command != null) {
                command.exec(args);
            } else {
                System.out.println("Неверная команда.");
            }
        }
    }


}