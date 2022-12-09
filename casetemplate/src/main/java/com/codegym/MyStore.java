package com.codegym;

import com.codegym.view.OrderView;
import com.codegym.view.ProductView;

import java.text.ParseException;

public class MyStore {
    public static void main(String[] args) throws ParseException {

//        OrderView orderView = new OrderView();
//        orderView.launch();
        ProductView productView = new ProductView();
        productView.launch();
    }
}
