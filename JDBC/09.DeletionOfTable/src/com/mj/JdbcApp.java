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
		String str1 = "CREATE TABLE employee2 (empno int, empname char(10),empsal int)"; // dummy table created
		String str2 = "drop table employee2"; // table drop
//execute SQL Query
		st.executeUpdate(str1);
		System.out.println("Table Created");
		int rowCount = st.executeUpdate(str2);
		System.out.println("Records Deleted :" + rowCount);
//close the connection
		con.close();
		st.close();
	}
}