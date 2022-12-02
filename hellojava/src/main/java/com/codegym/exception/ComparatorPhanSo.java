package com.codegym.exception;

import java.util.Comparator;

public class ComparatorPhanSo implements Comparator<PhanSo> {

    @Override
    public int compare(PhanSo o1, PhanSo o2) {
        ToanHoc toanHoc = new ToanHoc();
        int bcnn = toanHoc.timBoiChungNhoNhat(o1.getMauSo(), o2.getMauSo());
        if (bcnn / o1.getMauSo() * o1.getTuSo() > bcnn / o2.getMauSo() * o2.getTuSo()) {
            return 1;
        }else{
            if (bcnn / o1.getMauSo() * o1.getTuSo() == bcnn / o2.getMauSo() * o2.getTuSo()) {
                return 0;
            }else{
                return -1;
            }
        }
    }
}
