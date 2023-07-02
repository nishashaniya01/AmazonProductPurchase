package com.buyproduct.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.buyproduct.utils.BasePage;
import com.buyproduct.utils.DriverFactory;

public class LoginPage extends BasePage {

	private static WebDriver driver = baseDriver();
	public static LoginPage lp;

	public LoginPage() {

		// it is now pointing to the constructor of BasePage class using super()
		// functionality
		super();
	}

	/*
	 * Amazon Login Page By Locators
	 */

	private static By signinButtonHover = By
			.xpath("//span[@id='nav-link-accountList-nav-line-1' and text()='Hello, sign in']");
	private static By signButton = By.xpath(
			"//div[@id='nav-flyout-ya-signin']/a[@class='nav-action-signin-button']/span[contains(text(),'Sign in')]");
	private static By emailormobTextField = By.xpath("//div[@class='a-row a-spacing-base']//input[@name='email']");

	private static By continueButton = By.id("continue");
	private static By condition1 = By.xpath("//div[@id='legalTextRow']/a[1]");
	private static By NeedHelp = By.xpath(
			"(//div[@class='a-section'])[position()=3]//div[@class='a-row a-expander-container a-expander-inline-container']//span[@class='a-expander-prompt']");

	private static By password = By.xpath("//input[@id='ap_password']");
	private static By buttonSignin = By.id("signInSubmit");
	private static By rememberMeCheckbox = By.xpath("//div[@class='a-checkbox']//input[@name='rememberMe']");

	public String getloginPageTitle() {

		return driver.getTitle();

	}

	public static void navigateToAmazonSite() {

		navigateToURL("https://www.amazon.in/");
	}
	
	public static void sendKeyToSignIn(String value) {
		
		sendKeys(emailormobTextField, value);
	}
	
	
	public static void sendkey2password(String value) {
		
		sendKeys(password, value);
	}
	
	public static void clickToContinueButton() {
		
		click(continueButton);
	}
	
	public static void clicktoButton() {
		
		click(buttonSignin);
		
	}
	
	public static void quitDriver() {
		
		driver.quit();
		driver.close();
	}
}
