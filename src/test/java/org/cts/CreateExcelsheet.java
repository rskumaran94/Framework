package org.cts;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelsheet {
public static void main(String[] args) throws IOException {
	File f = new File("C:\\Users\\admin\\eclipse-workspace\\Framework\\TestData\\create.xlsx");
	boolean a = f.createNewFile();
	System.out.println(a);
	Workbook w = new XSSFWorkbook();
	Sheet sheet = w.createSheet("senthil");
	Row row = sheet.createRow(0);
	Cell cell = row.createCell(1);
	cell.setCellValue("Greens Technologies");
	FileOutputStream fout = new FileOutputStream(f);
	w.write(fout);
	System.out.println("success");
}
}
