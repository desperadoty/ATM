<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/4
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Campus Bank</title>
    <style type="text/css">
        *{
            margin:0;
            padding:0;
        }
        .bank{
            font-family:FZShuTi;
            font-size:60px;
            text-shadow:3px 3px 5px grey,-2px -2px 5px white;//阴影、模糊
        }
        .logo{
            position:relative;
            top:8px;
            left:5px;
        }
        .title{
            font-family:Sans-serif;
            font-size:30px;
            font-weight:bold;
            text-shadow:3px 3px 5px grey,-2px -2px 5px white;
            position:relative;
            left:110px;
            bottom:100px;
        }
        #time {
            width:50px;
            height:50px;
            border:2px solid white;
            position:fixed;
            right:320px;
            top:40px;
            text-align: center;
            background:#000;
            line-height: 50px;
            color:#00ec00;
            font-size:43px;
            box-shadow: 1px 1px 5px #000,inset 1px 1px 5px #000;
        }
        .tel{
            font-family:Sans-serif;
            font-size:20px;
            font-weight:bold;
            text-shadow:3px 3px 5px grey,-2px -2px 5px white;
            position:fixed;
            right:5px;
            top:30px;
        }
        .line{
            position:relative;
            top:15px;
        }
        .text{
            position:fixed;
            left:500px;
            top:265px;
            text-align:center;
            font-size:25px;
        }
        .english{
            font-family:Sans-serif;
        }
        button,input{
            width:200px;
            height:50px;
            border-radius:30px;
            font-weight:bold;
            font-size:20px;
            border:4px outset red;
            background:white;
        }
        button,input:hover{
            border:4px inset red;
            background:white;
        }
        /*.continue{*/
            /*position:fixed;*/
            /*left:100px;*/
            /*top:450px;*/
        /*}*/
        .show{
            position:fixed;
            left:1070px;
            top:450px;
        }
        .exit{
            position:fixed;
            left:100px;
            top:540px;
        }
        .return{
            position:fixed;
            left:1066px;
            top:540px;
        }
        body {
            font-family:"Microsoft Yahei";
            background: url("images/background.jpg");
            overflow:hidden;
        }
    </style>
</head>
<body>
<%
    String path = request.getContextPath();
    String transfer = request.getSession().getAttribute("transfer").toString();
%>
<div class="logo"><img src="images/sign.png"></div>
<div class="line">
    <hr width="100%" color="#f00" size="2"/>
    <hr width="100%" color="#000" size="2"/>
</div>
<div class="title"><span class="bank">校园银行</span><br/>BANK OF CAMPUS</div>
<div class="tel">
    <h2>本机编号：12340001</h2>
    <h2>客服电话：95558</h2>
</div>
<div class="text">
    <p>
    交易成功<br/>
    交易金额:<%=transfer%>元<br/>
    </p>
    <br/>
    <p>
    <span class="english">Successful trade</span><br/>
    <span class="english">Transaction amount:RMB&nbsp;<%=transfer%></span><br/>
    </p>
</div>
<form method="post" action="servlet/ServiceServlet">
    <input class="show" type="button" name="inquire" value="显&nbsp;示&nbsp;余&nbsp;额 &nbsp;&nbsp;&nbsp;&nbsp;&minus;&gt;"
           onclick="document.getElementById('btnType').value=this.name;this.form.submit()"/>
    <input type="hidden" id="btnType" name="btnType"/>
</form>

<%--<a href="<%=path%>/transfer_money.jsp" style="text-decoration: none">--%>
    <%--<button class="continue">--%>
        <%--&lt;&minus;&nbsp;&nbsp;&nbsp;&nbsp;继 &nbsp;续&nbsp;转&nbsp;账--%>
    <%--</button>--%>
<%--</a>--%>

<a href="<%=path%>/index.jsp" style="text-decoration: none">
    <button class="exit">
        &lt;&minus;&nbsp;&nbsp;&nbsp;&nbsp;退&nbsp;&nbsp;&nbsp;&nbsp;卡
    </button>
</a>
<a href="<%=path%>/login_ok.jsp" style="text-decoration: none">
    <button class="return">
        返&nbsp;&nbsp;&nbsp;&nbsp;回 &nbsp;&nbsp;&nbsp;&nbsp;&minus;&gt;
    </button>
</a>
<div id="time"></div>
</body>
</html>
<script type="text/javascript">
    var t = 61;  //设定倒数秒数
    var time;  //显示倒数秒数
    function showTime(){
        t -= 1;
        document.getElementById("time").innerHTML= t;
        time = setTimeout("showTime()",1000);  //每秒执行一次,showTime()
        if(t==0){
            location.href="index.jsp";
        }
    }
    showTime();  //执行showTime()
</script>