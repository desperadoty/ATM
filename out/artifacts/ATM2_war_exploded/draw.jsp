<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/3
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Campus Bank</title>
    <script language="javascript" type="text/javascript">
        function btnRes_onclick() {
            str = document.getElementById("draw");
            num=str.value;
            var newstr=num.substring(0,num.length-1);
            str.value = newstr;
        }
        function btnNum_onclick(i) {
            draw.value=draw.value+i;
        }
    </script>
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
            top:150px;
            left:500px;
            text-align:center;
            font-size:25px;
        }
        .english{
            font-family:Sans-serif;
        }
        .money{
            width:200px;
            height:50px;
            border-radius:5px;
            font-weight:bold;
            font-size:20px;
            left:583px;
            top:230px;
            position:fixed;
            box-shadow: inset 1px 1px 5px #000;
            text-align: center;
        }
        .number{
            color:red;
            font-weight:bold;
        }
        .btn{
            width:200px;
            height:50px;
            border-radius:30px;
            font-weight:bold;
            font-size:20px;
            border:4px outset red;
            background:white;
        }
        .btn:hover{
            border:4px inset red;
            background:white;
        }
        .tip{
            position:fixed;
            left:583px;
            top:300px;
        }
        .n100{
            position:fixed;
            left:100px;
            top:270px;
        }
        .n2500{
            position:fixed;
            left:1070px;
            top:270px;
        }
        .n500{
            position:fixed;
            left:100px;
            top:360px;

        }
        .n5000{
            position:fixed;
            left:1070px;
            top:360px;
        }
        .n1000{
            position:fixed;
            left:100px;
            top:450px;

        }
        .n10000{
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
            left:1070px;
            top:540px;
        }
        body {
            font-family:"Microsoft Yahei";
            background: url("images/background.jpg");
            overflow-x:hidden;
        }
        .grid_wrapper{
            width: 170px;
            height: 200px;
            left:600px;
            top:380px;
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
    </style>
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
    请您选择或输入取款金额<br/><span class="english">Please select or input amount</span>
</div>

<form action="servlet/DrawServlet" method="post">
    <input class="money" type="text"  id="draw" name="draw" >

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

    <input class="n100 btn" type="button" name="n100" value=" &lt;&minus;&nbsp;&nbsp;&nbsp;&nbsp;1&nbsp;0&nbsp;0"
           onclick="document.getElementById('service').value=this.name;this.form.submit()"/>

    <input class="n2500 btn" type="button" name="n2500" value="2&nbsp;5&nbsp;0&nbsp;0 &nbsp;&nbsp;&nbsp;&nbsp;&minus;&gt;"
           onclick="document.getElementById('service').value=this.name;this.form.submit()"/>

    <input class="n500 btn" type="button" name="n500" value=" &lt;&minus;&nbsp;&nbsp;&nbsp;&nbsp;5&nbsp;0&nbsp;0"
           onclick="document.getElementById('service').value=this.name;this.form.submit()"/>
    <div class="tip">
        本机现在提供面额为<span class="number">100</span>的纸币<br/>
        取款金额须为面额<span class="number">100</span>的整数倍<br/>

    </div>
    <input class="n5000 btn" type="button" name="n5000" value="5&nbsp;0&nbsp;0&nbsp;0 &nbsp;&nbsp;&nbsp;&nbsp;&minus;&gt;"
           onclick="document.getElementById('service').value=this.name;this.form.submit()"/>

    <input class="n1000 btn" type="button" name="n1000" value=" &lt;&minus;&nbsp;&nbsp;&nbsp;&nbsp;1&nbsp;0&nbsp;0&nbsp;0"
           onclick="document.getElementById('service').value=this.name;this.form.submit()"/>

    <input class="n10000 btn" type="button" name="n10000" value="1&nbsp;0&nbsp;0&nbsp;0&nbsp;0&nbsp;&nbsp;&nbsp;&nbsp;&minus;&gt;"
           onclick="document.getElementById('service').value=this.name;this.form.submit()"/>

    <input type="hidden" id="service" name="service"/>
</form>

<a href="login_ok.jsp" style="text-decoration: none"><button class="return btn">返&nbsp;&nbsp;&nbsp;&nbsp;回 &nbsp;&nbsp;&nbsp;&nbsp;&minus;&gt;</button></a>
<a href="index.jsp" style="text-decoration: none"><button class="exit btn">&lt;&minus;&nbsp;&nbsp;&nbsp;&nbsp;退&nbsp;&nbsp;&nbsp;&nbsp;卡</button></a>
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
