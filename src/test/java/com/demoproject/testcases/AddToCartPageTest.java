package com.demoproject.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoproject.base.BaseClass;
import com.demoproject.pageobject.AddToCartPage;
import com.demoproject.pageobject.HomePage;
import com.demoproject.pageobject.IndexPage;
import com.demoproject.pageobject.LoginPage;
import com.demoproject.pageobject.SearchProductPage;
import com.demoproject.utility.Log;

public class AddToCartPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchProductPage searchProductPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups= {"Sanity","Regression"})
	public void AddToCartPageTest() throws InterruptedException {
		Log.startTestCase("AddToCartPageTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnMyAccount();
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(3000);
		searchProductPage=homePage.selectMac();
		Thread.sleep(3000);
		addToCartPage=searchProductPage.clickOnImac();
		Thread.sleep(3000);
		addToCartPage.clickOnAddToCart("2");
		Log.info("entering the quantity");
		Thread.sleep(6000);
		addToCartPage.clickOnShoppingcart();
		Log.info("user successfully click on the shopping cart ");
		Log.endTestCase("AddToCartPageTest");
	}

}
