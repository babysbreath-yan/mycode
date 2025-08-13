package com.it.util;

public class clothes {
    private int clothesId;
    private String clothesName;
    private String clothesPct;
    private String clothesCount;
    private double price;
    private String type;
    private int    clothesNum;
    private int    clothesXl;
    private int    stata;

    public clothes() {
    }

    public clothes(String clothesName, String clothesPct, String clothesCount, double price, String type, int clothesNum, int clothesXl, int stata) {
        this.clothesName = clothesName;
        this.clothesPct = clothesPct;
        this.clothesCount = clothesCount;
        this.price = price;
        this.type = type;
        this.clothesNum = clothesNum;
        this.clothesXl = clothesXl;
        this.stata = stata;
    }

    public clothes(int clothesId, String clothesName, String clothesPct, String clothesCount, double price, String type, int clothesNum, int clothesXl, int stata) {
        this.clothesId = clothesId;
        this.clothesName = clothesName;
        this.clothesPct = clothesPct;
        this.clothesCount = clothesCount;
        this.price = price;
        this.type = type;
        this.clothesNum = clothesNum;
        this.clothesXl = clothesXl;
        this.stata = stata;
    }

    @Override
    public String toString() {
        return "clothes{" +
                "clothesId=" + clothesId +
                ", clothesName='" + clothesName + '\'' +
                ", clothesPct='" + clothesPct + '\'' +
                ", clothesCount='" + clothesCount + '\'' +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", clothesNum=" + clothesNum +
                ", clothesXl=" + clothesXl +
                ", stata=" + stata +
                '}';
    }

    public int getclothesId() {
        return clothesId;
    }

    public void setclothesId(int clothesId) {
        this.clothesId = clothesId;
    }

    public String getclothesName() {
        return clothesName;
    }

    public void setclothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public String getclothesPct() {
        return clothesPct;
    }

    public void setclothesPct(String clothesPct) {
        this.clothesPct = clothesPct;
    }

    public String getclothesCount() {
        return clothesCount;
    }

    public void setclothesCount(String clothesCount) {
        this.clothesCount = clothesCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getclothesNum() {
        return clothesNum;
    }

    public void setclothesNum(int clothesNum) {
        this.clothesNum = clothesNum;
    }

    public int getclothesXl() {
        return clothesXl;
    }

    public void setclothesXl(int clothesXl) {
        this.clothesXl = clothesXl;
    }

    public int getStata() {
        return stata;
    }

    public void setStata(int stata) {
        this.stata = stata;
    }
}