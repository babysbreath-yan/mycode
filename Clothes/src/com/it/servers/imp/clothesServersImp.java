package com.it.servers.imp;

import com.it.dao.clothesDao;
import com.it.dao.imp.clothesDaoImp;
import com.it.servers.clothesServers;
import com.it.util.clothes;
import com.it.util.Older;
import com.it.util.Pages;

import java.util.ArrayList;
import java.util.List;

public class clothesServersImp implements clothesServers {
    clothesDao clothesDao=new clothesDaoImp();
    @Override
    public List<clothes> queryclothesRm() {
        List<clothes> clothesList=clothesDao.queryclothesAll();
        List<clothes> clothesList1=new ArrayList<>();
        for (clothes clothes:clothesList){
            if("A".equals(clothes.getType())){
                clothesList1.add(clothes);
            }
        }
        return clothesList1;
    }

    @Override
    public List<clothes> queryclothesXp() {
        List<clothes> clothesList=clothesDao.queryclothesAll();
        List<clothes> clothesList1=new ArrayList<>();
        for (clothes clothes:clothesList){
            if("B".equals(clothes.getType())){
                clothesList1.add(clothes);
            }
        }
        return clothesList1;
    }

    @Override
    public List<clothes> queryclothesAllPage(Pages pages) {
        return clothesDao.queryclothesAllPage(pages);
    }

    @Override
    public boolean deleteclothes(int clothesId) {
        return clothesDao.deleteclothes(clothesId)>0;
    }

    @Override
    public List<clothes> likeQueryclothes(String clothesName) {
        return clothesDao.likeQueryclothes(clothesName);
    }

    @Override
    public boolean addclothes(clothes clothes) {
        return clothesDao.addclothes(clothes)>0;
    }

    @Override
    public clothes clothesQueryOne(int clothesId) {
        return clothesDao.clothesQueryOne(clothesId);
    }

    @Override
    public boolean addOlder(Older older) {
        return clothesDao.addOlder(older)>0;
    }
}