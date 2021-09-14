package service;

import java.io.File;
import java.util.Scanner;

public class InputService {
    public static String getInputPath(Scanner scanner){
        System.out.println("Please, enter path to directory or txt file:");
        boolean isFilePathCorrect = false;
        String filePath = null;
        while (!isFilePathCorrect){
            if (scanner.hasNextLine()) {
                filePath = scanner.nextLine();
                File file = new File(filePath);
                if (file.exists()) {
                    isFilePathCorrect = true;
                } else {
                    System.out.println("There is no such directory or file. Try again!");
                }
            }
        }
        return filePath;
    }
}
