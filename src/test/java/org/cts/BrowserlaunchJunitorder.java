package org.cts;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class BrowserlaunchJunitorder {
@BeforeClass
public static void StartingChrome() {
System.out.println("Launch Chrome");
}
@AfterClass
public static void EndingChrome() {
System.out.println("Close Chrome");
}
@Before
public void StartTime() {
System.out.println("Start");
}
@After
public void EndTime() {
System.out.println("End");
}
@Test
public void tc1() {
System.out.println("Test 1");
}
@Test
public void tc3() {
System.out.println("Test 3");
}
@Ignore
@Test
public void tc2() {
System.out.println("Test 2");
}
}
