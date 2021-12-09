package com.ttsx.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过反射动态调用方法
        //1、获得字节码对象
        Class clazz = this.getClass();
        //2、将获得请求的方法名称 xxxx?method=xxxx
        String method = request.getParameter("method");
        try {
            //3、获得字节码对象中的指定方法(同时要设置它的参数)
            Method handler = clazz.getDeclaredMethod(method,HttpServletRequest.class, HttpServletResponse.class);
            //4、忽略访问修饰符
            handler.setAccessible(true);
            //5、动态调用请求的方法
            handler.invoke(this,request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
