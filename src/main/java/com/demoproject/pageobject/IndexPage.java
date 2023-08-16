package com.demoproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.actiondriver.Action;
import com.demoproject.base.BaseClass;

public class IndexPage extends BaseClass{
	
	@FindBy(xpath="//*[@class='col-md-3 col-lg-4']/div/a/img")
	WebElement myDemoLogo;
	
	@FindBy(xpath="//*[@id='top']/div[2]/div[2]/ul/li[2]/div/a/span")
	WebElement myAccountBtn;
	
	@FindBy(xpath="//*[@class='dropdown-menu dropdown-menu-right show']/li[1]/a")
	WebElement registerBtn;
	
	@FindBy(xpath="//*[@class='dropdown-menu dropdown-menu-right show']/li[2]/a")
	WebElement loginBtn;
	
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyDemoLogo() {
		return Action.isDisplayed(getDriver(), myDemoLogo);
	}
	
	public LoginPage clickOnMyAccount() {
		Action.click(getDriver(), myAccountBtn);
		Action.click(getDriver(), loginBtn);
		return new LoginPage();
	}
	
	public String getMyTitle() throws Throwable {
		String actTitle=Action.getTitle(getDriver());
		return actTitle;
	}

}
