<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-md navbar-collapse collapse navbar-light bd-color pl-md-4">
    <form name="menu" class="form-inline container-fluid pr-0 pl-0" method="post" action="/control">
        <ul class="navbar-nav container-fluid">
            <li class="nav-item dropdown mr-md-2">
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"><fmt:message key="adminbar.clients"/></button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="view-clients">
                        <fmt:message key="adminbar.view-all-clients"/></button>
                </div>
            </li>
            <li class="nav-item dropdown mr-md-2">
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"><fmt:message key="adminbar.locations"/></button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="locations">
                        <fmt:message key="adminbar.view-all-locations"/></button>
                </div>
            </li>
            <li class="nav-item dropdown mr-md-2">
                <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false"><fmt:message key="adminbar.bikes"/></button>
                <div class="dropdown-menu">
                    <button class="dropdown-item" type="submit" name="command" value="all-bicycles">
                        <fmt:message key="menubar.all-bikes"/></button>
                    <button class="dropdown-item" type="submit" name="command" value="add-bicycle-form">
                        <fmt:message key="adminbar.add-bike"/></button>
                </div>
            </li>
        </ul>
        <div class="nav-item dropdown">
            <button type="button" class="btn btn-primary dropdown-toggle dropdown-toggle-split menu-user" data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">${sessionScope.login}</button>
            <div class="dropdown-menu dropdown-menu-right">
                <button class="dropdown-item" type="submit" name="command" value="user-account"><fmt:message key="menubar.account"/></button>
            </div>
        </div>
    </form>
</nav>