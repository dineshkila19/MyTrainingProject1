package com.demoproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.actiondriver.Action;
import com.demoproject.base.BaseClass;

public class HomePage extends BaseClass{
	
	
	@FindBy(xpath="//*[@id='account-account']/ul/li[1]")
	WebElement homeBtnLogo;
	
	@FindBy(xpath="//*[@class='form-control form-control-lg']")
	WebElement searchBox;
	
	@FindBy(xpath="//*[@class='btn btn-light btn-lg']")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[@class='nav navbar-nav']/li[1]/a")
	WebElement desktopLink;
	
	@FindBy(xpath="//*[@class='nav navbar-nav']/li[1]/div/div/ul/li[2]/a")
	WebElement macLink;
	
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateHomeButton() {
		return Action.isDisplayed(getDriver(), homeBtnLogo);
	}
	
	public boolean validateSearchBox() {
		return Action.isDisplayed(getDriver(), searchBox);
	}
	
	public String getCurrentUrl() throws Throwable {
		String getCurrentUrl1=Action.getCurrentURL(getDriver());
		return getCurrentUrl1;
	}
	
	public SearchProductPage searchProductBox(String uprod) {
		Action.type(searchBox, uprod);
		Action.click(getDriver(), searchBtn);
		return new SearchProductPage();
	}
	
	public SearchProductPage selectMac() {
		Action.click(getDriver(), desktopLink);
		Action.click(getDriver(), macLink);
		return new SearchProductPage();
		
	}
	
	

}
