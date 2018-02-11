<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="container text-center pb-5" name="locations-form" method="post" action="/control">
    <c:choose>
        <c:when test="${sessionScope.role=='administrator'&&select=='select'}">
            <input type="hidden" name="command" value="assign-location"/></c:when>
        <c:otherwise><input type="hidden" name="command" value="bicycles-by-location"/></c:otherwise>
    </c:choose>
    <c:forEach begin="0" end="${locations.size()/2+locations.size()%2-1}" varStatus="loop">
        <div class="row justify-content-around">
            <c:forEach begin="0" end="1" varStatus="element">
                <c:if test="${2*loop.index+element.index lt locations.size()}">
                    <div class="col-sm-4 pl-0 pr-0">
                        <div class="card location-card">
                            <c:set var="location" value="${locations.get(2*loop.index+element.index)}"/>
                            <button class="btn mb-2" type="submit" name="location-id" value="${location.locationId}">${location.name}</button>
                            <p class="text-center text">${location.address}</p>
                            <p class="text-center text">${location.phone}</p>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
</form>

