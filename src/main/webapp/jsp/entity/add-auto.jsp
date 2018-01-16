<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="entity" name="add-auto" method="post" action="/control">
    <c:if test="${requestScope.containsKey('wrong')}"><p>${requestScope.get("wrong")}</p></c:if>
    <p><label><b>Fill in auto information: </b></label></p>
    <p><label for="make" class="short"><b>Make: </b></label>
        <input type="text" id="make" name="make" size="50" value=""/></p>
    <p><label for="model" class="short"><b>Model: </b></label>
        <input type="text" id="model" name="model" size="50" value=""/></p>
    <p><label for="displacement" class="short"><b>Displacement: </b></label>
        <input type="number" step="0.1" id="displacement" name="displacement" size="50" value=""/></p>
    <p><label for="fuel" class="short"><b>Fuel: </b></label>
        <input type="text" id="fuel" name="fuel" size="50" value=""/></p>
    <p><label for="registration-number" class="short"><b>Registration number: </b></label>
        <input type="text" id="registration-number" name="registration-number" size="50" value=""/></p>
    <p><label for="vin" class="short"><b>VIN code: </b></label>
        <input type="text" id="vin" name="vin" size="50" value=""/></p>
    <p><label for="price-ph" class="short"><b>Price per hour: </b></label>
        <input type="number" step="0.01" id="price-ph" name="price-ph" size="50" value=""/></p>
    <p><button type="submit" name="command" value="add-auto">Add</button></p>
</form>