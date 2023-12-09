package com.mj;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {
	HttpServletResponse httpResponse;

	public MyResponse(HttpServletResponse httpResponse) {
		super(httpResponse);
		this.httpResponse = httpResponse;
	}

	public void setContentType(String type) {
		if (!type.equals("text/html")) {
			httpResponse.setContentType("text/html");
		}
	}
}