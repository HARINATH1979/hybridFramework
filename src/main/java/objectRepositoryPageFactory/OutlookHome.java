package objectRepositoryPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OutlookHome {
	public OutlookHome(WebDriver driver) {
	PageFactory.initElements(driver,this);
		
	}
	@FindBy(linkText="Sign in")
	public WebElement signin;
	
		
	public WebElement signin() {
	return signin;
}
	
}
