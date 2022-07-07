package com.zzh.web.old;

import com.alibaba.fastjson.JSON;
import com.zzh.pojo.Item;
import com.zzh.service.ItemServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

//@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    private ItemServiceImpl itemServiceImpl = new ItemServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service查询
        List<Item> items = itemServiceImpl.selectAll();
        //2.转为json
        String json = JSON.toJSONString(items);
        //3.写数据
        response.setContentType("text/json;charset=utf-8");//content:内容
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
