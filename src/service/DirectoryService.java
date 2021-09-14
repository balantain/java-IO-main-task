package service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Objects;

public class DirectoryService {
    public static void saveDirectoryTreeIntoFile(File directory, File outputFile) {
        try (PrintStream outputStream = new PrintStream(new FileOutputStream(outputFile))){
            outputStream.println(directory.getName());
            printAllFiles(outputStream, Objects.requireNonNull(directory.listFiles()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void printAllFiles(PrintStream printStream, File[] files){
        for (File f : files){
            if (f.isDirectory()){
                printStream.println("   |-----" + f.getName());
                printAllFiles(printStream, Objects.requireNonNull(f.listFiles()));
                printStream.println("   |");
            }else {
                printStream.println("   |     " + f.getName());
            }
        }
    }
}
