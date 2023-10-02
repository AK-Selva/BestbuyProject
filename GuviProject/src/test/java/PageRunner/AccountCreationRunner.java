package PageRunner;

import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;
import Pages.AccountCreation;

public class AccountCreationRunner extends BrowserSetup {
	public String firstPageTitle = "Best Buy International: Select your Country - Best Buy";
	public String pageTitle = "Best Buy | Official Online Store | Shop Now & Save";
	//String homePage = "https://www.bestbuy.com/";
	//public WebDriver driver;
	AccountCreation creation=null;
//	@BeforeClass
//	public void getBrowserDetails()
//	{
//		driver = BrowserOpen.getDriver();
//	}
//	
	@Test
	public void clickAccountCreation() throws InterruptedException
	{
		//Thread.sleep(5000);
		//System.out.println("clickAccountCreation");
//		WebElement account =webDriver.findElement(By.xpath("//span[@class='v-p-right-xxs line-clamp']"));
//		account.click();
		creation = new AccountCreation(webDriver);
		boolean accCreation=creation.clickAccountCreation();
		Thread.sleep(500);
		//boolean AccountCreationVisibility=creation.AccountCreationVisibility();
		if (accCreation) {
//			Assert.assertEquals(pageTitle, webDriver.getTitle(), "The Title of the page does not match");
//			System.out.println(webDriver.getTitle());
			System.out.println("Popup is visible");
		}
	}
	@Test
	public void validateAccountPopup()
	{
		boolean accCreation=creation.AccountCreationVisibility();
		//WebElement popupWindow= webDriver.findElement(By.xpath(""));
		if (accCreation) {
			creation.AccountCreationClick();
			
		}
		
	}
	
}
