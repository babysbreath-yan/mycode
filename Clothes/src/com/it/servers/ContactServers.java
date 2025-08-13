package com.it.servers;

import com.it.util.Users;
import com.it.util.contact;

import java.util.List;

public interface ContactServers {
    public Users login(Users users);

    public static List<contact> queryContactAll() {
        return null;
    }
}
