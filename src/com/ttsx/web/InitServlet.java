package com.ttsx.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ttsx.dao.GoodsDao;
import com.ttsx.daoImpl.GoodsDaoImpl;
import com.ttsx.entiy.Goods;
import com.ttsx.entiy.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/init")
public class InitServlet extends BaseServlet {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    protected void initIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Cookie[]
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if (cookies!=null){
            for (Cookie ck:cookies) {
                if (ck.getName().equals("userInfo")){
                    cookie=ck;
                    break;
                }
            }
        }
        if (cookie!=null){
            String userInfo1 = cookie.getValue();
            UserInfo userInfo = JSON.parseObject(userInfo1, UserInfo.class);
            System.out.println(userInfo.toString());
            request.getSession().setAttribute("userInfo",userInfo);
        }
        List<Goods> goodsFruitAll = goodsDao.getGoodsFruitAll();//获得水果商品
        List<Goods> goodsSeafoodAll = goodsDao.getGoodsSeafoodAll();//获得海鲜商品
        request.getSession().setAttribute("goodsFruitAll",goodsFruitAll);
        request.getSession().setAttribute("goodsSeafoodAll",goodsSeafoodAll);

        response.sendRedirect("index2.jsp");
    }
}
