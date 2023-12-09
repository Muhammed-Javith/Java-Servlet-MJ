package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.mj.service.UserService;

/**
 * Servlet implementation class Registrationservlet
 */
//@WebServlet("/Registrationservlet")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Registrationservlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		String uemail = request.getParameter("uemail");
		String umobile = request.getParameter("umobile");
		UserService us = new UserService();
		String status = us.registration(uname, pwd, uemail, umobile);
		out.println("<html>");
		out.println("<body bgcolor='lightblue'>");
		out.println("<center><br><br>");
		out.println("<font color='red' size='7'>");
		if (status.equals("success")) {
			out.println("Registration Success");
		}
		if (status.equals("failure")) {
			out.println("Registration Failure");
		}
		if (status.equals("existed")) {
			out.println("User Existed Already");
		}
		out.println("</font></center></body></html>");
	}

}
