package com.codegym.collections;

import java.util.*;

public class CollectionsApp {
    public static void main(String[] args) {
//        HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("Anh");
//        hashSet.add("Phat");
//        hashSet.add("Anh");
//        System.out.println(Arrays.toString(hashSet.toArray()));

        Set<String> hashSet1  = new HashSet<>();
        hashSet1.add("Anh");
        hashSet1.add("Phat");
        hashSet1.add("Anh");
        System.out.println(Arrays.toString(hashSet1.toArray()));
    }

    public void taoArrayListTuLopCon() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(5);

        System.out.println(Arrays.toString(arrayList.toArray()));


        List<Integer> arr = new ArrayList<>();

        arr.add(5);
        arr.add(7);
        arr.add(5);
        System.out.println(Arrays.toString(arr.toArray()));
    }


}
