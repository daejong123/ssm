<%--
  Created by IntelliJ IDEA.
  User: DaeJong
  Date: 2017/4/7
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>主页</title>
    <style>
        menu, h1, ul{
            margin: 0px;
        }
        html, body {
            margin: 0px;
            height:100%;
            font-size:18px;
        }
        body>header {
            line-height: 80px;
            background: #e3e3e3;
            text-align: center;
        }

        body>header>h1{
            display: inline;
        }

        body>header>span{
            float: right;
            margin-right:50px;
        }

        .body {
            position: absolute;
            top: 80px;
            bottom:0;
            width:100%;
        }

        .body>menu {
            position: absolute;
            left:0;
            width:200px;
            height:100%;
            background: #eee;
            box-sizing: border-box;
        }

        .body>menu>ul {
            padding-left:10px;
        }

        .body>menu>ul>li {
            margin-top:30px;
        }
        .body>main {
            margin-left:200px;
            height:100%;
        }
        main>iframe{
            height:100%;
            width:100%;
            border:0;
            display: block;
        }
    </style>
</head>
<body>
    <header>
        <h1>金鹰VIP消费查询系统</h1>
        <span>
            你好! <b><i>${sessionScope.currentUser.name}</i></b>
            <a href="logOut.do">退出登录</a>
        </span>
    </header>

    <section class="body">
        <menu>
            <ul>
                <li>
                    <a href="${pageContext.request.contextPath}/vip/qry.do" target="mainFrame">vip客户查询</a>
                </li>
                <li>
                    <a href="#">录入vip客户</a>
                </li>
                <li>
                    <a href="#">vip客户管理</a>
                </li>
                <li>
                    <a href="#">查看vip消费记录</a>
                </li>
                <li>
                    <a href="#">录入vip消费记录</a>
                </li>
                <li>
                    <a href="#">vip消费记录管理</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/updatePassword.do" target="mainFrame">修改密码</a>
                </li>
            </ul>
        </menu>
        <main>
            <iframe name="mainFrame" src="${pageContext.request.contextPath}/welcome.do"></iframe>
        </main>
    </section>

</body>
</html>
