<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
  <head><title>Sports Club: Invoicing - account invoice generated</title></head>
  <body>
    Invoice for account <c:out value="${id}"/> has been generated successfully!
    <br/>
    Go to <a href="searchAccount.do">account search</a> page.
  </body>
</html>