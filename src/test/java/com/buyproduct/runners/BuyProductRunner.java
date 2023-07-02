package com.buyproduct.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {
		"/Volumes/Safe/java workspace/AmazonProductPurchase/src/test/java/com/buyproduct/resources/Login.feature" },

		glue = { "com.buyproduct.stepDefinitions" }, dryRun = false, monochrome = true, plugin = {
				"pretty" }, publish = true)

public class BuyProductRunner extends AbstractTestNGCucumberTests {

}
