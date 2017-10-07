package Amazon;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AmazonLogging {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//Checking the OS and finding the directory
		if(System.getProperty("os.name").contains("Windows")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"geckodriver.exe");
			}
			else{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"geckodriver");	
			}
		
		WebDriver driver = new FirefoxDriver();    //Lunches Firefox browser
		Reporter.log("Firefox browser launched successfully", true);
		
		driver.get("https://www.amazon.in/"); //Launch the URL in the browser
		String title = driver.getTitle();    //Get the Window title
		Reporter.log("Window title is : "+ title, true);
		
		// Compare the window title of home page
		if(title.equalsIgnoreCase("Online Shopping: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")){
			Reporter.log("PASS - Home page displayed successfully", true);
		}else {
			Reporter.log("FAIL - Home page did not display successfully", true);
		}
		
		String url = driver.getCurrentUrl();   //Get the Window URL
		Reporter.log("Window URL is : "+ url, true);
		String pageSource = driver.getPageSource();   //Get the Page source
		
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
		
		WebElement signOut = driver.findElement(By.id("nav-item-signout")); //Identify Sign Out Button
		signOut.click();  //Clicks Signout button
		Reporter.log("PASS - Sign Out Button Clicked Successfully", true);
		
		driver.close();  //Closes the active Firefox browser
		
	}

}
