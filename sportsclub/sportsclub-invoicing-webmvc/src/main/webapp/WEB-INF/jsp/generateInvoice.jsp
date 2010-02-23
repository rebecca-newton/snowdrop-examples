<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <title>Sports Club: Invoicing - account invoice generated</title>
    <link href="../../images/favicon.png" rel="Shortcut Icon"/>
    <%@ include file="../../template/styles.html" %>
</head>

<body class="main-body">
<%@ include file="../../template/header.html" %>

    Invoice for account <c:out value="${id}"/> has been generated successfully!
    <br/>
    Go to <a href="searchAccount.do">account search</a> page.

<%@ include file="../../template/footer.html" %>
</body>
</html>