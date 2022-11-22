package com.codegym.mylist;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class MyList<E> {
    private int size;
    private final int DEFAUTL_SIZE = 5;
    private Object elements [];

    public MyList() {
        elements = new Object[DEFAUTL_SIZE];
        size = 0;
    }

    public MyList(int lenght) {
        elements = new Object[lenght];
        size = 0;
    }

    public void add(E e) {
        if (size >= DEFAUTL_SIZE) {
            ensureCapa();
        }
        elements[size] = e;
        size++;
    }
    public void remove (int index){
        if(index>=size|| index<0) throw new IndexOutOfBoundsException();
        for (int i = index; i < size; i ++){
            if(i<size-1){
                this.elements[i]=this.elements[i+1];
            }
        }
        size--;
    }

    public E get(int index) {
        if(index>=size|| index<0) throw new IndexOutOfBoundsException();
        return (E) this.elements[index];
    }

    private void ensureCapa() {
        elements = Arrays.copyOf(elements, DEFAUTL_SIZE*2);
    }

    public int indexOf(E e) {
        for (int i = 0; i < size; i++)
            if (e.equals(elements[i])) return i;
        return -1;
    }
    @Override
    public String toString() {
        /**
        StringBuilder arrString = new StringBuilder();
        arrString.append("[");
        for(int i =0; i<size;i++){
            if(i==size-1) {
                arrString.append(this.elements[i]).append("]");
                break;
            };
            arrString.append(this.elements[i]).append(",");
        }
         **/

        String arrString = "[";
        for(int i =0; i<size;i++){
            if(i==size-1) {
                arrString += this.elements[i] + "]";
                break;
            };
            arrString += this.elements[i] + ",";
        }
        return "MyList{" +
                "elements=" + arrString +
                '}';
    }
    public MyList clone() {
        MyList<E> clone = new MyList<E>(this.elements.length);
        for (E e : (E[]) elements) {
            clone.add(e);
        }
        return clone;
    }

    public static void main(String[] args) {
//        MyList<Integer> objs = new MyList<>();
//        objs.add(1);
//        objs.add(3);
//        objs.add(1);
//        objs.add(7);
//        System.out.println(objs);
//        System.out.println("After deleted");
//        objs.remove(6);
//        System.out.println(objs);
//
//
//        List<String> c;

        Integer c = 5;
        Integer d = 5;

        System.out.println(c.hashCode());
        System.out.println(d.hashCode());









    }
}
