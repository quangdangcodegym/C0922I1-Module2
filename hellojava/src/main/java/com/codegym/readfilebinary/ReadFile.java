package com.codegym.readfilebinary;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileVisitResult;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("D:\\CODEGYM\\CODEGYM\\Module2\\C0922I1\\hellojava\\data\\aa.txt");

//        int read = -1;
//        String str = "";
//        while ( (read = fileReader.read()) != -1){
//            str += (char) read;
//        }
//        System.out.println(str);



        char[] chars = new char[20];
        String str1 = "";
        int number = -1;
        while ((number = fileReader.read(chars)) != -1) {
            for (int i = 0; i < number; i++) {
                str1 += chars[i];
            }
        }
        System.out.println(str1);


    }
}
