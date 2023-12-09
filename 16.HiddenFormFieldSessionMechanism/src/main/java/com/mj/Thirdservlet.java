package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Thirdservlet")
public class Thirdservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String sage = request.getParameter("sage");
		out.println("<html><body bgcolor='lightpink'>");
		out.println("<center><b><br><br>");
		out.println("Student Age is....." + sage);
		out.println("</b></center></body></html>");
	}

}
