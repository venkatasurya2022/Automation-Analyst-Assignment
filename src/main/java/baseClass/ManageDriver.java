package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;

public class ManageDriver {
	private static final String CHROME_DRIVER_PATH = "C:\\Users\\user\\Downloads\\webdriver\\chromedriver-win64\\chromedriver.exe";
	private static final String CHROME_BINARY_PATH = "C:\\Users\\user\\Downloads\\webdriver\\chrome-win64\\chrome.exe";
	private static final String EDGE_DRIVER_PATH = "C:\\Users\\user\\Downloads\\webdriver\\edgedriver_win64\\msedgedriver.exe";
	private static final String FIREFOX_DRIVER_PATH = "C:\\Users\\user\\Downloads\\webdriver\\geckodriver-v0.34.0-win64\\geckodriver.exe";
	private WebDriver driver;

	public WebDriver getDriver(String browserName) throws InterruptedException {
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
			ChromeOptions options = new ChromeOptions();
			options.setBinary(CHROME_BINARY_PATH);
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
			driver.manage().window().maximize();
			Thread.sleep(2000);
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
			// EdgeOptions edgeDriverOptions = new EdgeOptions();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			Thread.sleep(2000);
			break;
		default:
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}
		return driver;
	}
	
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}

}
