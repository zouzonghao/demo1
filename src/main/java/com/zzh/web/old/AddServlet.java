package com.zzh.web.old;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zzh.pojo.Item;
import com.zzh.service.ItemService;
import com.zzh.service.ItemServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {

    private ItemServiceImpl itemServiceImpl = new ItemServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Item item = JSON.parseObject(s, Item.class);
        //2.调用service添加
        int flag = itemServiceImpl.add(item);
        //3.响应成功标识
        if (flag == 1)response.getWriter().write("success");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
