<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head><title>Sports Club: Invoicing - account detail</title></head>
<body>

<div>Account details</div>

<table>
    <tr>
        <td></td>
        <td></td>
    </tr>
    <tr>
        <td>Account ID:</td>
        <td><c:out value="${account.id}"/></td>
    </tr>
    <tr>
        <td>Created:</td>
        <td><c:out value="${account.creationDate}"/></td>
    </tr>
    <tr>
        <td>Subscriber name:</td>
        <td>
            <c:out value="${account.subscriber.name.firstName}"/>
            <c:out value="${account.subscriber.name.middleName}"/>
            <c:out value="${account.subscriber.name.lastName}"/>
        </td>
    </tr>
    <tr>
        <td>Subscriber address:</td>
        <td>
            <c:out value="${account.subscriber.address.streetAddress}"/>,
            <c:out value="${account.subscriber.address.city}"/>,
            <c:out value="${account.subscriber.address.provinceOrState}"/>,
            <c:out value="${account.subscriber.address.country}"/>,
            <c:out value="${account.subscriber.address.postalCode}"/>
        </td>
    </tr>
    <tr>
        <td>Membership:</td>
        <td>
            <c:out value="${account.membership.code}"/>
            (<c:if test="${account.membership.active}">active</c:if><c:if
                test="${!account.membership.active}">not active</c:if>)
        </td>
    </tr>
    <tr>
        <td>Balance:</td>
        <td>
            <c:out value="${account.balance.amount}"/>
        </td>
    </tr>
    <tr>
        <td>Billing type:</td>
        <td>
            <c:out value="${account.billingType}"/>
        </td>
    </tr>
    <tr>
        <td>Closed?:</td>
        <td>
            <c:out value="${account.closed}"/>
        </td>
    </tr>
    <c:if test="${account.closeDate != null}">
        <tr>
            <td>Close date:</td>
            <td>
                <c:out value="${account.closeDate}"/>
            </td>
        </tr>
    </c:if>
</table>

<form:form action="generateInvoice.do">
    You can create new invoice for this account:
    <input type="hidden" name="id" value="<c:out value="${account.id}"/>">
    <input type="submit" value="Create invoice"/><br/>
</form:form>

</body>
</html>