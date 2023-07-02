package com.buyproduct.utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

	private static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();

	public static WebDriver createDriver(String browserName) {

		/*
		 * 3rd may 2023 10:17 PM I have doubt here, why Webdriver driver was set to null
		 * ?, bcz if i dont set null then it is throwing error while return drive after
		 * switch case
		 */

//		WebDriver driver = null;
//		String browserType = "Chrome";
//
//		switch (browserType) {
//
//		case "chrome": {
//
//			System.setProperty("webdriver.http.factory", "jdk-http-client");
//			ChromeOptions options = new ChromeOptions();
//			// Used by default, waits for all resources to download
//			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//			driver = new ChromeDriver(options);
//
//			break;
//
//		}
//
//		case "firefox": {
//
//			System.setProperty("webdriver.http.factory", "jdk-http-client");
//			FirefoxOptions options = new FirefoxOptions();
//			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//			driver = new FirefoxDriver(options);
//
//			break;
//		}
//
//		}
//
//		driver.manage().window().maximize();
//		return driver;

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			ChromeOptions options = new ChromeOptions();
			// Used by default, waits for all resources to download
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			thread.set(new ChromeDriver(options));

			return ThreadDriver2Driver();

		} else {

			System.out.print("chrome only");
		}

		ThreadDriver2Driver().manage().window().maximize();
		return ThreadDriver2Driver();

	}

	public static Properties readPropertyFile() throws IOException {

		Properties prop = new Properties();

		FileInputStream fileobject = new FileInputStream(
				"./src/main/java/com/purchaseproduct/config/Config.properties");
		prop.load(fileobject);
		return prop;

	}

	public static void tearDown() {

		ThreadDriver2Driver().quit();

	}

	public static WebDriver ThreadDriver2Driver() {

		return thread.get();

	}

}
