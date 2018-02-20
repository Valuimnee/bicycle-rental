<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form class="container text-center pb-5" name="bicycles-form" method="post" action="/control">
    <input type="hidden" name="command" value="${sessionScope.role=='administrator'?'view-bicycle':'select-bicycle'}"/>
    <c:forEach begin="0" end="${bicycles.size()/4+(bicycles.size()%4>0?1:0)-1}" varStatus="loop">
        <div class="row justify-content-start">
            <c:forEach begin="0" end="3" varStatus="element">
                <c:if test="${4*loop.index+element.index lt bicycles.size()}">
                    <div class="col-sm-3 pl-0 pr-0">
                        <div class="card bicycle-card">
                            <c:set var="bicycle" value="${bicycles.get(4*loop.index+element.index)}"/>
                            <div class="card-header text-center text">${bicycle.model}</div>
                            <div class="card-body">
                                <p class="text-center text"><fmt:message key="bicycle.brand"/>: ${bicycle.brand}</p>
                                <p class="text-center text"><fmt:message key="bicycle.material"/>:
                                    <fmt:message key="material.${bicycle.material.toLowerCase().replace(' ', '-')}"/></p>
                                <p class="text-center text"><fmt:message key="bicycle.type"/>: <
                                    fmt:message key="type.${bicycle.type}"/></p>
                                <p class="text-center text"><fmt:message key="bicycle.price-ph"/>: ${bicycle.pricePh}
                                    <fmt:message key="bicycle.price-ph-currency"/></p>
                                <button class="btn mb-2" type="submit" name="bicycle-id" value="${bicycle.bicycleId}"
                                        <c:if test="${sessionScope.role!='user'}">hidden</c:if> >
                                    <fmt:message key="bicycle.rent"/></button>
                                <c:if test="${sessionScope.role=='administrator'}">
                                    <button class="btn mb-2" type="submit" name="bicycle-id" value="${bicycle.bicycleId}">
                                        <fmt:message key="bicycle.view"/></button>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </c:forEach>
</form>

