<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fld" uri="fldlib" %>
<form name="select-date-form" method="post" action="/control">
    <c:if test="${requestScope.wrong=='wrong'}"><p class="mb-2 text-center"><fmt:message key="date.wrong"/></p></c:if>
    <p class="mb-2 text-center"><label><b><fmt:message key="date.greeting"/></b></label></p>
    <fld:input type="datetime" labelType="long" name="start-date" required="required">
        <jsp:attribute name="label"><fmt:message key="date.start-date"/></jsp:attribute><jsp:body>${datetime}</jsp:body>
    </fld:input>
    <fld:input type="hours" labelType="long" name="hours" required="required">
        <jsp:attribute name="label"><fmt:message key="date.duration"/></jsp:attribute><jsp:body>${rental.hours}</jsp:body>
    </fld:input>
    <p class="container text-right"><button class="btn" type="submit" name="command" value="select-date">
        <fmt:message key="date.select"/></button></p>
</form>