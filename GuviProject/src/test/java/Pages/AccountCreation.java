package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverSetup.BrowserSetup;

public class AccountCreation {
	public WebDriver webDriver;

	@FindBy(xpath = "//span[@class='v-p-right-xxs line-clamp']")
	public WebElement clickAccountCreation;

	@FindBy(xpath = "//*[@class='utility-flyout flyout-arrow-up flyout-account-menu guest-user']")
	public WebElement account_menu;

	@FindBy(xpath = "//a[normalize-space()='Create Account']")
	public WebElement account_create;

	public AccountCreation(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() throws InterruptedException {
		return BrowserSetup.getPageTitle();
	}

	public boolean clickAccountCreation() {
		if (clickAccountCreation.isDisplayed()) {
			clickAccountCreation.click();
			return true;
		}
		return false;
	}

	public boolean AccountCreationVisibility() {
		if (account_menu.isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean AccountCreationClick() {
		if (account_create.isDisplayed()) {
			account_create.click();
			return true;
		}
		return false;
	}
}
