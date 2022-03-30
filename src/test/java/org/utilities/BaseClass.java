package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

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

public class BaseClass {
	
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
	public static void printurl() {												//6
		System.out.println(driver.getCurrentUrl());
	}
		public static void end() {												//7
		driver.close();
	}
	public static void closeall() {												//8
		driver.quit();
	}
	public static void printtxt(WebElement txt) {								//9
		System.out.println(txt.getText());
	}
	public static void printatt(WebElement text) {								//10
		System.out.println(text.getAttribute("value"));
	}
	public static void move(WebElement value) {									//11
		a.moveToElement(value).perform();
		}
	public static void rightclick(WebElement value) {							//12
		a.contextClick(value).perform();
	}
	public static void down() {													//13
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	public static void enterkey() {												//14
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void scrolldwn(WebElement value) {							//15
		js.executeScript("arguments[0].scrollIntoView(true)", value);
		}
	public static void scrollup(WebElement value) {								//16
		js.executeScript("arguments[0].scrollIntoView(false)", value);			
	}
	public static void sleep(long millis) throws InterruptedException {			//17
		Thread.sleep(millis);
	}
	public static void clickbtn(WebElement ele) {								//18
		js.executeScript("arguments[0].click()",ele);
		
	}
	public static void byvalue(String value) {									//19
		s.selectByValue(value);
	}
	
	public static void bytext(String value) {									//20
		s.selectByVisibleText(value);
	}
	public static void byindex(int ele) {										//21
		s.selectByIndex(ele);
	}
	public static void multiple() {												//22
		System.out.println(s.isMultiple());
	}
	public static void deselectindex(int index) {								//23
		s.deselectByIndex(index);
	}
	public static void deselectvalue(String ele) {								//24
		s.deselectByValue(ele);
	}
	public static void deselecttext(String ele) {								//25
		s.deselectByVisibleText(ele);
	}
	public static void alldeselect() {											//26
		s.deselectAll();
	}
	public static void implicitwait(long seconds) {								//27
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
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


