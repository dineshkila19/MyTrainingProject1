package com.demoproject.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.demoproject.base.BaseClass;
import com.demoproject.dataprovider.DataProviders;
import com.demoproject.pageobject.HomePage;
import com.demoproject.pageobject.IndexPage;
import com.demoproject.pageobject.LoginPage;
import com.demoproject.utility.Log;

public class LoginPageTest extends BaseClass{
	
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
	
	@Test(groups= {"Smoke","Sanity"}, dataProvider="OpencatloginData", dataProviderClass=DataProviders.class)
	public void loginTest(String uemail, String upwd) throws InterruptedException {
		Log.startTestCase("loginTest");
		IndexPage indexPage=new IndexPage();
		loginPage=indexPage.clickOnMyAccount();
		Log.info("user is clicking the login");
		Thread.sleep(3000);
	//	loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		loginPage.login(uemail, upwd);
		Log.info("user is successfully entered login credentials");
		Log.info("loginTest test case is passed");
		Log.endTestCase("loginTest");
	}
	
	

}
