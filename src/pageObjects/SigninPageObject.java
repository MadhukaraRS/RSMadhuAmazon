package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.GenericMethods;

public class SigninPageObject {
	
		WebDriver driver;
		WebDriverWait wait;
		GenericMethods genericMethods;
		
		public SigninPageObject(WebDriver driver, WebDriverWait wait, GenericMethods genericMethods) {
			this.driver = driver;
			this.wait = wait;
			this.genericMethods = genericMethods;
		}
		
		public String getSignInText( ) {
			String text = genericMethods.getTextByXpath("//a[@id='nav-link-yourAccount']", "FAIL - Sign In text did not display" );
			
		}
		

}
