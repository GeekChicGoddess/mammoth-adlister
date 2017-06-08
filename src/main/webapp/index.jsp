<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.io.*,java.util.*"%>

<html>
<head>
<jsp:include page="partials/head.jsp">
    <title><%= "GeekChicGoddess" %></title>
</jsp:include>

</head>
<body>

    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
    <h1>Welcome to the Adlister!</h1>
    </div>
    <c:if test="true">
        <h1>Variable names should be very descriptive</h1>
    </c:if>
    <c:if test="false">
        <h1>single letter variable names are good</h1>
    </c:if>
</body>
</html>
