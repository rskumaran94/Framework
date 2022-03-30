package org.cts;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelReadBaseclass {
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static JavascriptExecutor js;
	public static Select s;
	public static void launchChrome() throws AWTException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		a = new Actions(driver);
		r = new Robot();
		js = (JavascriptExecutor)driver;
	//	s = new Select(null);
	}
	public static void loadurl(String url) {									//1
	driver.get(url);
	}
	public static void Winmax() {												//2
	driver.manage().window().maximize();
	}
	public static void printTitle() {											//3
	System.out.println(driver.getTitle());
	}
	public static void fill(WebElement ele, String value) {						//4
		ele.sendKeys(value);
	}
	public static void btnclick(WebElement ele) {								//5
		ele.click();
	}
	public static String getData(int rowNumber, int cellNumber) throws IOException {
		File f = new File("C:\\Users\\admin\\eclipse-workspace\\Framework\\TestData\\StudentData.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet s = w.getSheet("senthil");
		Row r = s.getRow(rowNumber);
		Cell cell = r.getCell(cellNumber);
		int cellType = cell.getCellType();
		String value = "";
		if (cellType==1) {
			value = cell.getStringCellValue();
				
		}
		else if (cellType==0) {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date d = (Date) cell.getDateCellValue();
				SimpleDateFormat sim = new SimpleDateFormat("dd,MMMM,YYYY");
				value = sim.format(d);
		}
			else {
				double d = cell.getNumericCellValue();
				long l = (long)d;
				value = String.valueOf(l);
				
			}
		}
	return value;
	}	
	
}
