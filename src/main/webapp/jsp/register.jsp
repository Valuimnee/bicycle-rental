<%--
  Author: CalapovaMD
  Date: 5/28/2017
  Time: 2:14 PM
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
<%--<jsp:forward page="startpage/"/>--%>
<%--<c:if test="${sessionScope.get('result')!=null}"><br><p id="result">${sessionScope.get('result')}</p></c:if>--%>
<main class="container-fluid">
    <div class="register-block">
    <h2 id="reg" class="greeting text-center mb-4">Register on our site so you can rent your best bike!</h2>
    <form name="register" method="post" action="/control">
    <c:if test="${requestScope.containsKey('wrong')}"><p>${requestScope.wrong}</p></c:if>
    <p><label><b>Enter client information: </b></label></p>
    <p><label for="login" class="long-label"><b>Login: </b></label>
        <input type="text" id="login" name="login" size="50" value=""/></p>
    <p><label for="password" class="long-label"><b>Password: </b></label>
        <input type="password" id="password" name="password" size="50" value=""/></p>
    <p><b><label>Repeat password</label></b><br>
    <label for="password2" class="long-label"><b>Password: </b></label>
        <input type="password" id="password2" name="password2" size="50" value=""/></p>
    <p>
    <p><label for="fullname" class="long-label"><b>Full name: </b></label>
        <input type="text" id="fullname" name="fullname" size="50" value=""/></p>
    <p><label for="address" class="long-label"><b>Address: </b></label>
        <input type="text" id="address" name="address" size="50" value=""/></p>
    <p><label for="passport" class="long-label"><b>Passport number: </b></label>
        <input type="text" id="passport" name="passport" size="50" value=""/></p>
    <p><label for="drivers-license" class="long-label"><b>Driver&apos;s license number: </b></label>
        <input type="text" id="drivers-license" name="drivers-license" size="50" value=""/></p>
    <p class="text-center"><button class="btn" type="submit" name="command" value="register">Register</button></p>
    </form>
    </div>
</main>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
