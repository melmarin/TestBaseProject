package automation.TestBaseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import automation.helpers.Helper;
import automation.pages.PageLogin;

public class TestLogin {
	private WebDriver driver;
	private Helper helper;
	private PageLogin pageLogin;
	
	

	public TestLogin() {
		this.helper = new Helper();
	}

	@BeforeMethod
	public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/");
		helper.sleepSeconds(5);
	}
	
	@Test
	public void testLogOn() {
		this.pageLogin = new PageLogin(driver);
		pageLogin.login("mercury", "mercury");
		Assert.assertTrue(
				driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).getText().contains("SIGN-OFF"));
	}
	
	@Test
	public void testLogOff() {
		this.pageLogin = new PageLogin(driver);
		pageLogin.login("user", "user");
		Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Welcome back to')]")).getText().contains("Welcome back to Mercury Tours!"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
