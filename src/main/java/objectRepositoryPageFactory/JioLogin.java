package objectRepositoryPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JioLogin {
	
	public JioLogin(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[(@id = \"loginfirst_mobileno\")]")
	WebElement mobileno;
	@FindBy(xpath="//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"arrowbtn\", \" \" ))]")
	WebElement submit;
	@FindBy(xpath="//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"btn-login\", \" \" ))]")
	WebElement verify;
	@FindBy(xpath="//*[(@id = \"reg_firstname\")]")
	WebElement firstName;
	@FindBy(xpath="//*[(@id = \"reg_lastname\")]")
	WebElement lastName;
	@FindBy(xpath="//*[(@id = \"reg_email\")]")
	WebElement emailId;
	@FindBy(xpath="//*[(@id = \"register_pwd\")]")
	WebElement password;
	@FindBy(xpath="//*[(@id = \"register_confirm_pwd\")]")
	WebElement confirmpassword;

	

	public WebElement mobileno() {
		return mobileno;

	}

	public WebElement submit() {
		return submit;
	}

	public WebElement verify() {
		return verify;
	}
	
	public WebElement firstName() {
		return firstName;
	}
	
	public WebElement lastName() {
		return lastName;
	}
	
	public WebElement emailId() {
		return emailId;
	}
	
	public WebElement password() {
		return password;
	}

	public WebElement confirmpassword() {
		return confirmpassword;
	}


}
