package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HomePageNavigation {

	public WebDriver webDriver;

	@FindBy(xpath = "//*[name()='path' and contains(@d,'M19.25 7.5')]")
	public WebElement menu;

	@FindBy(xpath = "//button[normalize-space()='Deals']")
	public WebElement Deals;

	@FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']")
	public WebElement topdealsflyin;

//@FindBy(xpath = "//a[contains(@data-lid,'ubr_dls_td_topdeals')]")
	@FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/*/a[contains(text(),'Top Deals')]")
	public WebElement topdeals;

	@FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/*/a[contains(text(),'Deal of the Day')]")
	public WebElement dod;

	@FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/*/a[contains(text(),'Exclusive Member Deals')]")
	public WebElement memberDeal;

	@FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/*/a[contains(text(),'Best Buy Outlet')]")
	public WebElement bbo;

	@FindBy(xpath = "//button[normalize-space()='Brands']")
	public WebElement Brands;
@FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/*/a[contains(text(),'Best Buy Brands')]")
	public WebElement BestBuyBrands;


@FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/*/a[contains(text(),'Apple')]")
public WebElement Apple;


@FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/*/a[contains(text(),'Samsung')]")
public WebElement Samsung;


@FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/*/a[contains(text(),'Microsoft')]")
public WebElement Microsoft;


public HomePageNavigation(WebDriver driver) {
	this.webDriver = driver;
	PageFactory.initElements(driver, this);
	driver.get("https://www.bestbuy.com/");
}


	public void menutitles() {
		if (menu.isDisplayed())

		{
			menu.click();
			System.out.println("Menu Clicked");
		}
		if (Deals.isDisplayed()) {
			Deals.click();
			System.out.println("deals Clicked");
		}

	}

	public void TopDeals() throws InterruptedException {
		if (topdealsflyin.isDisplayed()) {
			this.highLighterMethod(webDriver, topdeals);
			Thread.sleep(1000);
			topdeals.click();
			System.out.println("topdeals Clicked");
			Assert.assertEquals(webDriver.getTitle(), "Top Deals and Featured Offers on Electronics - Best Buy");
		}
	}

	public void TodayDeals() throws InterruptedException {
		menutitles();
		if (topdealsflyin.isDisplayed()) {
			this.highLighterMethod(webDriver, dod);
			Thread.sleep(1000);
			dod.click();
			System.out.println("dod Clicked");
			Assert.assertEquals(webDriver.getTitle(), "Deal of the Day: Electronics Deals - Best Buy");
		}
	}

	public void memberDeal() throws InterruptedException {
		menutitles();
		if (topdealsflyin.isDisplayed()) {
			this.highLighterMethod(webDriver, memberDeal);
			Thread.sleep(1000);
			memberDeal.click();
			System.out.println("memberDeal Clicked");
			Assert.assertEquals(webDriver.getTitle(), "Top Deals on Plus and Total Exclusive Member Offers – Best Buy");
		}
	}

	public void BestBuyOutlet() throws InterruptedException {
		menutitles();
		if (topdealsflyin.isDisplayed()) {
			this.highLighterMethod(webDriver, bbo);
			Thread.sleep(1000);
			bbo.click();
			System.out.println("BestBuyOutlet Clicked");
			Assert.assertEquals(webDriver.getTitle(), "Best Buy Outlet: Clearance Electronics Outlet Store – Best Buy");
		}
	}

	public void menuBrands() throws InterruptedException {
		if (menu.isDisplayed())

		{
			menu.click();
			System.out.println("Menu Clicked");
		}
		if (Brands.isDisplayed()) {
//			this.highLighterMethod(webDriver, Brands);
//			Thread.sleep(1000);
			Brands.click();
			System.out.println("Brands Clicked");
			
		}

	}

public void BestBuyBrands() throws InterruptedException {
	
	if (BestBuyBrands.isDisplayed()) {
		this.highLighterMethod(webDriver, BestBuyBrands);
		Thread.sleep(1000);
		BestBuyBrands.click();
		System.out.println("BestBuyBrands Clicked");
		Assert.assertEquals(webDriver.getTitle(), "Insignia, Rocketfish, Dynex, Platinum and Modal - Best Buy");
	}

}
	
public void AppleBrands() throws InterruptedException {
	menuBrands();
		if (Apple.isDisplayed()) {
			this.highLighterMethod(webDriver, Apple);
			Thread.sleep(1000);
			Apple.click();
			System.out.println("Apple Clicked");
			Assert.assertEquals(webDriver.getTitle(), "Apple – Best Buy");
		}

	}

public void SamsungBrands() throws InterruptedException {
	menuBrands();
	if (Samsung.isDisplayed()) {
		this.highLighterMethod(webDriver, Samsung);
		Thread.sleep(1000);
		Samsung.click();
		System.out.println("Samsung Clicked");
		Assert.assertEquals(webDriver.getTitle(), "Samsung Store – Best Buy");
	}

}

public void MicrosoftBrands() throws InterruptedException {
	menuBrands();
	if (Microsoft.isDisplayed()) {
		this.highLighterMethod(webDriver, Microsoft);
		Thread.sleep(1000);
		Microsoft.click();
		System.out.println("Microsoft Clicked");
		Assert.assertEquals(webDriver.getTitle(), "Microsoft Brand Store - Best Buy");
	}
}
//Creating a custom function
public void highLighterMethod(WebDriver driver, WebElement element){
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
}


public ArrayList<String> homePageBottomLinks(String home)
{
	String url=null;
	ArrayList<String> urls= new ArrayList();
	HttpURLConnection huc = null;
	int respCode = 200;

JavascriptExecutor js = (JavascriptExecutor) webDriver;
js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	List<WebElement> spans = webDriver.findElements(By.xpath("//*[@class='flex justify-content-start']/a"));

	Iterator<WebElement> it = spans.iterator();

	while (it.hasNext()) {

		url = it.next().getAttribute("href");

		//System.out.println(url);

		if (url == null || url.isEmpty()) {
			System.out.println(url + " - URL is either not configured for anchor tag or it is empty");
			continue;
		}

		if (!url.startsWith(home)) {
			System.out.println(url + " - URL belongs to another domain, skipping it.");
			continue;
		}

		try {
			urls.add(url);
			huc = (HttpURLConnection) (new URL(url).openConnection());

			huc.setRequestMethod("HEAD");

			huc.connect();

			respCode = huc.getResponseCode();

			if (respCode >= 400) {
				System.out.println(url + " is a broken link");
			} else {
				System.out.println(url + " is a valid link");
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	return urls;
	
}

}
