package com.codegym.treemap;

import java.util.*;

public class TreeMain {
    public static void main(String[] args) {

        Set<String> sets = new HashSet<>();

    }
    public void testMap() {
        LinkedHashMap<String, Integer> customers = new LinkedHashMap<>();
        customers.put("John", 30);
        customers.put("Mike", 28);
        customers.put("Bill", 32);
        customers.put("Maria", 27);

        System.out.println(customers.get("John"));
        Set<String> keys = customers.keySet();
        for (String key : keys) {
            System.out.println(customers.get(key));
        }

        Set<Map.Entry<String,Integer>> set2 = customers.entrySet();
        for (Map.Entry<String,Integer> customer:set2){
            System.out.println(customer.getKey()+"-"+customer.getValue());
        }


        LinkedHashMap<Integer, String> customers1 = new LinkedHashMap<>();
        customers1.put(30, "John" );
        customers1.put(28, "Mike" );
        customers1.put(32, "Bill" );
        customers1.put(27, "Maria" );

        Set<Integer> keys2 = customers1.keySet();
        for (Integer key : keys2) {
            System.out.println(customers1.get(key));
        }

        System.out.println("TREE MAP");
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "Anh");
        treeMap.put(1, "Phuoc");
        treeMap.put(3, "Quang");
        Set<Integer> keys3 = treeMap.keySet();
        for (Integer key : keys3) {
            System.out.println(treeMap.get(key));
        }
    }
}
