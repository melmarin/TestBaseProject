package automation.Helpers;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Helper {
	private WebDriver driver;
	private ArrayList<String> tabs;

	public Helper(WebDriver driver) {
		this.driver = driver;
		this.tabs = new ArrayList<String>(driver.getWindowHandles());
	}

	public void implicitlyWaitSeconds(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public void takeScreenShot(String name) {
		File myScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenshot, new File("Screenshots/" +name+ "_" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void openNewTab(String url) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String googleWindow = "window.open('"+url+"')";
		jsExecutor.executeScript(googleWindow);
		this.tabs = new ArrayList<String>(driver.getWindowHandles());
	}
	
	public void changeWindowHandled(int index) {
		driver.switchTo().window(tabs.get(index));
	}
	
	public ArrayList<String> getTabs() {
		return tabs;
	}

	public void setTabs(ArrayList<String> tabs) {
		this.tabs = tabs;
	}
}
