package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class JdbcApp {
	public static void main(String args[]) throws Exception {
//load a register driver
		Class.forName("com.mysql.cj.jdbc.Driver");
//establish connection between Java application and database
		String url = "jdbc:mysql://localhost:3306/myfactory";
		String uname = "useradmin";
		String Password  = "admin123";
		Connection con = DriverManager.getConnection(url,uname,Password);
//prepare Statement
		Statement st = con.createStatement();

//prepare SQLQuery
		String str = "CREATE TABLE product (prdid int, prdname char(10),prdmrp int)";

//execute SQL Query
		try {
			st.execute(str);
			System.out.println("Table Created");
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
//close the connection
		con.close();
		st.close();
	}
}