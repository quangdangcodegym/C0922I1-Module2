package com.codegym;

public enum ECategory {
    IPHONE(1),
    SAMSUNG(2),
    NOKIA(3);
    private int id;
    private ECategory(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ECategory findCategoryById(int id) {
        for (ECategory eCategory : ECategory.values()) {
            if (eCategory.getId() == id) {
                return eCategory;
            }
        }
        return null;
    }
}
