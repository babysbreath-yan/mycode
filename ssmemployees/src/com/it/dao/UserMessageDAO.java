package com.it.dao;

import com.it.bean.UserMessage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserMessageDAO extends BaseDAO {
    // 插入用户消息
    public static void insertUserMessage(UserMessage userMessage) {
        String sql = "INSERT INTO user_message (id, user_id, message, timestamp) VALUES (?, ?, ?, ?)";
        executeUpdate(sql, userMessage.getId(), userMessage.getUserId(), userMessage.getMessage(), userMessage.getTimestamp());
    }

    // 更新用户消息
    public static void updateUserMessage(UserMessage userMessage) {
        String sql = "UPDATE user_message SET user_id = ?, message = ?, timestamp = ? WHERE id = ?";
        executeUpdate(sql, userMessage.getUserId(), userMessage.getMessage(), userMessage.getTimestamp(), userMessage.getId());    }

    // 删除用户消息
    public static void deleteUserMessage(int id) {
        String sql = "DELETE FROM user_message WHERE id = ?";
        executeUpdate(sql, id);
    }

    // 获取所有用户消息
    public static List<UserMessage> getAllUserMessages() {
        String sql = "SELECT * FROM user_message";
        ResultSet rs = executeQuery(sql);
        List<UserMessage> messages = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String message = rs.getString("message");
                Timestamp timestamp = rs.getTimestamp("timestamp");

                UserMessage userMessage = new UserMessage(id, user_id, message, timestamp);
                messages.add(userMessage);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return messages;
    }
}