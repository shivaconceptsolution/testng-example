package scs;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example2 {
@BeforeTest
 public void beforeTestFunc()
 {
	  System.out.println("Before Test");
 }
@BeforeMethod
public void beforeTestMethod()
{
	 System.out.println("Before Method");
}
@Test(priority = 2)
public void testFunc1()
{
	 System.out.println("Test1");
}
@Test(priority = 1)
public void testFunc2()
{
	 System.out.println("Test2");
}

@AfterMethod
public void afterTestMethod()
{
	 System.out.println("After Method");
}
@AfterTest
public void afterTestFunc()
{
	 System.out.println("After TEST");
}  
}
