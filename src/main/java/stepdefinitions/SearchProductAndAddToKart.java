package stepdefinitions;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.awt.event.KeyEvent;

import org.checkerframework.checker.units.qual.m;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import baseClass.ManageDriver;

import io.cucumber.java.en.*;
import utlities.MethodActions;

public class SearchProductAndAddToKart {
	private static WebDriver driver;
	private ManageDriver browserManager = new ManageDriver();
	public static List<WebElement> laptopResults;
	public static String mainWindow;

	@Given("I open the {string} browser")
	public void iOpenTheBrowser(String browserName) throws Exception {
		driver = browserManager.getDriver(browserName);
	}

	@When("I navigate to Flipkart website")
	public void iNavigateToFlipkartWebsite() {
		driver.get("https://www.flipkart.com/");
		// Popup not found or closed
		try {
			WebElement closePopup = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			closePopup.click();
		} catch (Exception e) {

		}
		String Title = driver.getTitle();
		System.out.println(Title);
		if (Title.equals(
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!")) {
			System.out.println("Applicatio is opened");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@When("I search for {string}")
	public void iSearchFor(String searchTerm) {
		WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
		if (searchBox.isDisplayed()) {
			System.out.println("homepage is loaded successfully");
		}
		searchBox.sendKeys("Laptops");
		searchBox.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		laptopResults = driver.findElements(By.xpath("//a[@class='_1fQZEK']"));

	}

	@When("I click on the first Laptop")
	public void iClickOnTheFirstMobile() throws InterruptedException {
		WebElement firstProduct = laptopResults.get(20);
		firstProduct.click();
		System.out.println("clicked on the product");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		mainWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String handle : handles) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle);
				System.out.println("Switched to next window");
				break;
			}
		}
		Thread.sleep(3000);
	}

	@When("I add the Laptop to the cart and close browser")
	public void iAddTheMobileToTheCartandclosebrowser() throws InterruptedException, AWTException {
		MethodActions.zoomOut();
		WebElement addToCartButton = driver.findElement(By
				.xpath("//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		addToCartButton.click();

		Thread.sleep(3000);
		WebElement addItemButton = driver.findElement(By.xpath("//span[contains(text(),'Add Item')]"));

		addItemButton.click();
		driver.close();
		driver.switchTo().window(mainWindow);
		driver.quit();
	}

	public static void enterOTP() throws InterruptedException {
		Thread.sleep(3000);
		WebElement otpInput = driver.findElement(By.cssSelector(
				"div._1eztQ7 div.row._7SvF2e div._3efVlV div.rvsx1l:nth-child(1) div._3E8aIl.gGqMBW div.cQZ0Lf div._11Elaw.row div.col.col-5-12 div._1XHoKS form:nth-child(1) div.IiD88i.GtCYSF:nth-child(2) > input._2IX_2-._3mctLh._17N0em"));
		String generatedOTP = userOTPInput();
		otpInput.clear();
		// Enter the OTP in the input field
		otpInput.sendKeys(generatedOTP);

		System.out.println(generatedOTP);
	}

	private static String userOTPInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter OTP:");
		sc.close();
		return sc.nextLine();
	}

}
