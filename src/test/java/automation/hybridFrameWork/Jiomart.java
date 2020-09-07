package automation.hybridFrameWork;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import objectRepositoryPageFactory.JioHome;
import objectRepositoryPageFactory.JioLogin;
import resources.*;

@Listeners(TestngListener.class)// - this is used inside the program
public class Jiomart {

	public WebDriver driver;
	private static Logger logger = LogManager.getLogger(Jiomart.class.getName());

	@BeforeTest
	void initialise() throws IOException {
		Base driverBase = new Base(driver);
		this.driver = driverBase.initializedriver();
		driver.get("https://www.jiomart.com/");
		driver.manage().window().maximize();
		logger.info("Log Driver Successfully Initialized");
	}

	@Test
	public void JioHome() {
		JioHome hm = new JioHome(driver);
		hm.signin.click();
	}

	@Test(dataProvider = "JioHomeSignin")
	public void JioHomeSignin(String mobileno) throws IOException, InterruptedException {
		JioLogin log = new JioLogin(driver);
		log.mobileno().sendKeys(mobileno);
		log.submit().click();
		Thread.sleep(25000);
		log.verify().submit();
		String Title = driver.getTitle();
		Assert.assertEquals(Title, "Buy Grocery Online at Best Prices Pan India");
		Thread.sleep(15000);
		logger.info("Signin test case successfully executed");
	}

	@AfterTest
	void driverclose() {
		driver.quit();
	}

	@DataProvider
	public String[] JioHomeSignin() {
		String object[] = { "9841688676" };
		return object;
	}

}
