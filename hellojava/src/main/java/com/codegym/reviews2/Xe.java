package com.codegym.reviews2;

public  abstract class Xe {
    private String name;
    private String dongco;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDongco() {
        return dongco;
    }

    public void setDongco(String dongco) {
        this.dongco = dongco;
    }

    public Xe() {

    }
    public Xe(String name,String dongco) {
        this.name = name;
        this.dongco = dongco;
    }

    public abstract void tangtoc();
}
