package com.uiautomation.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiautomation.base.TestBase;
import com.uiautomation.util.ExcelUtils;
import com.uiautomation.util.TestUtil;

public class AddToCartPage extends TestBase {
	
	@FindBy(how=How.XPATH, using= "//p/span[@id='our_price_display']")
	static WebElement priceItem;

	@FindBy(how=How.XPATH, using= "//button/span[contains(text(),'Add to cart')]")
	static WebElement addToCartBtn;

	@FindBy(how=How.XPATH, using= "//*[contains(text(),'Proceed to checkout')]")
	static WebElement proceedToCheckOut;
	

	@FindBy(how=How.XPATH, using= "//ul[@id='color_to_pick_list']/li/a[@name='Green']")
	static WebElement dressColour;
	
	@FindBy(how=How.XPATH, using= "//input[@id='quantity_wanted']")
	static WebElement dressQuantity;
	
	@FindBy(how=How.XPATH, using= "//p[@class='our_price_display']/span")
	static WebElement dressPrice;
	
	@FindBy(how=How.XPATH, using= "//select[@id='group_1']/option[@selected='selected']")
	static WebElement dressSize;
	
	
	
	
	
	
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
			
		WebDriverWait wait = new WebDriverWait(driver, TestUtil.ExplicitWaitTimeOut_pageload);
		wait.until(ExpectedConditions.visibilityOf(priceItem));
		
	}
	
	
	
	public void addToCart() {
		addToCartBtn.click();
	}
	
	public void addToCartAndCheckOut() throws Exception {
		
		
		
		ExcelUtils.setExcelFileSheet("UserRegistration");
		int totalNoOfRows = (ExcelUtils.getLastRowCount() - ExcelUtils.getFirstRowCount());
		System.out.println("rownum : " + totalNoOfRows);

		int totalNoOfColumns = ExcelUtils.getLastColumnCount();
		System.out.println("col count:" + totalNoOfColumns);
		
		ExcelUtils.setCellData(fetchProductPrice(), totalNoOfRows, 13);
		ExcelUtils.setCellData(fetchProductQuantity(), totalNoOfRows, 14);
		ExcelUtils.setCellData(fetchProductSize(), totalNoOfRows, 15);
		
		
		addToCartBtn.click();
		
		WebDriverWait wait = new WebDriverWait(driver, TestUtil.ExplicitWaitTimeOut_pageload);
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckOut));
		proceedToCheckOut.click();
		
		
		
	}
	
	
	public void changeDressColour() {
		dressColour.click();
		
	}
	

	public String fetchProductPrice() {
		String fetchProductPrice=dressPrice.getText().toString().trim();
		return fetchProductPrice;
	}
 
	public String fetchProductQuantity() {
		
		String fetchProductQuantity=dressQuantity.getAttribute("value");
		
		System.out.println("quantity:" +fetchProductQuantity);
		return fetchProductQuantity;
	}
	
	

	public String fetchProductSize() {
		String fetchProductSize=dressSize.getText().toString().trim();
		return fetchProductSize;
	}

	
	
	
	
}
