package com.webapp.test.amazon;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonSearchTest {
	
	String siteUrl = "https://www.amazon.in/";
	String driverPath = "drivers/linux/chromedriver";
	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(siteUrl);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
	
	@Test
	void testSearch1() {
		// step 5 : evaluate test
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 12 max pro");
		searchBox.submit();

		String expected = "Amazon.in : Iphone 12 max pro";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	void testSearch2() {
		// step 5 : evaluate test
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("Iphone 11 max");
		searchBox.submit();

		String expected = "Amazon.in : Iphone 11 max";
		String actual = driver.getTitle();
		assertEquals(expected, actual);
	}
}	
