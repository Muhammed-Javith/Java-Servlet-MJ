package com.mj;

import java.io.PrintWriter;

public class MyWriter extends PrintWriter {
	PrintWriter out;

	public MyWriter(PrintWriter out) {
		super(out);
		this.out = out;
	}

	public void println(String data) {
		if (!data.startsWith("<")) {
			StringBuffer sb = new StringBuffer(data);
			out.println(sb.reverse());
		} else {
			out.println(data);
		}
	}
}