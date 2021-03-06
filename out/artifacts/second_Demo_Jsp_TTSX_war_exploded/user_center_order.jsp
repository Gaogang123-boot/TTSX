<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天天生鲜-用户中心</title>
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
    <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>
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

<div class="main_con clearfix">
    <div class="left_menu_con clearfix">
        <h3>用户中心</h3>
        <ul>
            <li><a href="user_center_info.jsp">· 个人信息</a></li>
            <li><a href="user_center_order.jsp"  class="active">· 全部订单</a></li>
            <li><a href="user_center_site.jsp" >· 收货地址</a></li>
        </ul>
    </div>
    <div class="right_content clearfix">
        <h3 class="common_title2">全部订单</h3>
        <ul class="order_list_th w978 clearfix">
            <li class="col01">2016-8-21 17:36:24</li>
            <li class="col02">订单号：56872934</li>
            <li class="col02 stress">未支付</li>
        </ul>

        <table class="order_list_table w980">
            <tbody>
            <tr>
                <td width="55%">
                    <ul class="order_goods_list clearfix">
                        <li class="col01"><img src="${pageContext.request.contextPath}/image/goods02.jpg" ></li>
                        <li class="col02">嘎啦苹果嘎啦苹果<em>11.80元/500g</em></li>
                        <li class="col03">1</li>
                        <li class="col04">11.80元</li>
                    </ul>
                    <ul class="order_goods_list clearfix">
                        <li class="col01"><img src="${pageContext.request.contextPath}/image/goods02.jpg"></li>
                        <li class="col02">嘎啦苹果嘎啦苹果<em>11.80元/500g</em></li>
                        <li class="col03">1</li>
                        <li class="col04">11.80元</li>
                    </ul>
                </td>
                <td width="15%">33.60元</td>
                <td width="15%">待付款</td>
                <td width="15%"><a href="#" class="oper_btn">去付款</a></td>
            </tr>
            </tbody>
        </table>

        <ul class="order_list_th w978 clearfix">
            <li class="col01">2016-8-21 17:36:24</li>
            <li class="col02">订单号：56872934</li>
            <li class="col02 stress">已支付</li>
        </ul>
        <table class="order_list_table w980">
            <tbody>
            <tr>
                <td width="55%">
                    <ul class="order_goods_list clearfix">
                        <li class="col01"><img src="${pageContext.request.contextPath}/image/goods02.jpg" ></li>
                        <li class="col02">嘎啦苹果嘎啦苹果<em>11.80元/500g</em></li>
                        <li class="col03">1</li>
                        <li class="col04">11.80元</li>
                    </ul>
                    <ul class="order_goods_list clearfix">
                        <li class="col01"><img src="${pageContext.request.contextPath}/image/goods02.jpg"></li>
                        <li class="col02">嘎啦苹果嘎啦苹果<em>11.80元/500g</em></li>
                        <li class="col03">1</li>
                        <li class="col04">11.80元</li>
                    </ul>
                </td>
                <td width="15%">33.60元</td>
                <td width="15%">已付款</td>
                <td width="15%"><a href="#" class="oper_btn">查看物流</a></td>
            </tr>
            </tbody>
        </table>

        <div class="pagenation">
            <a href="#"><上一页</a>
            <a href="#" class="active">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">下一页></a>
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
