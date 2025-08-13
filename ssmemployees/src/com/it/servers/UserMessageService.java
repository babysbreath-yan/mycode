package com.it.servers;

import com.it.bean.UserMessage;
import com.it.dao.UserMessageDAO;

import java.util.List;

public class UserMessageService {
    // 插入用户消息
    public void addUserMessage(UserMessage userMessage) {
        UserMessageDAO.insertUserMessage(userMessage);
    }

    // 更新用户消息
    public void updateUserMessage(UserMessage userMessage) {
        UserMessageDAO.updateUserMessage(userMessage);
    }

    // 删除用户消息
    public void deleteUserMessage(int id) {
        UserMessageDAO.deleteUserMessage(id);
    }

    // 获取所有用户消息
    public List<UserMessage> getAllUserMessages() {
        return UserMessageDAO.getAllUserMessages();
    }

}
