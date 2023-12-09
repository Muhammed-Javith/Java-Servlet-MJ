package com.mj.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnUtil {
	private static Connection con = null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//return conn object
	public static Connection getConn() {
		return con;
	}
}