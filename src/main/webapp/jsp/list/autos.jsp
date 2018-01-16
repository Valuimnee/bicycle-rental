<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="list" name="autos">
    <table>
        <caption><c:out value="${caption}"/></caption>
        <tr>
            <c:forEach items="${autoHeaders}" var="theader">
                <th><c:out value="${theader}"/></th>
            </c:forEach>
        </tr>
        <c:forEach items="${autos}" var="rental">
            <tr>
                <td><c:out value="${rental.make}"/></td>
                <td><c:out value="${rental.model}"/></td>
                <td><c:out value="${rental.displacement}"/></td>
                <td><c:out value="${rental.fuel}"/></td>
                <td><c:out value="${rental.registrationNumber}"/></td>
                <td><c:out value="${rental.vin}"/></td>
                <td><c:out value="${rental.available}"/></td>
                <td><c:out value="${rental.pricePh}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>

