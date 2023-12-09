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

@WebServlet("/Searchservlet")
public class Searchservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			String sid = req.getParameter("sid");
			StudentDao sd = new StudentDaoImpl();
			ResultSet rs = sd.search(sid);
			boolean b = rs.next();
			if (b == true) {
				out.println("<html>");
				out.println("<body bgcolor='lightyellow'>");
				out.println("<b><font size='6'><br>");
				out.println("<pre>");
				out.println(" Student Id....." + rs.getString(1));
				out.println();
				out.println(" Student Name......" + rs.getString(2));
				out.println();
				out.println(" Student Marks....." + rs.getInt(3));
				out.println("</pre></font></b></body></html>");
			} else {
				req.getRequestDispatcher("notexisted.html").forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
