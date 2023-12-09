package com.mj;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Firstservlet")
public class Firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String uage = request.getParameter("uage");
		HttpSession hs = request.getSession();
		hs.setAttribute("uname", uname);
		hs.setAttribute("uage", uage);
		RequestDispatcher rd = request.getRequestDispatcher("form2.html");
		rd.forward(request, response);
	}

}
