<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fld" uri="fldlib" %>
<script src="/js/account.js"></script>
<div class="register-block mt-1">
    <h2 id="reg" class="greeting text-center mb-2"><fmt:message key="user-account.header"/></h2>
    <form name="user-account-form"  method="post" action="/control">
        <c:if test="${requestScope.wrong=='wrong-info'}"><p class="mb-2"><fmt:message key="register.wrong-info"/></p></c:if>
        <fld:input type="login" labelType="long" name="login"  required="required">
            <jsp:attribute name="label"><fmt:message key="login.login"/></jsp:attribute><jsp:body>${login}</jsp:body>
        </fld:input>
        <fld:input type="password" labelType="long" name="password">
            <jsp:attribute name="label"><fmt:message key="register.password"/></jsp:attribute><jsp:body/>
        </fld:input>
        <fld:input type="password" labelType="long" name="new-password">
            <jsp:attribute name="label"><fmt:message key="account.new-password"/></jsp:attribute><jsp:body/>
        </fld:input>
        <fld:input type="password" labelType="long" name="new-password2">
            <jsp:attribute name="label"><fmt:message key="account.new-password2"/></jsp:attribute><jsp:body/>
        </fld:input>
        <p class="text-right col-9"><button class="btn" type="submit" name="command" value="edit-account">
            <fmt:message key="account.save-changes"/></button></p>
    </form>
</div>