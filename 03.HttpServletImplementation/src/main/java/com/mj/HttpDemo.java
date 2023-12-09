package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;


public class HttpDemo extends HttpServlet {
	static {
		System.out.println("Servlet Loading");
	}

	public HttpDemo() {
		System.out.println("Servlet Instantiation");
	}

	public void init() {
		System.out.println("Servlet Initialization");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>hello this is http</h1>");
	}

	public void destroy() {
		System.out.println("Servlet Deinstantiation");
	}
}