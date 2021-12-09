package com.ttsx.web;

import com.ttsx.dao.UserInfoDao;
import com.ttsx.daoImpl.UserInfoDaoImpl;
import com.ttsx.entiy.AddressInfo;
import com.ttsx.entiy.UserInfo;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user")
public class UserInfoServlet extends BaseServlet{
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private Logger logger = Logger.getLogger("log4j.properties");
    /**
     * 用户登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        String rember = request.getParameter("rember");
        logger.info("用户登录,用户输入用户名："+username+"密码："+password);
        if (username!=null&password!=null&&!username.equals("")&!password.equals("")){
            UserInfo userInfo = userInfoDao.userLogin(username, password);
            logger.info(userInfo.toString());
            request.getSession().setAttribute("userInfo",userInfo);
            response.sendRedirect("index2.jsp");
        }else {
            response.sendRedirect("login.jsp");
        }

    }

    /**
     * 获取用户信息和地址
     * 待：获取用户登录信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void userAddressInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入userAddressInfo");
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        if (userInfo!=null){
            AddressInfo address = userInfoDao.getAddress(userInfo.getUserId());
            System.out.println(address.toString());
            request.getSession().setAttribute("Address",address);
            response.sendRedirect("user_center_info.jsp");
        }else {
            response.sendRedirect("user_center_info.jsp");
        }

    }

    /**
     * 退出登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserInfo userInfo = (UserInfo)session.getAttribute("userInfo");
        session.removeAttribute("userInfo");
        logger.info(userInfo.getUserName()+"退出登录");
        response.sendRedirect("index.jsp");
    }
}
