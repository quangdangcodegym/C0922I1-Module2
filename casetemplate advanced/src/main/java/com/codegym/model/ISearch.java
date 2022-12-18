package com.codegym.model;

public interface ISearch<T> {
    boolean searchByName(T item, String name);
}
