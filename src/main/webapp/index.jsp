<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<jsp:include page="partials/head.jsp">
    <jsp:param name="title" value="GeekChicGoddess" />
</jsp:include>

</head>
<body>

    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
    <h1>Welcome to the Adlister!</h1>
    </div>
    <c:if test="true">
        <h1>Welcome user</h1>
    </c:if>
    <c:if test="false">
        <h1>Please log in to post listings</h1>
    </c:if>
</body>
</html>
