package org.cts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class physicalnoofrowsandcells {
public static void main(String[] args) throws IOException {
	File f = new File("C:\\Users\\admin\\eclipse-workspace\\Framework\\TestData\\StudentData.xlsx");
	FileInputStream fin = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(fin);
	Sheet s = w.getSheet("senthil");
	int physicalrows = s.getPhysicalNumberOfRows();
	System.out.println("PhysicalNumberOfRows = "+physicalrows);
	Row r = s.getRow(1);
	int physicalcells = r.getPhysicalNumberOfCells();
	System.out.println("PhysicalNumberOfCells = "+physicalcells);
	
	
}
}
