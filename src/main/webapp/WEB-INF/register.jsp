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
<div class="container">
    <h1>Please Log In</h1>
<form action="/register" method="post">
    <div class="form-group">
    <label>
        Choose a username of 10 characters or less
        <input size="20" type="text" name="username">
    </label>
    </div>
    <div class="form-group">
    <label>
        Enter your email address
        <input size="100" type="email" name="email">
    </label>
    </div>
    <div class="form-group">
    <label>
        Choose a password between 8 and 15 characters
        <input size="30" type="password" name="password">
    </label>
    </div>
    <input type="submit" class="btn btn-primary btn-block" value="Submit" size="6">
</form>
</div>
</body>
</html>
