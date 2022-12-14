package com.codegym.service;

import com.codegym.model.ParseData;
import com.codegym.model.EModel;
import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.model.Product;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public <T> void  writeData(String path, List<T> list) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (T line : list) {
                bufferedWriter.write(line + "\n");
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
    public <T> List<T> readData(String path, EModel eModel) {
        List<T> items = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine())!=null) {
                ParseData<T> item = null;
                switch (eModel) {
                    case PRODUCT:
                        item = (ParseData<T>) new Product();
                        break;
                    case ORDER:
                        item = (ParseData<T>) new Order();
                        break;
                    case ORDERITEM:
                        item = (ParseData<T>) new OrderItem();
                        break;
                }
                T temp = item.parseData(line);
                items.add(temp);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return items;
    }


    public <T> List<T> readData(String path, Class<T> cls) {
        List<T> items = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;

            while ((line = bufferedReader.readLine())!=null) {
                ParseData<T> item = (ParseData<T>) cls.getDeclaredConstructor().newInstance();
                T temp = item.parseData(line);
                items.add(temp);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return items;
    }
}
