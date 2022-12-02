package com.codegym.exception;

import java.util.ArrayList;
import java.util.List;

public class PhanSoMain {
    public static void main(String[] args) {

        try {

            PhanSo ps1 = new PhanSo(1, 2);
            PhanSo ps2 = new PhanSo(3, 4);

            PhanSo ps3 = new PhanSo(1, 3);
            PhanSo ps4 = new PhanSo(1, 5);
            PhanSo ps5 = new PhanSo(1, 9);

            List<PhanSo> phanSos = new ArrayList<>();
            phanSos.add(ps1);
            phanSos.add(ps2);
            phanSos.add(ps3);
            phanSos.add(ps4);
            phanSos.add(ps5);



        } catch (MauSoException mauSoException) {
            mauSoException.getMessage();
        }
    }

    public static int findIndexInArray(List<PhanSo> phanSos, PhanSo ps) {
        for (int i = 0; i < phanSos.size(); i++) {
            if (phanSos.get(i).equals(ps)) {
                return i;
            }
        }
        return -1;
    }
    public static void sapXepPhanSo(List<PhanSo> phanSos) {
        inDanhSachPhanSo(phanSos);
        phanSos.sort(new ComparatorPhanSo());
        inDanhSachPhanSo(phanSos);
    }
    public static void inDanhSachPhanSo(List<PhanSo> phanSos) {
        for (PhanSo ps : phanSos) {
            System.out.println(ps);
        }
    }
    public static PhanSo tinhTongPhanSoTrongMang(List<PhanSo> phanSos) {
        PhanSo psTong = phanSos.get(0);
        for (int i = 1; i < phanSos.size(); i++) {
            psTong = psTong.congPhanSo(phanSos.get(i));
        }
        System.out.println(psTong);
        return psTong;
    }
    public static void xulyTryCatchBangThrow() {
        try {
            PhanSo ps = new PhanSo(3, 0);
        } catch (MauSoException mauSoException) {
            mauSoException.getMessage();
        }
    }
}
