package com.it.bean;

import java.sql.Timestamp;

public class UserMessage {
    private int id;
    private int userId;
    private String message;
    private Timestamp timestamp;

    // 无参构造方法
    public UserMessage() {
    }

    // 带参构造方法
    public UserMessage(int id, int userId, String message, Timestamp timestamp) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.timestamp = timestamp;
    }

    public UserMessage(int userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public UserMessage(int userId, String message, Timestamp timestamp) {
        this.userId = userId;
        this.message = message;
        this.timestamp = timestamp;
    }

    // getter 和 setter 方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

