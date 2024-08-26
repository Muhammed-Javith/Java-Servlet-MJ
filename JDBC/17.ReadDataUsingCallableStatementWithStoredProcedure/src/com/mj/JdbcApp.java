package com.mj;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Types;

class JdbcApp {
	public static void main(String args[]) throws Exception {

//load a register driver
		Class.forName("com.mysql.cj.jdbc.Driver");

//establish connection between Java application and database 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
		CallableStatement cst=con.prepareCall("{call getSal(?,?)}");
		cst.setInt(1,1004);
		cst.registerOutParameter(2, Types.INTEGER);
		cst.execute();
		System.out.println("Salary........."+cst.getInt(2));
		con.close();

	}
}