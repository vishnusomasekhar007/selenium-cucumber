package com.uiautomation.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.base.TestBase;
import com.uiautomation.util.ExcelUtils;

public class CartSummaryPage extends TestBase {

	@FindBy(how = How.XPATH, using = "//td[@class='cart_unit']/span/span[@class='price special-price']")
	static WebElement cartProSpecialPrice;

	@FindBy(how = How.XPATH, using = "//td[@class='cart_description']//small//a")
	static WebElement cartProSizeNColour;

	@FindBy(how = How.XPATH, using = "//div[@id='order-detail-content']//td//input[@autocomplete='off']")
	static WebElement cartProQantity;

	@FindBy(how = How.XPATH, using = "//td[@class='cart_description']//p//a")
	static WebElement productName;

	@FindBy(how = How.XPATH, using = "//a[@title='Log me out']")
	static WebElement signOutBtn;

	
//	@FindBy(how = How.XPATH, using = "//td[@class='cart_description']//p//a")
//	static WebElement productName;
	
	
	
	public CartSummaryPage() {
		PageFactory.initElements(driver, this);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");

	}

	public void validateCartDetails() throws Exception {

		ExcelUtils.setExcelFileSheet("UserRegistration");
		int totalNoOfRows = (ExcelUtils.getLastRowCount() - ExcelUtils.getFirstRowCount());
		System.out.println("rownum : " + totalNoOfRows);
		int totalNoOfColumns = ExcelUtils.getLastColumnCount();
		System.out.println("col count:" + totalNoOfColumns);


		String proCartColor=cartProSizeNColour.getText().toString().trim();
		String proCartColSplit=seperateColour(proCartColor);
		System.out.println(proCartColSplit);
		String proColour=ExcelUtils.getCellData(totalNoOfRows, 12);
		
		String proSpPrice = cartProSpecialPrice.getText().toString().trim();
		String proPrice = ExcelUtils.getCellData(totalNoOfRows, 13);

		String proCartQantity = cartProQantity.getAttribute("value");
		System.out.println(proCartQantity);
		String proQuantity = ExcelUtils.getCellData(totalNoOfRows, 14);

		String proCartSize = cartProSizeNColour.getText().toString().trim();
		String proCartSizeSplit = seperateSize(proCartSize);
		System.out.println(proCartSizeSplit);
		String proSize = ExcelUtils.getCellData(totalNoOfRows, 15);
		
		

		ExcelUtils.setExcelFileSheet("UIValidations");
		if (proSpPrice.equalsIgnoreCase(proPrice)) {
			String status = "Pass";
			ExcelUtils.setCellData(status, totalNoOfRows, 2);
		} else {
			String status = "Fail";
			ExcelUtils.setCellData(status, totalNoOfRows, 2);
		}

		if (proQuantity.equalsIgnoreCase(proCartQantity)) {
			String status = "Pass";
			ExcelUtils.setCellData(status, totalNoOfRows, 3);
		} else {
			String status = "Fail";
			ExcelUtils.setCellData(status, totalNoOfRows, 3);

		}

		if (proSize.equalsIgnoreCase(proCartSizeSplit)) {
			String status = "Pass";
			ExcelUtils.setCellData(status, totalNoOfRows, 4);
		} else {
			String status = "Fail";
			ExcelUtils.setCellData(status, totalNoOfRows, 4);
		}
		
		if (proColour.equalsIgnoreCase(proCartColSplit)) {
			String status = "Pass";
			ExcelUtils.setCellData(status, totalNoOfRows, 5);
		} else {
			String status = "Fail";
			ExcelUtils.setCellData(status, totalNoOfRows, 5);
		}
		
		
	}

	private String seperateSize(String proCartSize) {
		// TODO Auto-generated method stub

		String[] comaSep = proCartSize.split(",");
		String[] colanSep = comaSep[1].split(":");
		System.out.println("seperted:" + colanSep[1]);
		String sizeOfItem = colanSep[1].trim();

		return sizeOfItem;

	}

	private String seperateColour(String proCartColor) {
		// TODO Auto-generated method stub

		String[] comaSep = proCartColor.split(",");
		System.out.println("seperted:" + comaSep[0]);
		String[] clr=comaSep[0].split(":");
		String colrOfItem = clr[1].trim();
		return colrOfItem;

	}
	
	public void signOut() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView();", signOutBtn);
		signOutBtn.click();
	}

	public void browserCloses() {
		driver.close();
		
	}
}
