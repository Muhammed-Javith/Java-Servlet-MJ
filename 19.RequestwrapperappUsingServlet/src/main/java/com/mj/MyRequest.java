package com.mj;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletRequestWrapper;

public class MyRequest extends ServletRequestWrapper {
	ServletRequest request;

	public MyRequest(ServletRequest request) {
		super(request);
		this.request = request;
	}

	public String getParameter(String name) {
		String value = request.getParameter(name);
		if (name.equals("email")) {
			if (!value.endsWith("@dss.com")) {
				value = value + "@dss.com";
			}
		}
		return value;
	}
}