package PageRunner;

import java.util.ArrayList;

import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;

import Pages.HomePageNavigation;

public class HomePageNavigationrunner extends BrowserSetup{

	HomePageNavigation navigation=null;
	
	@Test
	public void HomePageMenuLinks() throws InterruptedException
	{
		//navigation=

	webDriver.navigate().to(homePage);
	navigation.menutitles();
	navigation.TopDeals();
	navigation.TodayDeals();
	navigation.memberDeal();
	navigation.BestBuyOutlet();
	navigation.menuBrands();
	navigation.BestBuyBrands();
	navigation.AppleBrands();
	navigation.SamsungBrands();
	navigation.MicrosoftBrands();
	
	}
	@Test
	public void BottomPageLinks()
	{
		navigation=new HomePageNavigation(webDriver);
		//List<WebElement> spans = driver.findElements(By.cssSelector(".nd_list span"));
ArrayList<String> urls=navigation.homePageBottomLinks(homePage);
//testinig
	}
}
