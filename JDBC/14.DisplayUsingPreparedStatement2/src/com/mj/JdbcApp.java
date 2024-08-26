package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class JdbcApp {
	public static void main(String args[]) throws Exception {

//load a register driver
		Class.forName("com.mysql.cj.jdbc.Driver");

//establish connection between Java application and database 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");

//prepare SQLQuery
		PreparedStatement pst = con.prepareStatement("update employee set empname=? where empno=?");
		pst.setString(1, "maryam");
		pst.setInt(2, 1005);
		int rowCount = pst.executeUpdate();
		System.out.println("Records Updated :" + rowCount);
		con.close();

	}
}