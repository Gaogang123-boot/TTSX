package com.ttsx.web;


import com.ttsx.dao.GoodsCartDao;
import com.ttsx.daoImpl.GoodsCartDaoImpl;
import com.ttsx.entiy.Goods;
import com.ttsx.entiy.GoodsCart;
import com.ttsx.entiy.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Eason
 * @version 1.0
 */
@WebServlet("/GoodsCart")
public class goodscartservlet extends BaseServlet {
    GoodsCartDao goodsCartDao=new GoodsCartDaoImpl();//实例化购物车DAO层
    protected void goodscartadd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfo userInfo =(UserInfo) request.getSession().getAttribute("userInfo");//获取登录用户信息
        Goods oneGoods =(Goods)request.getSession().getAttribute("oneGoods");//获取详情页当前商品信息

        boolean flag = goodsCartDao.checkExist(userInfo.getUserId(), oneGoods.getGoodsId());//判断是否存在商品
        if(flag){
            goodsCartDao.updateGoods(userInfo.getUserId(),oneGoods.getGoodsId());//存在改变数量
        }else {
            goodsCartDao.addGoods(oneGoods,userInfo.getUserId());//不存在增加商品信息
        }
        List<GoodsCart> cartList = goodsCartDao.getGoodsList(userInfo.getUserId());//通过用户ID获取购物车信息
        request.getSession().setAttribute("cartList",cartList);//存储购物车信息，用于显示在购物车界面
        response.sendRedirect("cart.jsp");//跳转购物车界面
    }

    protected void goodscartadd2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfo userInfo =(UserInfo) request.getSession().getAttribute("userInfo");//获取登录用户信息
        String goodsId = request.getParameter("goodsId");//获取当前商品，商品列表页添加购物车图标
        Goods goods = goodsCartDao.getGoods(goodsId);//通过商品ID获取商品详细信息
        boolean flag = goodsCartDao.checkExist(userInfo.getUserId(), goods.getGoodsId());//判断是否存在商品
        if(flag){
            goodsCartDao.updateGoods(userInfo.getUserId(),goods.getGoodsId());//存在改变数量
        }else {
            goodsCartDao.addGoods(goods,userInfo.getUserId());//不存在增加商品信息
        }
        List<GoodsCart> cartList = goodsCartDao.getGoodsList(userInfo.getUserId());//通过用户ID获取购物车信息
        request.getSession().setAttribute("cartList",cartList);//存储购物车信息，用于显示在购物车界面
        response.sendRedirect("cart.jsp");//跳转购物车界面
    }
    protected void updateNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfo userInfo =(UserInfo) request.getSession().getAttribute("userInfo");
//        String goodsId = request.getParameter("goodsId");
                Goods oneGoods =(Goods)request.getSession().getAttribute("oneGoods");
        System.out.println(oneGoods.toString());
        goodsCartDao.updateGoods(userInfo.getUserId(),oneGoods.getGoodsId());


//        request.getSession().setAttribute("oneGoods",oneGoods);
//        response.sendRedirect("user?method=findGoodsById");

    }
    protected void desNum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfo userInfo =(UserInfo) request.getSession().getAttribute("userInfo");
        String goodsId = request.getParameter("goodsId");
//        goodsCartDao.decGoods(userInfo.getUserId(),goodsId);
//        Goods oneGoods =(Goods)request.getSession().getAttribute("oneGoods");
//        request.getSession().setAttribute("oneGoods",oneGoods);
//        response.sendRedirect("detail.jsp");
    }
}
