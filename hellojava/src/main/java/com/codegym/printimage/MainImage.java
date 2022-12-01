package com.codegym.printimage;

import lu.ewelohd.jconsoleimage.core.ConsoleImage;

import java.io.IOException;

public class MainImage {
    public static void main(String[] args) throws IOException {
        ConsoleImage myImage = new ConsoleImage();

        myImage.setImage("D:\\CODEGYM\\CODEGYM\\Module2\\C0922I1\\hellojava\\data\\ngoctrinh.jpg");
        myImage.set8Colors();

        myImage.set8Colors();
        myImage.build();
    }
}
