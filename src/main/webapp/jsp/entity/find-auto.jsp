<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="entity" name="find-auto" method="post" action="/control">
    <c:if test="${requestScope.containsKey('wrong')}"><p>${requestScope.get("wrong")}</p></c:if>
    <p><label><b>Choose auto by VIN code: </b></label></p>
    <p><label for="vin" class="short"><b>VIN code: </b></label>
        <input type="text" id="vin" name="vin" size="50" value=""/></p>
    <p><button type="submit" name="command" value="find-auto">Display</button></p>
</form>