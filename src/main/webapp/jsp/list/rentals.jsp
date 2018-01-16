<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="list" name="rentals">
    <table>
        <caption><c:out value="${requestScope.getOrDefault('caption', '')}"/></caption>
        <tr>
            <c:forEach items="${requestScope.getOrDefault('rentalHeaders', null)}" var="theader">
                <th><c:out value="${theader}"/></th>
            </c:forEach>
        </tr>
        <c:forEach items="${requestScope.getOrDefault('rentals', null)}" var="rental">
            <tr>
                <td><c:out value="${rental.rentalId}"/></td>
                <td><c:out value="${rental.autoId}"/></td>
                <td><c:out value="${rental.getPickupDateString()}"/></td>
                <td><c:out value="${rental.hours}"/></td>
                <td><c:out value="${rental.total}"/></td>
                <td><c:out value="${rental.status}"/></td>
                <td><c:out value="${rental.secondDriver}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
