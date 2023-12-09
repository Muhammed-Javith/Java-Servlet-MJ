package com.mj;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

public class MyResponse extends HttpServletResponseWrapper {
	HttpServletResponse httpServletResponse;

	public MyResponse(HttpServletResponse httpServletResponse) {
		super(httpServletResponse);

		this.httpServletResponse = httpServletResponse;
	}

	public PrintWriter getWriter() throws IOException {
		PrintWriter out = httpServletResponse.getWriter();
		MyWriter myWriter = new MyWriter(out);
		return myWriter;
	}
}