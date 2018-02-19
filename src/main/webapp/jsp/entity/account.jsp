<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fld" uri="fldlib" %>
<script src="/js/account.js"></script>
<div class="register-block">
    <h2 id="reg" class="greeting text-center mb-2"><fmt:message key="account.header"/></h2>
    <form name="account-form">
        <fld:input type="currency" labelType="long" name="balance" required="required" disabled="disabled">
            <jsp:attribute name="label"><fmt:message key="profile.balance"/></jsp:attribute><jsp:body>${account.balance}</jsp:body>
        </fld:input>
        <fld:input type="currency" labelType="long" name="credit" required="required" disabled="disabled">
            <jsp:attribute name="label"><fmt:message key="profile.credit"/></jsp:attribute><jsp:body>${account.credit}</jsp:body>
        </fld:input>
    <%--<p class="text-right col-9"><button class="btn" type="submit" name="command" value="edit-account">
            <fmt:message key="account.save-changes"/></button></p>--%>
    </form>
</div>