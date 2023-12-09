package com.mj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class GenericDemo extends GenericServlet {

	private static final long serialVersionUID = 1L;

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// read form input
		String ename = req.getParameter("ename");
		String email = req.getParameter("email");
		String course = req.getParameter("course");
		String gender = req.getParameter("gender");
		String addr = req.getParameter("addr");
		// convert array data to List Type
		List<String> languages = Arrays.asList("lang");
		// display data
		PrintWriter out = res.getWriter();
		out.print("<html> <body>");
		out.print("<h2><Your Data<h2>");
		out.print("<table border= 1> </tr>");
		out.print("<td>NAME</td><td>" + ename + "</td>");
		out.print("</tr><tr>");
		out.print("<td>EMAIL</td><td>" + email + "</td>");
		out.print("</tr><tr>");
		out.print("<td>COURSE</td><td>" + course + "</td>");
		out.print("</tr><tr>");
		out.print("<td>GENDER</td><td>" + gender + "</td>");
		out.print("</tr><tr>");
		out.print("<td>ADDRESS</td><td>" + addr + "</td>");
		out.print("</tr><tr>");
		out.print("<td>LANGS</td><td>" + languages + "</td>");
		out.print("</tr></table></body></html>");
	}

}
