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
    <h1>Enter your information to sign up</h1>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username">Choose a username of 10 characters or less</label>
            <input  id="username" type="text" name="username" class="form-control">
        </div>
        <div class="form-group">
            <label for="email">Enter your email address</label>
            <input id="email"  type="email" name="email" class="form-control">
        </div>
        <div class="form-group">
            <label for="password">Choose a password between 8 and 15 characters</label>
            <input id="password" type="password" name="password" class="form-control">

        </div>
        <input type="submit" class="btn btn-primary btn-block" value="Submit">
    </form>
</div>
</body>
</html>
