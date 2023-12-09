<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<pre>
<c:url var="search" value="https://www.google.com/search">
<c:param name="q" value="Hyderabad" />
</c:url>
<c:redirect url="${search}" />
</pre>
</body>
</html>