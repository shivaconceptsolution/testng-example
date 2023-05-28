package scs;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class EroomRent1 {
	public static WebDriver driver;
    @BeforeSuite
    public void beforeSuiteExample()
    {
    	System.out.println("Before Suite Execution");
    }
    @BeforeClass
    public void beforeClassExample()
    {
    	System.out.println("Before Class Example");
    }
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.eroomrent.in/");
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void openWebsite() {
		System.out.println("Start Methos");
	}

	@Test(priority = 1)
	public void brokerRegister() {

		WebElement menu = driver.findElement(By.linkText("Broker-G"));
		Actions ack = new Actions(driver);
		Action event = ack.moveToElement(menu).build();
		event.perform();
		WebElement submenu = driver.findElement(By.xpath("//a[@href='brokerreg.php']"));
		submenu.click();
		String t = driver.getCurrentUrl();
		System.out.println("Page of URl:" + t);

		driver.findElement(By.id("txtfname")).sendKeys("Heera Jain");
		driver.findElement(By.id("txtmobile1")).sendKeys("9874563210");
		driver.findElement(By.id("txtpass")).sendKeys("1234567");
		driver.findElement(By.id("txtcpass")).sendKeys("1234567");
		driver.findElement(By.name("txtEmail")).sendKeys("heera9@yopmail.com");

		driver.findElement(By.name("btnsubmit")).click();
		String text = driver.switchTo().alert().getText();
		if(text.equalsIgnoreCase("Registration successfully")) {
		System.out.println("Broker register:" + text);
		driver.switchTo().alert().accept();
		}else {
			System.out.println("Broker register:" + driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
		}
			
	}

	@Test(priority = 2)
	public void brokerlogin() {
		WebElement menu = driver.findElement(By.linkText("Broker-G"));
		Actions ack = new Actions(driver);
		Action event = ack.moveToElement(menu).build();
		event.perform();
		WebElement submenu = driver.findElement(By.xpath("//a[@href='brokerlogin.php']"));
		submenu.click();
		driver.findElement(By.name("txtEmail")).sendKeys("heera9@yopmail.com");
		driver.findElement(By.name("txtPassword")).sendKeys("1234567");

		driver.findElement(By.name("btnsubmit")).click();
		// driver.switchTo().alert().accept();
		System.out.println("After login page title is : " + driver.getTitle());
	}

	@Test(priority = 3)
	public void addRoom() throws InterruptedException {
//	  WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
//		        .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div[1]/div/ul/li[2]/a")));

		// driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/ul/li[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Room")).click();
		Select location = new Select(driver.findElement(By.id("ddllocation")));
		location.selectByVisibleText("Vijay Nagar");
		Thread.sleep(2000);

		Select Category = new Select(driver.findElement(By.id("ddlcat")));
		Category.selectByVisibleText("Flat");
		Thread.sleep(2000);

		Select SubCategory = new Select(driver.findElement(By.id("subcat")));
		SubCategory.selectByVisibleText("3 BHK");

		driver.findElement(By.cssSelector("textarea[placeholder='Enter room description']"))
				.sendKeys("Testing Purpose");
		WebElement choosefile = driver.findElement(By.cssSelector("input[name='file']"));
		choosefile.sendKeys("C:\\Eclipse and project\\JA.png");

		driver.findElement(By.cssSelector("input[placeholder='Enter room price']")).sendKeys("200");
		driver.findElement(By.cssSelector("input[placeholder='Enter room facility']")).sendKeys("Testing896");
		driver.findElement(By.cssSelector("input[value='Insert']")).click();

	}

	@Test(priority = 4)
	public void logout() {
		driver.findElement(By.cssSelector("a[href='logout.php']")).click();
		System.out.println("After logut page title is : " + driver.getTitle());
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("This Method is run successfully");
		System.out.println("   ");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	@AfterSuite
    public void afterSuiteExample()
    {
    	System.out.println("After Suite Execution");
    }
	@AfterClass
    public void afterClassExample()
    {
    	System.out.println("After Class Execution");
    }
}
