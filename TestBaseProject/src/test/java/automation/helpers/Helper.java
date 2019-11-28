package automation.helpers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class Helper {
	private WebDriver driver;

	public Helper(WebDriver driver) {
		this.driver = driver;
	}

	public void implicitlyWaitSeconds(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
