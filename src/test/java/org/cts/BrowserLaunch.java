package org.cts;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.utilities.BaseClass;

public class BrowserLaunch extends BaseClass {
public static void main(String[] args) throws AWTException, InterruptedException {
	launchChrome();
	loadurl("https://www.facebook.com");
	Winmax();
	printTitle();
	printurl();
	WebElement txtuser = driver.findElement(By.id("email"));
	fill(txtuser, "greens");
	WebElement txtpass = driver.findElement(By.id("pass"));
	fill(txtpass, "greens@123");
	WebElement txt = driver.findElement(By.xpath("//button[text()='Log In']"));
	printtxt(txt);
	printatt(txtuser);
	printatt(txtpass);
	WebElement loginbtn = driver.findElement(By.xpath("//button[@name='login']"));
	clickbtn(loginbtn);
	WebElement forgetpass = driver.findElement(By.xpath("(//a[text()='Forgotten password?'])[2]"));
	move(forgetpass);
	rightclick(forgetpass);
	for (int i = 0; i < 1; i++) {
		down();
	}
	enterkey();

}
}
