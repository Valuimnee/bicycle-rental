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
<%--<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>--%>
<script type="text/javascript" src="/js/submit.js"></script>
<script type="text/javascript" src="/js/register.js"></script>
<main class="container-fluid mb-5">
    <div class="register-block">
        <h2 id="reg" class="greeting text-center mb-1"><fmt:message key="register.greeting"/></h2>
        <form class="no-resubmit mt-0" name="register-form" method="post" action="/control">
            <input type="hidden" name="submitted" value="false"/>
            <c:if test="${requestScope.wrong=='wrong-info'}"><p class="mb-0 text-center">
                <fmt:message key="register.wrong-info"/></p></c:if>
            <p class="mb-0 text-center"><label class="mb-0 pt-0"><b><fmt:message key="register.login-info"/></b></label></p>
            <p class="mb-0"><c:if test="${requestScope.wrong=='wrong-login'}"><div class="mt-1">
                    <fmt:message key="register.wrong-login"/></div></c:if></p>
            <fld:input type="login" labelType="long" name="login" required="required">
                <jsp:attribute name="label"><fmt:message key="register.login"/></jsp:attribute><jsp:body/>
            </fld:input>
            <fld:input type="password" labelType="long" name="password" required="required">
                <jsp:attribute name="label"><fmt:message key="register.password"/></jsp:attribute><jsp:body/>
            </fld:input>
            <fld:input type="password" labelType="long" name="password2" required="required">
                <jsp:attribute name="label"><fmt:message key="register.password2"/></jsp:attribute><jsp:body/>
            </fld:input>
            <p class="mb-0"><b><label class="container-fluid text-center mb-0 pt-0">
                <fmt:message key="register.personal-info"/></label></b></p>
            <fld:input type="name" labelType="long" name="first-name" required="required">
                <jsp:attribute name="label"><fmt:message key="register.first-name"/></jsp:attribute><jsp:body/>
            </fld:input>
            <fld:input type="name" labelType="long" name="middle-name">
                <jsp:attribute name="label"><fmt:message key="register.middle-name"/></jsp:attribute><jsp:body/>
            </fld:input>
            <fld:input type="name" labelType="long" name="lastname" required="required">
                <jsp:attribute name="label"><fmt:message key="register.lastname"/></jsp:attribute><jsp:body/>
            </fld:input>
            <fld:input type="address" labelType="long" name="address">
                <jsp:attribute name="label"><fmt:message key="register.address"/></jsp:attribute><jsp:body/>
            </fld:input>
            <fld:input type="passport" labelType="long" name="passport" required="required">
                <jsp:attribute name="label"><fmt:message key="register.passport-number"/></jsp:attribute><jsp:body/>
            </fld:input>
            <fld:input type="phone" labelType="long" name="phone" required="required">
                <jsp:attribute name="label"><fmt:message key="register.phone"/></jsp:attribute><jsp:body/>
            </fld:input>
            <fld:input type="email" labelType="long" name="email" required="required">
                <jsp:attribute name="label"><fmt:message key="register.email"/></jsp:attribute><jsp:body/>
            </fld:input>
            <fld:input type="currency" labelType="long" name="balance" required="required">
                <jsp:attribute name="label"><fmt:message key="profile.balance"/></jsp:attribute><jsp:body>0</jsp:body>
            </fld:input>
            <p class="text-right col-9"><button class="btn" type="submit" name="command" value="register">
                <fmt:message key="register.register"/></button></p>
        </form>
    </div>
</main>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
