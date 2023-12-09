package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Firstservlet")
public class Firstservlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String accNo = request.getParameter("accNo");
		String accName = request.getParameter("accName");
		HttpSession session = request.getSession();
		session.setAttribute("accNo", accNo);
		session.setAttribute("accName", accName);
		out.println("<html><body bgcolor='cyan'><br><br>");
		out.println("<center><h1>Deposit Form(Cont..)</h1></center><br><br><hr><br><br>");
		out.println("<form method='get'action='" + response.encodeURL("./second") + "'>");
		out.println("<pre>");
		//out.println("Account Type <input type='text' name='accType'/>");
		//out.println();
		out.println("Account Branch <input type='text' name='accBranch'/>");
		out.println();
		out.println(" <input type='submit' value='Next'/>");
		out.println("</pre></form></body></html>");
	}
}
