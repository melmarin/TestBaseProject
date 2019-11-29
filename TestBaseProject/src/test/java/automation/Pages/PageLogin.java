package automation.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.Helpers.Helper;

public class PageLogin {

	private WebDriver driver;
	private Helper helper;
	private By userInput;
	private By passwordInput;
	private By loginButton;
	private By inputFields;

	public PageLogin(WebDriver driver) {
		this.driver = driver;
		this.userInput = By.name("userName");
		this.passwordInput = By.name("password");
		this.loginButton = By.name("login");
		this.inputFields = By.tagName("input");
	}

	public void login(String user, String pass) {
		driver.findElement(userInput).sendKeys(user);
		driver.findElement(passwordInput).sendKeys(pass);
		driver.findElement(loginButton).click();
		helper = new Helper(driver);
		helper.implicitlyWaitSeconds(10);
	}
	
	public List<WebElement> loginByFields(String user, String pass) {
		List<WebElement> inputList = driver.findElements(inputFields);
		inputList.get(2).sendKeys(user);
		inputList.get(3).sendKeys(pass);
		inputList.get(4).click();
		helper = new Helper(driver);
		helper.implicitlyWaitSeconds(10);
		return inputList;
	}
	
	
}
