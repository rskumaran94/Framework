package org.cts;

import java.awt.AWTException;

import org.junit.Test;
import org.utilities.BaseClass;


public class AssersionJunit extends BaseClass {
@Test
public void tc2() {
System.out.println("Test 2");
}
@Test
public void tc3() {
org.junit.Assert.assertTrue("Check Tc3", true);
System.out.println("Test 3");
}
@Test
public void tc1() throws AWTException {
	launchChrome();
	loadurl("https://www.facebook.com");
	String tit = driver.getTitle();
	String exp="https://www.facebook.com";
	org.junit.Assert.assertTrue("Check U R Titlr", tit.contains("Facebook"));
	org.junit.Assert.assertEquals("Check The Url", exp, tit);
	System.out.println("Senthil");
}
}
