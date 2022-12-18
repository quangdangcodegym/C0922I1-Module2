package com.codegym.repository;

import com.codegym.model.*;

import java.util.ArrayList;
import java.util.List;

public abstract class DatabaseContext<T> {
    private Class<T> tClass;
    protected String path;
    protected FileService fileService;
    public DatabaseContext(Class<T> tClass) {
        fileService = new FileService();
        this.tClass = tClass;
    }
    public T find(long id){
        for (T p : getAll()) {
            IModel<T> item = (IModel<T>) p;
            if (item.getId() == id) {
                return p;
            }
        }
        return null;
    }
    public void edit(long id, T obj){
        List<T> items = getAll();

        for (T p : items) {
            IModel<T> item = (IModel<T>) p;
            if (item.getId() == id) {
                item.update(obj);
            }
        }
        fileService.writeData(path, items);

    }
    public List<T> searchBy(ISearch<T> iSearch, String name){
        List<T> items = new ArrayList<>();
        for (T p : getAll()) {
            if (iSearch.searchByName(p, name)) {
                items.add(p);
            }
        }
        return items;
    }

    public void add(T obj){
        List<T> items = getAll();
        items.add(obj);

        fileService.writeData(path, items);
    }
    public void addList(List objs){
        List<T> items = getAll();
        items.addAll(objs);

        fileService.writeData(path, items);
    }

    public List<T> getAll() {
        List<T> items = fileService.readData(path, tClass);
        return items;
    }


}
