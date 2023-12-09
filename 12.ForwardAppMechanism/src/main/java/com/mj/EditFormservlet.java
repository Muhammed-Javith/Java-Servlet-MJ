package com.mj;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mj.dao.StudentDao;
import com.mj.daoImpl.StudentDaoImpl;

@WebServlet("/EditFormservlet")
public class EditFormservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			String sid = req.getParameter("sid");
			StudentDao sd = new StudentDaoImpl();
			ResultSet rs = sd.getStudent(sid);
			boolean b = rs.next();
			if (b == true) {
				out.println("<html>");
				out.println("<body bgcolor='lightgreen'>");
				out.println("<b><font size='7'>");
				out.println("<br>");
				out.println("<form method='get' action='./update'>");
				out.println("<pre>");
				out.println(" Student Id " + rs.getString(1));
				out.println("<input type='hidden' name='sid' value='" + sid + "'/>");
				out.println(" Student Name <input type='text' name='sname' value='" + rs.getString(2) + "'/>");
				out.println();
				out.println(" Student marks <input type='text' name='smarks' value='" + rs.getInt(3) + "'/>");
				out.println();
				out.println(" <input type='submit' value='Update'/>");
				out.println("</pre></form></font></b></body></html>");
			} else {
				req.getRequestDispatcher("notexisted.html").forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
