package com.mj;

import java.util.Scanner;
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
//getting user input
		Scanner sc = new Scanner(System.in);
		System.out.print("ProductMrpRange :");
		int prdmrp_range = sc.nextInt();
//prepare SQLQuery
		String str = "delete from product where prdmrp<" + prdmrp_range;
//execute SQL Query
		int rowCount = st.executeUpdate(str);
		System.out.println("Records Deleted :" + rowCount);
//close the connection
		con.close();
		st.close();
		sc.close();// scanner closing statement
	}
}