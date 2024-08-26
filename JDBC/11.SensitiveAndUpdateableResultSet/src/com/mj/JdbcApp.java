package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class JdbcApp {
	public static void main(String args[]) throws Exception {

//load a register driver
		Class.forName("com.mysql.cj.jdbc.Driver");

//establish connection between Java application and database 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select * from student");
		System.out.println("Data In Forward Direction");
		System.out.println("SID\tSNAME\tSRANK\t");
		System.out.println("----------------------------------");
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
		}
		System.out.println("Data In Backward Direction");
		System.out.println("SID\tSNAME\tSRANK\t");
		System.out.println("-------------------------------");
		while (rs.previous()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
		}
		con.close();
		st.close();
	}
}