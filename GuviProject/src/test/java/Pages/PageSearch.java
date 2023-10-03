package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;

public class PageSearch {
	public WebDriver webDriver;
	@FindBy(xpath = "//input[@id='gh-search-input']")
	public WebElement menu;
	@FindBy(xpath = "//*[name()='path' and contains(@d,'M19.25 7.5')]")
	public WebElement Pagemenu;
//	@FindBy(xpath = "//div[@id='shop-sku-list-item-70039822']//a[contains(text(),'Dell - Inspiron 14.0\" 2-in-1 Touch Laptop - 13th Gen Intel Core i7 - 16GB Memory - 1TB SSD - Platinum Silver')]")
//	public WebElement item;
	@FindBy(xpath = "//span[normalize-space()='$999.99']")
	public WebElement itemprice;

	@FindBy(xpath = "//button[normalize-space()='Brands']")
	public WebElement Brands;
	@FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/*/a[contains(text(),'Best Buy Brands')]")
	public WebElement BestBuyBrands;

	@FindBy(xpath = "//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/*/a[contains(text(),'Lenovo')]")
	public WebElement Apple;

	public PageSearch(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
		// driver.get("https://www.bestbuy.com/");
	}

	public String SearchBox() throws InterruptedException {
		if (menu.isDisplayed()) {
			// this.highLighterMethod(webDriver, topdeals);
			Thread.sleep(1000);
			menu.click();
			menu.sendKeys("laptop");
			menu.sendKeys(Keys.ENTER);
			System.out.println("SearchBox Clicked");

		}
		return webDriver.getTitle();
	}

	public List<String> AddToCart(List<String> items) throws InterruptedException {
		Thread.sleep(1000);
//	  WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
//      new Actions(webDriver)
//              .scrollFromOrigin(scrollOrigin, 0,4000)
//              .perform();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,500)", "");
//      
		Thread.sleep(1000);
		WebElement AddtoCart = webDriver.findElement(By.xpath(
				"//div[contains(@class,'fulfillment-add-to-cart-button')]//div//div//button[contains(@type,'button')][normalize-space()='Add to Cart'][@data-sku-id='6539910']"));
		// String itemName=item.getText();
		// items.add(itemName);
		AddtoCart.click();
		Thread.sleep(1000);
		WebElement closepopup = webDriver.findElement(By.xpath("//*[@class='c-modal-window attach-modal active']"));
		if (closepopup.isEnabled() || closepopup.isDisplayed()) {
			WebElement continueShop = webDriver.findElement(By.xpath(
					"//*[@class='c-button-link continue-shopping' and normalize-space(text())='Continue shopping']"));
			continueShop.click();
		}
		return null;
	}

	public void ShopbyDepartment() throws InterruptedException {
		if (Pagemenu.isDisplayed()) {
			Pagemenu.click();
			System.out.println("Menu Clicked");
		}
		WebElement element = webDriver.findElement(By.xpath("//button[normalize-space()='Computers & Tablets']"));
		element.click();
		WebElement element1 = webDriver.findElement(By.xpath("//button[normalize-space()='Monitors']"));
		element1.click();
		WebElement element2 = webDriver.findElement(By.xpath(
				"//ul[@class='hamburger-menu-flyout-list hamburger-menu-flyout-sidecar-list']/*/a[contains(text(),'4K')]"));
		element2.click();
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,500)", "");
		WebElement AddtoCart = webDriver.findElement(By.xpath(
				"//div[contains(@class,'fulfillment-add-to-cart-button')]//div//div//button[contains(@type,'button')][normalize-space()='Add to Cart'][@data-sku-id='6511336']"));
		// String itemName=item.getText();
		// items.add(itemName);
		AddtoCart.click();
		Thread.sleep(1000);
		WebElement closepopup = webDriver.findElement(By.xpath("//*[@class='c-modal-window attach-modal active']"));
		if (closepopup.isEnabled() || closepopup.isDisplayed()) {
			WebElement continueShop = webDriver.findElement(By.xpath(
					"//*[@class='c-button-link continue-shopping' and normalize-space(text())='Continue shopping']"));
			continueShop.click();
		}
		menuBrands();
		AppleBrands();
		// JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollBy(0,600)", "");

		WebElement ele = webDriver.findElement(By.xpath("//div[@class='row v-m-vertical-l']//img[@alt='Laptop']"));
		ele.click();
		js.executeScript("window.scrollBy(0,600)", "");
		WebElement AddtoCart1 = webDriver.findElement(By.xpath(
				"//div[contains(@class,'fulfillment-add-to-cart-button')]//div//div//button[contains(@type,'button')][normalize-space()='Add to Cart'][@data-sku-id='6531746']"));
		// String itemName=item.getText();
		// items.add(itemName);
		AddtoCart1.click();
		WebElement continueShop = webDriver.findElement(By.xpath(
				"//*[@class='c-button-link continue-shopping' and normalize-space(text())='Continue shopping']"));
		continueShop.click();
		cartPayment();
	}

	public void menuBrands() throws InterruptedException {
		if (Pagemenu.isDisplayed())

		{
			Pagemenu.click();
			System.out.println("Menu Clicked");
		}
		if (Brands.isDisplayed()) {
//			this.highLighterMethod(webDriver, Brands);
//			Thread.sleep(1000);
			Brands.click();
			System.out.println("Brands Clicked");

		}

	}

	public void AppleBrands() throws InterruptedException {
//	menuBrands();
		if (Apple.isDisplayed()) {
			// this.highLighterMethod(webDriver, Apple);
			Thread.sleep(1000);
			Apple.click();
			System.out.println("Apple Clicked");
			Assert.assertEquals(webDriver.getTitle(), "Lenovo Computers - Best Buy");
		}
	}

	public void cartPayment() throws InterruptedException {
		WebElement element = webDriver.findElement(By.xpath("//span[@class='cart-label']"));
		element.click();
		Assert.assertEquals(webDriver.getTitle(), "Cart - Best Buy", "Not Moved to cart Page");
		WebElement element1 = webDriver.findElement(By.xpath("//button[normalize-space()='Checkout']"));
		element1.click();

		//Assert.assertEquals(webDriver.getTitle(), "Checkout – Best Buy", "Not Moved to cart Page");

		//WebElement elementGuest = webDriver.findElement(By.xpath("//span[normalize-space()='Getting your order']"));
		
		WebElement element2 = webDriver.findElement(By.xpath("//button[@class='c-button c-button-secondary c-button-lg cia-guest-content__continue guest'][normalize-space()='Continue as Guest']"));
		element2.click();

		//Assert.assertEquals(element2.getText(), "Getting your order", "Not Getting your order");

		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebElement Email = webDriver.findElement(By.xpath("//div[@class='clearFloat']/input[@class='tb-input'][@id='user.emailAddress']"));
		Email.click();
		Email.sendKeys("guviautomation2000@gmail.com");
		
		WebElement mobile = webDriver.findElement(By.xpath("//div[@class='clearFloat']/input[@class='tb-input'][@id='user.phone']"));
		mobile.click();
		mobile.sendKeys("9876541230");
		
		WebElement element3 = webDriver
				.findElement(By.xpath("//span[normalize-space()='Continue to Payment Information']"));
		element3.click();
	}
}
