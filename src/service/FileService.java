package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public static void printDirectoryInformationFromFile(File file){
        List<String> directories = new ArrayList<>();
        List<String> files = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));){
            while (bufferedReader.ready()){
                lines.add(bufferedReader.readLine());
            }
            for (String line : lines){
                if (line.contains("   |-----")){
                    directories.add(line.substring(9));
                }
                if (line.contains("   |     ")){
                    files.add(line.substring(9));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        double averageFilenameLength = 0;
        int totalFilenameLength = 0;
        for (String filename : files){
            totalFilenameLength += filename.length();
        }
        averageFilenameLength = (double) totalFilenameLength / files.size();
        System.out.println("There are " + directories.size() + " directories");
        System.out.println("There are " + files.size() + " files");
        System.out.println("Average quantity of files in the folder is " + (files.size() / directories.size()));
        System.out.println("Average length of filename is " + averageFilenameLength);
    }
}
