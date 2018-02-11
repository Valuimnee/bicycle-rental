<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="confirm-rental" method="post" action="/control">
    <p class="mb-2 text-center"><label><b><fmt:message key="rental.rental-info"/></b></label></p>
    <p class="mb-2"><b><label class="container-fluid text-center"><fmt:message key="rental.greeting"/></label></b></p>
    <p class="mb-2"><label for="bicycle-name" class="long-label"><b><fmt:message key="rental.bicycle-name"/>: </b></label>
        <input class="disabled aria-disabled" type="text" id="bicycle-name" name="bicycle-name" size="50" value="${bicycle.model}" disabled/></p>
    <p class="mb-2"><label for="bicycle-type" class="long-label"><b><fmt:message key="rental.bicycle-type"/>: </b></label>
        <input type="text" id="bicycle-type" name="bicycle-type" size="50" value="${bicycle.type}" disabled/></p>
    <p class="mb-2"><label for="location-name" class="long-label"><b><fmt:message key="rental.location-name"/>: </b></label>
        <input type="text" id="location-name" name="location-name" size="50" value="${location.name}" disabled/></p>
    <p class="mb-2"><label for="location-address" class="long-label"><b><fmt:message key="register.address"/>: </b></label>
        <input type="text" id="location-address" name="location-address" size="50" value="${location.address}" disabled/></p>
    <%--<fld:input type="datetime" labelType="long" name="start-date" required="required">
        <jsp:attribute name="label"><fmt:message key="date.start-date"/></jsp:attribute><jsp:body>${datetime}</jsp:body>
    </fld:input>
    <fld:input type="hours" labelType="long" name="hours" required="required">
        <jsp:attribute name="label"><fmt:message key="date.duration"/></jsp:attribute><jsp:body>$${rental.hours}</jsp:body>
    </fld:input>--%>
    <p class="mb-2"><label for="start-date" class="long-label"><b><fmt:message key="date.start-date"/>: </b></label>
        <input type="datetime-local" id="start-date" name="start-date" size="50" value="${rental.startTime.toString().replace(' ', 'T')}" disabled/></p>
    <p class="mb-2"><label for="hours" class="long-label"><b><fmt:message key="date.duration"/>: </b></label>
        <input type="number" min="1" max="168" id="hours" name="hours" size="50" value="${rental.hours}" disabled/></p>
    <p class="mb-2"><label for="total" class="long-label"><b><fmt:message key="rental.total"/>: </b></label>
        <input type="number" step="0.01" id="total" name="total" size="50" value="${rental.total}" disabled/></p>
    <p class="text-right col-9">
        <button class="btn mr-5" type="submit" name="command" value="back-to-date"><fmt:message key="rental.back"/></button>
        <button class="btn" type="submit" name="command" value="rent"><fmt:message key="rental.confirm"/></button></p>
</form>