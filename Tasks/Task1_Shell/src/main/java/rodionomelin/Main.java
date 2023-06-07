package rodionomelin;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CommandPrompt commandPrompt = new CommandPrompt();
        commandPrompt.init();
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

        private void init() {
            Scanner scan = new Scanner(System.in);
            while (true) {
                System.out.print(">");

                String input_string = scan.nextLine();

                String[] input_string_split = input_string.split("\\s+");

                String[] args;
                if (input_string_split.length > 1) {
                    String string_of_args = input_string.substring(input_string_split[0].length()).trim();
                    args = string_of_args.split(",");
                } else {
                    args = new String[0];
                }
                executeCommand(input_string_split[0], args);
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