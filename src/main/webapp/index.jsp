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
<main>
    <%--<c:if test="${sessionScope.get('result')!=null}"><br><p id="result">${sessionScope.get('result')}</p></c:if>--%>
    <c:if test="${requestScope.containsKey('message')}"><p class="message">${message}</p></c:if>
    <c:choose>
        <c:when test="${requestScope.get('content')=='autos'}">
            <jsp:include page="/jsp/list/autos.jsp"/>
        </c:when>
        <c:when test="${requestScope.get(\"content\")==\"rentals\"}">
            <jsp:include page="/jsp/list/rentals.jsp"/>
        </c:when>
        <c:when test="${requestScope.get(\"content\")==\"auto\"}">
            <jsp:include page="/jsp/entity/auto.jsp"/>
        </c:when>
        <c:when test="${requestScope.get(\"content\")==\"profile\"}">
            <jsp:include page="/jsp/entity/client.jsp"/>
        </c:when>
        <c:when test="${requestScope.get(\"content\")==\"client-account\"}">
            <jsp:include page="/jsp/entity/login.jsp"/>
        </c:when>
        <c:when test="${requestScope.get(\"content\")==\"date-form\"}">
            <jsp:include page="/jsp/entity/date-interval.jsp"/>
        </c:when>
        <c:when test="${requestScope.get(\"content\")==\"choose-auto\"}">
            <jsp:include page="/jsp/list/rent-autos.jsp"/>
        </c:when>
    </c:choose>
</main>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
