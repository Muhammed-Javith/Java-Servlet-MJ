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
		String data = request.getParameter("text");
		out.println("<html><body bgcolor='lightblue'>");
		out.println("<center><b><font size='7' color='red'>");
		out.println("<br><br>");
		out.println(data);
		out.println("</font></b></center></body></html>");
	}
}
