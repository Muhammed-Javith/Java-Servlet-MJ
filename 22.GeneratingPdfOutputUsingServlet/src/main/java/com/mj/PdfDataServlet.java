package com.mj;

import java.io.IOException;
import java.util.Date;

import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.itextpdf.text.pdf.PdfPTable;

@WebServlet("/PdfDataServlet")
public class PdfDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/pdf");
		res.addHeader("Content-Disposition", "attachment;filename=mydata.pdf");
		try {
			// 1. Create one Document
			Document doc = new Document();
			// 2. Get Writer over Doc
			PdfWriter.getInstance(doc, res.getOutputStream());
			// 3. Open Doc
			doc.open();
			// 4. Write data
			doc.add(new Paragraph("Hello Pdf"));
			// table with 2 columns in a row
			PdfPTable t = new PdfPTable(2);
			t.addCell("S1No");
			t.addCell("Name");
			t.addCell("101");
			t.addCell("Ajay");
			t.addCell("102");
			t.addCell("Vijay");
			doc.add(t);
			doc.add(new Paragraph(new Date().toString()));
			// 5. Close doc
			doc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
