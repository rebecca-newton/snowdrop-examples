<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>

<html>
<head><title>Sports Club: Invoicing - search account</title></head>
<body>Hello in invoicing!
<p>This is it: <c:out value="${userInput.data}"/></p>

<form:form commandName="userInput">
    <table>
        <tr>
        <tr>
            <td>Current Invoice:</td>
            <td><form:checkbox path="currentInvoice"/></td>
        </tr>
            <td>First Name:</td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Save Changes"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>