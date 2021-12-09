package com.ttsx.web;

import com.ttsx.dao.BrowseDao;
import com.ttsx.dao.GoodsDao;
import com.ttsx.daoImpl.BrowseDaoImpl;
import com.ttsx.daoImpl.GoodsDaoImpl;
import com.ttsx.entiy.Goods;
import com.ttsx.entiy.UserInfo;
import com.ttsx.util.PageUtils;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/goods")
public class GoodsServlet extends BaseServlet{
    //实例化goodsDao
    private GoodsDao goodsDao = new GoodsDaoImpl();
    private BrowseDao browseDao = new BrowseDaoImpl();
    private Logger logger = Logger.getLogger("log4j.properties");
    /**
     * 获得所有商品信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void goodsAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String goodsName = request.getParameter("goodsName");
            String pageNum = request.getParameter("pageNum");
            List<Goods> goodsAllProduct = null;
            PageUtils pageUtils = new PageUtils();
            pageUtils.setPageNum(1);
            pageUtils.setRows(5);
            if (pageNum!=null){
                pageUtils.setPageNum(Integer.parseInt(pageNum));
                if (Integer.parseInt(pageNum)<=0){
                    pageUtils.setPageNum(1);
                }
            }
            if (goodsName.equals("新鲜水果")){
                int goodsCount = goodsDao.getGoodsCount(goodsName);
                pageUtils.setMaxPage(goodsCount%pageUtils.getRows()==0?goodsCount/pageUtils.getRows():goodsCount/pageUtils.getRows()+1);
                if (pageUtils.getPageNum()>=pageUtils.getMaxPage()){
                    pageUtils.setPageNum(pageUtils.getMaxPage());
                }
//                System.out.println(pageUtils.getMaxPage());
                goodsAllProduct=goodsDao.getGoodsFruitAllProduct(pageUtils);
                request.getSession().setAttribute("goodsName",goodsName);
                request.getSession().setAttribute("pageUtils",pageUtils);
            }else if (goodsName.equals("海鲜水产")){
                int goodsCount = goodsDao.getGoodsCount(goodsName);
                pageUtils.setMaxPage(goodsCount%pageUtils.getRows()==0?goodsCount/pageUtils.getRows():goodsCount/pageUtils.getRows()+1);
                if (pageUtils.getPageNum()>=pageUtils.getMaxPage()){
                    pageUtils.setPageNum(pageUtils.getMaxPage());
                }
                goodsAllProduct=goodsDao.getGoodsSeafoodAllProduct(pageUtils);
                request.getSession().setAttribute("goodsName",goodsName);
                request.getSession().setAttribute("pageUtils",pageUtils);
            }
            HttpSession session = request.getSession();
            session.setAttribute("goodsAllProduct",goodsAllProduct);
            response.sendRedirect("list.jsp");
    }
    /**
     * 根据商品编号查询产品
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findGoodsById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("根据编号查询产品");
        //获取session判断用户是否登录
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
        String  goodsId = request.getParameter("goodsId");
        Goods oneGoods = goodsDao.findGoodsById(goodsId);
        HttpSession session = request.getSession();
        session.setAttribute("oneGoods",oneGoods);
        if (userInfo==null){
            response.sendRedirect("detail.jsp");
        }else {
            browseDao.insBrowseInfo(oneGoods.getGoodsPic(),oneGoods.getGoodsName(),oneGoods.getGoodsPrice(),userInfo.getUserId());
            response.sendRedirect("detail.jsp");
        }

    }

}
