package com.codegym;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static int max = 10;
    public static int min  = 1;

    public static void main(String[] args) {

        int a;
//        double[] numbers = {5.0, 7, 1, 7};
//        double[] numbers1 = new double[5];
//        double [] numbers2;

        // Tìm tìm số 5 có nằm trong mảng hay không
        System.out.println("Nhap so dòng: ");
        int row = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap so cột: ");
        int col = Integer.parseInt(scanner.nextLine());
        int [][] arr = createArrayTwoWay(row, col);
        System.out.println(printArrayTwoWay(arr));




    }

    public static String printArrayTwoWay(int[][] arr) {
        String str = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                str += arr[i][j];
                if (j != arr[i].length - 1) {
                    str += ",";
                }
            }
            str += "\n";
        }
        return str;
    }
    public static int[][] createArrayTwoWay(int nRow, int nCol) {
        int [][] arr = new int[nRow][nCol];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) ((Math.random() * (max - min)) + min);
            }
        }
        return arr;
    }

    public static void reverseArrayView() {
        System.out.println("Nhap so luong phan tu cua mang");
        int number = scanner.nextInt();
        int [] arr = createRandomArray(number);
        System.out.println(printArray(arr));

//        int [] arr1 = reverseArray1(arr);
        reverseArray(arr);

        System.out.println(printArray(arr));
    }
    public static int[] reverseArray1(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }
    public static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
    public static void findIndexView() {
        System.out.println("Nhap so luong phan tu cua mang");
        int number = scanner.nextInt();
        int [] arr = createRandomArray(number);
        System.out.println(printArray(arr));


        System.out.println("Tìm gia tri tron mảng trả về vị trí");
        System.out.println("Nhập giá tri cần tìm: ");
        int value = scanner.nextInt();
        System.out.println(findIndex(arr, value));
    }
    public static void createArrayView() {
        System.out.println("Nhap so luong phan tu cua mang");
        int number = scanner.nextInt();
        int [] arr = createRandomArray(number);
        System.out.println(printArray(arr));
    }


    public static int findIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
    public static String printArray(int[] arr) {
        String str = "[";
        for (int i = 0; i < arr.length; i++) {
            str += arr[i] ;
            if (i == arr.length - 1) {
                str += "]";
            }else{
                str +=  ",";
            }
        }
        return str;

    }
    public static int[] createRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i< numbers.length; i++) {
            numbers[i] =  (int) ((Math.random() * (max - min)) + min);
        }
        return numbers;
    }

    public static void totalPrimeView() {
        System.out.printf("Tỉnh tống %d só nguyên tố đầu tiên " + 5);
        int numberMax = scanner.nextInt();
        int sum = 0;
        int count = 0;
        int i = 2;
        while (i < numberMax) {
            if(checkPrimeNumber(i)){
                sum += i;
                System.out.println(i);
                count++;
            }
            if (count == 5) {
                break;
            }
            i++;
        }
        System.out.println("Sum: " + sum);
    }
    public static void printPrimeLessThanNumberView() {
        System.out.println("Nhap vao so: ");
        int number = scanner.nextInt();
        // [2,3,5,7]
        int i = 2;
        String str = "";
        for (; i < number; i++) {
            if (checkPrimeNumber(i)) {
                str += i + ",";
            }
        }
        // str = 2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,
        System.out.println(str.substring(0,str.length()-1));
        // O a d o
        System.out.println("oa".compareTo("Oa"));;

    }
    public static boolean checkPrimeNumber(int number) {
        boolean flag = true;
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;

    }
    public static void checkPrimiter1() {
        int number = scanner.nextInt();
        // Kiểm tra nguyen to
        // number = 15
        if (number < 2) {
            System.out.println(number + " Khong phai la so nguyen to");
        }else {
            if (number == 2) {
                System.out.printf("%d la so nguyen to", number);
            }
        }
        // 97
        for(int i = 2 ; i<number; i++){
            if (number % i == 0) {
                System.out.println(number + " Khong phai la so nguyen to");
                break;
            }
            if (i == number - 1) {
                System.out.printf("%d la so nguyen to", number);
            }
        }
    }
    // Bài 1
    public static void getMonth() {
        System.out.println("Nhập tháng: ");
        int month = scanner.nextInt();
        switch (month) {
            case 2:
                System.out.println("Thang co 29 ngay");
                break;
            case 1, 3, 5, 7, 8, 10, 12:
                System.out.println("Thang co 31 ngay");
                break;
            default:
                System.out.println("Thang co 30 ngay");
        }
    }

    // Bài 2
    public static void tinhchisocannang() {
        System.out.println("Nhap can nang: ");
        float cannang = scanner.nextFloat();
        System.out.println("Nhap chieu cao: ");
        float chieucao = scanner.nextFloat();
        float bmi = cannang / chieucao*chieucao;
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (18.5 <= bmi && bmi<25) {
            System.out.println("normal");
        } else if (25 <= bmi && bmi <30) {
            System.out.println("Overweight");
        } else if(bmi >= 30) {
            System.out.println("Obese");
        }
    }

    // Bai 3
    public static void chuyendoitiente() {
        float rate = 23000f;
        int usd;
        do{
            System.out.println("Nhap USD: ");
            usd = scanner.nextInt();
            if (usd <= -1) {
                System.out.println("Số không hợp lệ");
            } else if (usd > 1000000) {
                System.out.println("Số không hợp lệ");
            } else {
                System.out.println("Số tiền VND là" + rate * usd);
            }

        } while (usd<=-1 || usd > 1000000);
    }
}