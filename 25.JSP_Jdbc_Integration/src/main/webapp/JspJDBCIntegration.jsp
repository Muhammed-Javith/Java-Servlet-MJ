<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP with JDBC Integration</title>
<body>
	<%!//Writing methods with logic 
	public Boolean checkUser(String uname, String pwd) {
		boolean isExist = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin",
					"admin123");
			PreparedStatement pstmt = con.prepareStatement("select * from users where uname=? and pwd=?");
			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) { /* user exist */
				isExist = true;
			} else {
				//not Exist
				isExist = false;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return isExist;
	}%>
	<%
	//read data from HTML Form
	String uname = request.getParameter("user");
	String pwd = request.getParameter("pass");
	//calling method
	boolean isExist = checkUser(uname, pwd);
	//using if-else
	if (isExist) {
		out.println("Welcome to user: " + uname);
	} else {
		out.print("Invalid Login Details!!");
	}
	%>
</body>
</html>