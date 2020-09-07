package automation.hybridFrameWork;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import objectRepositoryPageFactory.*;
import resources.*;

@Listeners(TestngListener.class) //- - this is used inside the program
public class Outlook {
	public WebDriver driver;
	private static Logger logger = LogManager.getLogger(Outlook.class);

	@BeforeTest
	void initialise() throws IOException {
		logger.info("Initializing of Driver Started");
		Base driverBase = new Base(driver);
		this.driver = driverBase.initializedriver();
		driver.get("https://www.outlook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.info("Log Driver Successfully Initialized");
	}

	@Test
	public void OutlookHome() {
	OutlookHome hm = new OutlookHome(driver);
	hm.signin.click();
	logger.info("successfuly clicked on Sign in page");
	}

	@Test(dataProvider = "OutlookLogin")
	public void OutlookLogin(String userid, String password) throws InterruptedException {
		OutlookLogin log = new OutlookLogin(driver);
		log.userid().sendKeys(userid);
		log.submit().click();
		log.passwd().sendKeys(password);
		log.button().click();
		logger.info("SignUp test case successfully executed");
	}

	@AfterTest
	void driverclose() throws InterruptedException {
	Thread.sleep(5000);
	driver.quit();
	logger.info("successfully browser is closed");
	}

	@DataProvider
	public String[][] OutlookLogin() {
		String object[][] = { { "Harinath.veluru@outlook.com", "Outlook1979#" } };
		return object;
	}
	
	
}
