package autoamtion.Config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import automation.Helpers.Helper;

public class SetUp {
	protected WebDriver driver;
	protected Helper helper;
	
	@BeforeMethod
	public void setUp() {
		//Detecting OS
		String driverByOS = "";
		if(System.getProperty("os.name").equals("Windows 10")) {
			driverByOS = "Drivers/chromedriver.exe";
		}else {
			driverByOS = "Drivers/chromedriver";
		};
		System.setProperty("webdriver.chrome.driver", driverByOS);
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		//driver.manage().window().setSize(new Dimension(800, 600));
		//driver.manage().window().setPosition(new Point(200, 300));
		driver.navigate().to("http://newtours.demoaut.com/");
		helper = new Helper(driver);
		helper.implicitlyWaitSeconds(10);
	}
	
	/*public void setUpWihoutGUI() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/");
		helper = new Helper(driver);
		helper.implicitlyWaitSeconds(10);
	}*/

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
