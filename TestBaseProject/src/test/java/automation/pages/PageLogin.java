package automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import automation.helpers.Helper;

public class PageLogin {

	private WebDriver driver;
	private Helper helper;
	private By userInput;
	private By passwordInput;
	private By loginButton;

	public PageLogin(WebDriver driver) {
		this.driver = driver;
		this.userInput = By.name("userName");
		this.passwordInput = By.name("password");
		this.loginButton = By.name("login");
	}

	public void login(String user, String pass) {
		driver.findElement(userInput).sendKeys(user);
		driver.findElement(passwordInput).sendKeys(pass);
		driver.findElement(loginButton).click();
		helper = new Helper(driver);
		helper.implicitlyWaitSeconds(10);
	}
}
