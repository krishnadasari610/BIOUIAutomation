package com.mainapp.Utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.Validate;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

/*import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;*/

public class TestUtil {

	public static long IMPLICIT_TIME_OUT = 10;
	public static long PAGE_LOAD_TIME_OUT = 20;

	public static String SWAP_BUTTON_XPATH = "//span[contains(text(),'Swap')]";
	public static String PLUS_BUTTON_X_PATH = "//li[@id='zoomplus']//span[@class='num-icon']";
	public static String MINUS_BUTTON_X_PATH = "//li[@id='zoomminus']//span[@class='num-icon']";
	public static String SLICE_BUTTON_X_PATH = "//input[@id='rangeSvalue']";
	public static String COLOR_PROCESSING_TOOLS_XPATH = "//li[@id='colorProcessorTools']//img[@class='img-fluid']";
	public static String SELECT_FIRE_COLOR_XPATH = "//li[@id='fire']//img[@class='img-fluid ng-scope']";
	public static String SELECT_GOLD_COLOR_XPATH = "//li[@id='gold']//img[@class='img-fluid ng-scope']";
	public static String SELECT_GRAYSCALE_COLOR_XPATH = "//li[@id='grayScale']//img[@class='img-fluid ng-scope']";
	public static String SELECT_SPECTRUM_COLOR_XPATH = "//li[@id='spectrum']//img[@class='img-fluid ng-scope']";
	public static String IMAGE_PROCESSING_TOOL_XPATH = "//li[@id='imageProcessTools']//span[@class='num-icon']";
	public static String CONTRAST_DISABLE_XPATH = "//li[@id='disableContrast']//span[@class='num-icon ng-scope']";
	public static String CONTRAST_ENABLE_XPATH = "//li[@id='enableContrast']//img[@class='img-fluid ng-scope']";
	public static String SHADED_SURFACE_X_PATH = "//li[@id='shadedSurface']//img[@class='img-fluid ng-scope']";
	public static String CHANGE_IMAGE_COLOR_X_PATH = "//ul[@class='nav clearfix']//li[2]";
	public static String SELECT_RADIO_BUTTON_X_PATH = "//div[@class='color-box-radio-container radio-container']//ul";
	public static String MOVE_TRANSPERANCY_BAR_X_PATH = "//input[@id='rangeTvalue']";
	public static String ANNOTATIONS_TOOLS_XPATH = "//li[@id='annotationTools']//img[@class='img-fluid']";
	public static String BOXOVERLAY_XPATH = "//li[@id='boxOverlay']//img[@class='img-fluid ng-scope']";
	public static String ADD_BOX_XPATH = "//li[@id='addBox']//img[@class='img-fluid ng-scope']";
	public static String ADD_TEXT_XPATH = "//input[@id='edittdiboxtext']";
	public static String APPLY_TEXT_XPATH = "//input[contains(@value,'Apply')]";
	public static String EDIT_TEXT_XPATH = "//input[@id='edittdiboxtext']";
	public static String EDIT_BOX_XPATH = "//li[@id='editBox']//img[@class='img-fluid ng-scope']";
	public static String DELETE_BOX_XPATH = "//li[@id='deleteBox']//img[@class='img-fluid ng-scope']";
	

	public final WebDriver webDriver;

	public TestUtil(final WebDriver webDriver) {
		this.webDriver = webDriver;

	}

	/*
	 * public static final String SRC_DIR_PATH =
	 * "C:\\Users\\gd\\Downloads\\MPI\\rtt_bag _files"; public static final String
	 * TEMP_DIR_PATH = "D:\\rapiscan\\malibu\\tempDir"; public static final String
	 * DEST_DIR_PATH = "D:\\rapiscan\\malibu\\input";
	 * 
	 * 
	 * public void copySpecifFilesToDestFolder() throws IOException { File
	 * srcDirectory = new File(SRC_DIR_PATH); File tempDir = new
	 * File(TEMP_DIR_PATH); File destinationDir = null; if(new
	 * File(DEST_DIR_PATH).exists()) { FileUtils.forceDelete(new
	 * File(DEST_DIR_PATH)); } destinationDir = new File(DEST_DIR_PATH); //Copy
	 * specific extension files to Temp Folder
	 * selectAndCopyFilesToTempFolder(srcDirectory, tempDir); //Move selected files
	 * from TEMP Folder to Destination Folder FileUtils.moveDirectory(tempDir,
	 * destinationDir); }
	 * 
	 * public void selectAndCopyFilesToTempFolder(File srcDir, File tempDir) { try {
	 * String[] extensions = new String[] {"vol", "vol.txt"};
	 * System.out.println("Getting all vol and vol.txt files in " +
	 * srcDir.getCanonicalPath()); List<File> files = (List<File>)
	 * FileUtils.listFiles(srcDir, extensions, true);
	 * System.out.println("Selected files Count = " + files.size()); for (File file
	 * : files) { System.out.println("file: " + file.getCanonicalPath()); //Copy
	 * each selected file to Temp Folder FileUtils.copyFileToDirectory(file,
	 * tempDir); } } catch (Exception e) {
	 * System.out.print("Exception Occurred while copying files to Temp Folder"); }
	 * }
	 */
	public void generateClickEvents(final WebElement element, final int times, final long waitTime) {
		Validate.notNull(element, "WebElement is null");
		Validate.isTrue(times >= 0, "No of times is less than zero");
		Validate.isTrue(waitTime >= 0, "Wait time is less than zero");

		for (int x = 0; x < times; x++) {
			try {
				Thread.sleep(waitTime);
			} catch (InterruptedException e) {
				throw new RuntimeException("Exception Occurs while making webdriver wait ..", e);
			}
			element.click();
		}
	}

	public void generateClickOnPlusButton(final int times, final long waitTime) {
		final WebElement plusButtonElement = webDriver.findElement(By.xpath(PLUS_BUTTON_X_PATH));
		generateClickEvents(plusButtonElement, times, waitTime);
	}

	public void generateClickOnMinusButton(final int times, final long waitTime) {
		final WebElement minusButtonElement = webDriver.findElement(By.xpath(MINUS_BUTTON_X_PATH));
		generateClickEvents(minusButtonElement, times, waitTime);
	}

	public void generateClickOnSliceBar(final int times, final long waitTime) {
		final WebElement sliceBarElement = webDriver.findElement(By.xpath(SLICE_BUTTON_X_PATH));
		Actions act = new Actions(webDriver);
		act.clickAndHold(sliceBarElement).moveToElement(sliceBarElement, 100, 200).build().perform();
	}

	public void generateClickOnColorProcessingTools(final int times, final long waitTime) {
		final WebElement imageColorProcessing = webDriver.findElement(By.xpath(COLOR_PROCESSING_TOOLS_XPATH));
		generateClickEvents(imageColorProcessing, times, waitTime);

	}
	public void generateClickOnImageProcessingTool(final int times, final long waitTime) {
		final WebElement imageProcessingTool = webDriver.findElement(By.xpath(IMAGE_PROCESSING_TOOL_XPATH));
		generateClickEvents(imageProcessingTool, times, waitTime);
		
	}

	public void generateClickOnFireColorTool(final int times, final long waitTime) {
		final WebElement fireImageColorProcess = webDriver.findElement(By.xpath(SELECT_FIRE_COLOR_XPATH));
		generateClickEvents(fireImageColorProcess, times, waitTime);
		Shutterbug.shootPage(webDriver).withName("FireColor").save();
	}

	public void generateClickOnGrayScalColorTool(final int times, final long waitTime) {
		final WebElement grayScaleColorProcess = webDriver.findElement(By.xpath(SELECT_GRAYSCALE_COLOR_XPATH));
		generateClickEvents(grayScaleColorProcess, times, waitTime);
		Shutterbug.shootPage(webDriver).withName("GrayScaleColor").save();
	}

	public void generateClickOnSpectrumColorTool(final int times, final long waitTime) {
		final WebElement spectrumColorProcess = webDriver.findElement(By.xpath(SELECT_SPECTRUM_COLOR_XPATH));
		generateClickEvents(spectrumColorProcess, times, waitTime);
		Shutterbug.shootPage(webDriver).withName("SpectrumColor").save();
	}

	public void generateClickOnGoldColorTool(final int times, final long waitTime) {
		final WebElement golColorProcess = webDriver.findElement(By.xpath(SELECT_GOLD_COLOR_XPATH));
		generateClickEvents(golColorProcess, times, waitTime);
	}
	public void generateClickOnContrastDisableTool(final int times, final long waitTime) {
		final WebElement contrastApplyOnImage = webDriver.findElement(By.xpath(CONTRAST_DISABLE_XPATH));
		Actions act = new Actions(webDriver);
		act.clickAndHold(contrastApplyOnImage).moveToElement(contrastApplyOnImage, 100, 200).build().perform();
	}
	public void generateClickOnContrastEnableTool(final int times, final long waitTime) {
		final WebElement contrastDisableOnImage = webDriver.findElement(By.xpath(CONTRAST_ENABLE_XPATH));
		generateClickEvents(contrastDisableOnImage, times, waitTime);
	}
	
	public void generateClickOnSwapButton(final int times, final long waitTime) throws InterruptedException {
		final WebElement swapPerformance = webDriver.findElement(By.xpath(SWAP_BUTTON_XPATH));
		generateClickEvents(swapPerformance, times, waitTime);
		/*
		 * WebElement element = webDriver.findElement(By.xpath(
		 * "//div[@id='papayaViewer0']//canvas[@width='1533']")); //WebElement element =
		 * driver.findElement(By.xpath(
		 * "//div[@id='papayaViewer0']//canvas[@width='1533']")); int h =
		 * element.getSize().getHeight(); System.out.println(h); Point point =
		 * element.getLocation(); int xcord = point.getX();
		 * 
		 * System.out.println("X Coordinates " + xcord); int ycord = point.getY(); int w
		 * = element.getSize().getWidth(); System.out.println(w);
		 * System.out.println("Y Coordinates " + ycord); Thread.sleep(3000); Actions
		 * action = new Actions(webDriver); action.clickAndHold(element).moveByOffset(h,
		 * w).build().perform();
		 */	}
	
	public void generateClickOnAnnotations(final int times, final long waitTime) {
		final WebElement annotationsTool = webDriver.findElement(By.xpath(ANNOTATIONS_TOOLS_XPATH));
		generateClickEvents(annotationsTool, times, waitTime);
	}
	public void generateClickOnOverlayBox(final int times, final long waitTime) {
		final WebElement enableOverlayBox = webDriver.findElement(By.xpath(BOXOVERLAY_XPATH));
		generateClickEvents(enableOverlayBox, times, waitTime);
	}
	
	public void generateClickOnAddBox(final int times, final long waitTime) {
		final WebElement addBox = webDriver.findElement(By.xpath(ADD_BOX_XPATH));
		generateClickEvents(addBox, times, waitTime);
		webDriver.findElement(By.xpath(ADD_TEXT_XPATH)).sendKeys("apples");
		webDriver.findElement(By.xpath(APPLY_TEXT_XPATH)).click();
		Shutterbug.shootPage(webDriver).withName("textadded").save();
	}
	public void generateClickOnAddBox1(final int times, final long waitTime) {
		final WebElement addBox1 = webDriver.findElement(By.xpath(ADD_BOX_XPATH));
		generateClickEvents(addBox1, times, waitTime);
		webDriver.findElement(By.xpath(ADD_TEXT_XPATH)).sendKeys("4apples");
		webDriver.findElement(By.xpath(APPLY_TEXT_XPATH)).click();
		Shutterbug.shootPage(webDriver).withName("textadded1").save();
	}
	
	public void generateClickOnEditBox(final int times, final long waitTime) {
		final WebElement editBox = webDriver.findElement(By.xpath(EDIT_BOX_XPATH));
		generateClickEvents(editBox, times, waitTime);
		webDriver.findElement(By.xpath(EDIT_TEXT_XPATH)).sendKeys("oranges");
		webDriver.findElement(By.xpath(APPLY_TEXT_XPATH)).click();
		Shutterbug.shootPage(webDriver).withName("textedited").save();
	}
	/*
	 * public void generateClickOnBackgroundColor(final int times, final long
	 * waitTime) { final WebElement clickOnBackgroundClolor =
	 * webDriver.findElement(By.xpath(CHANGE_BACKGROUND_COLOR_WHITE));
	 * generateClickEvents(clickOnBackgroundClolor, times, waitTime); } public void
	 * generateClickOnBackgroundColor1(final int times, final long waitTime) { final
	 * WebElement clickOnBackgroundClolor =
	 * webDriver.findElement(By.xpath(CHANGE_BACKGROUND_COLOR_BLACK));
	 * generateClickEvents(clickOnBackgroundClolor, times, waitTime); }
	 */

	public void gererateClickOnColorProcessingTools(final int times, final long waitTime) {

	}

	public void generateClickOnShadedSurface(final int times, final long waitTime) {
		final WebElement clickOnShadedSurface = webDriver.findElement(By.xpath(SHADED_SURFACE_X_PATH));
		generateClickEvents(clickOnShadedSurface, times, waitTime);
	}

	public void generateClickOnColorButton(final int times, final long waitTime) {
		final WebElement clickOnColorButton = webDriver.findElement(By.xpath(CHANGE_IMAGE_COLOR_X_PATH));
		generateClickEvents(clickOnColorButton, times, waitTime);
	}

	public void generateClickOnRadioButton() {
		final WebElement selectRadioButton = webDriver.findElement(By.xpath(SELECT_RADIO_BUTTON_X_PATH));
		selectRadioButton.click();
	}
    public void generateClickOnDeleteBox(final int times, final long waitTime) throws IOException {
    	
    	final WebElement deleteBox = webDriver.findElement(By.xpath(DELETE_BOX_XPATH));
    	deleteBox.click();
    	Alert alert = webDriver.switchTo().alert();
    	String msg = webDriver.switchTo().alert().getText();
    	System.out.println("Alert Msg:"+ msg);
    	System.out.println("Box deleted successfully " );
    		alert.accept();	
    	 Shutterbug.shootPage(webDriver).withName("DeleteBox").save();
    		File image =  new File("/home/admin/Documents/Selenium/MainAppUI/screenshots/textadded.png");
    		BufferedImage expectedImage =  ImageIO.read(image);
    		String output = "/home/admin/Documents/Selenium/MainAppUI/Screenshots/";
    		boolean status = Shutterbug.shootPage(webDriver,ScrollStrategy.WHOLE_PAGE,500, true).withName("DeletedBox").equalsWithDiff(expectedImage, output);
    		System.out.println("Both Images are equal ?" + status);
    }
}
