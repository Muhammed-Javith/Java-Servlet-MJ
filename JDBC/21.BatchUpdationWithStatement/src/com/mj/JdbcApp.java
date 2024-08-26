package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

class JdbcApp {
	public static void main(String args[]) throws Exception {
		Connection con = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
		con.setAutoCommit(false);
		Statement st = con.createStatement();
		st.addBatch("insert into employee values(666,'murtasim',66000)");
		st.addBatch("update employee set empsal=empsal-500 where empsal<11000");
		st.addBatch("insert into employee values(786,'meerab',76000)");
		st.addBatch("delete from employee where empno=555");
		// st.addBatch("select * from emp1");--> java.sql.BatchUpdateException
		int[] rowCounts = st.executeBatch();
		con.commit();
		//System.out.println(rowCounts.length);
		for (int i = 0; i < rowCounts.length; i++) {
			System.out.println("Records Manipulated :" + rowCounts[i]);
		}
		con.close();

	}
}