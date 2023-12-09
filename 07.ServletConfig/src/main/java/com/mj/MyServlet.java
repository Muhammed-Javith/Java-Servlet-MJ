package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletConfig config=getServletConfig();
		String logicalName=config.getServletName();
		String driver=config.getInitParameter("driver");
		String url=config.getInitParameter("url");
		String user=config.getInitParameter("user");
		String password=config.getInitParameter("password");
		out.println("<html><body><h1>");
		out.println("Logical Name: "+logicalName+"<br><br>");
		out.println("Driver : "+driver+"<br><br>");
		out.println("Url : "+url+"<br><br>");
		out.println("User : "+user+"<br><br>");
		out.println("Password : "+password+"<br><br>");
		out.println("</h1></body></html>");
	}


}
