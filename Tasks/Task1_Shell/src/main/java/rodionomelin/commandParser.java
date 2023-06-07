package rodionomelin;

import rodionomelin.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class commandParser {
    private static Map<String, Command> commandMap;
    private static Map<String, String> commandDescMap;

    public commandParser() {
        commandMap = new HashMap<>();
        commandMap.put("time", new command_time());
        commandMap.put("date", new command_date());
        commandMap.put("ls", new command_ls());
        commandMap.put("cd", new command_cd());
        commandMap.put("help", new command_help());
        commandMap.put("commands", new command_commands());
        commandMap.put("exit", new command_exit());

        commandDescMap = new HashMap<>();
        commandDescMap.put("time", "Выводит текущее Время");
        commandDescMap.put("date", "Выводит текущую Дату");
        commandDescMap.put("ls", "Печатает список всех фалов в директории");
        commandDescMap.put("cd", "Меняет нынешнюю директорию на указанную");
        commandDescMap.put("help", "Печатает описание указанной команды");
        commandDescMap.put("commands", "Печатает список всех доступных команд");
        commandDescMap.put("exit", "Завершает работу программы");
    }

    public Command getCommand(String commandString) {
        return commandMap.get(commandString);
    }

    public static String getCommandDesc(String commandString) {
        return commandDescMap.get(commandString);
    }

    public static Set<String> getCommands() {
        return commandMap.keySet();
    }
}
