package objectRepositoryPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OutlookLogin {

	public OutlookLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@name='loginfmt']")
	WebElement userid;
	@FindBy(xpath = "//*[@type='submit']")
	WebElement submit;
	@FindBy(xpath = "//*[@name='passwd']")
	WebElement passwd;
	@FindBy(xpath = "//*[(@id = 'idSIButton9')]")
	WebElement button;

	public WebElement userid() {
		return userid;

	}

	public WebElement submit() {
		return submit;
	}
	public WebElement passwd() {
		return passwd;
	}
	public WebElement button() {
		return button;
	}

}
