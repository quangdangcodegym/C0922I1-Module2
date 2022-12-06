package com.codegym.characterfile;

import java.io.*;

public class MainCharacterFile {
    public static void main(String[] args) {
        try {

            FileReader fileReader = new FileReader("./data/c10.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            char[] cbuff = new char[5];
            int count = -1;
            String strContent = "";
            while ((count = bufferedReader.read(cbuff, 0, cbuff.length)) != -1) {
                for (int i = 0; i < count; i++) {
                    strContent += cbuff[i];
                }
            }
            System.out.println(strContent);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.getMessage();
        } catch (IOException ioException) {
            ioException.getMessage();
        }
    }

    public static void docTheoBufferReader() {
        try {

            FileReader fileReader = new FileReader("D:\\CODEGYM\\CODEGYM\\Module2\\C0922I1\\hellojava\\data\\c10.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            String fileContent = "";
            while ((line = bufferedReader.readLine()) != null) {
                fileContent += line + "\n";
            }
            System.out.println(fileContent);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.getMessage();
        } catch (IOException ioException) {
            ioException.getMessage();
        }
    }
    public static void docTheoBoDemLuongKiTu(){
        try {
        FileReader fileReader = new FileReader("D:\\CODEGYM\\CODEGYM\\Module2\\C0922I1\\hellojava\\data\\c10.txt");

        String strFile = "";
        char[] cbuff = new char[2];
        int count = -1;
        while ( (count = fileReader.read(cbuff)) != -1) {
            for (int i = 0; i < count; i++) {
                strFile += (char) cbuff[i];
            }
        }
        System.out.println(strFile);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.getMessage();
        } catch (IOException ioException) {
            ioException.getMessage();
        }
    }
    public static void docTungKiTu() {
        try {
            FileReader fileReader = new FileReader("D:\\CODEGYM\\CODEGYM\\Module2\\C0922I1\\hellojava\\data\\c10.txt");

            int item = -1;
            String strFile = "";
            while ( (item = fileReader.read()) != -1) {
                strFile += (char) item;
            }
            System.out.println(strFile);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.getMessage();
        } catch (IOException ioException) {
            ioException.getMessage();
        }
    }
}
