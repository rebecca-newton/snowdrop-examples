<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Payment Notification Created</title>
    <link href="images/favicon.png" rel="Shortcut Icon"/>
    <%@ include file="../../template/styles.html" %>
</head>
<body class="main-body">
<%@ include file="../../template/header.html" %>
    Payment amount: <c:out value="${amount}"/>
<%@ include file="../../template/footer.html" %>
</body>
</html>