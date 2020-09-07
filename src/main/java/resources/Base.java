package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {
	public WebDriver driver;
	public String webBrowser;

	public WebDriver initializedriver() throws IOException {
		Properties prop = new Properties();
		String filepath = System.getProperty("user.dir");
		String fileLocation = filepath + "\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(fileLocation);
		prop.load(fis);
		
		//invoking Browser Capabilities through maven Command test -Dbrowser=chrome
		webBrowser=System.getProperty("browser");
		//webBrowser = prop.getProperty("browser");
		if (webBrowser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Hari\\installation dump\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		if (webBrowser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Hari\\installation dump\\Drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(options);
			}
		if (webBrowser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\Hari\\installation dump\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public Base(WebDriver driver) {
		this.driver = driver;
	}
public void TakeScreenshot(String method,String testCaseName) {
	String path = System.getProperty("user.dir");
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		 FileUtils.copyFile(src,new File( path + "\\Screenshots\\"+method+"\\" +testCaseName+ ".jpeg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
}
}
