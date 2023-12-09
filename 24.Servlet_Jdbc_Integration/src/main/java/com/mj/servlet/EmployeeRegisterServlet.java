package com.mj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.mj.Dao.IEmployeeDao;
import com.mj.Factory.EmpDaoFactory;
import com.mj.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeRegisterServlet
 */
@WebServlet("/EmployeeRegisterServlet")
public class EmployeeRegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
//1. read input form data
		String eid = req.getParameter("eid");
		String empName = req.getParameter("ename");
		String empGen = req.getParameter("egen");
		String empAddr = req.getParameter("eaddr");
//2. parse data if required
		int empId = Integer.parseInt(eid);
//3. create model class object
		Employee emp = new Employee();
//4. store data in model class obj
		emp.setEmpId(empId);
		emp.setEmpName(empName);
		emp.setEmpGen(empGen);
		emp.setEmpAddr(empAddr);
//5. create Dao Object using Factory
		IEmployeeDao dao = EmpDaoFactory.getDao();
//6.call insert operation
		int count = dao.insertEmp(emp);

//7. print final message
		PrintWriter out = resp.getWriter();
		if (count == 1) {
			out.println("Successfully created record with Id : " + empId);
		} else {
			out.print("Check manully ... giving problem");
		}
//8. 
		RequestDispatcher rd = req.getRequestDispatcher("Register.html");
		rd.include(req, resp);
	}
}