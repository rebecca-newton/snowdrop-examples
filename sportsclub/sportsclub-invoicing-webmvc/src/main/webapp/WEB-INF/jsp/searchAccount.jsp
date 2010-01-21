<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head><title>Sports Club: Invoicing - search account</title></head>
<body>

<form:form commandName="userInput">

    Search accounts <form:select path="invoiceStatus" items="${stringList}"/> current invoice by subscriber name:<br/>
    <form:input path="nameFragment"/> <input type="submit" value="Search"/><br/>
    <span style="font-size:70%">
        Display up to
        <form:input path="maxAccountNum" maxlength="2" size="2" cssStyle="font-size:70%"/>
        relevant accounts.
    </span>
</form:form>

<c:if test="${empty accountList}">
    Sorry no result matches...
</c:if>
<c:if test="${not empty accountList}">
<table border="1">
    <thead>
        <tr>
            <td>#</td>
            <td>ID</td>
            <td>Subscriber name</td>
            <td>Membership</td>
            <td></td>
        </tr>
    </thead>
    <c:forEach items="${accountList}" var="account" varStatus="s">
        <tr>
            <td><c:out value="${s.index}" /></td>
            <td><c:out value="${account.id}" /></td>
            <td><c:out value="${account.subscriber.name.firstName} ${account.subscriber.name.lastName}" /></td>
            <td><c:out value="${account.membership.code}" /></td>
            <td><a href='accountDetail.do?id=<c:out value="${account.id}"/>'>Detail</a></td>
        </tr>
    </c:forEach>
</table>
</c:if>

</body>
</html>