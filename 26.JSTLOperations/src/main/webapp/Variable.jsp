<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<pre>
<c:out value="Hello" />
<c:out value="${6+36}" />
<c:out value="${6>36}" />
<c:set var="counter" value="86" />
<c:set var="counter" value="90" scope="request" />
<c:out value="${counter+10}" />
<c:out value="${requestScope.counter}" />
<c:set value="SAM" var="uname" />
Before: <c:out value="${uname}" />
<c:remove var="uname" />
After: <c:out value="${uname}" />
</pre>
</body>
</html>
