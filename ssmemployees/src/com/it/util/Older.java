package com.it.util;

public class Older {
    private int olderId;
    private int userId;
    private int clothesId;
    private int num;
    private String time;

    public Older() {
    }

    @Override
    public String toString() {
        return "Older{" +
                "olderId=" + olderId +
                ", userId=" + userId +
                ", clothesId=" + clothesId +
                ", num=" + num +
                ", time='" + time + '\'' +
                '}';
    }

    public Older(int olderId, int userId, int clothesId, int num, String time) {
        this.olderId = olderId;
        this.userId = userId;
        this.clothesId = clothesId;
        this.num = num;
        this.time = time;
    }

    public Older(int userId, int clothesId, int num, String time) {
        this.userId = userId;
        this.clothesId = clothesId;
        this.num = num;
        this.time = time;
    }

    public int getOlderId() {
        return olderId;
    }

    public void setOlderId(int olderId) {
        this.olderId = olderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getclothesId() {
        return clothesId;
    }

    public void setclothesId(int clothesId) {
        this.clothesId = clothesId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
