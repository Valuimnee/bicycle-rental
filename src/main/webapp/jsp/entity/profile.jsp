<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/js/profile.js"></script>
<div class="register-block">
    <h2 id="reg" class="greeting text-center mb-2"><fmt:message key="profile.header"/></h2>
    <form class="mt-2" name="profile" method="post" action="/control">
        <c:if test="${requestScope.wrong=='wrong-info'}"><p class="mb-2"><fmt:message key="register.wrong-info"/></p></c:if>
        <p class="mb-2"><b><label class="container-fluid text-center mb-4"><fmt:message key="profile.greeting"/></label></b><br/>
            <label for="first-name" class="long-label"><b><fmt:message key="register.first-name"/>: </b></label>
            <input type="text" pattern="^([\p{L}'][ \p{L}'-]*\p{L}|\p{L}[\p{L}'-]*)$" id="first-name" name="first-name" size="50" value="${client.firstName}" required="required"/></p>
        <p class="mb-2"><label for="middle-name" class="long-label"><b><fmt:message key="register.middle-name"/>: </b></label>
            <input type="text" pattern="^([\p{L}'][ \p{L}'-]*\p{L}|\p{L}[\p{L}'-]*)$" id="middle-name" name="middle-name" size="50" value="${client.middleName}"/></p>
        <p class="mb-2"><label for="lastname" class="long-label"><b><fmt:message key="register.lastname"/>: </b></label>
            <input type="text" pattern="^([\p{L}'][ \p{L}'-]*\p{L}|\p{L}[\p{L}'-]*)$" id="lastname" name="lastname" size="50" value="${client.lastname}" required="required"/></p>
        <p class="mb-2"><label for="address" class="long-label"><b><fmt:message key="register.address"/>: </b></label>
            <input type="text" pattern="^([\p{L}.,-/\d]+\s+)*[\p{L}.,-/\d]+$" id="address" name="address" size="50" value="${client.address}"/></p>
        <p class="mb-2"><label for="passport" class="long-label"><b><fmt:message key="register.passport-number"/>: </b></label>
            <input type="text" pattern="^(AB|BM|HB|KH|MP|MC|KB|PP)\d{7}$" id="passport" name="passport" size="50" value="${client.passportNumber}" required="required"/></p>
        <p class="mb-2"><label for="phone" class="long-label"><b><fmt:message key="register.phone"/>: </b></label>
            <input type="tel" pattern="^\d{12}$" id="phone" name="phone" size="50" value="${client.phone}" required="required"/></p>
        <p><label for="email" class="long-label"><b><fmt:message key="register.email"/>: </b></label>
            <input type="email" id="email" name="email" size="50" value="${client.email}" required="required"/></p>
        <p class="text-right col-9"><button class="btn" type="submit" name="command" value="edit-profile"><fmt:message key="profile.save-changes"/></button></p>
    </form>
</div>

