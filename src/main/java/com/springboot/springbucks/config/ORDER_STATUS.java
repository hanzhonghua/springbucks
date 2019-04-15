package com.springboot.springbucks.config;

public enum ORDER_STATUS {

//    1以创建 2已支付 3制作中 4已做完 5已取货 6 已取消
    INIT(1,"以创建"),
    PAY(2,"已支付"),
    PRODUCT(3,"制作中"),
    COMPLE(4,"已做完"),
    PICK(5,"已取货"),
    CANCEL(6,"已取消");

    public final int key;
    public final String value;

    private ORDER_STATUS(int key, String value){
        this.key = key;
        this.value = value;
    }
}
