package com.buyproduct.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends DriverFactory {
	

	private static Actions action;
	private static WebDriver driver = createDriver("chrome");
	// = createDriver("chrome");

	public BasePage() {

		PageFactory.initElements(driver, this);

	}

	public static WebDriver baseDriver() {

		driver = createDriver("chrome");
		return driver;
	}
//	

	public static void navigateToURL(String url) {

		driver.get(url);
	}

	public static void sendKeys(By by, String value) {

		// Need to learn about this stuff of WebDriverWait and ExpectedCondition class
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(value);

	}

	public static void click(By by) {

		// Need to learn about this stuff of WebDriverWait and ExpectedCondition class
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();

	}

	public static void hoverTo(By by) {

		action = new Actions(driver);

		action.moveToElement(driver.findElement(by)).perform();

	}

}
