<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="/js/account.js"></script>
<div class="register-block">
    <h2 id="reg" class="greeting text-center mb-2"><fmt:message key="account.header"/></h2>
    <form name="account"  method="post" action="/control">
        <c:if test="${requestScope.wrong=='wrong-info'}"><p class="mb-2"><fmt:message key="register.wrong-info"/></p></c:if>
        <%--<p class="mb-2 text-center"><label><b><fmt:message key="account.header"/></b></label></p>--%>
        <p class="mb-2"><%--<c:if test="${requestScope.containsKey('wrong')}"><div class="mb-1"><fmt:message key="register.wrong-info"/></div></c:if>--%>
            <label for="login" class="long-label"><b><fmt:message key="register.login"/>: </b></label>
            <input type="text" pattern="^[-\w.]{4,20}$" id="login" name="login" size="50" value="${login}" required="required"/></p>
        <p class="mb-2"><label for="password" class="long-label"><b><fmt:message key="register.password"/>: </b></label>
            <input type="password" pattern="^[^ ]{8,40}$" id="password" name="password" size="50" value=""/></p>
        <p class="mb-2"><label for="new-password" class="long-label"><b><fmt:message key="account.new-password"/>: </b></label>
            <input type="password" pattern="^[^ ]{8,40}$" id="new-password" name="new-password" size="50" value=""/></p>
        <p class="mb-2"><label for="new-password2" class="long-label"><b><fmt:message key="account.new-password2"/>: </b></label>
            <input type="password" pattern="^[^ ]{8,40}$" id="new-password2" name="new-password2" size="50" value=""/></p>
        <p class="text-right col-9"><button class="btn" type="submit" name="command" value="edit-account"><fmt:message key="account.save-changes"/></button></p>
    </form>
</div>