package automation.hybridFrameWork;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import objectRepositoryPageFactory.RediffHome;
import objectRepositoryPageFactory.RediffLogin;
import resources.Base;
import resources.TestngListener;

@Listeners(TestngListener.class)//- - this is used inside the program
public class Rediff {

	public WebDriver driver;
	private static Logger logger = LogManager.getLogger(Rediff.class);

	@BeforeTest
	void initialise() throws IOException {
		Base driverBase = new Base(driver);
		this.driver = driverBase.initializedriver();
		driver.get("https://www.rediffmail.com");
		driver.manage().window().maximize();
		logger.info("Log Driver Successfully Initialized");
	}

	@Test
	public void RediffHome() {
		RediffHome hm = new RediffHome(driver);
		hm.signin().click();
		logger.info("sign in Link Clicked Successfully");
	}

	@Test(dataProvider = "RediffLogin")
	public void RediffLogin(String loginName, String password) {
		RediffLogin log = new RediffLogin(driver);
		log.login1().sendKeys(loginName);
		log.password().sendKeys(password);
		log.signin().submit();
		logger.info("SignUp test case successfully executed");
	}

	@AfterTest
	void driverclose() {
		driver.quit();
	}

	@DataProvider
	public String[][] RediffLogin() {
		String object[][] = { { "Harinath.veluru@rediffmail.com", "Outlook1979#" } };
		return object;
	}
}
