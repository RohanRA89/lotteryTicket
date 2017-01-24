<%--
  Created by IntelliJ IDEA.
  User: rohanayub
  Date: 1/19/17
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Here are your picks for the lottery:</h2>
<p>
    <ul>
        <li><%=request.getSession().getAttribute("lottList")%></li>
    </ul>
</p>

<h2>Here are the winning numbers:</h2>
<p>
    <ul>
    <li><strong><%=request.getAttribute("lotteryWin")%></strong></li>
    </ul>
</p>

<h2>Here are your results:</h2>
    <ul>
        <li><strong><%=request.getAttribute("winMessage")%></strong></li>
    </ul>

</body>
</html>
