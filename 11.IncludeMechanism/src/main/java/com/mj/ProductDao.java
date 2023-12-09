package com.mj;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDao {
	Connection con;
	Statement st;
	ResultSet rs;
	ArrayList<Product> al;

	ProductDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
			st = con.createStatement();
			al = new ArrayList<Product>();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(String pid, String pname, int pcost) {
		try {
			st.executeUpdate("insert into product values('" + pid + "','" + pname + "'," + pcost + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Product> getProducts() {
		try {
			rs = st.executeQuery("select * from product");
			while (rs.next()) {
				Product p = new Product();
				p.setPid(rs.getString(1));
				p.setPname(rs.getString(2));
				p.setPcost(rs.getInt(3));
				al.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
