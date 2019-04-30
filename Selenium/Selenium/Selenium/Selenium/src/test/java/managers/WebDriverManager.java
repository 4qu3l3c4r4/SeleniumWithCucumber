package managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import enums.DriverType;
import enums.EnvironmentType;
import util.Constants;

public class WebDriverManager {
	static WebDriver driver;
	//private static DriverType driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	private static EnvironmentType environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
	private static final String FIREFOX_DRIVER_PROPERTY="webdriver.gecko.driver";

	
	public static WebDriver getDriver(DriverType driverType) {
		//if (driver == null)
			driver = createDriver(driverType);
		return driver;
	}

	private static WebDriver createDriver(DriverType driverType) {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver( driverType);
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private static WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	@SuppressWarnings("deprecation")
	private static WebDriver createLocalDriver(DriverType driverType) {
		switch (driverType) {
		case FIREFOX:
			System.setProperty(	FIREFOX_DRIVER_PROPERTY,
					Constants.FIREFOX_DRIVER);
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY,
					Constants.CHROME_DRIVER);
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability("requireWindowFocus", true);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			System.setProperty(IE_DRIVER_PROPERTY,
					Constants.IE_DRIVER);
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			break;
		case CHROMEHEADLESS:
			System.setProperty(CHROME_DRIVER_PROPERTY,
					Constants.CHROME_DRIVER);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1200x600");
			driver = new ChromeDriver(options);
			break;
		}

		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}