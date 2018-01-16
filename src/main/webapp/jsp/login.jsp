<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/28/2017
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page errorPage="/jsp/error.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; chatset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <title>BicycleRental</title>
</head>
<body>
<jsp:include page="/jsp/element/header.jsp"/>
<div class="content">
    <div class="greeting">
        <h2 id="log">Log in to rent your bike!</h2>
    </div>
    <form name="log" method="post" action="/control">
        <c:if test="${requestScope.containsKey('wrong')}" ><p>Invalid login or password, please try again</p></c:if>
        <p><label for="login" class="short"><b>Login: </b></label>
            <input type="text" id="login" name="login" size="50" value=""/></p>
        <p><label for="password" class="short"><b>Password: </b></label>
            <input type="password" id="password" name="password" size="50" value=""/></p>
        <p><button type="submit" name="command" value="login">Login</button>
    </form>
</div>
<jsp:include page="/jsp/element/footer.jsp"/>
</body>
</html>
</body>
</html>
