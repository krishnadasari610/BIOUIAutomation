package com.mainapp.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mainapp.Base.TestBase;
import com.mainapp.pages.HomePage;
import com.mainapp.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 3,description="Login page title verification")
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Signin", "Page Title Not Matched");
		// System.out.println("Page Title is = " + title);

	}

	@Test(description="Applying colors to images")
	public void setPageColorTest() throws InterruptedException {
		loginPage.setScreenColor();
	}

	@Test(description="Company Logo verification")
	public void companyLogoTest() {
		boolean flag = loginPage.verifyCompanyLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 1,description="Enter the Login credential ")
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
