package automation.TestBaseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.Helpers.Helper;
import automation.Pages.PageLogin;
import automation.Pages.PageReservation;

public class TestReservation {
	private WebDriver driver;
	private Helper helper;
	private PageReservation pageReservation;
	private PageLogin pageLogin;

	@BeforeMethod
	public void setUp() {
		// Detecting OS
		String driverByOS = "";
		if (System.getProperty("os.name").equals("windows 10")) {
			driverByOS = "Drivers/chromedriver.exe";
		} else {
			driverByOS = "Drivers/chromedriver";
		}
		System.setProperty("webdriver.chrome.driver", driverByOS);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/");
		helper = new Helper(driver);
		helper.implicitlyWaitSeconds(10);
	}

	@Test
	public void makeReservation() {
		this.pageLogin = new PageLogin(driver);
		pageLogin.login("mercury", "mercury");
		helper.implicitlyWaitSeconds(10);
		Assert.assertTrue(
				driver.findElement(By.xpath("//a[contains(text(),'SIGN-OFF')]")).getText().contains("SIGN-OFF"),
				"Text not found or different");
		this.pageReservation = new PageReservation(driver);
		this.pageReservation.selectPassengersNum(2);
		this.pageReservation.selectFromPort(3);
		this.pageReservation.selectToPort("London");
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (!result.isSuccess()) {
			helper.takeScreenShot("ERROR");
		}
		driver.close();
	}
}
