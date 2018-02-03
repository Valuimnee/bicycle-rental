<%--
  Author: TsalapovaMD
  Date: 5/28/2017
  Time: 2:14 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page errorPage="/jsp/error.jsp" %>
<!DOCTYPE HTML>
<html lang="en">
<jsp:include page="/jsp/component/head.jsp"/>
<body>
<jsp:include page="/jsp/component/main-nav.jsp"/>
<jsp:include page="/jsp/component/header.jsp"/>
<script src="/js/register.js"></script>
<main class="container-fluid mb-5">
    <div class="register-block">
    <h2 id="reg" class="greeting text-center mb-2"><fmt:message key="register.greeting"/></h2>
    <form name="register" method="post" action="/control">
        <c:if test="${requestScope.wrong=='wrong-info'}"><p class="mb-2"><fmt:message key="register.wrong-info"/></p></c:if>
        <p class="mb-2 text-center"><label><b><fmt:message key="register.login-info"/></b></label></p>
        <p class="mb-2"><c:if test="${requestScope.wrong=='wrong-login'}"><div class="mb-1"><fmt:message key="register.wrong-login"/></div></c:if>
        <label for="login" class="long-label"><b><fmt:message key="register.login"/>: </b></label>
            <input type="text" pattern="^[-\w.]{4,20}$" id="login" name="login" size="50" value="" required="required"/></p>
        <p class="mb-2"><label for="password" class="long-label"><b><fmt:message key="register.password"/>: </b></label>
            <input type="password" pattern="^[^ ]{8,40}$" id="password" name="password" size="50" value="" required="required"/></p>
        <p class="mb-2"><label for="password2" class="long-label"><b><fmt:message key="register.password2"/>: </b></label>
            <input type="password" pattern="^[^ ]{8,40}$" id="password2" name="password2" size="50" value="" required="required"/></p>
        <p class="mb-2"><b><label class="container-fluid text-center"><fmt:message key="register.personal-info"/></label></b><br/>
            <label for="first-name" class="long-label"><b><fmt:message key="register.first-name"/>: </b></label>
            <input type="text" pattern="^([\p{L}'][ \p{L}'-]*\p{L}|\p{L}[\p{L}'-]*)$" id="first-name" name="first-name" size="50" value="" required="required"/></p>
        <p class="mb-2"><label for="middle-name" class="long-label"><b><fmt:message key="register.middle-name"/>: </b></label>
            <input type="text" pattern="^([\p{L}'][ \p{L}'-]*\p{L}|\p{L}[\p{L}'-]*)$" id="middle-name" name="middle-name" size="50" value=""/></p>
        <p class="mb-2"><label for="lastname" class="long-label"><b><fmt:message key="register.lastname"/>: </b></label>
            <input type="text" pattern="^([\p{L}'][ \p{L}'-]*\p{L}|\p{L}[\p{L}'-]*)$" id="lastname" name="lastname" size="50" value="" required="required"/></p>
        <p class="mb-2"><label for="address" class="long-label"><b><fmt:message key="register.address"/>: </b></label>
            <input type="text" pattern="^([\p{L}.,-/\d]+\s+)*[\p{L}.,-/\d]+$" id="address" name="address" size="50" value=""/></p>
        <p class="mb-2"><label for="passport" class="long-label"><b><fmt:message key="register.passport-number"/>: </b></label>
            <input type="text" pattern="^(AB|BM|HB|KH|MP|MC|KB|PP)\d{7}$" id="passport" name="passport" size="50" value="" required="required"/></p>
        <p class="mb-2"><label for="phone" class="long-label"><b><fmt:message key="register.phone"/>: </b></label>
            <input type="tel" pattern="^\d{12}$" id="phone" name="phone" size="50" value="" required="required"/></p>
        <p><label for="email" class="long-label"><b><fmt:message key="register.email"/>: </b></label>
            <input type="email" id="email" name="email" size="50" value="" required="required"/></p>
        <p class="text-right col-9"><button class="btn" type="submit" name="command" value="register"><fmt:message key="register.register"/></button></p>
    </form>
    </div>
</main>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
