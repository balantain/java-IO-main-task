package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileService {
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
