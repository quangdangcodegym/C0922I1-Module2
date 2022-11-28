package com.codegym.reviews3.caua;

import java.util.ArrayList;
import java.util.List;

public class ThongDichVien{
    List<ISayHello> ngoaiNgus;

    public void hocNgoaiNguChina() {
        // Di hoc ngoai ngu
        ISayHello chinaHello = new ChinaHello();
        ngoaiNgus.add(chinaHello);
    }
    public void hocNgoaiNguVietnamese() {
        // Di hoc ngoai ngu
        ISayHello vietNamHello = new VietNamHello();
        ngoaiNgus.add(vietNamHello);
    }
    public void showSkill() {
        for (ISayHello c : ngoaiNgus) {
            System.out.println(c.hello());
        }
    }

    public ThongDichVien() {
        ngoaiNgus = new ArrayList<>();
    }
    public static void main(String[] args) {
        ThongDichVien thongDichVien = new ThongDichVien();
        thongDichVien.hocNgoaiNguChina();
        thongDichVien.hocNgoaiNguVietnamese();


        thongDichVien.showSkill();
    }

}
