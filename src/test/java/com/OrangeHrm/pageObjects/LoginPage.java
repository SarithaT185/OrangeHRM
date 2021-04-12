package com.OrangeHrm.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//1-Intiating Driver
	public WebDriver driver;
	
	//2-Creating Constructor
    public LoginPage(WebDriver driver) {
    	this.driver = driver ;//Assigning the driver passed from Test Case to local Webdriver driver
    	PageFactory.initElements(driver, this);
    }
    //3-Locator for Username
    @FindBy(id="txtUsername")  //webelement
    @CacheLookup //To Improve the performance of locating elements
    
    WebElement txtUsername;   //WebElement variable 
 
    //4-Locator for Password
    @FindBy(id="txtPassword")
    @CacheLookup  
    WebElement txtPassword;


    //5-Locator for Login Button
    @FindBy(id = "btnLogin")
    @CacheLookup
    WebElement btnLogin;

    //Locatorfor Welcomeusernamelnk 
    @FindBy(id="welcome")
    @CacheLookup
    WebElement lnkwelcome;

    //Locator for link logout after clicking on Welcomeusername link
    @FindBy(xpath="//a[contains(text(),'Logout')]")
    @CacheLookup
    WebElement lnkLogout;
    
    //6.Entering Username.
    public void setUserName(String uname) {
    	txtUsername.clear();
    	txtUsername.sendKeys(uname);
    	
    }
    
    //7.Entering Password.
    public void setPassword(String pword ) {
    	txtPassword.clear();
    	txtPassword.sendKeys(pword);	
    }
    
    //Clicking on Login button
    public void clickLoginButton() {
    	btnLogin.click();
    }
    
}
 
