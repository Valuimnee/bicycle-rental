<%--
  Author: TsalapovaMD
  Date: 5/28/2017
  Time: 2:35 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE HTML>
<html lang="en">
<jsp:include page="/jsp/component/head.jsp"/>
<body>
<jsp:include page="/jsp/component/main-nav.jsp"/>
<jsp:include page="/jsp/component/header.jsp"/>
<div class="container-fluid">
<form>
    <h1><fmt:message key="error.header"/></h1>
    <fmt:message key="error.code"/>: ${pageContext.errorData.statusCode}<br>
    <fmt:message key="error.uri"/>: ${pageContext.errorData.requestURI}<br>
    <fmt:message key="error.message"/>: ${pageContext.errorData.throwable.localizedMessage}<br>
</form>
</div>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>