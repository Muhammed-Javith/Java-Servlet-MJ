package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class JdbcApp {
	public static void main(String args[]) throws Exception {

//load a register driver
		Class.forName("com.mysql.cj.jdbc.Driver");

//establish connection between Java application and database 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");

//prepare SQLQuery
		PreparedStatement pst = con.prepareStatement("select * from employee where empsal<?");
		pst.setInt(1, 16000);
		ResultSet rs=pst.executeQuery();
		System.out.println("ENO ENAME ESAL");
		 System.out.println("-------------------------------------");
		 while(rs.next()){
		 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		 }
		con.close();

	}
}