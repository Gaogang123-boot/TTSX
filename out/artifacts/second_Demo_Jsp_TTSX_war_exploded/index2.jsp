<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>天天生鲜-首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" >
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/my.css" >
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/slide.js"></script>
<%--    <style>--%>
<%--      .serachContent{--%>
<%--        height: 30px;--%>
<%--        font-size: 20px;--%>
<%--        padding-left: 40px;--%>

<%--      }--%>
<%--      .serachContent a{--%>
<%--        font-family: "微软雅黑";--%>
<%--        text-decoration: none;--%>
<%--        color: darkgrey;--%>
<%--      }--%>
<%--      .serachContent:hover{--%>
<%--        background: gray;--%>
<%--      }--%>
<%--    </style>--%>
  </head>
  <body>
  <div class="header_con">
    <div class="header">
      <div class="welcome fl">欢迎来到天天生鲜!</div>
      <div class="fr">
<%--        <div class="login_info fl">--%>

<%--        </div>--%>
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
          <a href="show?method=showcart">我的购物车</a>
          <span>|</span>
          <a href="user_center_order.jsp">我的订单</a>
        </div>
      </div>
    </div>
  </div>

  <div class="search_bar clearfix">
    <a href="index2.jsp" class="logo fl"><img src="${pageContext.request.contextPath}/image/logo.png"></a>
    <div class="search_con fl">
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
    <div id="mySearchDiv" onmouseleave="divClose()" style="overflow: hidden;overflow-y:scroll;height:300px;display: none;border:1px solid forestgreen;width: 617px;background:white;position: absolute;z-index: 5;left: 26.8vw;top: 7.6vw"></div>
    <script>
      function divClose(){
        document.getElementById("mySearchDiv").style.display="none";
      }
    </script>
    <div class="guest_cart fr">
      <a href="cart.jsp" class="cart_name fl">我的购物车</a>
      <div class="goods_count fl" id="show_count">1</div>
    </div>
  </div>

  <div class="navbar_con">
    <div class="navbar">
      <h1 class="fl">全部商品分类</h1>
      <ul class="navlist fl">
        <li><a href="index2.jsp">首页</a></li>
        <li class="interval">|</li>
        <li><a href="">手机生鲜</a></li>
        <li class="interval">|</li>
        <li><a href="">抽奖</a></li>
      </ul>
    </div>
  </div>

  <div class="center_con clearfix">
    <ul class="subnav fl">
      <li><a href="#model01" class="fruit">新鲜水果</a></li>
      <li><a href="#model02" class="seafood">海鲜水产</a></li>
      <li><a href="#model03" class="meet">猪牛羊肉</a></li>
      <li><a href="#model04" class="egg">禽类蛋品</a></li>
      <li><a href="#model05" class="vegetables">新鲜蔬菜</a></li>
      <li><a href="#model06" class="ice">速冻食品</a></li>
    </ul>
    <div class="slide fl">
      <ul class="slide_pics">
        <li><img src="${pageContext.request.contextPath}/image/slide.jpg" alt="幻灯片"></li>
        <li><img src="${pageContext.request.contextPath}/image/slide02.jpg" alt="幻灯片"></li>
        <li><img src="${pageContext.request.contextPath}/image/slide03.jpg" alt="幻灯片"></li>
        <li><img src="${pageContext.request.contextPath}/image/slide04.jpg" alt="幻灯片"></li>
      </ul>
      <div class="prev"></div>
      <div class="next"></div>
      <ul class="points"></ul>
    </div>
    <div class="adv fl">
      <a href="#"><img src="${pageContext.request.contextPath}/image/adv01.jpg"></a>
      <a href="#"><img src="${pageContext.request.contextPath}/image/adv02.jpg"></a>
    </div>
  </div>

  <div class="list_model">
    <div class="list_title clearfix">
      <h3 class="fl" id="model01">新鲜水果</h3>
      <div class="subtitle fl">
        <span>|</span>
        <a href="#">鲜芒</a>
        <a href="#">加州提子</a>
        <a href="#">亚马逊牛油果</a>
      </div>
      <a href="goods?method=goodsAllProduct&goodsName=新鲜水果" class="goods_more fr" id="fruit_more">查看更多 ></a>
    </div>

    <div class="goods_con clearfix">
      <div class="goods_banner fl"><img src="${pageContext.request.contextPath}/image/banner01.jpg"></div>
      <ul class="goods_list fl">
        <c:forEach items="${goodsFruitAll}" var="gfs">
                  <li>
                    <h4><a href="goods?method=findGoodsById&goodsId=${gfs.goodsId}">${gfs.goodsName}</a></h4>
                    <a href="goods?method=findGoodsById&goodsId=${gfs.goodsId}"><img src="${pageContext.request.contextPath}/${gfs.goodsPic}"></a>
                    <div class="prize"><fmt:formatNumber value="${gfs.goodsPrice}" type="currency"></fmt:formatNumber></div>
                  </li>
        </c:forEach>
      </ul>
    </div>
  </div>

  <div class="list_model">
    <div class="list_title clearfix">
      <h3 class="fl" id="model02">海鲜水产</h3>
      <div class="subtitle fl">
        <span>|</span>
        <a href="#">河虾</a>
        <a href="#">扇贝</a>
      </div>
      <a href="goods?method=goodsAllProduct&goodsName=海鲜水产" class="goods_more fr">查看更多 ></a>
    </div>

    <div class="goods_con clearfix">
      <div class="goods_banner fl"><img src="${pageContext.request.contextPath}/image/banner02.jpg"></div>
      <ul class="goods_list fl">
        <c:forEach items="${goodsSeafoodAll}" var="gsa">
                  <li>
                    <h4><a href="goods?method=findGoodsById&goodsId=${gsa.goodsId}">${gsa.goodsName}</a></h4>
                    <a href="goods?method=findGoodsById&goodsId=${gsa.goodsId}"><img src="${pageContext.request.contextPath}/${gsa.goodsPic}"></a>
                    <div class="prize"><fmt:formatNumber value="${gsa.goodsPrice}" type="currency"></fmt:formatNumber></div>
                  </li>
        </c:forEach>
      </ul>
    </div>
  </div>

  <div class="list_model">
    <div class="list_title clearfix">
      <h3 class="fl" id="model03">猪牛羊肉</h3>
      <div class="subtitle fl">
        <span>|</span>
        <a href="#">鲜芒</a>
        <a href="#">加州提子</a>
        <a href="#">亚马逊牛油果</a>
      </div>
      <a href="#" class="goods_more fr">查看更多 ></a>
    </div>

    <div class="goods_con clearfix">
      <div class="goods_banner fl"><img src="${pageContext.request.contextPath}/image/banner03.jpg"></div>
      <ul class="goods_list fl">
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
      </ul>
    </div>
  </div>

  <div class="list_model">
    <div class="list_title clearfix">
      <h3 class="fl" id="model04">禽类蛋品</h3>
      <div class="subtitle fl">
        <span>|</span>
        <a href="#">鲜芒</a>
        <a href="#">加州提子</a>
        <a href="#">亚马逊牛油果</a>
      </div>
      <a href="#" class="goods_more fr">查看更多 ></a>
    </div>

    <div class="goods_con clearfix">
      <div class="goods_banner fl"><img src="${pageContext.request.contextPath}/image/banner04.jpg"></div>
      <ul class="goods_list fl">
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
      </ul>
    </div>
  </div>

  <div class="list_model">
    <div class="list_title clearfix">
      <h3 class="fl" id="model05">新鲜蔬菜</h3>
      <div class="subtitle fl">
        <span>|</span>
        <a href="#">鲜芒</a>
        <a href="#">加州提子</a>
        <a href="#">亚马逊牛油果</a>
      </div>
      <a href="#" class="goods_more fr">查看更多 ></a>
    </div>

    <div class="goods_con clearfix">
      <div class="goods_banner fl"><img src="${pageContext.request.contextPath}/image/banner05.jpg"></div>
      <ul class="goods_list fl">
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
      </ul>
    </div>
  </div>

  <div class="list_model">
    <div class="list_title clearfix">
      <h3 class="fl" id="model06">速冻食品</h3>
      <div class="subtitle fl">
        <span>|</span>
        <a href="#">鲜芒</a>
        <a href="#">加州提子</a>
        <a href="#">亚马逊牛油果</a>
      </div>
      <a href="#" class="goods_more fr">查看更多 ></a>
    </div>

    <div class="goods_con clearfix">
      <div class="goods_banner fl"><img src="${pageContext.request.contextPath}/image/banner06.jpg"></div>
      <ul class="goods_list fl">
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
        <li>
          <h4><a href="#">维多利亚葡萄</a></h4>
          <a href="#"><img src="${pageContext.request.contextPath}/image/goods.jpg"></a>
          <div class="prize">¥ 38.00</div>
        </li>
      </ul>
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
  <style>
    .copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
  </style>

  </body>
</html>
