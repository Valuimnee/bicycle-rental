<%--
  Author: TsalapovaMD
  Date: 12/28/2017
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page errorPage="/jsp/error.jsp" %>
<c:set var="lang" value="${not empty param.lang ? param.lang: not empty lang ? lang: pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${lang}" scope="session"/>
<fmt:setBundle basename="text" scope="session"/>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="/jsp/component/head.jsp"/>
<body>
<jsp:include page="/jsp/component/main-nav.jsp"/>
<jsp:include page="/jsp/component/header.jsp"/>
<jsp:include page="/jsp/component/adminbar.jsp"/>
<main class="container-fluid mt-4 mb-5">
    <c:if test="${requestScope.containsKey('message')}"><p class="text-center">
            <fmt:message key="message.${requestScope.message}"/></p></c:if>
    <c:choose>
        <c:when test="${requestScope.content=='clients'}">
            <jsp:include page="/jsp/list/clients.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='client'}">
            <jsp:include page="/jsp/entity/client.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='locations'}">
            <jsp:include page="/jsp/list/locations.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='bicycles'}">
            <jsp:include page="/jsp/list/bicycles.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='add-bicycle'}">
            <jsp:include page="/jsp/entity/add-bicycle.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='bicycle'}">
            <jsp:include page="/jsp/entity/bicycle.jsp"/>
        </c:when>
        <c:when test="${requestScope.content=='user-account'}">
            <jsp:include page="/jsp/entity/user-account.jsp"/>
        </c:when>
    </c:choose>
</main>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
