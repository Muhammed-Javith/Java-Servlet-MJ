package com.mj.Factory;

import com.mj.Dao.IEmployeeDao;
import com.mj.DaoImpl.EmployeeDaoImpl;

public class EmpDaoFactory {
	public static IEmployeeDao getDao() {
		return new EmployeeDaoImpl();
	}

}
