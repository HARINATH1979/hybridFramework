package objectRepositoryPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffHome {

	public RediffHome(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Sign in")
	WebElement signin;
	
	public WebElement signin() {
		return signin;
	}
	
	
	
	
	

}
