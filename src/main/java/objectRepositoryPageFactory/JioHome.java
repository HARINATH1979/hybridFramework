package objectRepositoryPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JioHome {
	
	public JioHome(WebDriver driver) {
	PageFactory.initElements(driver,this);
		
	}
	@FindBy(linkText="Sign in / Sign up")
	public WebElement signin;
	
		
	public WebElement signin() {
	return signin;
}
	
	}