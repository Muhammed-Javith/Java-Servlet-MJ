<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<pre>
<c:set var="max" value="10" />
<c:forEach begin="1" end="${max}" var="i">
			<c:out value="${i} Hello" />
</c:forEach>
<%
List<String> a1 = Arrays.asList("A", "B", "C");
request.setAttribute("list", a1);
%>
<c:forEach items="${list}" var="ob">
<c:out value="${ob}" />
</c:forEach>
<c:set var="str" value="Hello I am Uday Kumar" />
<c:forTokens items="${str}" delims=" " var="s">
<c:out value="${s}" />
			<br />
</c:forTokens>
</pre>
</body>
</html>