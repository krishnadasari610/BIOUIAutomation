package com.mainapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mainapp.Base.TestBase;

public class LoginPage extends TestBase {

	// Object Repository or WebPageElements
	@FindBy(xpath = "//input[@id='username']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='password']")
	WebElement password;

	@FindBy(xpath = "//button[@id='loginSubmit']")
	WebElement loginBtn;

	@FindBy(xpath = "//img[@src='./app/common/images/logos/logo.png']")
	WebElement companyLogo;
	
	@FindBy(xpath="//div[@class='dropdown theme-change-dropdown']//button[@type='button']")
	WebElement setColor;

	// initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Select screen color
	public void setScreenColor() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='dropdown theme-change-dropdown']//button[@type='button']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Gray')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='dropdown theme-change-dropdown']//button[@type='button']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Blue')]")).click();
	}
	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();

	}

	// Actions
	public boolean verifyCompanyLogo() {
		return companyLogo.isDisplayed();
	}
	
	public HomePage login(String uname,String pwd) {
		userName.clear();
		userName.sendKeys(uname);
		password.clear();
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
	
	

}
