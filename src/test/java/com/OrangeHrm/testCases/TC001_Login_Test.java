package com.OrangeHrm.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHrm.pageObjects.LoginPage;
import com.OrangeHrm.testBase.BaseClass;

public class TC001_Login_Test extends BaseClass  {
	  //1
	//public WebDriver driver;
	public String expurl ="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	
	/*//2.Launching Browser
	@BeforeClass
	public void setup() {
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}*/
	//3.Opening Application and Login into the application.
	@Test
	public void loginTest() throws IOException {
		logger.info("*******Starting Test Case -TC001_Login_Test***********");
		
		driver.get(prop.getProperty("url"));
		logger.info("Orange HRM application is opened");
		
		LoginPage lpg = new LoginPage(driver);
		logger.info("******** Entering Login Details**********" );
		//logger.info(*****Entering Login Details*****);
		lpg.setUserName(prop.getProperty("userName"));
		logger.info("Username Entered is "+prop.getProperty("userName"));
		
		lpg.setPassword(prop.getProperty("password"));
		logger.info("Password Entered is "+prop.getProperty("password"));
		
		lpg.clickLoginButton();
		
		String actUrl = driver.getCurrentUrl();
		
		if (expurl.equalsIgnoreCase(actUrl)) {
			logger.info("**********Login Successful*************");
			capturesscreen(driver, "loginTest");
			Assert.assertTrue(true);
			
		} else {
			logger.info("**********Login is not Successful*************");
			capturesscreen(driver, "loginTest");//Capturing Screen shot if it is failed
			Assert.assertTrue(false);

		}
		logger.info("*****Ending Test Case - TC001_Login_Test ********");
	}
/*	//4.Closing All the Browsers
	@AfterClass
	 public void teardown() {
		 driver.close();
   	  
     }*/
	

}
     