<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>Sports Club: Invoicing - account detail</title>
    <link href="../../images/favicon.png" rel="Shortcut Icon"/>
    <%@ include file="../../template/styles.html" %>
</head>

<body class="main-body">
<%@ include file="../../template/header.html" %>

    <p>
        <a href='searchAccount.do'>Go back to search form.</a>
    </p>

    <table class="simpletablestyle">
        <thead>
            <tr><th colspan="2">Account Details</th></tr>
        </thead>
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

    <p>
        <form:form action="generateInvoice.do">
            You can create new invoice for this account:
            <input type="hidden" name="id" value="<c:out value="${account.id}"/>">
            <input type="submit" value="Create invoice"/><br/>
        </form:form>
    </p>

    <table cellspacing="10">
        <tr>
            <td>
                <table class="simpletablestyle" border="0">
                    <thead>
                    <tr>
                        <th colspan="5">Invoices</th>
                    </tr>
                    <tr>
                        <th rowspan="2">Id</th>
                        <th rowspan="2">IssueDate</th>
                        <th rowspan="2">Amount</th>
                        <th colspan="2">BillingPeriod</th>
                    </tr>
                    <tr>
                        <th>Start</th>
                        <th>End</th>
                    </tr>
                    </thead>
                    <c:forEach items="${invoices}" var="invoice">
                        <tr>
                            <td><c:out value="${invoice.id}"/></td>
                            <td><c:out value="${invoice.issueDate}"/></td>
                            <td><c:out value="${invoice.amount}"/></td>
                            <td><fmt:formatDate value="${invoice.billingPeriod.startDate}" dateStyle="short" timeStyle="short" type="both"/></td>
                            <td><fmt:formatDate value="${invoice.billingPeriod.endDate}" dateStyle="short" timeStyle="short" type="both"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
            <td>
                <table class="simpletablestyle" border="0">
                    <thead>
                    <tr>
                        <th colspan="3">Payments</th>
                    </tr>
                    <tr>
                        <th>Id</th>
                        <th>Amount</th>
                        <th>Date</th>
                    </tr>
                    </thead>
                    <c:forEach items="${payments}" var="payment">
                        <tr>
                            <td><c:out value="${payment.id}"/></td>
                            <td><c:out value="${payment.amount}"/></td>
                            <td><fmt:formatDate value="${payment.date}" dateStyle="short" timeStyle="short" type="both"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>

<%@ include file="../../template/footer.html" %>
</body>
</html>