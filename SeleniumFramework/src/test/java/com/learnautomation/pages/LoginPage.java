package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(id = "txtUsername")
	WebElement userName;

	@FindBy(id = "txtPassword")
	WebElement password;

	@FindBy(id = "btnLogin")
	WebElement loginButton;

	public void logintoHRM(String userNameApplicstion, String passwordApplication) {

		userName.clear();
		userName.sendKeys(userNameApplicstion);

		password.clear();
		password.sendKeys(passwordApplication);

		loginButton.click();
	}

}
