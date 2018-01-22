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
<div class="content">
    <div class="greeting"><h2 id="reg">Register on our site so you can rent your best bike!</h2></div>
    <form name="register" method="post" action="/control">
    <%-- <input type="hidden" name="command" value="register"/>--%>
    <c:if test="${requestScope.containsKey('wrong')}"><p>${requestScope.get("wrong")}</p></c:if>
    <p><label><b>Enter client information: </b></label></p>
    <p><label for="login" class="short"><b>Login: </b></label>
        <input type="text" id="login" name="login" size="50" value=""/></p>
    <p><label for="password" class="short"><b>Password: </b></label>
        <input type="password" id="password" name="password" size="50" value=""/></p>
    <p><b><label>Repeat password</label></b><br>
    <label for="password2" class="short"><b>Password: </b></label>
        <input type="password" id="password2" name="password2" size="50" value=""/></p>
    <p>
    <p><label for="fullname" class="short"><b>Full name: </b></label>
        <input type="text" id="fullname" name="fullname" size="50" value=""/></p>
    <p><label for="address" class="short"><b>Address: </b></label>
        <input type="text" id="address" name="address" size="50" value=""/></p>
    <p><label for="passport" class="short"><b>Passport number: </b></label>
        <input type="text" id="passport" name="passport" size="50" value=""/></p>
    <p><label for="drivers-license" class="short"><b>Driver&apos;s license number: </b></label>
        <input type="text" id="drivers-license" name="drivers-license" size="50" value=""/></p>
    <%--<p><input type="submit" name="register" value="Register"/></p>--%>
    <p><button type="submit" name="command" value="register">Register</button></p>
    </form>
</div>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>
