package com.mainapp.pages;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mainapp.Base.TestBase;
import com.mainapp.Utils.TestUtil;

public class HomePage extends TestBase {

	@FindBy(xpath = "//img[@src='app/common/images/icons/logo.png']")
	public WebElement logoVerificaiton;

	@FindBy(xpath = "//span[@class='mng-menu-text ng-binding'][contains(text(),'System Operations')]")
	public WebElement clickOnSystemOperations;

	@FindBy(xpath = "//div[@class='menu-btn-hide-overlay ng-scope']")
	public WebElement clickOnMenuIcon;

	@FindBy(xpath = "//input[@id='folderpath']")
	public WebElement mountFolderPath;

	@FindBy(xpath = "//label[@id='folderpathCheckboxLabel']")
	public WebElement selectExistingFiles;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement clickonSubmitBtn;

	@FindBy(xpath = "//div[@class='alert alert-success']")
	public WebElement filesCopied;

	@FindBy(xpath = "//span[contains(text(),'Swap')]")
	public WebElement clickonSwapButton;

	@FindBy(xpath = "//span[contains(text(),'Background')]")
	public WebElement changeBGColor;

	/*
	 * @FindBy(xpath = "//div[@class='scanned-bags-list-container ng-scope']")
	 * public WebElement selectBagList;
	 */


	private TestUtil testUtil;

	// initialization
	public HomePage() {
		PageFactory.initElements(driver, this);
		this.testUtil = new TestUtil(driver);
	}

	// Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public void verifySystemOperations() throws InterruptedException, IOException {
		clickOnSystemOperations.click();
		clickOnMenuIcon.click();
		mountFolderPath.sendKeys(prop.getProperty("bagFilesPath"));
		selectExistingFiles.click();
		String errorMsg = "Error in updating folder path.";
		if(errorMsg.contains(errorMsg)) {
			driver.findElement(By.xpath("//div[@class='modal-header theme-bg-header-primary']//button[@type='button'][contains(text(),'×')]")).click();
		}else {
		clickonSubmitBtn.click();
		filesCopied.getText();
		String actMsg = filesCopied.getText();
		Assert.assertEquals(actMsg, "Folder path updated successfully.");
		}
		Thread.sleep(2000);
		List<WebElement> bagId = driver.findElements(By.xpath("//div[@class='scanned-bags-list-container ng-scope bags-navigation-hidden']"));
		Random random = new Random();
		int randomBagId = random.nextInt(bagId.size());
		Thread.sleep(3000);
		bagId.get(randomBagId).click();
		Thread.sleep(30000);
		/*
		 * for (int i = 0; i < 4; i++) { Thread.sleep(1000); clickonSwapButton.click();
		 * }
		 */

		testUtil.generateClickOnSwapButton(4, 1000);
		testUtil.generateClickOnPlusButton(4, 1000);
		testUtil.generateClickOnMinusButton(4, 1000);
		testUtil.generateClickOnColorProcessingTools(1,1000);
		testUtil.generateClickOnFireColorTool(1,1000);
		testUtil.generateClickOnGoldColorTool(1,1000);
		testUtil.generateClickOnGrayScalColorTool(1, 1000);
		testUtil.generateClickOnSpectrumColorTool(1, 1000);
		testUtil.generateClickOnAnnotations(1,1000);
		//testUtil.generateClickOnImageProcessingTool(1,5000);
		//testUtil.generateClickOnContrastDisableTool(3,1000);
		//testUtil.generateClickOnShadedSurface(1, 1000);
		//testUtil.generateClickOnContrastDisableTool(1,2000);
		//testUtil.generateClickOnContrastEnableTool(1, 1000);
		testUtil.generateClickOnOverlayBox(1,1000);
		testUtil.generateClickOnAddBox(1,2000);
		testUtil.generateClickOnEditBox(1, 2000);
		testUtil.generateClickOnDeleteBox(1,1000);
		//testUtil.generateClickOnAddBox1(1,1000);
	}
	

	
}
