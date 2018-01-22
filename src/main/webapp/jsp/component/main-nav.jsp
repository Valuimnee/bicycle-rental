<%--
  Author: TsalapovaMD
  Date: 1/22/2018
  Time: 3:22 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-fixed-top navbar-expand navbar-light bd-color">
    <div class="container-fluid">
        <div class="navbar-collapse collapse navbar-responsive-collapse justify-content-end">
            <ul class="navbar-nav">
                <c:choose>
                    <c:when test="${sessionScope.get('client')!=null||sessionScope.get('admin')==null}">
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Main
                            Page</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item"><a class="nav-link"
                                                href="${pageContext.request.contextPath}/jsp/cabinet.jsp">Admin
                            Cabinet</a></li>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${sessionScope.get('admin') == null&&sessionScope.get('client')==null}">
                        <li class="nav-item"><a class="nav-link" href="/jsp/login.jsp">Log In</a></li>
                        <li class="nav-item"><a class="nav-link" href="/jsp/register.jsp">Register</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <form class="form-inline" name="logout" method="post" action="/control">
                                <button type="submit" name="command" value="logout">Log out</button>
                            </form>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>