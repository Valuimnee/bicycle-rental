<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="entity" name="find-auto" method="post" action="/control">
    <c:if test="${requestScope.containsKey('wrong')}"><p>${requestScope.get("wrong")}</p></c:if>
    <p><label><b>Choose auto to rent by VIN code: </b></label></p>
    <p><label for="vin" class="short"><b>VIN code: </b></label>
        <input type="text" id="vin" name="vin" size="50" value=""/></p>
    <p><button type="submit" name="command" value="rent-auto">Display</button></p>
</form>
<br>
<jsp:include page="/jsp/list/autos.jsp"/>
<%--
<form class="list" name="autos">
    <table>
        <caption><c:out value="${caption}"/></caption>
        <tr>
            <c:forEach items="${autoHeaders}" var="theader">
                <th><c:out value="${theader}"/></th>
            </c:forEach>
        </tr>
        <c:forEach items="${sessionScope.get('autos')}" var="auto">
            <tr>
                <td><c:out value="${auto.make}"/></td>
                <td><c:out value="${auto.model}"/></td>
                <td><c:out value="${auto.displacement}"/></td>
                <td><c:out value="${auto.fuel}"/></td>
                <td><c:out value="${auto.registrationNumber}"/></td>
                <td><c:out value="${auto.vin}"/></td>
                <td><c:out value="${auto.available}"/></td>
                <td><c:out value="${auto.pricePh}"/></td>
            </tr>
        </c:forEach>
    </table>
</form>--%>
