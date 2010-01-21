<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head><title>Sports Club: Invoicing - account detail</title></head>
<body>
<form:form>
    ID = <c:out value="${account.id}"/>
</form:form>
</body>
</html>