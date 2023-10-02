package PageRunner;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;
import Pages.*;

public class SiteNavigationRunner extends BrowserSetup {
	public String firstPageTitle = "Best Buy International: Select your Country - Best Buy";
	public String pageTitle = "Best Buy | Official Online Store | Shop Now & Save";
	String homePage = "https://www.bestbuy.com/";
	// public static WebDriver driver;
	SiteNavigation siteNavigation=null;
	@BeforeTest
	public void test() throws InterruptedException {

		// get the current URL of the page
		// driver = BrowserSetup.getDriver();
		// driver.get("http://automationpractice.com/");
		// System.out.println(homePage);
		// WebDriver driver;
		webDriver.get(homePage);
		siteNavigation = new SiteNavigation(webDriver);
		String PageTitle = siteNavigation.getPageTitle();
		Assert.assertEquals(firstPageTitle, PageTitle, "The First Title of the page does not match");
//		System.out.println(PageTitle);
	}

	@Test(priority = 1)
	public void CheckCountry() {
		try {
			
//			System.out.println("Selected Element");
			boolean countryVisibleElement=siteNavigation.countryVisibleElement();
			if (countryVisibleElement) {
				Assert.assertEquals(pageTitle, webDriver.getTitle(), "The Title of the page does not match");
				System.out.println(webDriver.getTitle());
			}
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	@Test(priority = 1)
	public void survey_window() {
		try {
			
//			System.out.println("Selected Element");
			boolean countryVisibleElement=siteNavigation.survey_window();
			if (countryVisibleElement) {
				//Assert.assertEquals(pageTitle, webDriver.getTitle(), "The Title of the page does not match");
				//System.out.println(webDriver.getTitle());
			}
			else
			{
				System.out.println("No Element found for survey+");
			}
		} catch (Exception e) {
			System.out.print(e);
		}
	}
//
//	@Test
//	public void checkURLBroken() {
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

}
