package com.webapp.test.group;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BrowserSpecificGroupTest {

	String amzonUrl = "https://www.amazon.in/";
	String facebookUrl = "https://www.facebook.com/";

	String chromePath = "drivers/linux/chromedriver";
	String firefoxPath = "drivers/linux/geckodriver";

	WebDriver driverOne;
	WebDriver driverTwo;
	WebDriverWait wait;

	// test group from chrome
	@Test(groups = "ChromeOnly")
	public void lauchChromeTest() {
		System.setProperty("webdriver.chrome.driver", chromePath);
		driverOne = new ChromeDriver();
		driverOne.get(amzonUrl);
	}

	@Test(groups = "ChromeOnly", dependsOnMethods = "lauchChromeTest", priority = 0)
	void testAmazonHomepage() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driverOne.getTitle();
		assertEquals(expected, actual);
	}

	@Test(groups = "ChromeOnly", dependsOnMethods = "lauchChromeTest", priority = 1)
	void testHompageSource() {
		assertEquals(amzonUrl, driverOne.getCurrentUrl());
	}

	@Test(groups = "ChromeOnly", dependsOnMethods = "lauchChromeTest", priority = 2)
	void testSearch1() {
		// step 5 : evaluate test
		WebElement searchBox = driverOne.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 12 max pro");
		searchBox.submit();

		String expected = "Amazon.in : Iphone 12 max pro";
		String actual = driverOne.getTitle();
		assertEquals(expected, actual);
		driverOne.close();
	}

	// test group for firefox
	@Test(groups = "FirefoxOnly")
	public void lauchFireFoxTest() {
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		driverTwo = new FirefoxDriver();
		driverTwo.get(facebookUrl);
	}
	
	@Test(groups = "FirefoxOnly", dependsOnMethods="lauchFireFoxTest", priority=0)
	void testFacebookHomePage() throws InterruptedException {
		WebElement emailInput = driverTwo.findElement(By.id("email"));
		WebElement passwordInput = driverTwo.findElement(By.id("pass"));
		WebElement submitButton = driverTwo.findElement(By.name("login"));
		
		assertEquals(true, emailInput.isDisplayed());
		assertEquals(true, passwordInput.isDisplayed());
		assertEquals(true, submitButton.isDisplayed());
		Thread.sleep(3000);
	}
	
	@Test(groups = "FirefoxOnly", dependsOnMethods="lauchFireFoxTest", priority=1)
	void testFacebookloginTest() throws InterruptedException {
		WebElement emailInput = driverTwo.findElement(By.id("email"));
		WebElement passwordInput = driverTwo.findElement(By.id("pass"));
		WebElement submitButton = driverTwo.findElement(By.name("login"));
		
		emailInput.sendKeys("abc@gmail.com");
		passwordInput.sendKeys("abc@123");
		submitButton.submit();
		Thread.sleep(3000);
		driverTwo.close();
	}

}
