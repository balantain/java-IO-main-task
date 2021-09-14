import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Please, enter path to directory or file:");
        Scanner scanner = new Scanner(System.in);
        String filepath = getFilePath(scanner);
        scanner.close();
        File file = new File(filepath);
        File output = new File("data/outputFile.txt");
        if (file.isDirectory()){
            try(PrintStream outputStream = new PrintStream(new FileOutputStream(output))){
                outputStream.println(file.getName());
                printAllFiles(outputStream, file.listFiles());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("   |     " + file.getName());// - переписать
        }
    }
    public static String getFilePath(Scanner scanner){
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
    public static void printAllFiles(PrintStream printStream, File[] files){
        for (File f : files){
            if (f.isDirectory()){
                printStream.println("   |-----" + f.getName());
                printAllFiles(printStream, f.listFiles());
                printStream.println();
            }else {
                printStream.println("   |     " + f.getName());
            }
        }
    }
}
