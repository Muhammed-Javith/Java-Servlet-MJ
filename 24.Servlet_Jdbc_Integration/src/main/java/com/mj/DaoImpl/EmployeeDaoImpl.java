package com.mj.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.mj.Dao.IEmployeeDao;
import com.mj.model.Employee;
import com.mj.util.ConnUtil;

public class EmployeeDaoImpl implements IEmployeeDao {
	public int insertEmp(Employee emp) {
		String sql = "insert into emptabs values(?,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
//read connection
			con = ConnUtil.getConn();
//create statement
			pstmt = con.prepareStatement(sql);
//set data to stmt
			pstmt.setInt(1, emp.getEmpId());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getEmpGen());
			pstmt.setString(4, emp.getEmpAddr());
//execute stmt
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
//release connection
			con = null;
		}
		return count;
	}
}