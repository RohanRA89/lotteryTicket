<%--
  Created by IntelliJ IDEA.
  User: rohanayub
  Date: 1/18/17
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lottery Ticket</title>
</head>
<body>
<h3>Here is your ticket print out:</h3>
<ul>
    <li><%=request.getSession().getAttribute("numone")%></li>
    <li><%=request.getSession().getAttribute("numtwo")%></li>
    <li><%=request.getSession().getAttribute("numthree")%></li>
    <li><%=request.getSession().getAttribute("numfour")%></li>
    <li><%=request.getSession().getAttribute("numfive")%></li>
    <li><%=request.getSession().getAttribute("numsix")%></li>
</ul>

<h3><a href="index.jsp">Return to lottery ticket generator</a> </h3>

</body>
</html>
