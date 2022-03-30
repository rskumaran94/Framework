package org.cts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.utilities.BaseClass;
import org.utilities.FBLoginPojo;

public class BrowserLaunchJunit extends BaseClass{
	@BeforeClass
	public static void StartingChrome() throws AWTException {
		launchChrome();
		loadurl("https://www.facebook.com");
		Winmax();
		}
	@AfterClass
	public static void EndingChrome() {
	end();
	}
	@Before
	public void StartTime() {
	Date d = new Date();
	System.out.println(d);
	}
	@After
	public void EndTime() {
	System.out.println(new Date());
	}
	@Test
	public void tc1() throws IOException {
	FBLoginPojo f = new FBLoginPojo();
	fill(f.getTxtuser(), getData(3, 0));
	fill(f.getTxtpass(), getData(1, 1));
	btnclick(f.getBtnlogin());
	}
}
