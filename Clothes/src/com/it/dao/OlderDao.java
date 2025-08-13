package com.it.dao;

import com.it.util.Older;
import com.it.util.OlderInfo;
import com.it.util.Pages;

import java.util.List;

public interface OlderDao {

    //分页查询订单
    public List<OlderInfo> queryOlderPage(Pages pages);
    //查询所有订单
    public List<OlderInfo> queryOlderAll();
    //根据Id删除订单
    public int deleteOlder(int olderId);
}