<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="entity" name="find-auto-client" method="post" action="/control">
    <c:if test="${requestScope.containsKey('wrong')}"><p>${wrong}</p></c:if>
    <p><label><b>Enter client&apos;s full name to view all autos he ordered: </b></label></p>
    <p><label for="fullname" class="short"><b>Full name: </b></label>
        <input type="text" id="fullname" name="fullname" size="50" value=""/></p>
    <p><button type="submit" name="command" value="find-client-auto">Display</button></p>
</form>