package com.ttsx.web;

import com.alibaba.fastjson.JSON;
import com.ttsx.dao.BrowseDao;
import com.ttsx.dao.UserInfoDao;
import com.ttsx.daoImpl.BrowseDaoImpl;
import com.ttsx.daoImpl.UserInfoDaoImpl;
import com.ttsx.entiy.AddressInfo;
import com.ttsx.entiy.Browse;
import com.ttsx.entiy.UserInfo;
import com.ttsx.util.MailUtils;
import org.apache.log4j.Logger;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/user")
public class UserInfoServlet extends BaseServlet{
    private UserInfoDao userInfoDao = new UserInfoDaoImpl();
    private BrowseDao browseDao = new BrowseDaoImpl();
    private Logger logger = Logger.getLogger("log4j.properties");
    private static int code=0;
    /**
     * 用户登录
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建Cookie[]
        String username = request.getParameter("username");
        String password = request.getParameter("pwd");
        String rember = request.getParameter("rember");
        System.out.println("------------------remebr"+rember+"---------------------------------------------");
        logger.info("用户登录,用户输入用户名："+username+"密码："+password);
        if (username!=null&password!=null&&!username.equals("")&!password.equals("")){
            UserInfo userInfo = userInfoDao.userLogin(username, password);
            if (userInfo!=null){
                logger.info(userInfo.toString());
                request.getSession().setAttribute("userInfo",userInfo);
                if (rember!=null){
                    //创建一个cookie叫做username
                    Cookie ck = new Cookie("userInfo", JSON.toJSONString(userInfo));
                    ck.setMaxAge(60);//设置username这个cookie的存活时间为60s
                    response.addCookie(ck);//添加cookie
                    if (userInfo!=null){
                        AddressInfo address = userInfoDao.getAddress(userInfo.getUserId());
                        if (address==null){
                            browseInfo(request,response);
                        }else {
                            request.getSession().setAttribute("Address",address);
                            browseInfo(request,response);
                        }
                    }
                }
                response.sendRedirect("index2.jsp");
            }else {
                response.sendRedirect("login.jsp");
            }
        }else {
            response.sendRedirect("login.jsp");
        }

    }
    /**
     * 最近浏览信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void browseInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
        List<Browse> browseInfo = browseDao.getBrowseInfo(userInfo.getUserId());
        request.getSession().setAttribute("browseInfo",browseInfo);

//        response.sendRedirect("index2.jsp");
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
            if (address==null){
                browseInfo(request,response);
                response.sendRedirect("user_center_info.jsp");
            }else {
                request.getSession().setAttribute("Address",address);
                browseInfo(request,response);
                response.sendRedirect("user_center_info.jsp");
            }
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
        session.removeAttribute("userInfo");
        session.removeAttribute("browseInfo");
        session.removeAttribute("Address");
        //创建username的cookie和之间创建的cookie一致
        Cookie ck = new Cookie("userInfo","userInfo");
        ck.setMaxAge(0);//设置cookie的存活时间为0覆盖掉之间的cookie
        response.addCookie(ck);
        logger.info("退出登录");
        response.sendRedirect("index.jsp");
    }

    /**
     * 发送验证码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void sendCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入发送验证码");
        String email = request.getParameter("email");
        try {
            code=(int)(Math.random() * 1000000);
            String radCode = String.valueOf(code);
            System.out.println(radCode);
            MailUtils.sendMail(email,radCode);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 用户注册
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("user_name");
        String pwd = request.getParameter("pwd");
        String cpwd = request.getParameter("cpwd");
        String email = request.getParameter("email");
        String emailCode = request.getParameter("emailCode");
        System.out.println(emailCode);
        System.out.println(Integer.parseInt(emailCode)==code);
        if (pwd.equals(cpwd)&&Integer.parseInt(emailCode)==code){
            boolean isFlag = userInfoDao.userReg(userName, pwd, email);
            if (isFlag){
                response.sendRedirect("login.jsp");
            }else {
                response.sendRedirect("register.jsp");
            }
        }

    }
}
