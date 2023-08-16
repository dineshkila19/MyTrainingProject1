package com.demoproject.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoproject.base.BaseClass;
import com.demoproject.pageobject.IndexPage;
import com.demoproject.pageobject.LoginPage;
import com.demoproject.utility.Log;

public class IndexPageTest extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	
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
	public void verifyMyDemoLogo() {
		Log.startTestCase("verifyMyDemoLogo");
		IndexPage indexPage=new IndexPage();
		Log.info("user ids going to validate demo logo");
		boolean result=indexPage.validateMyDemoLogo();
		Assert.assertTrue(result);
		Log.info("verifyMyDemoLogo testcase is passed");
		Log.endTestCase("verifyMyDemoLogo");
	}
	@Test(groups="Smoke")
	public void getMyTitle() throws Throwable {
		Log.startTestCase("getMyTitle");
		IndexPage indexPage=new IndexPage();
		Log.info("user is going to getting title");
		String actTitle1=indexPage.getMyTitle();
		String expTitle1="Your Store";
		Assert.assertEquals(actTitle1, expTitle1);
		Log.info("getMyTitle testcase is passed");
		Log.endTestCase("getMyTitle");
	}

}
