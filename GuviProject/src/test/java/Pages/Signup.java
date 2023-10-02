package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DriverSetup.BrowserSetup;

public class Signup {
	public WebDriver webDriver;

//	@FindBy(xpath = "//span[@class='v-p-right-xxs line-clamp']")
//	public WebElement clickAccountCreation;
//
//	@FindBy(xpath = "//*[@class='utility-flyout flyout-arrow-up flyout-account-menu guest-user']")
//	public WebElement account_menu;
//
	@FindBy(xpath = "//h1[contains(text(),'Create an Account')]")
	public WebElement account_create_title;

	@FindBy(xpath = "//button[contains(text(),'Create an Account')]")
	public WebElement account_create_button;

	@FindBy(xpath = "//input[@id='firstName']")
	public WebElement firstNameTextBox;

	@FindBy(xpath = "//input[@id='lastName']")
	public WebElement lastNameTextBox;

	@FindBy(xpath = "//input[@id='email']")
	public WebElement emailTextBox;

	@FindBy(xpath = "//input[@id='fld-p1']")
	public WebElement pwdTextBox;

	@FindBy(xpath = "//input[@id='reenterPassword']")
	public WebElement reenterPasswordTextBox;

	@FindBy(xpath = "//input[@id='phone']")
	public WebElement phoneTextBox;

	@FindBy(xpath = "//div[@class='tb-validation']/p[contains(text(),'Too many numeric characters')]")
	public List<WebElement> errorMessages;
//@FindBy(xpath = "//div[@class='tb-validation']")
//public WebElements totalErrors;

	public Signup(WebDriver driver) {
		this.webDriver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() throws InterruptedException {
		return BrowserSetup.getPageTitle();
	}

	public String accountCreationVisibleElement() {
		if (account_create_title.isDisplayed()) {

			return account_create_title.getText();
		}
		return null;
	}

	// Negative Test cases
	public void clickCreateAccountButton() {
		if (account_create_button.isDisplayed()) {

			account_create_button.click();
		}

	}

	public int getErrorCount() {
		List<WebElement> elements = webDriver.findElements(By.xpath("//div[@class='tb-validation']"));
		int elementsCount = elements.size();
		return elementsCount;
	}

	public List<String> invalidFirstName() throws InterruptedException {
		firstNameTextBox.click();
		Thread.sleep(1000);
		firstNameTextBox.sendKeys("Test" + (1000));
		Thread.sleep(1000);
		clickCreateAccountButton();
		List<String> invalidName = new ArrayList<>();
		invalidName.add(errorMessages.get(0).getText());
		return invalidName;
	}

	public List<String> invalidLastName() throws InterruptedException {
		lastNameTextBox.click();
		Thread.sleep(1000);
		lastNameTextBox.sendKeys("Test" + (1000));
		Thread.sleep(1000);
		clickCreateAccountButton();
		List<String> invalidName = new ArrayList<>();
		invalidName.add(errorMessages.get(0).getText());
		return invalidName;
	}

	public void validEmailandRegisterForm(String email) throws InterruptedException {
		//webDriver.navigate().refresh();
		Thread.sleep(1000);
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		// this.email = email;
		Thread.sleep(1000);
		clickCreateAccountButton();
		Thread.sleep(1200);
	}

	public void validAllFields(String email,String pwd,String cpwd,String mobile)throws InterruptedException {
		Thread.sleep(1000);
		firstNameTextBox.click();
		Thread.sleep(1000);
		firstNameTextBox.sendKeys("firstname");
		Thread.sleep(1000);
		lastNameTextBox.click();
		Thread.sleep(1000);
		lastNameTextBox.sendKeys("lastname");
		Thread.sleep(1000);
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		// this.email = email;
		Thread.sleep(1000);
		pwdTextBox.click();
		Thread.sleep(1000);
		pwdTextBox.sendKeys(pwd);
		Thread.sleep(1000);
		reenterPasswordTextBox.click();
		Thread.sleep(1000);
		reenterPasswordTextBox.sendKeys(pwd);
		validmobilenumber(mobile);
	}
	
	public void validfNamelNameEmail(String email)throws InterruptedException {
		firstNameTextBox.click();
		Thread.sleep(1000);
		firstNameTextBox.sendKeys("firstname");
		Thread.sleep(1000);
		lastNameTextBox.click();
		Thread.sleep(1000);
		lastNameTextBox.sendKeys("lastname");
		Thread.sleep(1000);
		emailTextBox.clear();
		emailTextBox.sendKeys(email);
		// this.email = email;
		Thread.sleep(1000);
		clickCreateAccountButton();
		
	}
	
	public void PwdandCpwd(String pwd,String cpwd)throws InterruptedException
	{
		pwdTextBox.click();
		Thread.sleep(1000);
		pwdTextBox.sendKeys(pwd);
		Thread.sleep(1000);
		reenterPasswordTextBox.click();
		Thread.sleep(1000);
		reenterPasswordTextBox.sendKeys(pwd);
		clickCreateAccountButton();
		Thread.sleep(1200);
	}
	public void validmobilenumber(String mobile)throws InterruptedException
	{
		phoneTextBox.click();
		Thread.sleep(1000);
		phoneTextBox.sendKeys(mobile);
		clickCreateAccountButton();
		Thread.sleep(1200);
	}
}
