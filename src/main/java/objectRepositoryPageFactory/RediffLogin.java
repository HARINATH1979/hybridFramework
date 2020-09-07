package objectRepositoryPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLogin {
	
	public RediffLogin(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[(@id = 'login1')]")
	WebElement login1;
	@FindBy(xpath ="//*[(@id = 'password')]")
	WebElement password;
	@FindBy(xpath = "//*[(@name = 'proceed')]")
	WebElement signin;
	
	public WebElement login1() {
		return login1;
	}
	public WebElement password() {
		return password;
	}
	public WebElement signin() {
		return signin;
	}
	
	
	
}
