package com.it.servers;

import com.it.util.clothes;
import com.it.util.Older;
import com.it.util.Pages;

import java.util.List;

public interface clothesServers {

    //查询热卖商品衣服
    public List<clothes> queryclothesRm();
    //查询新品商品衣服
    public List<clothes> queryclothesXp();
    //分页查询所有商品
    public List<clothes> queryclothesAllPage(Pages pages);
    //根据Id删除衣服商品
    public boolean deleteclothes(int clothesId);
    //根据衣服名模糊查询
    public List<clothes> likeQueryclothes(String clothesName);
    //管理员添加衣服
    public boolean  addclothes(clothes clothes);
    //根据Id查询衣服商品
    public clothes clothesQueryOne(int clothesId);
    //添加订单
    public boolean  addOlder(Older older);
}