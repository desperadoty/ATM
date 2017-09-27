<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/4
  Time: 11:36
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
            top:150px;
            left:288px;
            text-align:center;
            font-size:25px;
        }
        .english{
            font-family:Sans-serif;
        }
        body {
            font-family:"Microsoft Yahei";
            background: url("images/background.jpg");
            overflow-x:hidden;
        }
        .account{
            text-align:center;
            width:250px;
            height:50px;
            border-radius:5px;
            font-weight:bold;
            font-size:20px;
            left:558px;
            top:230px;
            position:fixed;
            box-shadow: 1px 1px 5px #000,inset 1px 1px 5px #000;
        }
        .exit,.return{
            width:200px;
            height:50px;
            border-radius:30px;
            font-weight:bold;
            font-size:20px;
            border:4px outset red;
            background:white;
        }
        .exit,.return:hover{
            border:4px inset red;
            background:white;
        }
        .exit{
            position:fixed;
            left:100px;
            top:540px;
        }
        .return{
            position:fixed;
            left:1070px;
            top:540px;
        }
        .tip{
            font-weight:bold;
            position:relative;
            top:120px;
            left:100px;
            border:1px solid #000; width:285px; height:160px;
            border-radius:10px;
            box-shadow: 3px 3px 5px #000,inset 2px 2px 5px #000;
            background:#d0d0d0;
        }
        h4{
            text-align:center;
            color:#F00;
            font-size:25px;
        }
        .grid_wrapper{
            width: 170px;
            height: 200px;
            left:600px;
            top:310px;
            position:fixed;
        }
        .grid{
            margin-left: 5px;
            margin-top: 5px;
        }
        .grid:after{
            content: ".";
            display: block;
        }
        .grid li{float:left;line-height: 50px;}
        .grid li,.grid li:visited{
            display:block;
            border: 5px solid #ccc;
            width: 50px;
            height: 50px;
            text-align: center;
            margin-left: -5px;
            margin-top: -5px;
            position: relative;
            z-index: 1;
        }
        .grid li a:hover{
            border-color: #f00;
            z-index: 2;
        }
        .Button{
            width:49px;
            height:49px;
            border-radius:5px;
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
        }
    </style>
    <script language="javascript" type="text/javascript">
        function btnRes_onclick() {
            str = document.getElementById("account");
            num=str.value;
            var newstr=num.substring(0,num.length-1);
            str.value = newstr;
        }
        function btnNum_onclick(i) {
            account.value=account.value+i;
        }
    </script>
</head>
<body>
<div class="logo"><img src="images/sign.png"></div>
<div class="line">
    <hr width="100%" color="#F00" size="2"/>
    <hr width="100%" color="#000" size="2"/>
</div>
<div class="title"><span class="bank">校园银行</span><br/>BANK OF CAMPUS</div>
<div class="tel">
    <h2>本机编号：12340001</h2>
    <h2>客服电话：95558</h2>
</div>
<div class="text">
    请输入转账账号并以确定键结束<br/><span class="english">Please input the transfer and press the enter key to the end.</span>
</div>
<form action="transfer_check.jsp" method="post">
    <input type="text" class="account" id="account" name="transferin" >
    <div class="tip">
        <h4>安全提示</h4><br/>
        &nbsp;△操作前请先确认收款账户的真实性，<br/>
        &nbsp; 不要轻信他人假冒银行张贴的通知。<br/>
        &nbsp;△不给陌生人汇款、转账，谨防被骗，<br/>&nbsp;造成损失。
    </div>
    <div class="grid_wrapper">
        <ul class="grid">
            <li><input class="Button" type="button" value="1" onclick="return btnNum_onclick(1)"/></li>
            <li><input class="Button" type="button" value="2" onclick="return btnNum_onclick(2)"/></li>
            <li><input class="Button" type="button" value="3" onclick="return btnNum_onclick(3)"/></li>
            <li><input class="Button" type="button" value="4" onclick="return btnNum_onclick(4)"/></li>
            <li><input class="Button" type="button" value="5" onclick="return btnNum_onclick(5)"/></li>
            <li><input class="Button" type="button" value="6" onclick="return btnNum_onclick(6)"/></li>
            <li><input class="Button" type="button" value="7" onclick="return btnNum_onclick(7)"/></li>
            <li><input class="Button" type="button" value="8" onclick="return btnNum_onclick(8)"/></li>
            <li><input class="Button" type="button" value="9" onclick="return btnNum_onclick(9)"/></li>
            <li><input class="Button" type="button" value="清除" onclick="return btnRes_onclick()"/></li>
            <li><input class="Button" type="button" value="0" onclick="return btnNum_onclick(0)"/></li>
            <li><input class="Button" type="submit" value="确定"/></li>
        </ul>
    </div>
</form>
<div id="time"></div>
<a href="login_ok.jsp" style="text-decoration: none"><button class="return">返&nbsp;&nbsp;&nbsp;&nbsp;回 &nbsp;&nbsp;&nbsp;&nbsp;&minus;&gt;</button></a>
<a href="index.jsp" style="text-decoration: none"><button class="exit">&lt;&minus;&nbsp;&nbsp;&nbsp;&nbsp;退&nbsp;&nbsp;&nbsp;&nbsp;卡</button></a>
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
