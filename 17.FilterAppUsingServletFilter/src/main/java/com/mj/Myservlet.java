package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Myservlet")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String sname = request.getParameter("sname");
		int sage = Integer.parseInt(request.getParameter("sage"));
		String saddr = request.getParameter("saddr");
		out.println("<br><br>");
		out.println("Hello Student..... Ur details are....");
		out.println("<br><br>");
		out.println("Name....." + sname);
		out.println("<br><br>");
		out.println("Name....." + sage);
		out.println("<br><br>");
		out.println("Name....." + saddr);
		out.println("<br><br>");
		out.println("Enjoy the Fashion show");

	}

}
