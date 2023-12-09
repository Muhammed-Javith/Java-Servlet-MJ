package com.mj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MyServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext context = getServletConfig().getServletContext();
		String logicalName = context.getServletContextName();
		String a = context.getInitParameter("a");
		String b = context.getInitParameter("b");
		Enumeration e = context.getInitParameterNames();
		context.setAttribute("c", "cat");
		context.setAttribute("d", "dog");
		out.println("<html><body><h1><br>");
		out.println("Logical Name : " + logicalName);
		out.println("<br>");
		out.println("a for ... " + a);
		out.println("<br>");
		out.println("b for ... " + b);
		out.println("<br>");
		while (e.hasMoreElements()) {
			out.println(e.nextElement() + "<br>");
		}
		out.println("c for ... " + context.getAttribute("c"));
		out.println("<br>");
		out.println("d for ... " + context.getAttribute("d") + "<br>");
		e = context.getAttributeNames();
		while (e.hasMoreElements()) {
			out.println(e.nextElement() + "<br>");
		}
		out.println("</h1></body></html>");
	}

}
