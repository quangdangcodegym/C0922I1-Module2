package com.codegym.model;

public enum EOrderStatus {
    //New, Checkout, Paid, Failed, Shipped, Delivered, Returned, and Complete
    NEW(1),
    PAID(2),
    SHIPPED(3),
    COMPLETE(4);
    private int id;

    private EOrderStatus(int id) {
        this.id = id;
    }

    public static EOrderStatus findEOrderStatusByName(String name) {
        for (EOrderStatus eOrderStatus : values()) {
            String temp = String.valueOf(eOrderStatus);
            if (temp.equals(name)) {
                return eOrderStatus;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EOrderStatus eOrderStatus = EOrderStatus.findEOrderStatusByName("NEW");
        System.out.println(eOrderStatus);
    }


}
