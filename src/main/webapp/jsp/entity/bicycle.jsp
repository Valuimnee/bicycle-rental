<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fld" uri="fldlib" %>
<form name="bicycle-form" method="post" action="/control">
    <p class="mb-2 text-center"><label><b><fmt:message key="bicycle.edit-greeting"/></b></label></p>
    <c:if test="${requestScope.wrong=='wrong-info'}"><p class="mb-2"><fmt:message key="bicycle.wrong-info"/></p></c:if>
    <fld:input type="product-name" labelType="medium" name="model" required="required">
        <jsp:attribute name="label"><fmt:message key="bicycle.model"/></jsp:attribute><jsp:body>${bicycle.model}</jsp:body>
    </fld:input>
    <fld:input type="product-name" labelType="medium" name="brand" required="required">
        <jsp:attribute name="label"><fmt:message key="bicycle.brand"/></jsp:attribute><jsp:body>${bicycle.brand}</jsp:body>
    </fld:input>
    <fld:input type="product-name" labelType="medium" name="location" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="bicycle.location-name"/></jsp:attribute><jsp:body>${location.name}</jsp:body>
    </fld:input>
    <fld:input type="product-name" labelType="medium" name="location-address" disabled="disabled">
        <jsp:attribute name="label"><fmt:message key="bicycle.location-address"/></jsp:attribute><jsp:body>${location.address}</jsp:body>
    </fld:input>
    <div class="mb-2 input-group">
        <label for="material" class="medium-label"><b><fmt:message key="bicycle.material"/>: </b></label>
        <select class="custom-select" name="material" id="material" required="required">
            <option></option>
            <c:forEach var="material" items="${materials}">
            <option value="${material}" <c:if test="${bicycle.material.toLowerCase().replace(' ', '-')==material}">selected</c:if> >
                <fmt:message key="material.${material}"/></option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-2 input-group">
        <label for="type" class="medium-label"><b><fmt:message key="bicycle.type"/>: </b></label>
        <select class="custom-select" name="type" id="type" required="required">
            <option></option>
            <c:forEach var="type" items="${types}">
                <option value="${type}" <c:if test="${bicycle.type==type}">selected</c:if> >
                    <fmt:message key="type.${type}"/></option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-2 input-group">
        <label for="price-ph" class="medium-label"><b><fmt:message key="bicycle.price-ph"/>,
            <fmt:message key="bicycle.price-ph-currency"/>: </b></label>
        <input type="number" class="form-control" step="0.01" min="0.01" max="100.00" id="price-ph" name="price-ph"
               size="50" value="${bicycle.pricePh}" required="required"/>
    </div>
    <div class="mb-lg-2 mt-lg-4 pl-lg-5 text-left col-sm-12">
        <c:choose>
            <c:when test="${location==null}"><button class="btn mr-2" type="submit" name="command" value="select-location">
                <fmt:message key="bicycle.add-location"/></button></c:when>
            <c:otherwise><button class="btn mr-2" type="submit" name="command" value="delete-location">
                <fmt:message key="bicycle.delete-location"/></button></c:otherwise>
        </c:choose>
        <button class="btn mr-2" type="submit" name="command" value="delete-bicycle"><fmt:message key="bicycle.remove"/></button>
        <button class="btn" type="submit" name="command" value="edit-bicycle"><fmt:message key="bicycle.save-changes"/></button>
    </div>
</form>
