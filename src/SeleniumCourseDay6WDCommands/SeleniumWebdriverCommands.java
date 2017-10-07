
package SeleniumCourseDay6WDCommands;
import java.io.File;
import org.eclipse.jetty.util.Loader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LoggingHandler;
import org.testng.Assert;
import org.testng.Reporter;
import org.yaml.snakeyaml.tokens.DirectiveToken;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;

public class SeleniumWebdriverCommands{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(System.getProperty("os.name").contains("Windows")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"geckodriver.exe");
			}
			else{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+File.separator+"geckodriver");	
			}
		WebDriver driver = new FirefoxDriver();    //Lunches Firefox browser
		Reporter.log("Firefox browser launched successfully", true);
		driver.get("http://automationpractice.com/index.php"); //Launch the URL in the browser
		String title = driver.getTitle();    //Get the Window title
		Reporter.log("Window title is "+ title, true);
		String url = driver.getCurrentUrl();   //Get the Window URL
		Reporter.log("Window URL is "+ url, true);
		String pageSource = driver.getPageSource();   //Get the Page source
		//Reporter.log("Page Source is"+ pageSource, true);
		
		WebElement signIn = driver.findElement(By.xpath("//a[@class='login']")); //Find element using xpath
		String text = signIn.getText();  //Get the text of the webelement
		Reporter.log("Sign In button text is "+ text, true);  
		
		signIn.click();  //Clicks the web element
		String signInTitle = driver.getTitle();  //Gets the window title
		
		/**
		 * Verifies the Sign in Window Title with expected value using if..else statements
		 */
		if(signInTitle.equalsIgnoreCase("LOGIN - My Store")) {
			Reporter.log("PASS - Sign in page displayed successfully", true);
		}else {
			Reporter.log("FAIL - Sign in page did not display successfully", true);
		}
		
		/**
		 * Verifies the Sign in Window Title with expected value using TestNG assertions
		 */
		Assert.assertEquals(signInTitle, "Login - My Store", "FAIL - Sign in page did not display successfully");
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));  //Identify Email field
		email.sendKeys("testautomation88@test.com");  //Enter Email into the email field
		Reporter.log("PASS - Email entered Successfully", true);
		
		WebElement password = driver.findElement(By.id("passwd"));  //Identify Password field
		password.sendKeys("123456");   //Enter Password into the email field
		Reporter.log("PASS - Password entered Successfully", true);
		
		WebElement signInButton = driver.findElement(By.xpath("//button[@id='SubmitLogin']")); //Identify Sign In Button
		signInButton.click();  //Click the Sign In button
		Reporter.log("PASS - Sign in Button Clicked Successfully", true);
		
		String myAccountText = driver.findElement(By.xpath("//h1[@class='page-heading']")).
				getText();   //Identify My account text and fetch it
		
		/**
		 * Verifies the My Account text with the expected value using Test NG assertions
		 */
		Assert.assertEquals(myAccountText, "MY ACCOUNT", "FAIL - My Account page is not displayed");
		
		WebElement signOut = driver.findElement(By.xpath("//a[@class='logout']")); //Identify Sign Out Button
		signOut.click();  //Clicks Signout button
		Reporter.log("PASS - Sign Out Button Clicked Successfully", true);
		
		driver.close();  //Closes the active Firefox browser
	}

}


