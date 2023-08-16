package com.demoproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.actiondriver.Action;
import com.demoproject.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(id="input-email")
	WebElement emailText;
	
	@FindBy(id="input-password")
	WebElement passwordText;
	
	@FindBy(xpath="//*[@id='form-login']/button")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[contains(text(),'Continue')]")
	WebElement regNewBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uemail, String upwd) {
		Action.type(emailText, uemail);
		Action.type(passwordText, upwd);
		Action.click(getDriver(), loginBtn);
		return new HomePage();
	}
	
	
	
	
	
	
	
}
