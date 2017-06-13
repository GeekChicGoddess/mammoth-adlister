<%--
  Created by IntelliJ IDEA.
  User: melodytempleton
  Date: 6/12/17
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="New User Sign-up"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"></jsp:include>

<form action="/register" method="post">
    <label>
        Choose a username of 10 characters or less
        <input size="20" type="text" name="username">
    </label>
    <label>
        Enter your email address
        <input size="200" type="email" name="email">
    </label>
    <label>
        Choose a password between 8 and 15 characters
        <input size="50" type="password" name="password">
    </label>
    <input type="submit" class="btn btn-primary btn-block" value="Submit" size="6">
</form>

</body>
</html>
