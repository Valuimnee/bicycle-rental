<%--
  User: TsalapovaMD
  Date: 5/28/2017
  Time: 2:33 PM
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<form name="menu" method="post" action="/control">
    <div>
        <ul class="menu-bar">
            <li class="dropdown"><div class="dropdown-name">Admins</div>
                <ul class="submenu">
                    <li><button type="submit" name="command" value="view-all-admins">View all admins</button></li>
                </ul>
            </li>
            <li class="dropdown"><div class="dropdown-name">Clients</div>
                <ul class="submenu">
                    <li><button type="submit" name="command" value="view-all-user-clients">View all clients</button></li>
                    <%--<li><button type="submit" name="command" value="">Choose client</button></li>
                    <li><button type="submit" name="command" value=""></button></li>--%>
                </ul>
            </li>
            <li class="dropdown"><div class="dropdown-name">Locations</div>
                <ul class="submenu">
                    <li><button type="submit" name="command" value="view-all-autos">View all locations</button></li>
                    <li><button type="submit" name="command" value="add-auto-form">Add location</button></li>
                    <li><button type="submit" name="command" value="choose-auto">Choose location</button></li>
                </ul>
            </li>
            <li class="dropdown"><div class="dropdown-name">Bikes</div>
                <ul class="submenu">
                    <li><button type="submit" name="command" value="view-all-autos">View all bikes</button></li>
                    <li><button type="submit" name="command" value="view-client-autos">View all bikes of location</button></li>
                    <li><button type="submit" name="command" value="add-auto-form">Add bike</button></li>
                    <li><button type="submit" name="command" value="choose-auto">Choose bike</button></li>
                </ul>
            </li>
            <li class="dropdown"><div class="dropdown-name">Rentals</div>
                <ul class="submenu">
                    <li><button type="submit" name="command" value="view-all-rentals">View all rentals</button></li>
                    <%--<li><button type="submit" name="command" value="three-longest-rentals">View three rentals with longest time</button></li>
                    <li><button type="submit" name="command" value="delete-canceled-rentals">Delete canceled rentals</button></li>--%>
                </ul>
            </li>
        </ul>
    </div>
</form>
