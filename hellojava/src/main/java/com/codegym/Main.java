package com.codegym;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


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