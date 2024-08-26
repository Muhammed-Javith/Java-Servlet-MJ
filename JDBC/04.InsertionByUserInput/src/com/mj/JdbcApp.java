package com.mj;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class JdbcApp {
	public static void main(String args[]) throws Exception {

//load a register driver
		Class.forName("com.mysql.cj.jdbc.Driver");

//establish connection between Java application and database 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
//prepare Statement
		Statement st = con.createStatement();
//getting user input
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("Employee Number :");
			int eno = sc.nextInt();
			System.out.print("Employee Name :");
			String ename = sc.next();
			System.out.print("Employee Salary :");
			float esal = sc.nextFloat();
//prepare SQLQuery
			String str = "insert into employee values(" + eno + ",'" + ename + "'," + esal + ")";
//execute SQL Query
			st.executeUpdate(str);
			System.out.println("Employee Inserted Successfully");
			System.out.print("Onemore Employee[Yes/No]? :");
			String option = sc.next();
			if (option.equalsIgnoreCase("No")) {
				break;
			}
		}
//close the connection
		con.close();
		st.close();
		sc.close();//scanner closing statement
	}
}