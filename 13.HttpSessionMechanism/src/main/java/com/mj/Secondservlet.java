package com.mj;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Secondservlet")
public class Secondservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uqual = request.getParameter("uqual");
		String udesig = request.getParameter("udesig");
		HttpSession hs = request.getSession();
		hs.setAttribute("uqual", uqual);
		hs.setAttribute("udesig", udesig);
		RequestDispatcher rd = request.getRequestDispatcher("form3.html");
		rd.forward(request, response);
	}

}
