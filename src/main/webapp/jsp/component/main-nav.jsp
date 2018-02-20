<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-fixed-top navbar-expand navbar-light bd-color">
    <div class="container nav-fill filler">
        <c:choose>
            <c:when test="${sessionScope.role=='administrator'}">
                <div class="nav-item"><a class="nav-link text-left" href="/jsp/cabinet.jsp"><fmt:message key="main-nav.admin-cabinet"/></a></div>
            </c:when>
            <c:otherwise>
                <div class="nav-item"><a class="nav-link text-left" href="/index.jsp"><fmt:message key="main-nav.main-page"/></a></div>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="container-fluid navbar-collapse collapse navbar-responsive-collapse justify-content-end">
        <ul class="navbar-nav">
            <li class="nav-item dropdown mr-md-2">
                <form class="form-inline" method="post" action="/control">
                    <input type="hidden" name="command" value="language"/>
                    <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><fmt:message key="main-nav.language"/></button>
                    <div class="dropdown-menu">
                        <button class="dropdown-item" type="submit" name="lang" value="en_US" >EN</button>
                        <button class="dropdown-item" type="submit" name="lang" value="ru_RU">RU</button>
                    </div>
                </form>
            </li>
            <c:choose>
                <c:when test="${sessionScope.role==null}">
                    <li class="nav-item"><a class="nav-link" href="/jsp/login.jsp"><fmt:message key="main-nav.login"/></a></li>
                    <li class="nav-item"><a class="nav-link" href="/jsp/register.jsp"><fmt:message key="main-nav.register"/></a></li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <form class="form-inline" name="logout" method="post" action="/control">
                            <button class="btn nav-link bd-color border-0" type="submit" name="command" value="logout"><fmt:message key="main-nav.logout"/></button>
                        </form>
                    </li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</nav>