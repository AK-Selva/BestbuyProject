package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Signout {
	public WebDriver webDriver;
	public Signout(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String logout() throws InterruptedException
	{
		WebElement element = webDriver.findElement(By.xpath("//span[@class='v-p-right-xxs line-clamp']"));
		element.click();
		Thread.sleep(1000);
		WebElement logoutelement = webDriver.findElement(By.xpath("//button[@id='logout-button-bby']"));
		logoutelement.click();
		
		return webDriver.getCurrentUrl();
	}
}
