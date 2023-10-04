package PageRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;
import Pages.*;

public class LoginRunner extends BrowserSetup {

	@Test
	public void loginPage() throws InterruptedException {
		Login s = new Login(webDriver);
		String url = s.loginPage(homePage);
		if (url.equals("Sign In to Best Buy")) {
			Assert.assertTrue(true);
		} else
			Assert.assertTrue(false);

	}
	@Test
	public void validLoginDetails() throws InterruptedException {
		Login s = new Login(webDriver);
		String url = s.validLoginDetails();
		if (url.equals("Best Buy | Official Online Store | Shop Now & Save")) {
			Assert.assertTrue(true);
			System.out.println("signin Success");
		} else
			Assert.assertTrue(false);
	}
}
