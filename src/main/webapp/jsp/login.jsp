<%--
  Author: TsalapovaMD
  Date: 12/28/2017
  Time: 2:25 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page errorPage="/jsp/error.jsp" %>
<!DOCTYPE HTML>
<html lang="en">
<jsp:include page="/jsp/component/head.jsp"/>
<body>
<jsp:include page="/jsp/component/main-nav.jsp"/>
<jsp:include page="/jsp/component/header.jsp"/>
<script type="text/javascript" src="/js/login.js"></script>
<main role="main" class="container-fluid">
    <div class="login-block">
        <h2 id="log" class="text-center mb-4"><fmt:message key="login.header"/></h2>
        <form name="login" method="post" action="/control">
            <c:if test="${requestScope.containsKey('wrong')}" ><p><fmt:message key="login.wrong"/></p></c:if>
            <p class="mb-3"><label for="login" class="short-label"><b><fmt:message key="login.login"/>: </b></label>
                <input type="text" pattern="^[-\w.]{4,20}$" id="login" name="login" size="50" value="" required="required"/></p>
            <p><label for="password" class="short-label"><b><fmt:message key="login.password"/>: </b></label>
                <input type="password" id="password" name="password" size="50" value="" required="required"/></p>
            <p class="text-center"><button class="btn" type="submit" name="command" value="login"><fmt:message key="login.button"/></button>
        </form>
    </div>
</main>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
