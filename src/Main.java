import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File output = new File("data/outputFile.txt");
        saveDirectoryTreeIntoFile(output);
    }
// переделать код, чтобы в одну программу можно было передать или путь к директории или путь к файлу

    private static void saveDirectoryTreeIntoFile(File outputFile) {
        System.out.println("Please, enter path to directory:");
        Scanner scanner = new Scanner(System.in);
        String filepath = getDirectoryPath(scanner);
        scanner.close();
        File file = new File(filepath);
        try (PrintStream outputStream = new PrintStream(new FileOutputStream(outputFile))){
            outputStream.println(file.getName());
            printAllFiles(outputStream, Objects.requireNonNull(file.listFiles()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getDirectoryPath(Scanner scanner){
        boolean isFilePathCorrect = false;
        String filePath = null;
        while (!isFilePathCorrect){
            if (scanner.hasNextLine()) {
                filePath = scanner.nextLine();
                File file = new File(filePath);
                if (file.exists() && file.isDirectory()) {
                    isFilePathCorrect = true;
                } else {
                    System.out.println("There is no such directory. Try again!");
                }
            }
        }
        return filePath;
    }

    public static void printAllFiles(PrintStream printStream, File[] files){
        for (File f : files){
            if (f.isDirectory()){
                printStream.println("   |-----" + f.getName());
                printAllFiles(printStream, Objects.requireNonNull(f.listFiles()));
            }else {
                printStream.println("   |     " + f.getName());
            }
        }
        printStream.println("   |");
    }

    public static void printDirectoryInformationFromFile(File file){
        int directories = 0;
        int files = 0;
        List<String> filesList = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));){
            while (bufferedReader.ready()){
                lines.add(bufferedReader.readLine());
            }
            for (String line : lines){
                if (line.contains("-----")){
                    directories ++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
