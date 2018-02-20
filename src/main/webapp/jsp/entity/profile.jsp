<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fld" uri="fldlib" %>
<script src="/js/profile.js"></script>
<div class="register-block">
    <h2 id="reg" class="greeting text-center mb-2"><fmt:message key="profile.header"/></h2>
    <form class="mt-2" name="profile" method="post" action="/control">
        <c:if test="${requestScope.wrong=='wrong-info'}"><p class="mb-2 text-center"><fmt:message key="register.wrong-info"/></p></c:if>
        <p class="mb-2"><b><label class="container-fluid text-center mb-4"><fmt:message key="profile.greeting"/></label></b></p>
        <fld:input type="name" labelType="long" name="first-name" required="required">
            <jsp:attribute name="label"><fmt:message key="register.first-name"/></jsp:attribute><jsp:body>${client.firstName}</jsp:body>
        </fld:input>
        <fld:input type="name" labelType="long" name="middle-name">
            <jsp:attribute name="label"><fmt:message key="register.middle-name"/></jsp:attribute><jsp:body>${client.middleName}</jsp:body>
        </fld:input>
        <fld:input type="name" labelType="long" name="lastname" required="required">
            <jsp:attribute name="label"><fmt:message key="register.lastname"/></jsp:attribute><jsp:body>${client.lastname}</jsp:body>
        </fld:input>
        <fld:input type="address" labelType="long" name="address">
            <jsp:attribute name="label"><fmt:message key="register.address"/></jsp:attribute><jsp:body>${client.address}</jsp:body>
        </fld:input>
        <fld:input type="passport" labelType="long" name="passport" required="required">
            <jsp:attribute name="label"><fmt:message key="register.passport-number"/></jsp:attribute><jsp:body>${client.passportNumber}</jsp:body>
        </fld:input>
        <fld:input type="phone" labelType="long" name="phone" required="required">
            <jsp:attribute name="label"><fmt:message key="register.phone"/></jsp:attribute><jsp:body>+${client.phone}</jsp:body>
        </fld:input>
        <fld:input type="email" labelType="long" name="email" required="required">
            <jsp:attribute name="label"><fmt:message key="register.email"/></jsp:attribute><jsp:body>${client.email}</jsp:body>
        </fld:input>
        <p class="text-right col-9"><button class="btn" type="submit" name="command" value="edit-profile">
            <fmt:message key="profile.save-changes"/></button></p>
    </form>
</div>

