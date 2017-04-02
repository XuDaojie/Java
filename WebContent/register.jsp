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
    <script type="application/javascript">
        function register() {
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            var passwordConfirm = document.getElementById("password_confirm").value;

            if (username === "") {
                alert("请输入用户名")
            } else if (password === "") {
                alert("请输入密码")
            } else if (passwordConfirm === "") {
                alert("请输入确认密码")
            } else if (password !== passwordConfirm) {
                alert("两次输入的密码不同")
            } else {
                document.getElementById("register_form").submit();
            }
        }
    </script>
    <title>注册</title>
</head>
<body>
<form id="register_form" action="register.do" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td><input id="username" name="username" type="text"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input id="password" name="password" type="password"></td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td><input id="password_confirm" name="password_confirm" type="password"></td>
        </tr>
        <tr>
            <td>国籍</td>
            <td>
                <select id="country">
                    <option value="v1">中国</option>
                    <option value="v2">美国</option>
                    <option value="v3">俄罗斯</option>
                    <option value="v4">英国</option>
                    <option value="v5">法国</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="button" onclick="register()" value="确认注册"></td>
        </tr>
    </table>
</form>
</body>
</html>
