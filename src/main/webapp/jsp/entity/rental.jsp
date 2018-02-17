<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fld" uri="fldlib" %>
<form name="edit-rental" method="post" action="/control">
    <input type="hidden" name="rental-id" value="${rental.rentalId}">
    <p class="mb-2 text-center"><label><b><fmt:message key="rental.rental-info"/></b></label></p>
    <p class="mb-2"><b><label class="container-fluid text-center"><fmt:message key="rental.edit-greeting"/></label></b></p>
    <fld:input type="product-name" labelType="long" name="bicycle-name" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="rental.bicycle-name"/></jsp:attribute><jsp:body>${bicycle.model}</jsp:body>
    </fld:input>
    <fld:input type="product-name" labelType="long" name="bicycle-type" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="rental.bicycle-type"/></jsp:attribute>
        <jsp:body><fmt:message key="type.${bicycle.type}"/></jsp:body>
    </fld:input>
    <fld:input type="product-name" labelType="long" name="location-name" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="rental.location-name"/></jsp:attribute><jsp:body>${location.name}</jsp:body>
    </fld:input>
    <fld:input type="address" labelType="long" name="location-address" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="register.address"/></jsp:attribute><jsp:body>${location.address}</jsp:body>
    </fld:input>
    <fld:input type="datetime" labelType="long" name="start-date" disabled="${rental.status != 'Concluded'?'disabled':''}" >
        <jsp:attribute name="label"><fmt:message key="date.start-date"/></jsp:attribute><jsp:body>${datetime}</jsp:body>
    </fld:input>
    <fld:input type="hours" labelType="long" name="hours" disabled="${rental.status != 'Concluded'?'disabled':''}">
        <jsp:attribute name="label"><fmt:message key="date.duration"/></jsp:attribute><jsp:body>${rental.hours}</jsp:body>
    </fld:input>
    <fld:input type="currency" labelType="long" name="total" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="rental.total"/></jsp:attribute><jsp:body>${rental.total}</jsp:body>
    </fld:input>
    <fld:input type="product-name" labelType="long" name="status" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="rental.status"/></jsp:attribute>
        <jsp:body><fmt:message key="status.${rental.status.toLowerCase()}"/></jsp:body>
    </fld:input>
    <c:if test="${rental.status == 'Concluded'}">
    <p class="text-right col-9">
        <button class="btn mr-5" type="submit" name="command" value="cancel-rental"><fmt:message key="rental.cancel"/></button>
        <button class="btn" type="submit" name="command" value="edit-rental"><fmt:message key="rental.save-changes"/></button></p>
    </c:if>
</form>