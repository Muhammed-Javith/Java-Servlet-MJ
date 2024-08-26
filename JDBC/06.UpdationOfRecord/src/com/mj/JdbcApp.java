package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class JdbcApp {
	public static void main(String args[]) throws Exception {

//load a register driver
		Class.forName("com.mysql.cj.jdbc.Driver");

//establish connection between Java application and database 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
//prepare Statement
		Statement st = con.createStatement();

//prepare SQLQuery
		String str = "update product set prdmrp  = 1000 where prdname = 'Liril'";

//execute SQL Query
		try {
			st.execute(str);
			System.out.println("Record Updated");
		} catch (Exception e) {
			System.out.println("Error" + e.toString());
		}
//close the connection
		con.close();
		st.close();
	}
}