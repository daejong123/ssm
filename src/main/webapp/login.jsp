<%--
  Created by IntelliJ IDEA.
  User: DaeJong
  Date: 2017/4/7
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page  pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="x-ua-compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <%--引入bootstarp的css文件--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet">

    <script src="static/scripts/html5shiv.js"></script>
    <script src="static/scripts/respond.js"></script>
    <script src="static/scripts/modernizr.js"></script>

    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <style>
        body{
            padding:10px;
        }
    </style>
    <script>
        if(window.top != window) {
            window.top.location.href = window.location.href;
        }
    </script>
</head>
<body>
    <h1>用户登录界面</h1>
    <hr>
    <strong>${message}</strong>
    <form action="${pageContext.request.contextPath}/login.do" method="post">
        <div class="form-group">
            <label for="usernameInput">用户名</label>
            <input type="text" class="form-control" id="usernameInput" placeholder="username" name="username">
        </div>
        <div class="form-group">
            <label for="passwordInput">密码</label>
            <input type="password" class="form-control" id="passwordInput" placeholder="Password" name="password">
        </div>
        <p><button type="submit" class="btn btn-primary btn-block">提交</button></p>
        <p><button type="reset" class="btn btn-warning btn-block">重置</button></p>
        <%session.removeAttribute("message"); %>
    </form>
</body>
</html>
