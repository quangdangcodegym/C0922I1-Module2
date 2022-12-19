package com.codegym;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethodinvokeExample1  {
    private String name;
    private String age;


    public String getName() {
        System.out.println("Getter name: " + name);
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        System.out.println("Getter age: " + age);
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private  void process(String str) {
        System.out.println("helllllllllll");
        System.out.println("processing " + str);
    }

    public static Method findMethod(String prefix, String name) {
        for (Method m : ReflectMethodinvokeExample1.class.getDeclaredMethods()) {
            if (m.getName().contains(prefix) && m.getName().toUpperCase().contains(name.toUpperCase())) {
                return m;
            }
        }
        return null;
    }
    public static void main(String... args) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException {
        for (Field field : ReflectMethodinvokeExample1.class.getDeclaredFields()) {
            Method m1 = findMethod("get", field.getName());
            Object obj = ReflectMethodinvokeExample1.class.getDeclaredConstructor().newInstance();
            Object rv = m1.invoke(obj);
        }
//        for (Method m : ReflectMethodinvokeExample1.class.getDeclaredMethods()) {
//            if (m.getName().contains("get")) {
//                Method m1 = ReflectMethodinvokeExample1.class.getDeclaredMethod(m.getName());
//                Object obj = ReflectMethodinvokeExample1.class.getDeclaredConstructor().newInstance();
//                Object rv = m1.invoke(obj);
//            }
//
//        }
//
//        Method m1 = ReflectMethodinvokeExample1.class.getDeclaredMethod("process", String.class);
//        Object obj = ReflectMethodinvokeExample1.class.getDeclaredConstructor().newInstance();
//        Object rv = m1.invoke(obj, "test");
    }
}
