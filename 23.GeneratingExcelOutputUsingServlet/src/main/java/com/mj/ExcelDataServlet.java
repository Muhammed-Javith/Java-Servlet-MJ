package com.mj;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ExcelDataServlet")
public class ExcelDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("application/vnd.ms-excel");
		res.addHeader("Content-Disposition", "attachement:filename=students.xls");
		try { // 1. Create WorkBook
			HSSFWorkbook book = new HSSFWorkbook();
//2.Create Sheet in workbook
			HSSFSheet sheet = book.createSheet("My STUDENTS DATA");
//3.Create Rows in sheet
			HSSFRow row0 = sheet.createRow(0);
//4.Create Cells and add data
//>> 1st row with data
			row0.createCell(0).setCellValue("S1.No.");
			row0.createCell(1).setCellValue("Name");
			row0.createCell(2).setCellValue("Marks");
//>>2nd row with data
			HSSFRow row1 = sheet.createRow(1);
			row1.createCell(0).setCellValue("101");
			row1.createCell(1).setCellValue("Uday");
			row1.createCell(2).setCellValue("98.36");
			HSSFRow row2 = sheet.createRow(2);
			row2.createCell(0).setCellValue("102");
			row2.createCell(1).setCellValue("Ramu");
			row2.createCell(2).setCellValue("95.36");
//5. Write data to ServletOutPutSteram 
			book.write(res.getOutputStream());
//6. close book
			book.close();
		} catch (Exception e) {
			System.out.println(e);

		}
	}
}
