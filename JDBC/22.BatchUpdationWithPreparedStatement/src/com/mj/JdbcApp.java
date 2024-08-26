package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class JdbcApp {
	public static void main(String args[]) throws Exception {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
		con.setAutoCommit(false);
		PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?)");
		pst.setInt(1, 456);
		pst.setString(2, "meera");
		pst.setInt(3, 36000);
		pst.addBatch();
		pst.setInt(1, 406);
		pst.setString(2, "maheer");
		pst.setInt(3, 56000);
		pst.addBatch();
		pst.setInt(1, 486);
		pst.setString(2, "megha");
		pst.setInt(3, 86000);
		pst.addBatch();
		int[] rowCounts = pst.executeBatch();
		con.commit();
		for (int i = 0; i < rowCounts.length; i++) {
			System.out.println("Records Manipulated :" + rowCounts[i]);
		}
		con.close();
	}
}