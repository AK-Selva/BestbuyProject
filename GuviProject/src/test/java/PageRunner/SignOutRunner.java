package PageRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;
import Pages.*;

public class SignOutRunner extends BrowserSetup{

	@Test
	public void signout() throws InterruptedException
	{
		Signout s = new Signout(webDriver);
		String url=s.logout();
		if(url.equals("https://www.bestbuy.com/"))
		{
			Assert.assertTrue(true);
		}
		else
			Assert.assertTrue(false);
			
	}
}
