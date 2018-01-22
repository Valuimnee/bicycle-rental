<%--
  Author: TsalapovaMD
  Date: 5/28/2017
  Time: 2:14 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page errorPage="/jsp/error.jsp" %>
<!DOCTYPE HTML>
<html lang="en">
<jsp:include page="/jsp/component/head.jsp"/>
<body>
<jsp:include page="/jsp/component/main-nav.jsp"/>
<jsp:include page="/jsp/component/header.jsp"/>
<jsp:include page="/jsp/component/menubar.jsp"/>
<main class="container">
    <%--<c:if test="${sessionScope.get('result')!=null}"><br><p id="result">${sessionScope.get('result')}</p></c:if>--%>
    <c:if test="${requestScope.containsKey('message')}"><p class="message">${requestScope.message}</p></c:if>
    <c:choose>
        <c:when test="${requestScope.content=='bikes'}">
            <jsp:include page="/jsp/list/autos.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='rentals'}">
            <jsp:include page="/jsp/list/rentals.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='bike'}">
            <jsp:include page="/jsp/entity/bike.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='profile'}">
            <jsp:include page="/jsp/entity/client.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='client-account'}">
            <jsp:include page="/jsp/entity/login.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='date-form'}">
            <jsp:include page="/jsp/entity/date-interval.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='choose-bike'}">
            <jsp:include page="/jsp/list/rent-autos.jsp"/>
        </c:when>
    </c:choose>
</main>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
