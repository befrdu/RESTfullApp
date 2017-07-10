<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/createContactRecord" var="createContactRecord"/>
<spring:url value="/editContactRecord" var="editContactRecord"/>

<table><tr>

<td>
<a href="${createContactRecord}">Create Contact</a>
</td>
<td>
</td>
<td>
<a href="${editContactRecord}">Edit Contact</a>
</td>
<td>
</td>

</tr></table>