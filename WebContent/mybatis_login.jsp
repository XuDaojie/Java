<%--
  Created by IntelliJ IDEA.
  User: xdj
  Date: 2017/4/2
  Time: 上午10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="mybatisLogin" method="post">
    <table>
        <tr>
            <td>登录</td>
            <td><input name="username" type="text"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input name="password" type="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
