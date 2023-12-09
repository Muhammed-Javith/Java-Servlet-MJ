package com.mj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionBean {
	Connection connection;
	Statement statement;
	ResultSet resultSet;
	String status = "";
	int totalAvailableAmount;

	TransactionBean() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String deposit(String accNo, int depAmount) {
		try {
			String sql = String.format("UPDATE  account set balance = balance+ %d where accNo=%s ", depAmount, accNo);
			int rowCount = statement.executeUpdate(sql);
			// or
			// int rowCount=statement.executeUpdate("update account set
			// balance=balance+"+depAmount+"where accNo='"+accNo+"'");

			if (rowCount == 1)
				status = "SUCCESS";
			else
				status = "FAILURE";
		} catch (Exception e) {
			status = "FAILURE";
			e.printStackTrace();
		}
		return status;
	}

	public int getTotalAvailableAmount() {
		try {
			resultSet = statement.executeQuery("select * from account");
			resultSet.next();
			totalAvailableAmount = resultSet.getInt(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalAvailableAmount;
	}

}
