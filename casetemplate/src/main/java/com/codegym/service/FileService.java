package com.codegym.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    public void writeData(String path, List<String> list) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (String line : list) {
                // 1670310571,Iphone 12,12000.0,5,1
                bufferedWriter.write(line + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
    public List<String> readData(String path) {
        List<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine())!=null) {
                lines.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return lines;
    }
}
