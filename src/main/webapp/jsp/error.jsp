<%--
  User: CalapovaMD
  Date: 5/28/2017
  Time: 2:35 PM
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <title>BicycleRental</title>
</head>
<body>
<jsp:include page="element/header.jsp"/>
<%--<fmt:parseNumber var="page" value="${-1}" scope="session"/>--%>
<div class="content">
<form>
    <%--<a href="${pageContext.request.contextPath}/index.jsp" onclick="<jsp:forward page="../index.jsp"/>">Back to main menu</a>--%>
    <h1>An error occurred!</h1>
    Error code: ${pageContext.errorData.statusCode}<br>
    URI: ${pageContext.errorData.requestURI}<br>
    Message: ${pageContext.errorData.throwable.message}<br>
</form>
</div>
<jsp:include page="/jsp/element/footer.jsp"/>
</body>
</html>