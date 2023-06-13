<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>World Clock</title>
</head>
<body>
<h1>Local Time in Major Cities</h1>
<ul>
    <%
        java.util.Map<String, String> times = (java.util.Map<String, String>) request.getAttribute("times");
        for (java.util.Map.Entry<String, String> entry : times.entrySet()) {
    %>
    <li><%= entry.getKey() %>: <%= entry.getValue() %></li>
    <%
        }
    %>
</ul>
</body>
</html>