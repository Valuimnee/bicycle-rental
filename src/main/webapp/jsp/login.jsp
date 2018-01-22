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
<main role="main" class="container-fluid">
    <div class="login-block">
        <h2 id="log" class="text-center mb-4">Log in to rent your bike!</h2>
        <form name="login" method="post" action="/control">
            <c:if test="${requestScope.containsKey('wrong')}" ><p>Invalid login or password, please try again</p></c:if>
            <p class="mb-3"><label for="login" class="short-label"><b>Login: </b></label>
                <input type="text" id="login" name="login" size="50" value=""/></p>
            <p><label for="password" class="short-label"><b>Password: </b></label>
                <input type="password" id="password" name="password" size="50" value=""/></p>
            <p class="text-center"><button class="btn" type="submit" name="command" value="login">Login</button>
        </form>
    </div>
</main>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
