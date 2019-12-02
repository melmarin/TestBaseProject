package automation.TestBaseProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import automation.Helpers.Helper;
import automation.Pages.PageLogin;

public class TestLogin {
	private WebDriver driver;
	private Helper helper;
	private PageLogin pageLogin;
	
	@BeforeMethod
	/*public void setUp() {
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		//driver.manage().window().setSize(new Dimension(800, 600));
		//driver.manage().window().setPosition(new Point(200, 300));
		driver.navigate().to("http://newtours.demoaut.com/");
		helper = new Helper(driver);
		helper.implicitlyWaitSeconds(10);
	}*/
	
	public void setUpWihoutGUI() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/");
		helper = new Helper(driver);
		helper.implicitlyWaitSeconds(10);
	}
	
	@Test (description = "Login correct")
	public void testLogOn() {
		this.pageLogin = new PageLogin(driver);
		pageLogin.login("mercury", "mercury");
		Assert.assertTrue(
				driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).getText().contains("SIGN-OFF"), 
				"Text different or not found");
		helper.openNewTab("http://www.google.com");
		helper.changeWindowHandled(1);
		driver.navigate().to("http://www.youtube.com");
	}
	
	@Test (description = "Login correct with list")
	public void testLogOnFields() {
		this.pageLogin = new PageLogin(driver);
		List<WebElement> inputList = pageLogin.loginByFields("mercury", "mercury");
		Assert.assertTrue(inputList.size()==5);
	}
	
	@Test (description = "Login incorrect")
	public void testLogOff() {
		this.pageLogin = new PageLogin(driver);
		pageLogin.login("user", "user");
		Assert.assertTrue(driver.findElement(By.xpath("//b[contains(text(),'Welcome back to')]")).getText().contains("Welcome back to Mercury Tours!"));
	}
	
	@Test (description = "Write page tittle")
	public void testTitle() {
		this.pageLogin = new PageLogin(driver);
		pageLogin.login(driver.getTitle(),"88");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		System.out.println("Test: "+ result.getMethod().getDescription()+ " is: " + result.getStatus());
		if(!result.isSuccess()) {
			helper.takeScreenShot("ERROR");
		}
		for(int i=0; i<=helper.getTabs().size()-1;i++) {
			driver.switchTo().window(helper.getTabs().get(i)).close();
		}
	}
}
