package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class JdbcApp {
	public static void main(String args[]) throws Exception {

//load a register driver
		Class.forName("com.mysql.cj.jdbc.Driver");

//establish connection between Java application and database 
		String url = "jdbc:mysql://localhost:3306/myfactory";
		String uname = "useradmin";
		String pswrd = "admin123";
		Connection con = DriverManager.getConnection(url, uname, pswrd);

//prepare Statement
		Statement st = con.createStatement();

//CREATE Operation
		String str1 = "CREATE TABLE student (sid int, sname char(10),srank int)";
		String str5 = "CREATE TABLE student1 (sid int, sname char(10),srank int)";
		st.execute(str1);
		st.execute(str5);
		System.out.println("Table Created");

//Insertion- one record
		String str2 = "insert into student values(111,'javith',24000)";
		st.execute(str2);
		System.out.println("one row inserted");

//Insertion- Multiple record
		String str3 = "insert into student(sid,sname,srank) values(112,'ameer',20000),(113,'akash',15000),(114,'vijay',14000),(115,'ram',10000)";
		int rowcount = st.executeUpdate(str3);
		System.out.println(rowcount + " Row inserted");

//Update operation
		String str4 = "update student set sname  = 'aslam' where sid = 115";
		st.execute(str4);
		System.out.println("Record updated");

// Display Record before delete
		String str71 = "select *from student where srank >15000";
		ResultSet rs1 = st.executeQuery(str71);
		while (rs1.next()) {
			System.out.println(rs1.getInt(1) + " " + rs1.getString(2) + " " + rs1.getInt(3));
		};
		
//Delete Record
		String str8 = "delete from student where sid = 113";
		int rowCount = st.executeUpdate(str8);
		System.out.println("Records Deleted :" + rowCount);

//Display Record After delete
		String str7 = "select *from student where srank >15000";
		ResultSet rs = st.executeQuery(str7);
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
		};

//Delete Table
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Number less than 100 :");
		int no = sc.nextInt();
		if(no <100) //reason to check db whether table is create or not.
		{
			String str10 = "drop table student1";
			st.execute(str10);
			System.out.println("table deleted");
		}

//close the connection
		con.close();
		st.close();
		sc.close();
	}
}
