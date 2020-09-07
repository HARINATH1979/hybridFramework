package objectRepositoryPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login {
	private WebDriver driver;
	public Login(WebDriver driver) {
	this.driver = driver;
	}

	By mobileno = By.xpath("//*[(@id = \"loginfirst_mobileno\")]");
	By submit = By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"arrowbtn\", \" \" ))]");
	By verify = By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"btn-login\", \" \" ))]");
	By firstName = By.xpath("//*[(@id = \"reg_firstname\")]");
	By lastName = By.xpath("//*[(@id = \"reg_lastname\")]");
	By emailId = By.xpath("//*[(@id = \"reg_email\")]");
	By password = By.xpath("//*[(@id = \"register_pwd\")]");
	By confirmpassword = By.xpath("//*[(@id = \"register_confirm_pwd\")]");
	
	

	public WebElement mobileno() {
		return driver.findElement(mobileno);
	}

	public WebElement submit() {
		return driver.findElement(submit);
	}

	public WebElement verify() {
		return driver.findElement(verify);
	}
	
	public WebElement firstName() {
		return driver.findElement(firstName);
	}
	
	public WebElement lastName() {
		return driver.findElement(lastName);
	}
	
	public WebElement emailId() {
		return driver.findElement(emailId);
	}
	
	public WebElement password() {
		return driver.findElement(password);
	}

	public WebElement confirmpassword() {
		return driver.findElement(confirmpassword);
	}


}
