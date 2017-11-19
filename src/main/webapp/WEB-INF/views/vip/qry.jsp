<%@ page pageEncoding="utf-8" contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>查询vip用户</title>
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

    <h2>vip客户查询 <small>(支持模糊查询)</small></h2>
    <header>
        <form action="${pageContext.request.contextPath}/vip/qry.do" method="post">
            <p>
                <label><input name="key" autofocus></label>
                <button type="submit">查询</button>
                ${daejong}
            </p>
        </form>
    </header>
    <p>查询结果如下:</p>
    <hr>

    <main>
        <article>
            <table style="text-align: center" border="1" cellspacing="0" cellpadding="0" width="100%">
                <tr>
                    <th>编号</th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>年龄</th>
                    <th>等级</th>
                    <th>消费总金额</th>
                    <th>QQ</th>
                    <th>邮箱</th>
                    <th>地址</th>
                    <th>邮编</th>
                </tr>
                <c:forEach items="${vipList}" var="item">
                    <tr>
                        <td>${item['id']}</td>
                        <td>${item.name}</td>
                        <td>${item.code}</td>
                        <td>${item.age}</td>
                        <td>${item.rank.name} (${item.rank.discount}折)</td>
                        <td>${item.amount}</td>
                        <td>${item.qq}</td>
                        <td>${item.email}</td>
                        <td>${item.address}</td>
                        <td>${item.zip}</td>
                    </tr>
                </c:forEach>
            </table>
        </article>
        <div>
            <a href="${pageContext.request.contextPath}/vip/qry.do?page=${page.firstPage}">首页</a>
            <a href="${pageContext.request.contextPath}/vip/qry.do?page=${page.hasPreviousPage ? page.prePage : page.pageNum}">上一页</a>
            <a href="${pageContext.request.contextPath}/vip/qry.do?page=${page.hasNextPage ? page.nextPage : page.pageNum}">下一页</a>
            <a href="${pageContext.request.contextPath}/vip/qry.do?page=${page.lastPage}">末页</a>
        </div>
    </main>
</body>
</html>
