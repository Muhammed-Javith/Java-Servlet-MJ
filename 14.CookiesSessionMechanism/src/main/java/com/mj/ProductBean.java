package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductBean {
	Connection con;
	Statement st;
	ResultSet rs;
	String status = "";

	public ProductBean() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String register(String pid, String pname, int pcost, int pquantity, String man_Date, String exp_Date) {
		try {
			rs = st.executeQuery("select * from product where pid='" + pid + "'");
			boolean b = rs.next();
			if (b == true) {
				status = "Product Existed Already";
			} else {
				int rowCount = st.executeUpdate("insert into product values('" + pid + "','" + pname + "'," + pcost
						+ "," + pquantity + ",'" + man_Date + "','" + exp_Date + "')");
				if (rowCount == 1) {
					status = "SUCCESS";
				} else {
					status = "FAILURE";
				}
			}
		} catch (Exception e) {
			status = "FAILURE";
			e.printStackTrace();
		}
		return status;
	}
}
