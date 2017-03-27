<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
    response.setContentType("text/html;charset=utf-8");
    out.println("<h1>内置out对象</h1>");
    out.flush(); // response生成的out对象总是在内置对象前进行输出，通过此方法可强制将内置out内容首先输出
    PrintWriter outer = response.getWriter();
    outer.println("<h1>responese生成的out对象</h1>");
    %>
    
</body>
</html>