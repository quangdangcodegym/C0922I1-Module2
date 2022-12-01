package com.codegym.treemap;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String s = "Welcome";
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i)>stack.peek()) stack.add(s.charAt(i));
        }
        System.out.println(stack);

    }
    public void testHashCode() {
        Product p1 = new Product("Iphone X", 1000);
        Product p2 = new Product("IPHONE X", 1000);
        Product p3 = new Product("IPHONE X", 2000);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());

        if (p1.equals(p2)) {
            System.out.println("TRUE");
        }

        HashMap<Product, Integer> hashMap = new HashMap<>();
        hashMap.put(p1, 1);
        hashMap.put(p2, 2);
        hashMap.put(p2, 5);
        hashMap.put(p3, 3);

        Set<Product> keys = hashMap.keySet();
        for (Product key : keys) {
            System.out.println(hashMap.get(key));
        }
    }
}
