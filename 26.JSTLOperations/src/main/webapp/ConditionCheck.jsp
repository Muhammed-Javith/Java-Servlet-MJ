<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<pre>
<c:set var="counter" value="36" />
<c:if test="${counter>0}">
Hi It is a+positive value
</c:if>
<c:choose>
<c:when test="${counter > 0}">
It is a +positive number
</c:when>
<c:when test="${counter < 0 }">
It is –positive value
</c:when>
<c:otherwise>
It might be +positive value
</c:otherwise>
</c:choose>
</pre>
</body>
</html>