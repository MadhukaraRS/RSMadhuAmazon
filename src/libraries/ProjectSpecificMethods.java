package libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.SigninPageObject;

public class ProjectSpecificMethods {

	WebDriver driver;
	WebDriver wait;
	SigninPageObject signIn;
	
		public ProjectSpecificMethods(WebDriver driver, WebDriver wait, SigninPageObject signIn) {
				this.driver = driver;
				this.wait = wait;
				this.signIn = signIn;
		}
		
		public void Login(String email, String password) throws Exception {
			signIn.enterEmail(email);
			signIn.enterPassword(password);
			signIn.clickSignInButton();
		}

}
