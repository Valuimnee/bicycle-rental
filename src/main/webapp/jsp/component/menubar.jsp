<%--
  Author: TsalapovaMD
  Date: 5/28/2017
  Time: 2:33 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-md navbar-collapse collapse navbar-light bd-color pl-md-4">
    <form name="menu" class="form-inline navbar-collapse container-fluid pr-0" method="post" action="/control">
        <ul class="navbar-nav  mr-auto pr-0">
            <li class="nav-item dropdown mr-md-2">
                <button type="submit" name="command" value="locations" class="btn btn-primary <%--dropdown-toggle dropdown-toggle-split--%>"
                        <%--data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"--%>><fmt:message key="menubar.locations"/></button>
               <%-- <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="all-autos">View all locations</button>
                    <c:if test="${sessionScope.role=='user'}">
                    <button class="dropdown-item" type="submit" name="command" value="all-available-autos">View all available bikes</button>
                    <button class="dropdown-item" type="submit" name="command" value="choose-date-interval">Rent a bike</button>
                    </c:if>
                </div>--%>
            </li>
            <li class="nav-item dropdown mr-md-2">
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"><fmt:message key="menubar.bikes"/></button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="all-bicycles">View all bikes</button>
                    <button class="dropdown-item" type="submit" name="command" value="all-autos">View bikes by type</button>
                    <%--<c:if test="${sessionScope.role=='user'}">
                    <button class="dropdown-item" type="submit" name="command" value="all-available-autos">View all rented bikes</button>
                    <button class="dropdown-item" type="submit" name="command" value="choose-date-interval">Rent a bike</button>
                    </c:if>--%>
                </div>
            </li>
            <c:if test="${sessionScope.role=='user'}">
            <li class="nav-item dropdown mr-md-2">
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Rentals</button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="client-rentals">View all rentals</button>
                    <%--<button class="dropdown-item" type="submit" name="command" value="view-client-rentals">View current rentals</button>--%>
                    <%--<button class="dropdown-item" type="submit" name="command" value="view-client-rentals">Choose rental</button>
                    <button class="dropdown-item" type="submit" name="command" value="view-client-rentals">Edit rental</button>--%>
                </div>
            </li>
            </c:if>
        </ul>
        <c:if test="${sessionScope.role=='user'}">
        <div class="nav-item dropdown">
            <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split menu-user" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">${sessionScope.login}</button>
            <div class="dropdown-menu dropdown-menu-right">
                <button class="dropdown-item" type="submit" name="command" value="account"><fmt:message key="menubar.account"/></button>
                <button class="dropdown-item" type="submit" name="command" value="profile"><fmt:message key="menubar.profile"/></button>
                <%--<button class="dropdown-item" type="submit" name="command" value="card"><fmt:message key="menubar.card"/></button>--%>
                <button class="dropdown-item" type="submit" name="command" value="delete-account"><fmt:message key="menubar.delete-account"/></button>
            </div>
        </div>
        </c:if>
    </form>
</nav>
