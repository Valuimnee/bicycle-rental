<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="list" name="clients">
    <table>
        <caption><c:out value="${requestScope.getOrDefault('caption', '')}"/></caption>
        <tr>
            <c:forEach items="${requestScope.getOrDefault('clientHeaders', null)}" var="theader">
                <th><c:out value="${theader}"/></th>
            </c:forEach>
        </tr>
        <c:forEach items="${requestScope.getOrDefault('clients', null)}" var="rental">
            <tr>
                <%--<td><c:out value="${client.clientId}"/></td>--%>
                <td><c:out value="${rental.login}"/></td>
                <td><c:out value="${rental.password}"/></td>
                <td><c:out value="${rental.fullname}"/></td>
                <td><c:out value="${rental.address}"/></td>
                <td><c:out value="${rental.passport}"/></td>
                <td><c:out value="${rental.driversLicense}"/></td>
                <td><c:out value="${rental.regular}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>

