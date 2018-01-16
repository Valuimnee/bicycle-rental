<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="entity" name="add-auto" method="post" action="/control">
    <input type="hidden" name="auto-id" size="50" value="${auto.autoId}"/>
    <c:if test="${requestScope.containsKey('wrong')}"><p>${requestScope.get("wrong")}</p></c:if>
    <p><label><b>Fill in auto information: </b></label></p>
    <p><label for="make" class="short"><b>Make: </b></label>
        <input type="text" id="make" name="make" size="50" value="${auto.make}"/></p>
    <p><label for="model" class="short"><b>Model: </b></label>
        <input type="text" id="model" name="model" size="50" value="${auto.model}"/></p>
    <p><label for="displacement" class="short"><b>Displacement: </b></label>
        <input type="number" step="0.1" id="displacement" name="displacement" size="50" value="${auto.displacement}"/></p>
    <p><label for="fuel" class="short"><b>Fuel: </b></label>
        <input type="text" id="fuel" name="fuel" size="50" value="${auto.fuel}"/></p>
    <p><label for="registration-number" class="short"><b>Registration number: </b></label>
        <input type="text" id="registration-number" name="registration-number" size="50" value="${auto.registrationNumber}"/></p>
    <p><label for="vin" class="short"><b>VIN code: </b></label>
        <input type="text" id="vin" name="vin" size="50" value="${auto.vin}" contenteditable="false"/></p>
    <p><label for="available" class="short"><b>Available: </b></label>
        <input type="number" min="0" max="1"  id="available" name="available" size="50" value="${auto.available}"/></p>
    <p><label for="price-ph" class="short"><b>Price per hour: </b></label>
        <input type="number" step="0.01" id="price-ph" name="price-ph" size="50" value="${auto.pricePh}"/></p>
    <p><button type="submit" name="command" value="edit-auto">Save changes</button>
        <button type="submit" name="command" value="delete-auto">Delete auto</button></p>
</form>