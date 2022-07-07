package com.zzh.web;

import com.alibaba.fastjson.JSON;
import com.zzh.pojo.Item;
import com.zzh.pojo.PageBean;
import com.zzh.service.ItemServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/item/*")
public class ItemServlet extends BaseServlet {
    private ItemServiceImpl itemServiceImpl = new ItemServiceImpl();
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Item item = JSON.parseObject(s, Item.class);
        //2.调用service添加
        int flag = itemServiceImpl.add(item);
        //3.响应成功标识
        if (flag == 1)response.getWriter().write("success");
    }
    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.调用service查询
        List<Item> items = itemServiceImpl.selectAll();
        //2.转为json
        String json = JSON.toJSONString(items);
        //3.写数据
        response.setContentType("text/json;charset=utf-8");//content:内容
        response.getWriter().write(json);
    }
    public void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Item item = JSON.parseObject(s, Item.class);
        //2.调用service添加
        int flag = itemServiceImpl.del(item);
        //3.响应成功标识
        if (flag == 1)response.getWriter().write("success");
    }
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Item item = JSON.parseObject(s, Item.class);
        //2.调用service添加
        int flag = itemServiceImpl.update(item);
        //3.响应成功标识
        if (flag == 1)response.getWriter().write("success");
    }
    public void mdel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        Item[] items = JSON.parseObject(s, Item[].class);
        //2.调用service添加
        int flag = itemServiceImpl.mdel(items);
        //3.响应成功标识
        if (flag == 1)response.getWriter().write("success");
    }
    public void updateip(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据
        BufferedReader reader = request.getReader();
        String s = reader.readLine();
        String ip = JSON.parseObject(s, String.class);
        //2.调用service添加
        int flag = itemServiceImpl.updateip(ip);
        //3.响应成功标识
        if (flag == 1)response.getWriter().write("success");
    }
    public void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");
        String name = request.getParameter("name");
        String dname = request.getParameter("dname");
        System.out.println("servlet:"+name);
        System.out.println("servlet:"+dname);
        if (name != null)name = name.trim();
        if (dname != null)dname = dname.trim();
        int size = Integer.parseInt(pageSize);
        int begin = Integer.parseInt(currentPage);
        //2.调用service添加
        PageBean<Item> pageBean;
        if(("".equals(name) || name == null) && ("".equals(dname) || dname == null)){
            pageBean = itemServiceImpl.page(begin, size);
        }else {
            pageBean = itemServiceImpl.selectByLikeName(begin, size, name, dname);
        }
        System.out.println("servlet:"+ pageBean);

        String jsonString = JSON.toJSONString(pageBean);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);


    }


}
