package com.demoproject.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demoproject.actiondriver.Action;
import com.demoproject.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(id="input-quantity")
	WebElement txtQuantity;
	
	@FindBy(id="button-cart")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@class='nav float-end']/ul/li[4]/a/span")
	WebElement shoppingCartBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickOnAddToCart(String uqnty) {
		Action.type(txtQuantity, uqnty);
		Action.click(getDriver(), addToCartBtn);
	}
	
	public ShoppingCartPage clickOnShoppingcart() {
		Action.click(getDriver(), shoppingCartBtn);
		return new ShoppingCartPage();
	}

}
