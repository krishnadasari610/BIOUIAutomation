package com.mainapp.tests;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mainapp.Base.TestBase;
import com.mainapp.Utils.TestUtil;
import com.mainapp.pages.HomePage;
import com.mainapp.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		testUtil = new TestUtil(TestBase.driver);
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1,enabled =  false)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		System.out.println("Home Page Title is = " + title);
		Assert.assertEquals(title,"SNT Landing Screen","Home Page Title Not Matched");
	}

	/*
	 * @Test(priority = 2) public void verifyPerformanceTest() {
	 * homePage.verifyPerformance(); // driver.navigate().back(); }
	 */

	@Test(priority = 3)
	public void verifySystemOperationsTest() throws Exception {

		try {
		/* To Run the MainApp in Background */
		//Runtime.getRuntime().exec("D:\\rapiscan\\malibu\\apps\\MainApp\\MainApp.exe BIO --verbose --console");

		/* To Perform click operation on System Operations Button */
		
		homePage.verifySystemOperations();
	
			
	
		
		}catch(Exception exp) {
			exp.printStackTrace();
			System.out.println(exp.getMessage());
		}
	}

	@AfterSuite
	public void tearDown() {
		// System.exit(0);
	}
}
