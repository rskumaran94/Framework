package org.cts;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utilities.BaseClass;

public class greens extends BaseClass {
	public static void main(String[] args) throws AWTException, InterruptedException {
		launchChrome();
		loadurl("http://greenstech.in/selenium-course-content.html");
		Winmax();
		printTitle();
		printurl();
		WebElement scrldwn = driver.findElement(By.id("heading304"));
		scrolldwn(scrldwn);
		sleep(3000);
		scrollup(scrldwn);
}
}