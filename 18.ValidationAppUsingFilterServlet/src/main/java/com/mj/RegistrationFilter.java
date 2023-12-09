package com.mj;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class RegistrationFilter implements Filter {
	String eid_err_msg = "", ename_err_msg = "", eage_err_msg = "", eemail_err_msg = "", emobile_err_msg = "";
	boolean b = true;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String eid = request.getParameter("eid");
			String ename = request.getParameter("ename");
			String eage = request.getParameter("eage");
			String eemail = request.getParameter("eemail");
			String emobile = request.getParameter("emobile");
			if (eid == null || eid.equals("")) {
				eid_err_msg = "Employee Id is Required";
				b = false;
			} else {
				if (!eid.startsWith("DSS-")) {
					eid_err_msg = "Employee Id Must be in DSS-ddd Format";
					b = false;
				} else {
					b = true;
				}
			}
			if (ename == null || ename.equals("")) {
				ename_err_msg = "Employee Name is Required";
				b = false;
			} else {
				b = true;
			}
			if (eage == null || eage.equals("")) {
				eage_err_msg = "Employee Age is Required.";
				b = false;
			} else {
				int age = Integer.parseInt(eage);
				if (age < 20 || age > 30) {
					eage_err_msg = "Employee Age Must be in between 20 to 30 Years.";
					b = false;
				} else {
					b = true;
				}
			}
			if (eemail == null || eemail.equals("")) {
				eemail_err_msg = "Employee Email is Required";
				b = false;
			} else {
				if (!eemail.endsWith("@mj.com")) {
					eemail_err_msg = "Employee Email is Invalid";
					b = false;
				} else {
					b = true;
				}
			}
			if (emobile == null || emobile.equals("")) {
				emobile_err_msg = "Employee Mobile is Required";
				b = false;
			} else {
				if (!emobile.startsWith("91-")) {
					emobile_err_msg = "Employee Mobile Num. is Invalid";
					b = false;
				} else {
					b = true;
				}
			}
			if (b == false) {
				out.println("<html>");
				out.println("<body>");
				out.println("<font color='red'>");
				out.println("<h2>Durga Software Solutions</h2>");
				out.println("<h3>Employee Registration Form</h3>");
				out.println("</font>");
				out.println("<font color='blue' size='5'>");
				out.println(eid_err_msg + "<br>");
				out.println(ename_err_msg + "<br>");
				out.println(eage_err_msg + "<br>");
				out.println(eemail_err_msg + "<br>");
				out.println(emobile_err_msg + "<br>");
				out.println("</font>");
				out.println("<form method='post' action='./reg'>");
				out.println("<table>");
				out.println("<tr><td>Employee Id</td><td><input type='text' name='eid' value='" + eid + "'/></td><td>"
						+ eid_err_msg + "</td></tr>");
				out.println("<tr><td>Employee Name</td><td><input type='text' name='ename' value='" + ename
						+ "'/></td><td>" + ename_err_msg + "</td></tr>");
				out.println("<tr><td>Employee Age</td><td><input type='text' name='eage' value='" + eage
						+ "'/></td><td>" + eage_err_msg + "</td></tr>");
				out.println("<tr><td>Employee Email</td><td><input type='text' name='eemail' value='" + eemail
						+ "'/></td><td>" + eemail_err_msg + "</td></tr>");
				out.println("<tr><td>Employee Mobile</td><td><input type='text' name='emobile' value='" + emobile
						+ "'/></td><td>" + emobile_err_msg + "</td></tr>");
				out.println("<tr><td><input type='submit' value='Registration'/></td></tr>");
				out.println("</table></form></body></html>");
				eid_err_msg = "";
				ename_err_msg = "";
				eage_err_msg = "";
				eemail_err_msg = "";
				emobile_err_msg = "";
				b = true;
			} else {
				chain.doFilter(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}