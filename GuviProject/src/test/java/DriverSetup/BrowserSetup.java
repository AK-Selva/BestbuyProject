package DriverSetup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.chrome.ChromeOptions;
public class BrowserSetup {
public	String homePage = "https://www.bestbuy.com/";
	public static WebDriver webDriver;
	@BeforeTest
	public  void setUp() throws IOException{
	//	System.out.println("Before Class");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Desktop\\GuviProject\\GuviProject\\Files\\chromedriver.exe");
		  ChromeOptions ops=new ChromeOptions();
	        ops.addArguments("--headed");
	        webDriver=new ChromeDriver(ops);
		//webDriver = new ChromeDriver();  
		//webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		webDriver.manage().window().maximize();  
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

       // return webDriver;
    }
	public  WebDriver getDriver()
	{
		return webDriver;
	}
	public static String getPageTitle() throws InterruptedException {
		return webDriver.getTitle();
	}
	  void quitDriver() {
        if (null != webDriver) {
            webDriver.quit();
            webDriver = null;
        }
    }
	  @AfterMethod(alwaysRun = true)
	    public void screenShot(ITestResult result){
	        if(ITestResult.FAILURE==result.getStatus()){
	            try{
	               
	                this.takeScreenshot(webDriver);
	            }
	            catch (Exception exception){
	                System.out.println(exception.toString());
	            }
	        }
	    }

    @AfterSuite(alwaysRun = true)
    public  void closeDriverObjects() {
   //   quitDriver();
    }
    
    
    public void takeScreenshot(WebDriver driver) throws IOException {
        File screenshotFile=((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        String time=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithPath="./src/test/resources/screenshots/"+time+".png";
        File DestFile= new File(fileWithPath);
        FileUtils.copyFile(screenshotFile,DestFile);
    }
    
    public String generateRandomPassword(int len){
        String chars="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
                +"jklmnopqrstuvwxyz!@#$%&";
        StringBuilder sb=new StringBuilder(len);
        Random rand=new Random();
        for(int i=0;i<len;i++){
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }
    public long generateRandomNumber(long min,long max){
    	long randomId= (int)(Math.random() * ((max - min) + 1)) + min;
        return randomId;
    }
//	@BeforeClass
//	public void beforeClass()
//	{
//		
//		driver.get("https://bestbuy.com");  
//	}
//	@Test             
//	public void test() {    
//		
//		// get the current URL of the page  
//		String URL= driver.getCurrentUrl();  
//		System.out.print(URL);  
//		//get the title of the page  
//		String title = driver.getTitle();                  
//		System.out.println(title);  
//		}     
//		@BeforeTest  
//		public void beforeTest() {    
//		System.out.println("before test");  
//		}     
//		@AfterTest  
//		public void afterTest() {  
//		driver.quit();  
//		System.out.println("after test");  
//		}  
		
	}


//public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	System.setProperty("webdriver.chrome.driver", "D:\\Eclipse-Code\\GuviProject\\Files\\chromedriver.exe");
//	WebDriver driver = new ChromeDriver();
//	  driver.manage().window().maximize();
//        driver.get("https://bestbuy.com");
//        String title = driver.getTitle();
//        System.out.println(title);      
//      //  driver.quit();  
//}