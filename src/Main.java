import service.DirectoryService;
import service.FileService;
import service.InputService;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File(InputService.getInputPath(scanner));
        scanner.close();

        if (file.isDirectory()){
            File output = new File("data/outputFile.txt");
            DirectoryService.saveDirectoryTreeIntoFile(file, output);
        }
        else {
            FileService.printDirectoryInformationFromFile(file);
        }
    }
}
