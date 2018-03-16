<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fld" uri="fldlib" %>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="/js/submit.js"></script>
<form class="no-resubmit" name="add-bicycle-form" method="post" action="/control">
    <input type="hidden" name="submitted" value="false"/>
    <p class="mb-2 text-center"><label><b><fmt:message key="bicycle.add-greeting"/></b></label></p>
    <c:if test="${requestScope.wrong=='wrong-info'}"><p class="mb-2"><fmt:message key="bicycle.wrong-info"/></p></c:if>
    <fld:input type="product-name" labelType="medium" name="model" required="required" autofocus="autofocus">
        <jsp:attribute name="label"><fmt:message key="bicycle.model"/></jsp:attribute><jsp:body/>
    </fld:input>
    <fld:input type="product-name" labelType="medium" name="brand" required="required">
        <jsp:attribute name="label"><fmt:message key="bicycle.brand"/></jsp:attribute><jsp:body/>
    </fld:input>
    <div class="mb-2 input-group">
        <label for="material" class="medium-label"><b><fmt:message key="bicycle.material"/>: </b></label>
        <select class="custom-select" name="material" id="material" required="required">
            <option></option>
            <c:forEach var="material" items="${materials}">
                <option value="${material}"><fmt:message key="material.${material}"/></option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-2 input-group">
        <label for="type" class="medium-label"><b><fmt:message key="bicycle.type"/>: </b></label>
        <select class="custom-select" name="type" id="type" required="required">
            <option></option>
            <c:forEach var="type" items="${types}">
                <option value="${type}"><fmt:message key="type.${type}"/></option>
            </c:forEach>
        </select>
    </div>
    <div class="mb-2 input-group">
        <label for="price-ph" class="medium-label"><b><fmt:message key="bicycle.price-ph"/>,
        <fmt:message key="bicycle.price-ph-currency"/>: </b></label>
        <input type="number" class="form-control" step="0.01" min="0.01" max="100.00" id="price-ph" name="price-ph"
               size="50" value="" required="required"/>
    </div>
    <div class="mb-lg-2 text-right col-9">
        <button class="btn" type="submit" name="command" value="add-bicycle"><fmt:message key="bicycle.add"/></button>
    </div>
</form>
