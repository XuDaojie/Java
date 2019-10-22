<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Session内置对象</h1>
<%
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String time = sdf.format(session.getCreationTime());

    String username = null;
    if (session.getAttribute("username") != null) {
        username = session.getAttribute("username").toString();
    }
%>
Session创建时间:<%=time %> <br>
SessionID:<%=session.getId() %> <br>
Username:<%=username %>
</body>
</html>