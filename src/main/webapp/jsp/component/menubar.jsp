<%--
  Author: TsalapovaMD
  Date: 5/28/2017
  Time: 2:33 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-md navbar-collapse collapse navbar-light bd-color pl-md-4">
    <form name="menu" class="form-inline" method="post" action="/control">
        <ul class="navbar-nav">
            <li class="nav-item dropdown mr-md-2">
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Locations</button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="all-autos">View all locations</button>
                    <c:if test="${sessionScope.get('client')!=null}">
                        <button class="dropdown-item" type="submit" name="command" value="all-available-autos">View all available autos</button>
                        <%--<li><button type="submit" name="command" value="">View rented autos</button></li>--%>
                        <button class="dropdown-item" type="submit" name="command" value="choose-date-interval">Rent auto</button>
                        <%--<li><button type="submit" name="command" value="">Delete student</button></li>--%>
                    </c:if>
                </div>
            </li>
            <li class="nav-item dropdown mr-md-2">
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Bikes</button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="all-autos">View all bikes</button>
                    <button class="dropdown-item" type="submit" name="command" value="all-autos">View all bikes of location</button>
                    <c:if test="${sessionScope.get('client')!=null}">
                        <button class="dropdown-item" type="submit" name="command" value="all-available-autos">View all rented bikes</button>
                        <%--<li><button type="submit" name="command" value="">View rented autos</button></li>--%>
                        <button class="dropdown-item" type="submit" name="command" value="choose-date-interval">Rent a bike</button>
                        <%--<li><button type="submit" name="command" value="">Delete student</button></li>--%>
                    </c:if>
                </div>
            </li>
            <c:if test="${sessionScope.get('client')!=null}">
                <li class="dropdown"><div class="dropdown-name">Rentals</div>
                    <ul class="submenu">
                        <li><button type="submit" name="command" value="view-client-rentals">View all rentals</button></li>
                            <%--<li><button type="submit" name="command" value="">View current rentals</button></li>--%>
                            <%--<li><button type="submit" name="command" value="">Choose rental</button></li>--%>
                            <%--<li><button type="submit" name="command" value="">Edit rental</button></li>--%>
                    </ul>
                </li>
                <li class="dropdown"><div class="dropdown-name">Profile</div>
                    <ul class="submenu">
                        <li><button type="submit" name="command" value="view-profile">View profile</button></li>
                        <li><button type="submit" name="command" value="view-login">View login information</button></li>
                        <li><button type="submit" name="command" value="delete-client">Delete account</button></li>
                    </ul>
                </li>
            </c:if>
        </ul>
    </form>
</nav>
