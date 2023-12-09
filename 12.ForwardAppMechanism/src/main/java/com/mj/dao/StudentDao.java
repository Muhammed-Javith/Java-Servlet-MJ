package com.mj.dao;

import java.sql.ResultSet;

public interface StudentDao {
	public String add(String sid, String sname, int smarks);

	public ResultSet search(String sid);

	public ResultSet getStudent(String sid);

	public String update(String sid, String sname, int smarks);

	public String delete(String sid);
}
