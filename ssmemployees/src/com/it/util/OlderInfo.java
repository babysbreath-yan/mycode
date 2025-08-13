package com.it.util;

public class OlderInfo {
    private int olderId;
    private String userName;
    private int num;
    private String clothesName;
    private double price;
    private String clothesPct;
    private String time;

    public OlderInfo() {
    }

    public OlderInfo(int olderId, String userName, int num, String clothesName, double price, String clothesPct, String time) {
        this.olderId = olderId;
        this.userName = userName;
        this.num = num;
        this.clothesName = clothesName;
        this.price = price;
        this.clothesPct = clothesPct;
        this.time = time;
    }

    public int getOlderId() {
        return olderId;
    }

    public void setOlderId(int olderId) {
        this.olderId = olderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getclothesName() {
        return clothesName;
    }

    public void setclothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getclothesPct() {
        return clothesPct;
    }

    public void setclothesPct(String clothesPct) {
        this.clothesPct = clothesPct;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}