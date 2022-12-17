package com.codegym;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Main implements Serializable{
    public static List<String> fileReader (String filePath){
        FileReader fileReader = null;
        List<String> lines = new ArrayList<>();
        try {
            fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static void writeFile (String filePath, List<String> list){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            for (String line : list){
                fileWriter.write(line+"\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ObjectOutputStream objectInputStream;



    }
    public static void docFileNhiPhan() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./data/ngoctrinh1.jpeg");

            FileOutputStream fileOutputStream = new FileOutputStream("./data/nhiphan4.jpeg");

            byte[] nBytes = new byte[10];
            int count = -1;
            while ((count = fileInputStream.read(nBytes)) != -1) {
                for (int i = 0; i < count; i++) {
                    fileOutputStream.write(nBytes[i]);
                }
            }

            fileOutputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static byte[] intToBytes( final int i ) {
        ByteBuffer bb = ByteBuffer.allocate(4);
        bb.putInt(i);
        return bb.array();
    }
    public static void docFileVanBan() {
        String filePath = "D:\\CODEGYM\\CODEGYM\\Module2\\C0922I1\\readfile\\readfile\\data\\numbers.txt";
        List<String> lines = fileReader(filePath);
        int sum = 0;
        for (String line : lines){
            sum += Integer.parseInt(line);
        }
        lines.add(sum+"");

        writeFile(filePath,lines);
    }
}