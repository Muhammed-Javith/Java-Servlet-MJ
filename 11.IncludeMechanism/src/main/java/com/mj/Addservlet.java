package com.mj;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/Addservlet")
public class Addservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String pid = request.getParameter("pid");
			String pname = request.getParameter("pname");
			int pcost = Integer.parseInt(request.getParameter("pcost"));
			ProductDao pd = new ProductDao();
			pd.add(pid, pname, pcost);
			ArrayList<Product> prds = pd.getProducts();
			out.println("<html><body><center><br><br>");
			out.println("<table border='1' bgcolor='lightyellow'>");
			out.println("<tr><td>PID</td><td>PNAME</td><td>PCOST</td></tr>");
			for (Object o : prds) {
				Product p = (Product) o;
				out.println("<tr><td>" + p.getPid() + "</td><td>" + p.getPname() + "</td><td>" + p.getPcost()+ "</td></tr>");
			}
			out.println("</table></center><br><hr><br></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("/addform.html");
			rd.include(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
