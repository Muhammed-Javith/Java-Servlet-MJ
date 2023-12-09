package com.mj;

import jakarta.servlet.GenericServlet;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Myservlet")
public class Myservlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		out.println("<html><body bgcolor='lightyellow'>");
		out.println("<b><font size='7'><br><br>");
		out.println("Name......" + uname + "<br><br>");
		out.println("Password......" + upwd + "<br><br>");
		out.println("Email......" + email + "<br><br>");
		out.println("Mobile......" + mobile);
		out.println("</font></b></body></html>");
	}
}
