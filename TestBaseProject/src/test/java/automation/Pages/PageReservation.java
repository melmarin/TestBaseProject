package automation.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageReservation {
	private WebDriver driver;
	private By passengerDrop;
	private By fromDrop;
	private By toDrop;
	
	public PageReservation(WebDriver driver) {
		this.driver = driver;
		this.passengerDrop = By.name("passCount");
		this.fromDrop = By.name("fromPort");
		this.toDrop = By.name("toPort");
	}
	
	public void selectPassengersNum(int num) {
		Duration fromSeconds = Duration.ofSeconds(10);
		WebDriverWait wait = new WebDriverWait(driver, fromSeconds);
		WebElement passengers = wait.until(ExpectedConditions.presenceOfElementLocated(passengerDrop));
		Select selectPassangers = new Select(passengers);
		selectPassangers.selectByVisibleText(Integer.toString(num));
	}
	
	public void selectFromPort(int index) {
		Select selectFrom = new Select(driver.findElement(fromDrop));
		selectFrom.selectByIndex(index);
	}
	
	public void selectToPort(String city) {
		Select selectTo = new Select(driver.findElement(toDrop));
		selectTo.selectByValue(city);
	}
	
	
	
	
	

}
