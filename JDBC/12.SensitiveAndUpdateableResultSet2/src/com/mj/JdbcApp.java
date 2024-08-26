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
		while (rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));
		}
		System.out.println("----------------------------------");
		rs.afterLast();
		rs.previous();
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
		rs.beforeFirst();
		rs.next();
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
		rs.last();
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
		rs.first();
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
		rs.absolute(3);
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
		rs.absolute(-3);
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
		rs.first();
		rs.relative(2);
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
		rs.last();
		rs.relative(-2);
		System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
		con.close();
		st.close();
	}
}