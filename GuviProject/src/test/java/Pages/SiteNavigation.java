package Pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import DriverSetup.BrowserSetup;



public class SiteNavigation  {
	
	 @FindBy(xpath = "//div[@lang='en']//img[@alt='United States']")
	    public WebElement countryVisibleElement;
	
	 @FindBy(xpath="//div[@id=\"survey_window\"]")
	  public WebElement survey_window;
	
	 @FindBy(xpath="//div[@id='survey_invite_no']")
	  public WebElement survey_invite_no;
	//button[@id="survey_invite_no"]
	 
	public WebDriver webDriver;

	   public SiteNavigation(WebDriver driver) {
	        this.webDriver = driver;
	        PageFactory.initElements(driver, this);
	    }

	public String firstPageTitle = "Best Buy International: Select your Country - Best Buy";
	public String pageTitle = "Best Buy | Official Online Store | Shop Now & Save";
	String homePage = "https://www.bestbuy.com/";

	public String getPageTitle() throws InterruptedException {
		return BrowserSetup.getPageTitle();
	}
	
	public boolean countryVisibleElement()
	{
		if (countryVisibleElement.isDisplayed()) {
			countryVisibleElement.click();
			return true;
		}
		return false;
	}
	public boolean survey_window() throws IOException
	{
		
		if (survey_window.isEnabled()) {
			survey_invite_no.click();
			return true;
		}
		else
		{
			//BrowserSetup.takeScreenshot(webDriver);
		}
		return false;
	}
	
//	public void test() {
//
//		// get the current URL of the page
//		driver = BrowserSetup.getDriver();
//
//		driver.get(homePage);
//
//		Assert.assertEquals(firstPageTitle, driver.getTitle(), "The First Title of the page does not match");
//
//	}
//
//	@Test(priority = 1)
//	public void CheckCountry() {
//	
//		WebElement countryVisibleElement = driver.findElement(By.xpath("//div[@lang='en']//img[@alt='United States']"));
//		if (countryVisibleElement.isDisplayed()) {
//			countryVisibleElement.click();
//			Assert.assertEquals(pageTitle, driver.getTitle(), "The Title of the page does not match");
//		}
//	}
//	
//	@Test(priority=2)
//	public void checkURLBroken()
//	{
//		try {
//			HttpURLConnection huc = null;
//			int respCode = 200;
//			huc = (HttpURLConnection) (new URL(homePage).openConnection());
//			huc.setRequestMethod("HEAD");
//			huc.connect();
//			respCode = huc.getResponseCode();
//			if (respCode >= 400) {
//				System.out.println(homePage + " is a broken link");
//			} else {
//				System.out.println(homePage + " is a valid link");
//			}
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
	
}
