package com.Paylocity.pages;

import com.Paylocity.utilities.Driver;
import com.Paylocity.utilities.Screens;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaylocityLogin {
	
	public PaylocityLogin() {
		PageFactory.initElements(Driver.get(), this);
	}	
	
	@FindBy(id = "Username")
	public WebElement usernameInput;

	@FindBy(id = "Password")
	public WebElement passwordInput;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	public WebElement signInButton;

	public void usernameAndPasswordInput(String usernameInput,String password){
		Screens.getPaylocityLogin().usernameInput.sendKeys(usernameInput);
		Screens.getPaylocityLogin().passwordInput.sendKeys(password);
	}

	public void verifyTitle(String actualTitle, String expectedTitle){
		Assert.assertEquals("The title is not matching!",actualTitle,expectedTitle);
	}
}
