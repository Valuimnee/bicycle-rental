<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="entity" name="client-profile" method="post" action="/control">
    <c:if test="${requestScope.containsKey('wrong')}"><p>${wrong}</p></c:if>
    <p><label><b>Profile information: </b></label></p>
    <p><label for="fullname" class="short"><b>Full name: </b></label>
        <input type="text" id="fullname" name="fullname" size="50" value="${client.fullname}"/></p>
    <p><label for="address" class="short"><b>Address: </b></label>
        <input type="text" id="address" name="address" size="50" value="${client.address}"/></p>
    <p><label for="passport" class="short"><b>Passport number: </b></label>
        <input type="text" id="passport" name="passport" size="50" value="${client.passport}"/></p>
    <p><label for="drivers-license" class="short"><b>Driver&apos;s license number: </b></label>
        <input type="text" id="drivers-license" name="drivers-license" size="50" value="${client.driversLicense}"/></p>
    <p><button type="submit" name="command" value="edit-client">Save changes</button></p>
</form>