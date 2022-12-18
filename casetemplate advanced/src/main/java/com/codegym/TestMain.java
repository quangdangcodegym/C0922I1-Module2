package com.codegym;

import com.codegym.model.ECategory;
import com.codegym.model.Product;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMain {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /**
        Class<Product> productClass;
        productClass = Product.class;
        System.out.println(productClass.getName());
        System.out.println(productClass.getPackageName());
        System.out.println(productClass.getSimpleName());

        String t = String.format("select * from %s", productClass.getSimpleName().toLowerCase());
        System.out.println(t);

        for (Method method : productClass.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        for (Field field : productClass.getDeclaredFields()) {
            System.out.println(field.getName());
        }
         **/

        Product p = new Product(1L, "Iphone", 12000, 1, ECategory.IPHONE);
        p.getName();
        System.out.println(p.getClass().getMethod("getName"));
        Class<Product> productClass = Product.class;
        productClass.getDeclaredConstructor().newInstance();

    }
}
