package org.cts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BrowseLaunchExcelread extends ExcelReadBaseclass {
	public static void main(String[] args) throws AWTException, IOException {
		launchChrome();
		loadurl("https:///www.facebook.com");
		Winmax();
		WebElement txtuser = driver.findElement(By.id("email"));
		fill(txtuser, getData(2, 0));
		WebElement txtpass = driver.findElement(By.id("pass"));
		fill(txtpass, getData(1, 1));
		
	}

}
