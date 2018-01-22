<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="entity" name="find-auto" method="post" action="/control">
    <c:if test="${requestScope.containsKey('wrong')}"><p>${wrong}</p></c:if>
    <p><label><b>Enter rental start time and duration: </b></label></p>
    <p><label for="start-date" class="short-label"><b>Rental start date and time: </b></label>
        <input type="datetime-local" id="start-date" name="start-date" size="50" value=""/></p>
    <p><label for="hours" class="short-label"><b>Rental duration in hours: </b></label>
        <input type="number" min="2" id="hours" name="hours" size="50" value=""/></p>
    <p><label><b>Fill in second driver&apos;s full name (optional)</b></label></p>
    <p><label for="second-driver" class="short-label"><b>Full name: </b></label>
        <input type="text" id="second-driver" name="second-driver" size="50" value=""/></p>
    <p><button type="submit" name="command" value="find-auto-for-date">Search</button></p>
</form>