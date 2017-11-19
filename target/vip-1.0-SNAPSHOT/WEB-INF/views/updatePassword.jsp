<%--
  Created by IntelliJ IDEA.
  User: DaeJong
  Date: 2017/4/12
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>updatePassword</title>
    <style>
        input {
            width: 200px;
            height: 30px;
        }
        button {
            width: auto;
            height:30px;
        }
    </style>
</head>
<body>
    <h2>修改密码</h2>
    <a href="welcome.do">返回</a>
    <hr>
    <strong>${message}</strong>
    <form action="${pageContext.request.contextPath}/updatePassword.do" method="post">
        <p>
            <label>旧密码:<input name="oldPassword"></label>
        </p>
        <p>
            <label>新密码:<input name="newPassword"></label>
        </p>
        <p>
            <label>确认密码:<input name="newPasswordConfirm"></label>
        </p>
        <p>
            <button type="submit">确定</button>
        </p>
    </form>
</body>
</html>
