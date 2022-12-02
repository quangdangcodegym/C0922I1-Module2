package com.codegym.exception;

public class ToanHoc {
    public PhanSo congHaiPhanSo(PhanSo ps1, PhanSo ps2) {
        PhanSo psTong = new PhanSo();
        // 1/2 + 3/4;
        int mauSoChung = timBoiChungNhoNhat(ps1.getMauSo(), ps2.getMauSo());
        psTong.setTuSo(mauSoChung / ps1.getMauSo() * ps1.getTuSo() + mauSoChung / ps2.getMauSo() * ps2.getTuSo());
        psTong.setMauSo(mauSoChung);

        return psTong;


    }

    public int timBoiChungNhoNhat(int n1, int n2) {
        int gcd = 1, lcm;
        for(int i = 1; i <= n1 && i <= n2; i++)
        {
            if(n1%i==0 && n2%i==0)
                gcd = i;
        }
        lcm = (n1 * n2) / gcd;
        return lcm;
    }
}
