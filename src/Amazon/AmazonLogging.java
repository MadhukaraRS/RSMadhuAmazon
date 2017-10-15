package Amazon;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraries.ProjectSpecificMethods;
import libraries.Utilities;
import pageObjects.MyAccountPageObject;
import pageObjects.SigninPageObject;

/**
 * This class file contains Test scripts
 * @author Madhukara R S
 */
public class AmazonLogging {

		public static int i =0;
		WebDriver driver;
		WebDriverWait wait;
		Utilities utilities = new Utilities();
		SigninPageObject signIn;
		MyAccountPageObject myAccount;
		ProjectSpecificMethods projectSpecificMethods;
			
		
		
		@BeforeTest
		public void startBrowser() {
			driver = utilities.launchBrowser();
			wait = new WebDriverWait(driver, 30);
			signIn = new SigninPageObject(driver, wait);
			myAccount = new MyAccountPageObject(driver, wait);
			ProjectSpecificMethods = new ProjectSpecificMethods(driver, wait);
			
			
		}
		
		@Test(enabled = true)
		public void webdriverCommands() {
		//Find Sign In element using xpath
		WebElement signIn = driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']")); 
		String text = signIn.getText();  //Get the text of the webelement
		Reporter.log("Sign In button text is:  "+ text, true);
		
		signIn.click();  //Clicks the web element
		String signInTitle = driver.getTitle();  //Gets the window title
		
		// Verifies the Sign in Window Title with expected value using if..else statements
		 
		if(signInTitle.equalsIgnoreCase("Amazon Sign In")) {
			Reporter.log("PASS - Sign in page displayed successfully", true);
		}else {
			Reporter.log("FAIL - Sign in page did not display successfully", true);
		}
		
			
		// Verifies the Sign in Window Title with expected value using TestNG assertions
		Assert.assertEquals(signInTitle, "Amazon Sign In", "FAIL - Sign in page did not display successfully");
		
				
		WebElement email = driver.findElement(By.id("ap_email"));  //Identify Email field
		email.sendKeys("8147808493");  //Enter Email into the email field
		Reporter.log("PASS - Email entered Successfully", true);
		
		WebElement password = driver.findElement(By.id("ap_password"));  //Identify Password field
		password.sendKeys("Madhu@87");   //Enter Password into the password field
		Reporter.log("PASS - Password entered Successfully", true);
		
		WebElement signInButton = driver.findElement(By.id("signInSubmit")); //Identify Sign In Button
		signInButton.click();  //Click the Sign In button
		Reporter.log("PASS - Sign in Button Clicked Successfully", true);
		
		WebElement myAccount = driver.findElement(By.id("nav-link-yourAccount")); //Identify User Account
		myAccount.click(); //Click the User Account
		Reporter.log("PASS - User Account Clicked Successfully", true);
		
		String myAccountText = driver.findElement(By.xpath("//div[@class='a-row a-spacing-base']")).
				getText();   //Identify My account text and fetch it
		
		//Verifies the My Account text with the expected value using Test NG assertions
		Assert.assertEquals(myAccountText, "Your Account", "FAIL - My Account page is not displayed");
		
		WebElement account = driver.findElement(By.xpath("//div[@class='a-row a-spacing-base']/h1"));
		Actions action = new Actions(driver);
		action.moveToElement(account).build().perform();
		WebElement signOut = driver.findElement(By.id("nav-item-signout"));
		action.moveToElement(signOut).click().build().perform();
		
		driver.close();  //Closes the active Firefox browser
		
	}

		@AfterTest
		public void endBrowser() {
			
		}
}
