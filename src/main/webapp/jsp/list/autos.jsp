<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="list" name="autos">
    <table>
        <caption><c:out value="${caption}"/></caption>
        <tr>
            <c:forEach items="${autoHeaders}" var="theader">
                <th><c:out value="${theader}"/></th>
            </c:forEach>
        </tr>
        <c:forEach items="${autos}" var="bicycle">
            <tr>
                <td><c:out value="${bicycle.make}"/></td>
                <td><c:out value="${bicycle.model}"/></td>
                <td><c:out value="${bicycle.displacement}"/></td>
                <td><c:out value="${bicycle.fuel}"/></td>
                <td><c:out value="${bicycle.registrationNumber}"/></td>
                <td><c:out value="${bicycle.vin}"/></td>
                <td><c:out value="${bicycle.available}"/></td>
                <td><c:out value="${bicycle.pricePh}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>

