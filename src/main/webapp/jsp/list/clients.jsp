<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="list" name="clients">
    <table>
        <caption><c:out value="${requestScope.getOrDefault('caption', '')}"/></caption>
        <tr>
            <c:forEach items="${requestScope.getOrDefault('clientHeaders', null)}" var="theader">
                <th><c:out value="${theader}"/></th>
            </c:forEach>
        </tr>
        <c:forEach items="${requestScope.getOrDefault('clients', null)}" var="bicycle">
            <tr>
                <%--<td><c:out value="${client.clientId}"/></td>--%>
                <td><c:out value="${bicycle.login}"/></td>
                <td><c:out value="${bicycle.password}"/></td>
                <td><c:out value="${bicycle.fullname}"/></td>
                <td><c:out value="${bicycle.address}"/></td>
                <td><c:out value="${bicycle.passport}"/></td>
                <td><c:out value="${bicycle.driversLicense}"/></td>
                <td><c:out value="${bicycle.regular}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>

