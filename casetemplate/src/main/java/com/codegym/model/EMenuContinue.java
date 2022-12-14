package com.codegym.model;

public enum EMenuContinue {
    ORDER("Menu quản lý order"),
    PRODUCT("Menu quản lý sản phẩm"),
    ADD_PRODUCT ("Thêm sản phẩm"),
    EDIT_PRRODUCT("Sửa sản phẩm"),
    DELETE_PRODUCT("Xóa sản phẩm"),
    ADD_ORDER("Thêm order"),
    EDIT_ORDER("Sửa order"),
    DELETE_ORDER("Xóa order"),

    ADD_ORDER_ITEM("Thêm order item"),

    MENU_ADMIN("Menu admin"),
    MENU_USER("Menu user"),
    ORDER_EDIT_QUANTITY("Sửa số lượng");
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    EMenuContinue(String value) {
        this.value = value;
    }

}
