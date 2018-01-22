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
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Admins</button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="view-all-admins">View all admins</button>
                </div>
            </li>
            <li class="nav-item dropdown mr-md-2">
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Clients</button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="view-all-user-clients">View all clients</button>
                    <button class="dropdown-item" type="submit" name="command" value="view-all-user-clients">Choose client</button>
                </div>
            </li>
            <li class="nav-item dropdown mr-md-2">
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Locations</button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="view-all-user-clients">View all locations</button>
                    <button class="dropdown-item" type="submit" name="command" value="view-all-user-clients">Add location</button>
                    <button class="dropdown-item" type="submit" name="command" value="view-all-user-clients">Choose location</button>
                </div>
            </li>
            <li class="nav-item dropdown mr-md-2">
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Bikes</button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="view-all-autos">View all bikes</button>
                    <button class="dropdown-item" type="submit" name="command" value="view-client-autos">View all bikes of location</button>
                    <button class="dropdown-item" type="submit" name="command" value="add-auto-form">Add bike</button>
                    <button class="dropdown-item" type="submit" name="command" value="choose-auto">Choose bike</button>
                </div>
            </li>
            <li class="nav-item dropdown mr-md-2">
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Rentals</button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="view-all-rentals">View all rentals</button>
                    <button class="dropdown-item" type="submit" name="command" value="three-longest-rentals">View three rentals with longest time</button>
                    <button class="dropdown-item" type="submit" name="command" value="delete-canceled-rentals">Delete canceled rentals</button>
                </div>
            </li>
        </ul>
    </form>
</nav>