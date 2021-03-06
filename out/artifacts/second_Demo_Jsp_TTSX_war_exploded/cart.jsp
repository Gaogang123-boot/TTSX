<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天天生鲜-购物车</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css">
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
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
    <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;购物车</div>
    <div class="search_con fr">
        <input type="text" class="input_text fl searchGoods" name="content" placeholder="搜索商品">
        <input type="button" class="input_btn fr" name="" value="搜索">
        <script>
            $(function () {
                $(".searchGoods").keyup(function () {
                    $.ajax({
                        url:"goods",
                        type:"post",
                        data:{
                            "method":"searchGoods",
                            "content":$(this).val()
                        },
                        dataType:"json",
                        success:function (data) {
                            $("#mySearchDiv").css({"display":"block"})

                            var msg = "";
                            $.each(data,function (index, k) {
                                msg+="<div class='serachContent'><a href='goods?method=findGoodsById&goodsId="+k.goodsId+"'>"+k.goodsName+"</a></div>"
                            });
                            // $(".serachContent").mouseover(function () {
                            //   $(this).css({"background":"gray"})
                            // });
                            $("#mySearchDiv").html(msg);
                        }
                    });
                });

            })
        </script>
    </div>
    <div id="mySearchDiv" onmouseleave="divClose()" style="overflow: hidden;overflow-y:scroll;height:300px;display: none;border:1px solid forestgreen;width: 617px;background:white;position: absolute;z-index: 5;left: 48vw;top: 7.6vw"></div>
    <script>
        function divClose(){
            document.getElementById("mySearchDiv").style.display="none";
        }
    </script>
</div>

<div class="total_count">全部商品<em>2</em>件</div>
<ul class="cart_list_th clearfix">
    <li class="col01">商品名称</li>
    <li class="col02">商品单位</li>
    <li class="col03">商品价格</li>
    <li class="col04">数量</li>
    <li class="col05">小计</li>
    <li class="col06">操作</li>
</ul>
<ul class="cart_list_td clearfix">
    <c:set var="total" value="0"/>
    <c:set var="totnum" value="0"/>
    <c:forEach items="${cartList}" var="gg">
        <li class="col01"><input type="checkbox" name="" checked></li>
        <li class="col02"><img src="${pageContext.request.contextPath}/${gg.goodsPic}"></li>
        <li class="col03">${gg.goodsName}<br><em>${gg.goodsPrice}元/500g</em></li>
        <li class="col04">500g</li>
        <li class="col05">${gg.goodsPrice}元</li>
        <li class="col06">
            <div class="num_add">
                <a href="javascript:;" class="add fl">+</a>
                <input type="text" class="num_show fl" value="${gg.goodsNum}">
                <a href="javascript:;" class="minus fl">-</a>
            </div>
        </li>
        <li class="col07">${gg.goodsPrice*gg.goodsNum}元</li>
        <li class="col08"><a href="javascript:;">删除</a></li>
        <c:set var="total" value="${total+gg.goodsPrice*gg.goodsNum}"/>
        <c:set var="totnum" value="${totnum+gg.goodsNum}"/>
    </c:forEach>
</ul>

<%--<ul class="cart_list_td clearfix">--%>
<%--    <li class="col01"><input type="checkbox" name="" checked></li>--%>
<%--    <li class="col02"><img src="${pageContext.request.contextPath}/image/goods003.jpg"></li>--%>
<%--    <li class="col03">大兴大棚草莓<br><em>16.80元/500g</em></li>--%>
<%--    <li class="col04">500g</li>--%>
<%--    <li class="col05">16.80元</li>--%>
<%--    <li class="col06">--%>
<%--        <div class="num_add">--%>
<%--            <a href="javascript:;" class="add fl">+</a>--%>
<%--            <input type="text" class="num_show fl" value="1">--%>
<%--            <a href="javascript:;" class="minus fl">-</a>--%>
<%--        </div>--%>
<%--    </li>--%>
<%--    <li class="col07">16.80元</li>--%>
<%--    <li class="col08"><a href="javascript:;">删除</a></li>--%>
<%--</ul>--%>


<ul class="settlements">
    <li class="col01"><input type="checkbox" name="" checked=""></li>
    <li class="col02">全选</li>
    <li class="col03">合计(不含运费)：<span>¥</span><em>${total}</em><br>共计<b>${totnum}</b>件商品</li>
    <li class="col04"><a href="place_order.jsp">去结算</a></li>
</ul>

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
