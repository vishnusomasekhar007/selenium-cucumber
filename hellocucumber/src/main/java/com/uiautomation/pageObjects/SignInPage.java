package com.uiautomation.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.uiautomation.base.TestBase;
import com.uiautomation.util.ExcelUtils;

public class SignInPage extends TestBase {

	@FindBy(how=How.NAME, using= "email_create") 
	static WebElement createAcc_emailInput;

	@FindBy(how=How.XPATH, using= "//div/ol/li[contains(text(),'Invalid email address.')]") 
	static WebElement alertInvalidEmail;

	@FindBy(how=How.ID, using= "SubmitCreate") 
	static WebElement createAccBtn;

	
	public SignInPage() {
		PageFactory.initElements(driver, this);

	}

	public boolean validateEmailAdd() {
		System.out.println(alertInvalidEmail.getText().toString());
		return alertInvalidEmail.isDisplayed();

	}

	public void enterEmailID() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)");

		String regEmailID=prop.getProperty("registrationemailID");
		
		createAcc_emailInput.clear();
		createAcc_emailInput.sendKeys(regEmailID);
		createAccBtn.click();
		
		ExcelUtils.setExcelFileSheet("UIValidations");

		int totalNoOfRows = (ExcelUtils.getLastRowCount() - ExcelUtils.getFirstRowCount());
		System.out.println("rownum : " + totalNoOfRows);

		int totalNoOfColumns = ExcelUtils.getLastColumnCount();
		System.out.println("col count:" + totalNoOfColumns);

		
		//email ID verification
		if (regEmailID.contains(".com") && regEmailID.contains("@")) {
			System.out.println("email right");
			String status = "Pass";
			ExcelUtils.setCellData(status, totalNoOfRows, 0);
			
			
		} else {
			System.out.println("email not right");
			validateEmailAdd();
			String status = "Fail";
			ExcelUtils.setCellData(status, totalNoOfRows, 0);
		}

	}

}
