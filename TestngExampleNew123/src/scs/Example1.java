package scs;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Example1 {
	WebDriver driver;
	@BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver","c://chromedriver.exe");
			driver = new ChromeDriver();
	  }
    @Test
    public void f() {
	     driver.get("https://www.shivaconceptsolution.com/backupmain/test.html");
		 driver.findElement(By.linkText("Click"));
		 driver.findElement(By.partialLinkText("shivaconcept")).click();
         driver.navigate().back();
         try {
		     Thread.sleep(1000);
	          } catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	        }
      for(int i=0;i<2;i++)
      {
      driver.findElement(By.name("chk2")).click();
      }
  }
  

  @AfterTest
  public void afterTest() 
  {
	  System.out.println("Test Executed Successfully");
  }

}
