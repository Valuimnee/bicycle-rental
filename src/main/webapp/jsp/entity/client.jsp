<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fld" uri="fldlib" %>
<form name="client-form" method="post" action="/control?command=change-status">
    <p class="mb-2 text-center"><label class="pt-0 mb-0"><b><fmt:message key="client.information"/></b></label></p>
    <input type="hidden" name="client-id" value="${client.clientId}">
    <fld:input type="login" labelType="long" name="login"  required="required" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="login.login"/></jsp:attribute><jsp:body>${login}</jsp:body>
    </fld:input>
    <fld:input type="name" labelType="long" name="first-name" required="required" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="register.first-name"/></jsp:attribute><jsp:body>${client.firstName}</jsp:body>
    </fld:input>
    <fld:input type="name" labelType="long" name="middle-name" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="register.middle-name"/></jsp:attribute><jsp:body>${client.middleName}</jsp:body>
    </fld:input>
    <fld:input type="name" labelType="long" name="lastname" required="required" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="register.lastname"/></jsp:attribute><jsp:body>${client.lastname}</jsp:body>
    </fld:input>
    <fld:input type="address" labelType="long" name="address" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="register.address"/></jsp:attribute><jsp:body>${client.address}</jsp:body>
    </fld:input>
    <fld:input type="passport" labelType="long" name="passport" required="required" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="register.passport-number"/></jsp:attribute><jsp:body>${client.passportNumber}</jsp:body>
    </fld:input>
    <fld:input type="phone" labelType="long" name="phone" required="required" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="register.phone"/></jsp:attribute><jsp:body>+${client.phone}</jsp:body>
    </fld:input>
    <fld:input type="email" labelType="long" name="email" required="required" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="register.email"/></jsp:attribute><jsp:body>${client.email}</jsp:body>
    </fld:input>
    <p class="mb-2 input-group"><label for="rentals" class="long-label"><b><fmt:message key="clients.rentals"/>: </b></label>
        <input type="number" min="0" class="form-control disabled aria-disabled" id="rentals" name="rentals" size="50"
               value="${rentalCount}" disabled="disabled" /></p>
    <p class="mb-2 input-group"><label for="status" class="long-label"><b><fmt:message key="rental.status"/>: </b></label>
        <fmt:message key="client.${client.active==1?'active':'blocked'}" var="active"/>
        <input type="text" id="status" class="form-control disabled aria-disabled" name="status" size="50"
               value="${active}" disabled="disabled" /></p>
    <div class="mb-lg-2 mt-lg-2 pl-lg-5 text-center col-sm-12">
        <button class="btn mr-2" type="submit" name="active" value="${client.active==0?1:0}">
            <fmt:message key="client.${client.active==0?'activate':'block'}"/></button>
    </div>
</form>
