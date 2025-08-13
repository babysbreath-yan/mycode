package com.it.dao.imp;

import com.it.dao.contactDao;
import com.it.util.DBUtil;
import com.it.util.OlderInfo;
import com.it.util.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImp implements contactDao {
    Connection conn=null;
    PreparedStatement pstm=null;
    ResultSet rst=null;
    public List<contact> queryContactAll(){
        conn= DBUtil.getConn();
        List<contact> contactList=new ArrayList<>();
        String sql="select c.contact_id ,c.user_id,c.email ,c.telephone ,c.content ,c.publish_time from contact c inner join users u on c.user_id = u.user_id";
        try {
            pstm=conn.prepareStatement(sql);
            rst=pstm.executeQuery();
            while (rst.next()){
                contact contact=new contact();
                contact.setContact_id(rst.getString(1));
                contact.setUser_id(rst.getString(2));
                contact.setEmail(rst.getString(3));
                contact.setTelephone(rst.getString(4));
                contact.setContent(rst.getString(5));
                contact.setPublish_time(rst.getString(6));
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        DBUtil.closes(conn,pstm,rst);
        return contactList;
    }
}
