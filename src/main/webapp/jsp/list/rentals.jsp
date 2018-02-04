<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="list" name="rentals">
    <table>
        <caption><c:out value="${requestScope.getOrDefault('caption', '')}"/></caption>
        <tr>
            <c:forEach items="${requestScope.getOrDefault('rentalHeaders', null)}" var="theader">
                <th><c:out value="${theader}"/></th>
            </c:forEach>
        </tr>
        <c:forEach items="${requestScope.getOrDefault('rentals', null)}" var="bicycle">
            <tr>
                <td><c:out value="${bicycle.rentalId}"/></td>
                <td><c:out value="${bicycle.autoId}"/></td>
                <td><c:out value="${bicycle.getPickupDateString()}"/></td>
                <td><c:out value="${bicycle.hours}"/></td>
                <td><c:out value="${bicycle.total}"/></td>
                <td><c:out value="${bicycle.status}"/></td>
                <td><c:out value="${bicycle.secondDriver}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
