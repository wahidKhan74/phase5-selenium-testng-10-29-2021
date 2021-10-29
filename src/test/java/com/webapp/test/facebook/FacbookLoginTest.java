package com.webapp.test.facebook;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacbookLoginTest {

	String siteUrl = "https://www.facebook.com/";
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
	void testFacebookHomePage() throws InterruptedException {
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("pass"));
		WebElement submitButton = driver.findElement(By.name("login"));
		
		assertEquals(true, emailInput.isDisplayed());
		assertEquals(true, passwordInput.isDisplayed());
		assertEquals(true, submitButton.isDisplayed());
	}
	
	
	@Test
	void testFacebookloginTest() throws InterruptedException {
		WebElement emailInput = driver.findElement(By.id("email"));
		WebElement passwordInput = driver.findElement(By.id("pass"));
		WebElement submitButton = driver.findElement(By.name("login"));
		
		emailInput.sendKeys("abc@gmail.com");
		passwordInput.sendKeys("abc@123");
		submitButton.submit();
	}

	
}	
