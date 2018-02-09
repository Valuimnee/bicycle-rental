<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<form name="add-bicycle" method="post" action="/control">
    <p class="mb-2 text-center"><label><b><fmt:message key="bicycle.add-greeting"/></b></label></p>
    <c:if test="${requestScope.wrong=='wrong-info'}"><p class="mb-2"><fmt:message key="bicycle.wrong-info"/></p></c:if>
    <div class="mb-2 input-group"><label for="model" class="medium-label"><b><fmt:message key="bicycle.model"/>: </b></label>
        <input type="text" class="form-control" pattern="^([\p{L}\d'][ \p{L}\d'-]*[\p{L}\d]|[\p{L}\d][\p{L}\d'-]*)$"
               id="model" name="model" size="50" value="" required="required"/>
    </div>
    <div class="mb-2 input-group"><label for="brand" class="medium-label"><b><fmt:message key="bicycle.brand"/>: </b></label>
        <input type="text" class="form-control" pattern="^([\p{L}'][ \p{L}'-]*\p{L}|\p{L}[\p{L}'-]*)$" id="brand"
               name="brand" size="50" value="" required="required"/>
    </div>
    <div class="mb-2 input-group"><label for="material" class="medium-label"><b><fmt:message key="bicycle.material"/>: </b></label>
        <select class="custom-select" name="material" id="material" required="required">
            <option></option>
            <c:forEach var="material" items="${materials}">
                <option value="${material}"><fmt:message key="material.${material}"/></option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-2 input-group"><label for="type" class="medium-label"><b><fmt:message key="bicycle.type"/>: </b></label>
        <select class="custom-select" name="type" id="type" required="required">
            <option></option>
            <c:forEach var="type" items="${types}">
                <option value="${type}"><fmt:message key="type.${type}"/></option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-2 input-group"><label for="price-ph" class="medium-label"><b><fmt:message key="bicycle.price-ph"/>,
        <fmt:message key="bicycle.price-ph-currency"/>: </b></label>
        <input type="number" class="form-control" step="0.01" min="0.01" max="100.00" id="price-ph" name="price-ph"
               size="50" value="" required="required"/>
    </div>
    <div class="mb-lg-2 text-right col-9">
        <button class="btn" type="submit" name="command" value="add-bicycle"><fmt:message key="bicycle.add"/></button>
    </div>
</form>
