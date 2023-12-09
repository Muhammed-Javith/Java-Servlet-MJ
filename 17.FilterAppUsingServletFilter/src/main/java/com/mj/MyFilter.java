package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyFilter implements Filter {

	public MyFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='yellow'>");
		out.println("<center><b><br><br>");
		int age = Integer.parseInt(request.getParameter("sage"));
		if (age < 18) {
			out.println("U R not allowed for this Fashion Show");
			out.println("<br><br>");
			out.println("Bcoz, U R minor");
			out.println("<br><br>");
			out.println("Try after few years");
			out.println("<br><br>");
			out.println("<a href='/17.FilterAppUsingServletFilter/'>New StudentForm</a>");
			//RequestDispatcher rd=request.getRequestDispatcher("studentform.html");  
		    //rd.include(request, response);  
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
