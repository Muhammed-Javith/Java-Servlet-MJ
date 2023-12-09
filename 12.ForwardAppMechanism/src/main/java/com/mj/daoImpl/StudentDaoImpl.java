package com.mj.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mj.dao.StudentDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class StudentDaoImpl implements StudentDao {
	Connection con;
	Statement st;
	ResultSet rs;
	String status = "";

	public StudentDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myfactory", "useradmin", "admin123");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String add(String sid, String sname, int smarks) {
		try {
			rs = getStudent(sid);
			boolean b = rs.next();
			if (b == true) {
				status = "existed";
			} else {
				int rowCount = st
						.executeUpdate("insert into student values('" + sid + "','" + sname + "'," + smarks + ")");
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ResultSet search(String sid) {
		try {
			rs = st.executeQuery("select * from student where sid='" + sid + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public ResultSet getStudent(String sid) {
		try {
			rs = st.executeQuery("select * from student where sid='" + sid + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	@Override
	public String update(String sid, String sname, int smarks) {
		try {
			int rowCount = st.executeUpdate(
					"update student set sname='" + sname + "',smarks=" + smarks + " where sid='" + sid + "'");
			if (rowCount == 1) {
				status = "success";
			} else {
				status = "failure";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public String delete(String sid) {
		try {
			rs = getStudent(sid);
			boolean b = rs.next();
			if (b == true) {
				int rowCount = st.executeUpdate("delete from student where sid='" + sid + "'");
				if (rowCount == 1) {
					status = "success";
				} else {
					status = "failure";
				}
			} else {
				status = "notexisted";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
