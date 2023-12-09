package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Register() {
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
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String uname = request.getParameter("uname");
			int uage = Integer.parseInt(request.getParameter("uage"));
			String uemail = request.getParameter("uemail");
			String umobile = request.getParameter("umobile");
			if (uage < 18 || uage > 30) {
				response.sendError(504, "User Age Is Not Sufficient for this Recruitment");
			} else {
				out.println("<html>");
				out.println("<body>");
				out.println("<font color='red'>");
				out.println("<h2>MJ Consultency Services</h2>");
				out.println("<h3>User Registration Details</h3>");
				out.println("</font>");
				out.println("<table border='1'>");
				out.println("<tr><td>User Name</td><td>" + uname + "</td></tr>");
				out.println("<tr><td>User Age</td><td>" + uage + "</td></tr>");
				out.println("<tr><td>User Email</td><td>" + uemail + "</td></tr>");
				out.println("<tr><td>User Mobile</td><td>" + umobile + "</td></tr>");
				out.println("</table></body></html>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
