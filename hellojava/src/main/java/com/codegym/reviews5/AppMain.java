package com.codegym.reviews5;

import java.util.ArrayList;
import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        /**
         String[] list = new String[2];
         list[0] = "Quang";
         list[1] = "Y";
         // list[2] = thêm ở đây thì lỗi
         **/
        // ArrayList lưu được danh sách mà có thể trùng lăp
        List<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        list1.add("Quang");
        list1.add("Y");
        list1.add("Toan");

        boolean check = false;
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
            if (list1.get(i).equals("Khoa")) {
                System.out.println("Tìm thấy ở vị trí thứ" + i);
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Khong tim thay");
        }

    }
}
