package automation.TestBaseProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import autoamtion.Config.SetUp;
import automation.Helpers.Helper;
import automation.Pages.PageLogin;
import automation.Pages.PageReservation;

public class TestReservation extends SetUp{
	private WebDriver driver;
	private Helper helper;
	private PageReservation pageReservation;
	private PageLogin pageLogin;

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

}
