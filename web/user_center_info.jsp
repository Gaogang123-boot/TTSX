<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天天生鲜-用户中心</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<div class="header_con">
    <div class="header">
        <div class="welcome fl">欢迎来到天天生鲜!</div>
        <div class="fr">
<%--            <div class="login_info fl">--%>
<%--                欢迎您：<em>张 山</em>--%>
<%--            </div>--%>
            <div class="login_btn fl">
                <c:if test="${userInfo!=null}">
                    欢迎您：<em style="color: red">${userInfo.userName}</em>
                    <span>|</span>
                    <a href="user?method=logout">退出</a>
                </c:if>
                <c:if test="${userInfo==null}">
                    <a href="login.jsp">登录</a>
                    <span>|</span>
                    <a href="register.jsp">注册</a>
                </c:if>
            </div>
            <div class="user_link fl">
                <span>|</span>
                <a href="user?method=userAddressInfo">用户中心</a>
                <span>|</span>
                <a href="cart.jsp">我的购物车</a>
                <span>|</span>
                <a href="user_center_order.jsp">我的订单</a>
            </div>
        </div>
    </div>
</div>

<div class="search_bar clearfix">
    <a href="index2.jsp" class="logo fl"><img src="${pageContext.request.contextPath}/image/logo.png"></a>
    <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>
    <div class="search_con fr">
        <input type="text" class="input_text fl" name="" placeholder="搜索商品">
        <input type="button" class="input_btn fr" name="" value="搜索">
    </div>
</div>
<div class="main_con clearfix">
    <div class="left_menu_con clearfix">
        <h3>用户中心</h3>
        <ul>
            <li><a href="user_center_info.jsp" class="active">· 个人信息</a></li>
            <li><a href="user_center_order.jsp">· 全部订单</a></li>
            <li><a href="user_center_site.jsp">· 收货地址</a></li>
        </ul>
    </div>
    <div class="right_content clearfix">
        <div class="info_con clearfix">
            <h3 class="common_title2">基本信息</h3>
            <ul class="user_info_list">
                <c:if test="${userInfo==null}">
                    请先<a href="login.jsp" style="color: red">登录</a>,登陆后查看用户信息!
                </c:if>
                <c:if test="${userInfo!=null}">
                <li><span>用户名：</span><b style="color: red">${userInfo.userName}</b></li>
                <li><span>联系方式：</span><b style="color: red">${Address.addressPhone}</b></li>
                <li><span>联系地址：</span><b style="color: red">${Address.addressDetail}</b></li>
                </c:if>
            </ul>
        </div>

        <h3 class="common_title2">最近浏览</h3>
        <div class="has_view_list">
            <ul class="goods_type_list clearfix">
                <c:if test="${browseInfo==null}">
                    请先<a href="login.jsp" style="color: red">登录</a>,登陆后查看浏览信息!
                </c:if>
                <c:if test="${browseInfo!=null}">
                    <c:forEach items="${browseInfo}" var="browse">
                                        <li>
                                            <a href="detail.jsp" ><img src="${pageContext.request.contextPath}/${browse.browseGoodsPic}"></a>
                                            <h4><a href="detail.jsp">${browse.browseGoodsName}</a></h4>
                                            <div class="operate">
                                                <span class="prize">${browse.browseGoodsPrice}</span>
                                                <span class="unit">${browse.browseGoodsPrice}/500g</span>
                                                <a href="#" class="add_goods" title="加入购物车"></a>
                                            </div>
                                        </li>
                    </c:forEach>
<%--                <li>--%>
<%--                    <a href="detail.jsp" ><img src="${pageContext.request.contextPath}/image/goods003.jpg"></a>--%>
<%--                    <h4><a href="detail.jsp">大兴大棚草莓</a></h4>--%>
<%--                    <div class="operate">--%>
<%--                        <span class="prize">￥16.80</span>--%>
<%--                        <span class="unit">16.80/500g</span>--%>
<%--                        <a href="#" class="add_goods" title="加入购物车"></a>--%>
<%--                    </div>--%>
<%--                </li>--%>

<%--                <li>--%>
<%--                    <a href="#"><img src="${pageContext.request.contextPath}/image/goods004.jpg"></a>--%>
<%--                    <h4><a href="#">吐鲁番梨光杏</a></h4>--%>
<%--                    <div class="operate">--%>
<%--                        <span class="prize">￥5.50</span>--%>
<%--                        <span class="unit">5.50/500g</span>--%>
<%--                        <a href="#" class="add_goods" title="加入购物车"></a>--%>
<%--                    </div>--%>
<%--                </li>--%>

<%--                <li>--%>
<%--                    <a href="#"><img src="${pageContext.request.contextPath}/image/goods005.jpg"></a>--%>
<%--                    <h4><a href="#">黄肉桃</a></h4>--%>
<%--                    <div class="operate">--%>
<%--                        <span class="prize">￥10.00</span>--%>
<%--                        <span class="unit">10.00/500g</span>--%>
<%--                        <a href="#" class="add_goods" title="加入购物车"></a>--%>
<%--                    </div>--%>
<%--                </li>--%>

<%--                <li>--%>
<%--                    <a href="#"><img src="${pageContext.request.contextPath}/image/goods006.jpg"></a>--%>
<%--                    <h4><a href="#">进口西梅</a></h4>--%>
<%--                    <div class="operate">--%>
<%--                        <span class="prize">￥28.80</span>--%>
<%--                        <span class="unit">28.8/500g</span>--%>
<%--                        <a href="#" class="add_goods" title="加入购物车"></a>--%>
<%--                    </div>--%>
<%--                </li>--%>

<%--                <li>--%>
<%--                    <a href="#"><img src="${pageContext.request.contextPath}/image/goods007.jpg"></a>--%>
<%--                    <h4><a href="#">香梨</a></h4>--%>
<%--                    <div class="operate">--%>
<%--                        <span class="prize">￥6.45</span>--%>
<%--                        <span class="unit">6.45/500g</span>--%>
<%--                        <a href="#" class="add_goods" title="加入购物车"></a>--%>
<%--                    </div>--%>
<%--                </li>--%>
                </c:if>
            </ul>
        </div>
    </div>
</div>


<div class="footer">
    <div class="foot_link">
        <a href="#">关于我们</a>
        <span>|</span>
        <a href="#">联系我们</a>
        <span>|</span>
        <a href="#">招聘人才</a>
        <span>|</span>
        <a href="#">友情链接</a>
    </div>
    <p>CopyRight © 2016 北京天天生鲜信息技术有限公司 All Rights Reserved</p>
    <p>电话：010-****888    京ICP备*******8号</p>
</div>
</body>
</html>
