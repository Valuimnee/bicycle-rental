<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form name="select-date" method="post" action="/control">
    <c:if test="${requestScope.wrong=='wrong'}"><p class="mb-2"><fmt:message key="date.wrong"/></p></c:if>
    <p class="mb-2 text-center"><label><b><fmt:message key="date.greeting"/></b></label></p>
    <p class="mb-2"><label for="start-date" class="long-label"><b><fmt:message key="date.start-date"/>: </b></label>
        <input type="datetime-local" id="start-date" name="start-date" size="50" value="" required="required"/></p>
    <p class="mb-2"><label for="hours" class="long-label"><b><fmt:message key="date.duration"/>: </b></label>
        <input type="number" min="1" max="168" id="hours" name="hours" size="50" value="" required="required"/></p>
    <p class="container text-right"><button class="btn" type="submit" name="command" value="select-date">Select</button></p>
</form>