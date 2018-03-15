<%--
  Author: TsalapovaMD
  Date: 12/28/2017
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fld" uri="fldlib" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page errorPage="/jsp/error.jsp" %>
<!DOCTYPE html>
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
            <fld:input type="login" labelType="short" name="login" required="required">
                <jsp:attribute name="label"><fmt:message key="login.login"/></jsp:attribute><jsp:body/>
            </fld:input>
            <fld:input type="password" labelType="short" name="password" required="required">
                <jsp:attribute name="label"><fmt:message key="login.password"/></jsp:attribute><jsp:body/>
            </fld:input>
            <p class="text-center"><button class="btn" type="submit" name="command" value="login">
                <fmt:message key="login.button"/></button>
        </form>
    </div>
</main>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
