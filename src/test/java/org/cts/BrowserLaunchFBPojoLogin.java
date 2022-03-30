package org.cts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.utilities.BaseClass;
import org.utilities.FBLoginPojo;
import org.utilities.FBLoginPojo1;

public class BrowserLaunchFBPojoLogin extends BaseClass{
@BeforeClass
public void StartingChrome() throws AWTException {
	launchChrome();
	loadurl("https://www.facebook.com");
	Winmax();
	printTitle();
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
@After
public void tc1() throws IOException {
	//FBLoginPojo f = new FBLoginPojo();       //
	FBLoginPojo1 f = new FBLoginPojo1();
	fill(f.getTxtuser(), getData(2, 0));
	fill(f.getTxtpass(), getData(1, 1));
	btnclick(f.getBtnlogin());
}
}
