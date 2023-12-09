package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Depositservlet")
public class Depositservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String depName = request.getParameter("depName");
		int depAmount = Integer.parseInt(request.getParameter("depAmount"));
		HttpSession session = request.getSession();
		String accNo = (String) session.getAttribute("accNo");
		String accName = (String) session.getAttribute("accName");
		//String accType = (String) session.getAttribute("accType");
		String accBranch = (String) session.getAttribute("accBranch");
		TransactionBean tb = new TransactionBean();
		String status = tb.deposit(accNo, depAmount);
		out.println("<html><body bgcolor='lightblue'><br><br>");
		out.println("<center><table>");
		out.println("<tr><td colospan='2'><center><b><font size='6' color='red'>");
		out.println("<u>Transaction Details</u><font></b></center></td></tr>");
		out.println("<tr><td>Transaction Id</td><td>:t1</td></tr>");
		out.println("<tr><td>Transaction Name</td><td>:Deposit</td></tr>");
		out.println("<tr><td>Account Number</td><td>:" + accNo + "</td></tr>");
		out.println("<tr><td>Account Name</td><td>:" + accName + "</td></tr>");
		//out.println("<tr><td>Account Type</td><td>:" + accType + "</td></tr>");
		out.println("<tr><td>Account Branch</td><td>:" + accBranch + "</td></tr>");
		out.println("<tr><td>Depositor Name</td><td>:" + depName + "</td></tr>");
		out.println("<tr><td>Deposit Amount</td><td>:" + depAmount + "</td></tr>");
		int totalAvailableAmount = tb.getTotalAvailableAmount();
		out.println("<tr><td>Total Available Amount</td><td>:" + totalAvailableAmount + "</td></tr>");
		out.println("<tr><td>Transaction Status</td><td>:" + status + "</td></tr>");
		out.println("<tr><td colspan='2'><b><font size='5'>...Visit Again...</td></tr>");
		out.println("</table></center></body></html>");
	}
}
