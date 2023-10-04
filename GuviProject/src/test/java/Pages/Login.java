package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Login {
	public WebDriver webDriver;

	public Login(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public String loginPage(String url) throws InterruptedException {
		webDriver.get(url);
		Thread.sleep(1000);
		WebElement element = webDriver.findElement(By.xpath("//span[@class='v-p-right-xxs line-clamp']"));
		element.click();
		Thread.sleep(8000);
		WebElement logoutelement = webDriver.findElement(By.xpath("//a[normalize-space()='Sign In']"));
		logoutelement.click();

		return webDriver.getTitle();
	}

	public String validLoginDetails() throws InterruptedException {
		WebElement element = webDriver.findElement(By.xpath("//input[@id='fld-e']"));
		element.click();
		element.sendKeys("guviautomation2000@gmail.com");
		Thread.sleep(1000);
		WebElement passwordElement = webDriver.findElement(By.xpath("//input[@id='fld-p1']"));
		passwordElement.click();
		passwordElement.sendKeys("password@Cbe2023");
		Thread.sleep(5000);
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement SubmitElement = webDriver.findElement(By.xpath("//button[@type='submit']"));
		SubmitElement.click();
		return webDriver.getTitle();
	}
}
