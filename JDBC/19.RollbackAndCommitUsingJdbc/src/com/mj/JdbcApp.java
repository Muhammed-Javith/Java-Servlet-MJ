package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class JdbcApp {
	public static void main(String args[]) throws Exception {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			st.executeUpdate("insert into student values(111,'AAA',78)");
			st.executeUpdate("insert into student values(222,'BBB',87)");
			st.executeUpdate("insert into student values(333,'CCC',96)");
			con.commit();
			System.out.println("Transaction Success");
		} catch (Exception e) {
			try {
				con.rollback();
				System.out.println("Transaction Failure");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			// e.printStackTrace();
		}

	}
}