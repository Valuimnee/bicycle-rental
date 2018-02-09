<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form class="container text-center pb-5" name="rentals" method="post" action="/control?command=rental">
    <table class="table table-striped table-responsive-sm">
        <caption></caption>
        <thead>
            <tr>
                <th class="text-center text"><fmt:message key="rental.bicycle-name" /></th>
                <th class="text-center text"><fmt:message key="date.start-date" /></th>
                <th class="text-center text"><fmt:message key="rental.total"/></th>
                <th class="text-center text"><fmt:message key="rental.status"/></th>
            </tr>
        </thead>
        <tbody>
        <c:forEach begin="0" end="${rentals.size()-1}" varStatus="loop">
            <c:set var="rental" value="${rentals.get(loop.index)}"/>
            <c:set var="bicycle" value="${bicycles.get(loop.index)}"/>
            <tr class="clickable" onclick="document.getElementById('rental${loop.index}').click()">
                <td class="text-center text">${bicycle.model}</td>
                <td class="text-center text">${rental.startTime.toString().replace(":00.0", "")}</td>
                <td class="text-center text">${rental.total} <fmt:message key="bicycle.price-ph-currency"/></td>
                <td class="text-center text">${rental.status}</td>
                <td hidden><button id="rental${loop.index}" type="submit" name="rental-id" value="${rental.rentalId}"></button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
