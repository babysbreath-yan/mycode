package com.it.servers;

import com.it.util.OlderInfo;
import com.it.util.Pages;

import java.util.List;

public interface OlderServers {
    //分页查询订单
    public List<OlderInfo> queryOlderPage(Pages pages);
    //根据Id删除订单
    public boolean deleteOlder(int olderId);
}