package com.codegym.task.task31.task3110;

import com.codegym.task.task31.task3110.command.ExitCommand;
import com.codegym.task.task31.task3110.exception.Chat;
import com.codegym.task.task31.task3110.exception.NoSuchZipFileException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalLong;


public class Archiver {
    static final boolean DEBUG = false;

    public static void main(String[] args) {
        Operation operation = null;

        Map<Integer, Chat> chatMap = new HashMap<>();
        chatMap.put(1, new Chat(1, "Anton", 5));
        chatMap.put(2, new Chat(2, "Eugene", 15));
        chatMap.put(3, new Chat(3, "Shavkat", 9));


        System.out.println(chatMap);

        chatMap.get(2).setTestStep(16);

        System.out.println(chatMap);
        System.out.println();



        do {
            try {
                operation = askOperation();
                CommandExecutor.execute(operation);
            } catch (NoSuchZipFileException e) {
                ConsoleHelper.writeMessage("You didn't select an archive or you selected an invalid file.");
            } catch (Exception e) {
                ConsoleHelper.writeMessage("An error occurred. Please check the entered data.");
            }
        } while (operation != Operation.EXIT);

    }

    public static Operation askOperation() throws IOException {
        ConsoleHelper.writeMessage("Select an operation:");
        ConsoleHelper.writeMessage(Operation.CREATE.ordinal() + "- Zip files into an archive");
        ConsoleHelper.writeMessage(Operation.ADD.ordinal() + "- Add a file to an archive");
        ConsoleHelper.writeMessage(Operation.REMOVE.ordinal() + "- Remove a file from an archive");
        ConsoleHelper.writeMessage(Operation.EXTRACT.ordinal() + "- Extract an archive");
        ConsoleHelper.writeMessage(Operation.CONTENT.ordinal() + "- View the contents of an archive");
        ConsoleHelper.writeMessage(Operation.EXIT.ordinal() + "- Exit");

        int selected = ConsoleHelper.readInt();

        for (Operation operation: Operation.values()
             ) {
            if ( operation.ordinal() == selected) {
                return operation;
            }
        }
        return null;
    }
}
