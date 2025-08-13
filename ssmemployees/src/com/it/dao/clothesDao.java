package com.it.dao;

import com.it.util.clothes;
import com.it.util.Older;
import com.it.util.Pages;

import java.util.List;

public interface clothesDao {
    //查询所有商品
    public List<clothes> queryclothesAll();
    //分页查询所有商品
    public List<clothes> queryclothesAllPage(Pages pages);
    //根据Id删除衣服商品
    public int deleteclothes(int clothesId);
    //根据衣服名模糊查询
    public List<clothes> likeQueryclothes(String clothesName);
    //管理员添加衣服
    public int  addclothes(clothes clothes);
    //根据Id查询衣服商品
    public clothes clothesQueryOne(int clothesId);
    //添加订单
    public int  addOlder(Older older);
}