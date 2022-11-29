package com.codegym.reviews4;

import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    public static List<Category> categories;
    public void init() {
        categories = new ArrayList<>();
        categories.add(new Category(1, "Apple"));
        categories.add(new Category(2, "Samsung"));
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public static Category findCategoryById(int id) {
        for (Category c : categories) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
}
