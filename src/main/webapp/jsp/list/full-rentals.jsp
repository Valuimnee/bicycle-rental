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
                <td><c:out value="${rental.fullname}"/></td>
                <td><c:out value="${rental.make}"/></td>
                <td><c:out value="${rental.model}"/></td>
                <td><c:out value="${rental.vin}"/></td>
                <td><c:out value="${rental.pricePh}"/></td>
                <td><c:out value="${rental.pickupDate}"/></td>
                <td><c:out value="${rental.hours}"/></td>
                <td><c:out value="${rental.total}"/></td>
                <td><c:out value="${rental.status}"/></td>
                <td><c:out value="${rental.secondDriver==null?'':rental.secondDriver}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>
