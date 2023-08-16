package com.demoproject.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoproject.base.BaseClass;
import com.demoproject.pageobject.HomePage;
import com.demoproject.pageobject.IndexPage;
import com.demoproject.pageobject.LoginPage;
import com.demoproject.pageobject.SearchProductPage;
import com.demoproject.utility.Log;

public class SearchProductPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchProductPage searchProductPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setUp(String browser) {
		launchApp(browser);
	}
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	@Test(groups="Sanity")
	public void searchProductPageTest() throws InterruptedException {
		Log.startTestCase("searchProductPageTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnMyAccount();
		homePage=loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(3000);
		searchProductPage=homePage.selectMac();
		Log.info("user is selecting the imac");
		Thread.sleep(3000);
		searchProductPage.clickOnImac();
		Log.info("user successfully clicking on the imac");
		Log.endTestCase("searchProductPageTest");
	}
	
	
	

}
