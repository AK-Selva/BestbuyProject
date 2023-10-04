package PageRunner;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;
import Pages.*;

public class SignupRunner extends BrowserSetup {
	Signup signup = null;
	String email;
	String password;
	String mobile;
	String ValidationTitle = "Create an Account";

	public void basicInfo() {
		String emailUserAcc = "guviautomation2" + generateRandomNumber(1000, 9999);
		email = emailUserAcc + "@mailinator.com";
		password = generateRandomPassword(12);
		mobile = String.valueOf(generateRandomNumber(1000000000L, 9999999999L));
	}

	@Test(priority = 1)
	public void SignUpValidation() throws InterruptedException, IOException {
		try {
			signup = new Signup(webDriver);
			String text = signup.accountCreationVisibleElement();
			Assert.assertEquals(text, ValidationTitle, "Title not equal");
		} catch (Exception e) {
			// BrowserSetup.takeScreenshot(webDriver);
		}
	}

	@Test(priority = 2,description = "User press register button without inputting any data")
	public void blankRegistration() throws InterruptedException, IOException {
		try {
			// SignupPage signupPage=new SignupPage(driver);
			signup.clickCreateAccountButton();
			int count = signup.getErrorCount();
			System.out.println(count);
			Assert.assertEquals(count, 6, "Error Count not matching");
		} catch (Exception e) {
			// BrowserSetup.takeScreenshot(webDriver);
		}
	}

	@Test(priority = 3,description = "Firstname cannot include any digit at last")
	public void invalidFirstName() throws InterruptedException {
		webDriver.navigate().refresh();
		// signup signupPage=new SignupPage(driver);
		List<String> invalidName = signup.invalidFirstName();
		String invalidFirstName = invalidName.get(0);
		// String invalidLastName=invalidName.get(1);
		Assert.assertTrue(invalidFirstName.contains("numeric characters."));
//	        Assert.assertTrue(invalidLastName.contains("lastname is invalid"));
		System.out.println(invalidFirstName);

	}

	@Test(priority = 4,description = "Lastname cannot include any digit at last")
	public void invalidLastName() throws InterruptedException {
		webDriver.navigate().refresh();
		// signup signupPage=new SignupPage(driver);
		List<String> invalidName = signup.invalidLastName();
		String invalidLastName = invalidName.get(0);
		// String invalidLastName=invalidName.get(1);
		Assert.assertTrue(invalidLastName.contains("numeric characters."));
//	        Assert.assertTrue(invalidLastName.contains("lastname is invalid"));
		System.out.println(invalidLastName);

	}

	@Test(priority = 5,description = "After giving valid email No  Error Message")
	public void validEmailandRegisterForm() throws InterruptedException {
//	        driver.get("http://automationpractice.com/");
		// SignupPage signupPage=new SignupPage(driver);
		webDriver.navigate().refresh();
		basicInfo();
		signup.validEmailandRegisterForm(email);
		// after logging with valid email
		int count = signup.getErrorCount();
		System.out.println(count);
		Assert.assertEquals(count, 5, "Error Count not matching");
	}

	@Test(priority = 6,description = "Valid FName,Lname and email No  Error Message")
	public void validFnamelNameEmailandRegisterForm() throws InterruptedException {
//	        driver.get("http://automationpractice.com/");
		// SignupPage signupPage=new SignupPage(driver);
		webDriver.navigate().refresh();
		basicInfo();
		signup.validfNamelNameEmail(email);
		// after logging with valid email
		int count = signup.getErrorCount();
		// System.out.println(count);
		Assert.assertEquals(count, 3, "Error Count not matching");
	}

	@Test(priority =7,description = "No  Error Message all fieled are added")
	public void ValidateAllFields() throws InterruptedException {
		Thread.sleep(1000);
		webDriver.navigate().refresh();
		basicInfo();
		signup.validAllFields(email,password,password,mobile);
		System.out.println(password);
//		signup.PwdandCpwd(password, password);
//		signup.validmobilenumber(mobile);
		// after logging with valid email
		int count = signup.getErrorCount();
		// System.out.println(count);
		boolean exists = signup.AlreadyExistsVisible();
//		if(exists)
//			Assert.fail();
//		else
//		Assert.assertEquals(count, 0, "Error Count not matching");
	}
}
