<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form name="register" method="post" action="/control">
    <c:if test="${requestScope.wrong=='wrong-info'}"><p class="mb-2"><fmt:message key="register.wrong-info"/></p></c:if>
    <p class="mb-2 text-center"><label><b><fmt:message key="register.login-info"/></b></label></p>
    <p class="mb-2"><c:if test="${requestScope.wrong=='wrong-login'}"><div class="mb-1"><fmt:message key="register.wrong-login"/></div></c:if>
    <label for="login" class="long-label"><b><fmt:message key="register.login"/>: </b></label>
    <input type="text" pattern="^[-\w.]{4,20}$" id="login" name="login" size="50" value="" disabled/></p>
    <p class="mb-2"><label for="password" class="long-label"><b><fmt:message key="register.password"/>: </b></label>
        <input type="password" pattern="^[^ ]{8,40}$" id="password" name="password" size="50" value="" disabled/></p>
    <p class="mb-2"><label for="password2" class="long-label"><b><fmt:message key="register.password2"/>: </b></label>
        <input type="password" pattern="^[^ ]{8,40}$" id="password2" name="password2" size="50" value="" disabled/></p>
    <p class="mb-2"><b><label class="container-fluid text-center"><fmt:message key="register.personal-info"/></label></b><br/>
        <label for="first-name" class="long-label"><b><fmt:message key="register.first-name"/>: </b></label>
        <input type="text" pattern="^([\p{L}'][ \p{L}'-]*\p{L}|\p{L}[\p{L}'-]*)$" id="first-name" name="first-name" size="50" value="" disabled/></p>
    <p class="mb-2"><label for="middle-name" class="long-label"><b><fmt:message key="register.middle-name"/>: </b></label>
        <input type="text" pattern="^([\p{L}'][ \p{L}'-]*\p{L}|\p{L}[\p{L}'-]*)$" id="middle-name" name="middle-name" size="50" value=""/></p>
    <p class="mb-2"><label for="lastname" class="long-label"><b><fmt:message key="register.lastname"/>: </b></label>
        <input type="text" pattern="^([\p{L}'][ \p{L}'-]*\p{L}|\p{L}[\p{L}'-]*)$" id="lastname" name="lastname" size="50" value="" disabled/></p>
    <p class="mb-2"><label for="address" class="long-label"><b><fmt:message key="register.address"/>: </b></label>
        <input type="text" pattern="^([\p{L}.,-/\d]+\s+)*[\p{L}.,-/\d]+$" id="address" name="address" size="50" value=""/></p>
    <p class="mb-2"><label for="passport" class="long-label"><b><fmt:message key="register.passport-number"/>: </b></label>
        <input type="text" pattern="^(AB|BM|HB|KH|MP|MC|KB|PP)\d{7}$" id="passport" name="passport" size="50" value="" disabled/></p>
    <p class="mb-2"><label for="phone" class="long-label"><b><fmt:message key="register.phone"/>: </b></label>
        <input type="tel" pattern="^\d{12}$" id="phone" name="phone" size="50" value="" disabled/></p>
    <p><label for="email" class="long-label"><b><fmt:message key="register.email"/>: </b></label>
        <input type="email" id="email" name="email" size="50" value="" disabled/></p>
    <p class="mb-2"><label for="start-date" class="long-label"><b><fmt:message key="date.start-date"/>: </b></label>
        <input type="datetime-local" id="start-date" name="start-date" size="50" value="${rental.startTime.toString()}" disabled/></p>
    <p class="mb-2"><label for="hours" class="long-label"><b><fmt:message key="date.duration"/>: </b></label>
        <input type="number" min="1" max="168" id="hours" name="hours" size="50" value="${rental.hours}" disabled/></p>
    <p class="text-right col-9"><button class="btn" type="submit" name="command" value="rent"><fmt:message key="rental.confirm"/></button></p>
</form>