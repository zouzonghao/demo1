package com.zzh.service;

import com.zzh.pojo.Item;
import com.zzh.pojo.PageBean;

import java.util.List;

public interface ItemService {

    List<Item> selectAll();

    int add(Item item);
    Item selectByName(String name);
    int del(Item item);
    int update(Item item);
    //分页查询
    PageBean<Item> page(int currentPage, int pageSize);

    PageBean<Item> selectByLikeName (int currentPage, int pageSize, String name, String dname);
}
