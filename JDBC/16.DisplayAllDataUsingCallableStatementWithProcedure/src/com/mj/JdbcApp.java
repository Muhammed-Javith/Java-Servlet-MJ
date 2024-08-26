package com.mj;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

class JdbcApp {
	public static void main(String args[]) throws Exception {

//load a register driver
		Class.forName("com.mysql.cj.jdbc.Driver");

//establish connection between Java application and database 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
		CallableStatement cst = con.prepareCall("{call getdetails()}");
		ResultSet rs = cst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			}
		con.close();
		rs.close();
	}
}