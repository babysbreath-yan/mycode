package com.it.servers.imp;

import com.it.servers.ContactServers;
import com.it.util.Users;

public class contactServersImp implements ContactServers {
    private Object contact;

    public Users login(Users users){
        return users;
    }
    public Object queryContactAll(){
        return contact;
    }
}
