<%--
  User: CalapovaMD
  Date: 5/30/2017
  Time: 10:10 AM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=windows-1251" language="java" %>
<%@ page errorPage="../error.jsp" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
    <title>Student'sGrades</title>
</head>
<body>
<jsp:include page="../element/header.jsp"/>
<form name="studentInfo" method="post" action="grades">
    <p><label for="fullname" class="short"><b>Full name</b></label>
        <input type="text" id="fullname" name="fullname" size="50" value=""/></p>
    <p><label for="group" class="short"><b>Group</b></label>
        <input type="number" id="group" name="group" size="100" value=""/></p>
    <p><button type="submit" name="back" onclick="value='0'">Back</button>
        <button type="submit" name="select" onclick="value='0'">Select</button>
</form>
</body>
</html>
