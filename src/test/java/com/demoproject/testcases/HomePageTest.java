package com.demoproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoproject.base.BaseClass;
import com.demoproject.pageobject.HomePage;
import com.demoproject.pageobject.IndexPage;
import com.demoproject.pageobject.LoginPage;
import com.demoproject.utility.Log;

public class HomePageTest extends  BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Smoke")
	public void verifySearchBox() {
		Log.startTestCase("verifySearchBox");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnMyAccount();
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		boolean reasult=homePage.validateSearchBox();
		Assert.assertTrue(reasult);
		Log.info("user is successfully verifys the searchbox");
		Log.endTestCase("verifySearchBox");
	}
	
	@Test(groups="Smoke")
	public void getCurrentURL() throws Throwable {
		Log.startTestCase("getCurrentURL");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnMyAccount();
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		String actURL=homePage.getCurrentUrl();
		String expURL="https://demo.opencart.com/index.php?route=account/login&language=en-gb";
		Assert.assertEquals(actURL, expURL);
		Log.info("user getting the current url is successfully");
		Log.endTestCase("getCurrentURL");
	}
	
	

}
