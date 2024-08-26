<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%!int eid;
	String ename;
	float esal;%>
<%
try {
	eid = Integer.parseInt(request.getParameter("eid"));
	ename = request.getParameter("ename");
	esal = Float.parseFloat(request.getParameter("esal"));
} catch (Exception e) {
	e.printStackTrace();
}
%>
<jsp:useBean id="e" class="com.mj.Employee" type="com.mj.Employee"
	scope="session">
	<jsp:setProperty name="e" property="eid" value='<%=eid%>' />
	<jsp:setProperty name="e" property="ename" value='<%=ename%>' />
	<jsp:setProperty name="e" property="esal" value='<%=esal%>' />
	<html>
<body>
	<center>
		<h1>Employee Details</h1>
	</center>
	<center>
		Employee Id :
		<jsp:getProperty name="e" property="eid" /><br>
		<br> Employee Name :
		<jsp:getProperty name="e" property="ename" /><br>
		<br> Employee Salary :
		<jsp:getProperty name="e" property="esal" /><br>
		<br>
	</center>
</body>
	</html>
</jsp:useBean>
