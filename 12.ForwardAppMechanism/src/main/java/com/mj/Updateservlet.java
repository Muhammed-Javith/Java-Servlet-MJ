package com.mj;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mj.dao.StudentDao;
import com.mj.daoImpl.StudentDaoImpl;

@WebServlet("/Updateservlet")
public class Updateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String sid = req.getParameter("sid");
			String sname = req.getParameter("sname");
			int smarks = Integer.parseInt(req.getParameter("smarks"));
			StudentDao sd = new StudentDaoImpl();
			String status = sd.update(sid, sname, smarks);
			if (status.equals("success")) {
				req.getRequestDispatcher("success.html").forward(req, res);
			}
			if (status.equals("failure")) {
				req.getRequestDispatcher("failure.html").forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
