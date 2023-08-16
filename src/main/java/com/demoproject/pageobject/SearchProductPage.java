package com.demoproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.actiondriver.Action;
import com.demoproject.base.BaseClass;

public class SearchProductPage extends BaseClass{

	@FindBy(xpath="//*[@class='product-thumb']/div[2]/div/h4/a")
	WebElement iMacProduct;
	
	public SearchProductPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public AddToCartPage clickOnImac() {
		Action.click(getDriver(), iMacProduct);
		return new AddToCartPage();
	}
	
	
}
