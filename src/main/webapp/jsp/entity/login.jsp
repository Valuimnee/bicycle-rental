<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="entity" name="client-login" method="post" action="/control">
    <c:if test="${requestScope.containsKey('wrong')}"><p>${wrong}</p></c:if>
    <p><label><b>Enter client information: </b></label></p>
    <p><label for="login" class="short"><b>Login: </b></label>
        <input type="text" id="login" name="login" size="50" value="${user.login}"/></p>
    <p><label for="password" class="short"><b>Password: </b></label>
        <input type="password" id="password" name="password" size="50" value=""/></p>
    <p><label for="new-password" class="short"><b>New password: </b></label>
        <input type="password" id="new-password" name="new-password" size="50" value=""/></p>
    <p><b><label>Repeat new password</label></b><br>
        <label for="new-password2" class="short"><b>New password: </b></label>
        <input type="password" id="new-password2" name="new-password2" size="50" value=""/></p>
    <p><button type="submit" name="command" value="edit-client-account">Save changes</button></p>
</form>