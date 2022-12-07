package com.codegym;

import java.io.*;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<String> studentLines = readData("./data/student.txt");

        List<Student> students = convertStudentLinesToStudents(studentLines);
        showStudents(students);

        System.out.println("Them hoc sinh: ");
        System.out.println("Nhap ID: ");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Nhap ten: ");
        String name = scanner.nextLine();
        Student s = new Student();
        s.setId(id);
        s.setName(name);

        students.add(s);
        saveStudents(students);

        //      Viết chức năng sửa tên của học sinh
        //      Viết chức năng xóa học sinh theo ID
        //      Viết chức năng sắp xếp học sinh theo tên

    }


    public static void saveStudents(List<Student> students) {
        List<String> studentLines = convertStudentsToStudentLines(students);
        writeData("./data/student.txt", studentLines);

    }
    public static void showStudents(List<Student> students) {
        String tieude = String.format("%-10s|  %-20s", "ID", "Fullname");
        System.out.println(tieude);
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
    public static List<Student> convertStudentLinesToStudents(List<String> studentLines) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentLines.size(); i++) {
            String line = studentLines.get(i);  // line: 1,Toan
            String[] items = line.split(","); // items: ["1","Toan"]
            Student s = new Student();
            s.setId(Long.parseLong(items[0]));
            s.setName(items[1]);

            students.add(s);
        }
        return students;
    }

    public static List<String> convertStudentsToStudentLines(List<Student> students) {
        List<String> studentLines = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            String line = students.get(i).getId() + "," + students.get(i).getName();
            studentLines.add(line);
        }
        return studentLines;
    }

    public static void writeData(String path, List<String> lines) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                if (i != lines.size()-1) {
                    line += "\n";
                }
                bufferedWriter.write(line);
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
    public static List<String> readData(String path) {
        List<String> strLines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                strLines.add(line);
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return strLines;
    }

    public static void baitapStack() {
        Stack<Double> nganXep = new Stack<>();
        nganXep.push(5.0);
        nganXep.push(8.0);
        nganXep.push(10.0);
        for (int i = 0; i < nganXep.size(); i++) {
            System.out.println(nganXep.get(i));
        }
        System.out.println(nganXep.pop());  // 10
        System.out.println(nganXep.peek()); //8
        System.out.println(nganXep.pop()); //8
        System.out.println(nganXep.pop()); //5

        int[] numbers = {5, 1, 6, 9};
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            st.push(numbers[i]);
        }
        // st [5 -> 6 -> 1-> 9]
        int vitri = 0;
        while (!st.isEmpty()) {
            numbers[vitri] = st.pop();
            vitri++;
        }
        System.out.println(Arrays.toString(numbers));
    }

    public static void danhsachCoBan() {
        System.out.println("Hello world!");
        List<String> ds = new ArrayList<>();

        ds.add("Quang");
        ds.add("Toàn");
        ds.add("Ý");
        ds.add("Long");


        for (int i = 0; i < ds.size(); i++) {
            if (ds.get(i).equals("Toàn")) {
                //vi tri tai i
                ds.remove(i);
                break;
            }
        }

        System.out.println(Arrays.toString(ds.toArray()));
    }
}