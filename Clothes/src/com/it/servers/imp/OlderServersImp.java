package com.it.servers.imp;

import com.it.dao.OlderDao;
import com.it.dao.imp.OlderDaoImp;
import com.it.servers.OlderServers;
import com.it.util.OlderInfo;
import com.it.util.Pages;

import java.util.List;

public class OlderServersImp implements OlderServers {
    OlderDao olderDao=new OlderDaoImp();
    @Override
    public List<OlderInfo> queryOlderPage(Pages pages) {
        return olderDao.queryOlderPage(pages);
    }

    @Override
    public boolean deleteOlder(int olderId) {
        return olderDao.deleteOlder(olderId)>0;
    }
}