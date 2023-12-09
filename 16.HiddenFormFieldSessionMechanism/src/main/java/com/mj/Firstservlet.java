package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Firstservlet")
public class Firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String sname = request.getParameter("sname");
		String sid = request.getParameter("sid");
		String saddr = request.getParameter("saddr");
		out.println("<html><body bgcolor='lightyellow'>");
		out.println("<center><b><br><br>");
		out.println("Welcome to Student Application");
		out.println("<br><br>");
		out.println("<form method='get' action='second'>");
		out.println("<input type='hidden' name=sname value='" + sname + "'>");
		out.println("<input type='hidden' name=sid value='" + sid + "'>");
		out.println("<input type='hidden' name=saddr value='" + saddr + "'>");
		out.println("<br><br>");
		out.println("Student Age:");
		out.println("<input type='text' name='sage'>");
		out.println("<br><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form></b></center></body></html>");
	}

}
