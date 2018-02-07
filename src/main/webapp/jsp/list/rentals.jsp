<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form class="container text-center pb-5" name="rentals" method="post" action="/control">
    <table>
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
            <tr>
                <td class="text-center text">${bicycle.model}</td>
                <td class="text-center text">${rental.startTime}</td>
                <td class="text-center text">${rental.total} <fmt:message key="bicycle.price-ph-currency"/></td>
                <td class="text-center text">${rental.status}</td>
               <%-- <button class="btn mb-2" type="submit" name="bicycle-id" value="${bicycle.bicycleId}" <c:if test="${sessionScope.role!='user'}">hidden</c:if> >Rent</button>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
