package com.buyproduct.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import com.buyproduct.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.buyproduct.utils.BasePage;

public class LoginPageSteps extends BasePage {

	private static WebDriver driver;
	private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();

	@Before
	public void startDriver() {

		System.setProperty("webdriver.http.factory", "jdk-http-client");
		ChromeOptions options = new ChromeOptions();
//		// Used by default, waits for all resources to download
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		driver = new ChromeDriver(options);

		tldriver.set(new ChromeDriver(options));
		driver = tldriver.get();

	}

	@After
	public void closeDriver() {

		driver.close();
		driver.quit();
	}
	// private LoginPage lp;

//	public LoginPageSteps(LoginPage lp) {
//
//		this.lp = lp;
//	}

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

//	@Given("^User is in Amazon.in website$")
//	public void user_is_in_amazon_in_website() {
//
//		// lp.navigateToURL("https://www.amazon.in/");
//		lp.navigateToAmazonSite();
//	}
//
//	@When("^User hovers to signIn text$")
//	public void user_hovers_to_sign_in_text() {
//
//		hoverTo(signinButtonHover);
//
//	}
//
//	@And("^Click to signIn button$")
//	public void click_to_sign_in_button() {
//		click(signButton);
//	}
//
//	@And("^I entered the valid \"(.*)\" and clicks to button$")
//	public void I_entered_the_valid_and_clicks_to_button(String mobileNumber) throws InterruptedException {
//		lp.sendKeyToSignIn(mobileNumber);
//		Thread.sleep(3000);
//		lp.clickToContinueButton();
//	}
//
//	@And("now {string} and clicks to button")
//	public void now_and_clicks_to_button(String password) throws InterruptedException {
//
//		lp.sendkey2password(password);
//		click(rememberMeCheckbox);
//		lp.clicktoButton();
//		Thread.sleep(8000);
//
//	}
//
//	@Then("^validate user gets land to homepage$")
//	public void validate_user_gets_land_to_homepage() {
//
//		System.out.print("test completed!!!");
//
//	}

	@Given("^User is in Amazon.in website$")
	public void user_is_in_amazon_in_website() {

		driver.get("https://www.amazon.in/");
	}

	@When("^User hovers to signIn text$")
	public void user_hovers_to_sign_in_text() {

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(signinButtonHover)).perform();

	}

	@And("^Click to signIn button$")
	public void click_to_sign_in_button() {
		driver.findElement(signButton).click();
	}

	@And("^I entered the valid \"(.*)\" and clicks to button$")
	public void I_entered_the_valid_and_clicks_to_button(String mobileNumber) throws InterruptedException {
		driver.findElement(emailormobTextField).sendKeys(mobileNumber);
		Thread.sleep(3000);
		driver.findElement(continueButton).click();
	}

	@And("now {string} and clicks to button")
	public void now_and_clicks_to_button(String passsword) throws InterruptedException {

		driver.findElement(password).sendKeys(passsword);
		driver.findElement(rememberMeCheckbox).click();
		driver.findElement(buttonSignin).click();

		Thread.sleep(8000);

	}

}
