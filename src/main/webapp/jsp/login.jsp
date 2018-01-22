<%--
  Author: TsalapovaMD
  Date: 12/28/2017
  Time: 2:25 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page errorPage="/jsp/error.jsp" %>
<!DOCTYPE HTML>
<html lang="en">
<jsp:include page="/jsp/component/head.jsp"/>
<body>
<jsp:include page="/jsp/component/main-nav.jsp"/>
<jsp:include page="/jsp/component/header.jsp"/>
<div class="content">
    <div class="greeting">
        <h2 id="log">Log in to rent your bike!</h2>
    </div>
    <form name="log" method="post" action="/control">
        <c:if test="${requestScope.containsKey('wrong')}" ><p>Invalid login or password, please try again</p></c:if>
        <p><label for="login" class="short"><b>Login: </b></label>
            <input type="text" id="login" name="login" size="50" value=""/></p>
        <p><label for="password" class="short"><b>Password: </b></label>
            <input type="password" id="password" name="password" size="50" value=""/></p>
        <p><button type="submit" name="command" value="login">Login</button>
    </form>
</div>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
