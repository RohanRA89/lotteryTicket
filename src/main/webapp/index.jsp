<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="var" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Generate Your Numbers</title>
</head>
<body>
<h2>Hello. Please generate your lottery numbers!</h2>
<form method="post" action="/generateNumbers">
    <button name="generateNumbers" type="submit" value="HTML">Generate Lottery Numbers</button>
</form>
<h3>Here are your lottery ticket numbers:</h3>
<ul>
    <c:forEach items="${lottList}" var="numbers">
    <li><c:out escapeXml="false" value="${numbers}"/></li>
        <!--If I placed value="$lottList" I get the previous string of numbers added on to the next string-->
    </c:forEach>
</ul>


<h2>Check your ticket below.</h2>
<form method="post" action="/checkNumbers">
    <button name="checkNumbers" type="submit" value="HTML">Check Your Ticket</button>
</form>
</body>
</html>