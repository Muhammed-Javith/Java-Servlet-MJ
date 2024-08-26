package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.Scanner;

class JdbcApp {
	public static void main(String args[]) throws Exception {

//load a register driver
		Class.forName("com.mysql.cj.jdbc.Driver");

//establish connection between Java application and database 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");

//prepare SQLQuery
		PreparedStatement pst = con.prepareStatement("insert into employee values(?,?,?)");
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Employee Number :");
			int eno = sc.nextInt();
			System.out.print("Employee Name :");
			String ename = sc.next();
			System.out.print("Employee Salary :");
			float esal = sc.nextFloat();
			pst.setInt(1, eno);
			pst.setString(2, ename);
			pst.setFloat(3, esal);
			pst.executeUpdate();
			System.out.println("Employee Inserted Successfully");
			System.out.print("Onemore Employee[Yes/No]? :");
			String option = sc.next();
			if (option.equalsIgnoreCase("No")) {
				break;
			}
		}
		con.close();
		sc.close();
	}
}