package com.mj;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

@WebServlet("/Secondservlet")
public class Secondservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int pcost = Integer.parseInt(request.getParameter("pcost"));
			int pquantity = Integer.parseInt(request.getParameter("pquantity"));
			Cookie c3 = new Cookie("pcost", "" + pcost);
			Cookie c4 = new Cookie("pquantity", "" + pquantity);
			response.addCookie(c3);
			response.addCookie(c4);
			RequestDispatcher rd = request.getRequestDispatcher("form3.html");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
