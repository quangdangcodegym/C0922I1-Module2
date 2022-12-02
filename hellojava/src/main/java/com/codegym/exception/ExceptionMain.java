package com.codegym.exception;

import javax.annotation.processing.FilerException;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileReader;

public class ExceptionMain {
    public static void main(String[] args) {
//        int[] arr = {2, 5, 6};
//        System.out.println(arr[5]);

//        try {
//            int a[] = new int[5];
//            a[10] = 30 / 0;
//            System.out.println("AAAAAA");
//
//
//            //Có cả ngàn dong
//
//        }
//        catch (Exception exception) {
//            System.out.println(exception.getMessage());
//        }


        System.out.println(ketNoiDatabase());



//        File file = new
//                File("D:\\CODEGYM\\CODEGYM\\Module2\\C0922I1\\hellojava\\data\\ngoctrinh.jpg");
//
//        FileReader fileReader = new FileReader(file);
    }

    public static String ketNoiDatabase() {
        try {

            // mo ket noi
            // truy van ....
            //Có cả ngàn dong
            return "ketqua: Phuoc dep trai";
        }
        catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        finally {

            System.out.println("Dong ket noi");
            return "ketqua: Phuoc xau trai";
        }

    }

}
