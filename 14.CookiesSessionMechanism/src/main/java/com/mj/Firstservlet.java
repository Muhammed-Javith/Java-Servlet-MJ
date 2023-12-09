package com.mj;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Firstservlet")
public class Firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		Cookie c1 = new Cookie("pid", pid);
		Cookie c2 = new Cookie("pname", pname);
		response.addCookie(c1);
		response.addCookie(c2);
		RequestDispatcher rd = request.getRequestDispatcher("form2.html");
		rd.forward(request, response);

	}

}
