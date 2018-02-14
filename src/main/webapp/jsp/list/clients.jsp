<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form class="container text-center pb-5" name="clients-form" method="post" action="/control?command=view-client">
    <table class="table table-striped table-responsive-sm">
        <caption></caption>
        <thead>
        <tr>
            <th class="text-center text"><fmt:message key="clients.login" /></th>
            <th class="text-center text"><fmt:message key="clients.fullname" /></th>
            <th class="text-center text"><fmt:message key="clients.phone"/></th>
            <th class="text-center text"><fmt:message key="clients.rentals"/></th>
            <th class="text-center text"><fmt:message key="clients.status"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach begin="0" end="${clients.size()-1}" varStatus="loop">
            <c:set var="login" value="${logins.get(loop.index)}"/>
            <c:set var="client" value="${clients.get(loop.index)}"/>
            <c:set var="rental" value="${rentals.get(loop.index)}"/>
            <tr class="clickable" onclick="document.getElementById('client${loop.index}').click()">
                <td class="text-center text">${login}</td>
                <td class="text-center text">${client.firstName} ${client.middleName} ${client.lastname}</td>
                <td class="text-center text">+${client.phone}</td>
                <td class="text-center text">${rental}</td>
                <td class="text-center text"><input type="checkbox" <c:if test="${client.active==1}">checked</c:if> disabled="disabled"/></td>
                <td hidden><button id="client${loop.index}" type="submit" name="client-id" value="${client.clientId}"></button></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
