package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupSuite() {

		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		ExtentHtmlReporter extent = new ExtentHtmlReporter(
				new File("./Reports/HRMApp_" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);

	}

	@BeforeClass
	public void setUp() {

		driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
	}

	@AfterClass
	public void tearDown() {

		BrowserFactory.quitBrowser(driver);
	}

	@AfterMethod
	public void tearDwonMerhod(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {

			// Helper.captureScreenshots(driver);

			try {
				logger.pass("Test Passed",
						MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		report.flush();

	}

}
