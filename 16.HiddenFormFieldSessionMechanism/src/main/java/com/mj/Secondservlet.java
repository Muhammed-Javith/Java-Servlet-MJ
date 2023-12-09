package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Secondservlet")
public class Secondservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String sname = request.getParameter("sname");
		String sid = request.getParameter("sid");
		String saddr = request.getParameter("saddr");
		String sage = request.getParameter("sage");
		out.println("<html><body bgcolor='lightyellow'>");
		out.println("<center><b><br><br>");
		out.println("Student Details Are...");
		out.println("<br><br>");
		out.println("Student Name....." + sname + "<br><br>");
		out.println("Student Id....." + sid + "<br><br>");
		out.println("Student Address....." + saddr + "<br><br>");
		out.println("<a href='third?sage=" + sage + "'>SHOW STUDENT AGE</a>");
	    
	}

}
