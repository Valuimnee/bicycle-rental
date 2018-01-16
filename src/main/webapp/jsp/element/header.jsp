<%--
  User: TsalapovaMD
  Date: 5/28/2017
  Time: 2:33 PM
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <div class="nav-bar">
    <ul class="nav-menu">
        <c:choose>
        <c:when test="${sessionScope.get('client')!=null||sessionScope.get('admin')==null}">
            <li><a class="nav-menu-item" href="${pageContext.request.contextPath}/index.jsp">Main Page</a></li>
        </c:when>
            <c:otherwise>
                <li><a class="nav-menu-item" href="${pageContext.request.contextPath}/jsp/cabinet.jsp">Admin Cabinet</a></li>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${sessionScope.get('admin') == null&&sessionScope.get('client')==null}">
                <li><a class="nav-menu-item" href="/jsp/login.jsp">Log In</a></li>
                <li><a class="nav-menu-item" href="/jsp/register.jsp">Register</a></li>
            </c:when>
            <c:otherwise>
                <li><form class="nav-menu-item" name="logout" method="post" action="/control">
                    <button type="submit" name="command" value="logout">Log out</button>
                </form></li>
            </c:otherwise>
        </c:choose>
    </ul>
    </div>
    <div>
    <h1 id="title">Bicycle rental<br>Rent your bike today!</h1>
    </div>
</header>