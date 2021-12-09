package com.ttsx.web;

import com.alibaba.fastjson.JSON;
import com.ttsx.dao.GoodsTypeDao;
import com.ttsx.daoImpl.GoodsTypeDaoImpl;
import com.ttsx.entiy.GoodsType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/goodsType")
public class GoodsTypeServlet extends BaseServlet{
    //实例化商品类型
    private GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();

    /**
     * 查询所有商品类型信息展示在index.jsp页面上
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getGoodsTypeAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<GoodsType> goodsTypeAll = goodsTypeDao.getGoodsTypeAll();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String goodsTypeAllJson = JSON.toJSONString(goodsTypeAll);
        out.write(goodsTypeAllJson);
        out.flush();
        out.close();
    }
}
