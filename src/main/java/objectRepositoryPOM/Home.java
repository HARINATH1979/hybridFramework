package objectRepositoryPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
	private WebDriver driver;
	public Home(WebDriver driver) {
	this.driver = driver;
	}
	By signin = By.linkText("Sign in / Sign up");
			
	public WebElement signin() {
	return driver.findElement(signin);
}
	}