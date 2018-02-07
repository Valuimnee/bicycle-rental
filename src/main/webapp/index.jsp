<%--
  Author: TsalapovaMD
  Date: 5/28/2017
  Time: 2:14 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page errorPage="/jsp/error.jsp" %>
<c:set var="lang" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="text" scope="session"/>
<!DOCTYPE HTML>
<html lang="en">
<jsp:include page="/jsp/component/head.jsp"/>
<body>
<jsp:include page="/jsp/component/main-nav.jsp"/>
<jsp:include page="/jsp/component/header.jsp"/>
<jsp:include page="/jsp/component/menubar.jsp"/>
<main class="container-fluid mt-4 mb-5">
    <c:if test="${requestScope.containsKey('message')}"><p class="text-center"><fmt:message  key="message.${requestScope.message}"/></p></c:if>
    <c:choose>
        <c:when test="${requestScope.content=='locations'}">
            <jsp:include page="/jsp/list/locations.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='bicycles'}">
            <jsp:include page="/jsp/list/bicycles.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='date'}">
            <jsp:include page="/jsp/entity/date.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='confirm-rental'}">
            <jsp:include page="/jsp/entity/confirm-rental.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='rentals'}">
            <jsp:include page="/jsp/list/rentals.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='account'}">
            <jsp:include page="/jsp/entity/account.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='profile'}">
            <jsp:include page="/jsp/entity/profile.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='date-form'}">
            <jsp:include page="/jsp/entity/date.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='choose-bike'}">
            <jsp:include page="/jsp/list/rent-autos.jsp"/>
        </c:when>
    </c:choose>
</main>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
