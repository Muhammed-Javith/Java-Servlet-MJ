package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;

@WebServlet("/Registrationservlet")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String man_Date = request.getParameter("man_Date");
		String exp_Date = request.getParameter("exp_Date");
		Cookie[] c = request.getCookies();
		String pid = c[0].getValue();
		String pname = c[1].getValue();
		int pcost = Integer.parseInt(c[2].getValue());
		int pquantity = Integer.parseInt(c[3].getValue());
		ProductBean pb = new ProductBean();
		String status = pb.register(pid, pname, pcost, pquantity, man_Date, exp_Date);
		out.println("<html>");
		out.println("<body bgcolor='pink'>");
		out.println("<center><br><br>");
		out.println("<u>Product Registration Details</u><br><br>");
		out.println("Product Id....." + pid + "<br><br>");
		out.println("Product Name....." + pname + "<br><br>");
		out.println("Product Cost....." + pcost + "<br><br>");
		out.println("Product Quantity....." + pquantity + "<br><br>");
		out.println("Product Manufactured Date....." + man_Date + "<br><br>");
		out.println("Product Expiry Date....." + exp_Date + "<br><br>");
		out.println("Status....." + status);
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}
}
