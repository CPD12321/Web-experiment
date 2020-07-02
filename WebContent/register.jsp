<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>login</title>
    <link href="css/semantic.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath }/scripts/jquery-1.9.1.min.js"></script>
</head>
<body style="background: url(img/8.jpg);background-size: cover">
<br>
<br>
<br>
<h1 align="center">注册</h1>
<div class="loginpage">
    <br> <br> <br>
    <h2 align="center">欢迎注册</h2>
    <!--do_login.jsp  -->
    <form action="RegisterServlet.do"method="post">
        <table align="center" width="298" border="0" cellpadding="2" cellspacing="1">
            <tr>
                <td align="right">用户名：</td>
                <td align="left">
                    <input type="text"  placeholder="请输入用户名" name="account" size="15" id="input1">
                </td>
            </tr>
            <tr>
                <td align="right">密码：</td>
                <td align="left">
                    <input type="password" placeholder="请输入密码" name="password" size="15" id="input2">
                </td>
            <tr />
            <br>
        </table>
        <div class="submit-p">
            <div class="submit-button">
                <input type="submit" value="注册" />
            </div>

            <div class="back-button" >
                <input type="button"  value="返回" onclick=" window.location.href='index.jsp'" />
            </div>
        </div>
    </form>
<span id="e1" style="color: red; position:relative; left: 150px; top: 30px;">
  <%
      Object error1 = request.getAttribute("error1");
      if (error1!=null){
          out.print(error1);
      }
  %>
</span>
<span id="e2" style="color: red; position:relative; left: 150px; top: 30px;">
  <%
      Object error2 = request.getAttribute("success");
      if (error2!=null){
          out.print(error2);
      }
  %>
</span>
</div>
<script type="text/javascript">
    function resValue() {
        document.getElementById("input1").value="";
        document.getElementById("input2").value="";
    }

</script>


<style>
    .loginpage {
        height: 400px;
        border: 1px solid #d7d7d7;
        box-shadow: 0 0 20px #d7d7d7;
        background-color: #fff;
        position: absolute;
        width: 382px;
        color: #818181;
        margin: 80px auto;
        position: absolute;
        left: 0;
        right: 0;
    }

    .submit-button {
        display: inline;

    }

    .back-button {
        display: inline;
        margin-left: 20px;
    }

    .submit-p {
        margin-left: 150px;
        margin-top:20px;
    }
</style>
</body>
</html>

