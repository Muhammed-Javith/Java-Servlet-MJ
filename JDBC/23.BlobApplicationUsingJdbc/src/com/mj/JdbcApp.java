package com.mj;

import java.sql.Connection;
import java.io.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class JdbcApp {
	public static void main(String args[]) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");

		File f = new File("C:\\Users\\DELL\\Downloads\\images\\Dove.jpg");
		FileInputStream fis = new FileInputStream(f);
		PreparedStatement pst = con.prepareStatement("insert into emp_detail values(?,?)");
		pst.setInt(1, 105);
		pst.setBinaryStream(2, fis, (int) f.length());
		pst.executeUpdate();
		System.out.println("Employee Image inserted Successfully");
		con.close();
	}
}