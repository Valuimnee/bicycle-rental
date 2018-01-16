<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  User: TsalapovaMD
  Date: 5/28/2017
  Time: 2:33 PM
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<form name="menu" method="post" action="/control">
    <div>
        <ul class="menu-bar">
            <li class="dropdown"><div class="dropdown-name">Locations</div>
                <ul class="submenu">
                    <li><button type="submit" name="command" value="all-autos">View all locations</button></li>
                    <c:if test="${sessionScope.get('client')!=null}">
                        <li><button type="submit" name="command" value="all-available-autos">View all available autos</button></li>
                        <%--<li><button type="submit" name="command" value="">View rented autos</button></li>--%>
                        <li><button type="submit" name="command" value="choose-date-interval">Rent auto</button></li>
                        <%--<li><button type="submit" name="command" value="">Delete student</button></li>--%>
                    </c:if>
                </ul>
            </li>
            <li class="dropdown"><div class="dropdown-name">Bikes</div>
                <ul class="submenu">
                    <li><button type="submit" name="command" value="all-autos">View all bikes</button></li>
                    <li><button type="submit" name="command" value="all-autos">View all bikes of location</button></li>
                    <c:if test="${sessionScope.get('client')!=null}">
                        <li><button type="submit" name="command" value="all-available-autos">View all rented bikes</button></li>
                        <%--<li><button type="submit" name="command" value="">View rented autos</button></li>--%>
                        <li><button type="submit" name="command" value="choose-date-interval">Rent a bike</button></li>
                        <%--<li><button type="submit" name="command" value="">Delete student</button></li>--%>
                    </c:if>
                </ul>
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
    </div>
</form>
