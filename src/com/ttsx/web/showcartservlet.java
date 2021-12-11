package com.ttsx.web;

import com.ttsx.dao.GoodsCartDao;
import com.ttsx.daoImpl.GoodsCartDaoImpl;
import com.ttsx.entiy.GoodsCart;
import com.ttsx.entiy.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Eason
 * @version 1.0
 */
@WebServlet("/show")
public class showcartservlet extends BaseServlet {//展示购物车信息
    GoodsCartDao goodsCartDao=new GoodsCartDaoImpl();
    protected void showcart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfo userInfo =(UserInfo)request.getSession().getAttribute("userInfo");//获取当前登录用户信息
        List<GoodsCart> cartList = goodsCartDao.getGoodsList(userInfo.getUserId());//通过当前用户ID获取对应的购物车信息
        request.getSession().setAttribute("cartList",cartList);//存储查询出来的购物车信息
        response.sendRedirect("cart.jsp");//跳转到购物车界面
    }
}
