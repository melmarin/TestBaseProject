package automation.TestBaseProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import autoamtion.Config.SetUp;
import automation.Pages.PageLogin;

public class TestLogin extends SetUp{
	//private Helper helper;
	private PageLogin pageLogin;
	
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
	
}
