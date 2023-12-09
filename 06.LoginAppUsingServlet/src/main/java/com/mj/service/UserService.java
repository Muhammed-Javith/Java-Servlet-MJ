package com.mj.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserService {
	Connection con;
	Statement st;
	ResultSet rs;
	String status = "";

	public UserService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String checkLogin(String uname, String pwd) {
		try {
			//System.out.println(pwd);
			rs = st.executeQuery("select * from users where uname='" + uname + "' and pwd='" + pwd + "'");
			boolean b = rs.next();
			if (b == true) {
				status = "success";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
		}
		return status;
	}

	public String registration(String uname, String pwd, String uemail, String umobile) {
		try {
			rs = st.executeQuery("select * from users where uname='" + uname + "'");
			boolean b = rs.next();
			if (b == true) {
				status = "existed";
			} else {
				st.executeUpdate("insert into users values('" + uname + "','" + pwd + "','" + uemail + "','"+ umobile + "')");
				status = "success";
			}
		} catch (Exception e) {
			status = "failure";
			e.printStackTrace();
		}
		return status;
	}
}