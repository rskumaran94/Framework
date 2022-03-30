package org.cts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadupdate {
public static void main(String[] args) throws IOException {
	File f = new File("C:\\Users\\admin\\eclipse-workspace\\Framework\\TestData\\StudentData.xlsx");
	FileInputStream fin = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(fin);
	Sheet s = w.getSheet("senthil");
	for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
		Row row = s.getRow(i);
		for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
			Cell cell = row.getCell(j);
			int cellType = cell.getCellType();
			if (cellType==1) {
				String value = cell.getStringCellValue();
				if (value.equals("tambaram")) {
					cell.setCellValue("tambaram sani");
					FileOutputStream fout = new FileOutputStream(f);
					w.write(fout);
					System.out.println("success");
				}
				
			}
		}
	}
	
}
}
