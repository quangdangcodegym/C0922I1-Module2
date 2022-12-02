package com.codegym.exception;

import java.util.Objects;

public class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo(int tuSo, int mauSo) throws MauSoException{
        /**
        try {
            if (mauSo == 0) {
                throw new Exception();
            }
            this.tuSo = tuSo;
            this.mauSo = mauSo;
        } catch (Exception exception) {
            System.out.println("Mẫu số không được =0");
        }
         **/
        if (mauSo == 0) {
            throw new MauSoException();
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
    public PhanSo() {

    }

    @Override
    public String toString() {
        return String.format("%s/%s", this.tuSo, this.mauSo);
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }

    public PhanSo congPhanSo(PhanSo phanSo) {
        PhanSo psTong = new PhanSo();
        ToanHoc toanHoc = new ToanHoc();
        int mauSoChung = toanHoc.timBoiChungNhoNhat(this.getMauSo(), phanSo.getMauSo());
        psTong.setTuSo(mauSoChung / this.getMauSo() * this.getTuSo() + mauSoChung / phanSo.getMauSo() * phanSo.getTuSo());
        psTong.setMauSo(mauSoChung);

        return psTong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhanSo phanSo = (PhanSo) o;
        return tuSo == phanSo.tuSo && mauSo == phanSo.mauSo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tuSo, mauSo);
    }
}
