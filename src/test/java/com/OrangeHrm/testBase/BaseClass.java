package com.OrangeHrm.testBase;
//In this base class mostly we try to manage the data which we use in every Testcase before and after
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	  //1.
		public WebDriver driver;  //initialising Webdriver
		public Properties prop;  //intialising Properties file
	
		public Logger logger = LogManager.getLogger(this.getClass()); 
		
		//2.Launching Browser
		@BeforeClass
		@Parameters("browser")
		public void setup(String br) throws IOException {
			
			prop = new Properties();//calling properties in setup method
			FileInputStream fis = new FileInputStream(".\\resources\\config.properties");
			prop.load(fis);
			
						
			/*WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();*/
			if (br.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromiumdriver().setup();
				driver = new ChromeDriver();
			} else if (br.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}else if (br.equalsIgnoreCase("")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}else {
				System.out.println("Please pass chrome / firefox / ie as browser names");
			}
			driver.manage().window().maximize();
		}
		
		//4.Closing All the Browsers
		@AfterClass
		 public void teardown() {
			 driver.quit();
		}
		//This method is for capturing screenshots
		public void capturesscreen(WebDriver driver, String testName) throws IOException {
			TakesScreenshot ts= (TakesScreenshot)driver;
			File source =ts.getScreenshotAs(OutputType.FILE);  //Screenshot is saved in source
			File target = new File(System.getProperty("user.dir")+"\\screenshots\\"+ testName + ".png");
			//url location with path associate with test name+file formate as .png
			FileUtils.copyFile(source, target);
			//copying file from sorce and copying in target by using FileUtils
			System.out.println("Captured Screen Shot");
		}
}
