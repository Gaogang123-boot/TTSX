package com.ttsx.web;

import com.ttsx.dao.GoodsDao;
import com.ttsx.daoImpl.GoodsDaoImpl;
import com.ttsx.entiy.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/init")
public class InitServlet extends BaseServlet {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    protected void initIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> goodsFruitAll = goodsDao.getGoodsFruitAll();//获得水果商品
        List<Goods> goodsSeafoodAll = goodsDao.getGoodsSeafoodAll();//获得海鲜商品
        HttpSession session = request.getSession();
        session.setAttribute("goodsFruitAll",goodsFruitAll);
        session.setAttribute("goodsSeafoodAll",goodsSeafoodAll);

        response.sendRedirect("index2.jsp");
    }
}
