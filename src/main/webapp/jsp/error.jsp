<%--
  Author: TsalapovaMD
  Date: 5/28/2017
  Time: 2:35 PM
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page errorPage="/jsp/error.jsp" %>
<!DOCTYPE HTML>
<html lang="en">
<jsp:include page="/jsp/component/head.jsp"/>
<body>
<jsp:include page="/jsp/component/main-nav.jsp"/>
<jsp:include page="/jsp/component/header.jsp"/>
<div class="content">
<form>
    <h1>An error occurred!</h1>
    Error code: ${pageContext.errorData.statusCode}<br>
    URI: ${pageContext.errorData.requestURI}<br>
    Message: ${pageContext.errorData.throwable.message}<br>
</form>
</div>
<jsp:include page="/jsp/component/footer.jsp"/>
</body>
</html>