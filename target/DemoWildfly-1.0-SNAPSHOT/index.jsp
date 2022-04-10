<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>Ï
<h1><% for(int i = 0; i < 10; i++){%>
    <br> hallo <% out.println(i); %>
    <%}%>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>