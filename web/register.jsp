<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>天天生鲜-注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
    <style>
        #sendCode:hover{
            color: red;
        }
    </style>
</head>
<body>
<div class="register_con">
    <div class="l_con fl">
        <a class="reg_logo"><img src="${pageContext.request.contextPath}/image/logo02.png"></a>
        <div class="reg_slogan">足不出户  ·  新鲜每一天</div>
        <div class="reg_banner"></div>
    </div>

    <div class="r_con fr">
        <div class="reg_title clearfix">
            <h1>用户注册</h1>
            <a href="login.jsp">登录</a>
        </div>
        <div class="reg_form clearfix">
            <form action="user?method=reg" method="post">
                <ul>
                    <li>
                        <label>用户名:</label>
                        <input type="text" name="user_name" id="user_name">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>密码:</label>
                        <input type="password" name="pwd" id="pwd">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>确认密码:</label>
                        <input type="password" name="cpwd" id="cpwd">
                        <span class="error_tip">提示信息</span>
                    </li>
                    <li>
                        <label>邮箱:</label>
                        <input type="text" name="email" id="email"><span class="error_tip Myemail">提示信息</span>
                    </li>
                    <li>
                        <label>验证码:</label>
                        <input type="code" name="emailCode">
<%--                        <span class="error_tip">提示信息</span>--%>
                    </li>
                    <li class="agreement">
                        <input type="checkbox" name="allow" id="allow" checked>
                        <label>同意”天天生鲜用户使用协议“</label>
                        <span class="error_tip2">提示信息</span>
                    </li>
                    <script>
                        $(function () {

                            $("[name='allow']").click(function () {
                                var isChecked = $('#allow').prop('checked');
                                if (isChecked==false){
                                    $("#btn").css({"background-color":"gray"}).attr("disabled",true)
                                }else {
                                    $("#btn").css({"background-color":"#47aa34"}).attr("disabled",false)
                                }
                            });
                            $("#sendCode").click(function () {
                                var email = $("[name='email']").val();
                                if (email==""||email==null){
                                    alert("邮箱不能为空！")
                                }else {
                                    $(this).next().html(" ")
                                $.ajax({
                                    url:"user",
                                    type:"post",
                                    data:{"method":"sendCode","email":$("[name='email']").val()},
                                    success:function () {
                                        alert("发送成功!请去邮箱查收")
                                        $("#sendCode").html("已发送,重新发送？")
                                    }
                                });
                                }

                            });
                        })
                    </script>
                    <li class="reg_sub">
                        <input type="submit" id="btn" value="注 册" name="">
                    </li>
                    <a id="sendCode" style="position: relative;top: -20vw;left: 27vw">发送验证码</a>
                </ul>
            </form>
        </div>

    </div>

</div>

<div class="footer no-mp">
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
