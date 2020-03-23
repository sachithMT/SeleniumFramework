package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.Helper;

public class TC001_LoginHRM extends BaseClass {

	@Test
	public void loginApp() throws InterruptedException {

		logger = report.createTest("Login to Orange HRM");

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);

		logger.info("Starting the Application");

		loginpage.logintoHRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

		logger.pass("Login Success");

	}

}
