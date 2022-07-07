package com.zzh.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.Method;


public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得访问地址
        String uri = request.getRequestURI();
        //按‘/’分隔，取出方法名
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1);
        //获得子类
        Class<? extends BaseServlet> cla = this.getClass();
        //获得子类方法，执行
        try {
            Method method = cla.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
