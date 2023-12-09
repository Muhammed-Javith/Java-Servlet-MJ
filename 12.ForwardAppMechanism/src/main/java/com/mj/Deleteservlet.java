package com.mj;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mj.dao.StudentDao;
import com.mj.daoImpl.StudentDaoImpl;

@WebServlet("/Deleteservlet")
public class Deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String sid = req.getParameter("sid");
		StudentDao sd = new StudentDaoImpl();
		String status = sd.delete(sid);
		if (status.equals("success")) {
			req.getRequestDispatcher("success.html").forward(req, res);
		}
		if (status.equals("failure")) {
			req.getRequestDispatcher("failure.html").forward(req, res);
		}
		if (status.equals("notexisted")) {
			req.getRequestDispatcher("notexisted.html").forward(req, res);
		}

	}
}
