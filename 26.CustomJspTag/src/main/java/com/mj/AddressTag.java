package com.mj;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import jakarta.servlet.jsp.JspException;
public class AddressTag extends SimpleTagSupport {
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();

		out.print("Welcome to Nareshit technology");
		out.print("<br/> Date :" + new Date());
	}
}
