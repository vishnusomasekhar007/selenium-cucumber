package com.uiautomation.pageObjects;

import java.util.LinkedList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiautomation.base.TestBase;
import com.uiautomation.util.ExcelUtils;
import com.uiautomation.util.TestUtil;

public class CreateAccountPage extends TestBase {
	LinkedList<String> testdataList = new LinkedList<String>();
	

	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Create an account')]")
	static WebElement createAccountText;

	@FindBy(how = How.ID, using = "customer_firstname")
	static WebElement firstName;

	@FindBy(how = How.ID, using = "customer_lastname")
	static WebElement lastName;

	@FindBy(how = How.NAME, using = "passwd")
	static WebElement password;

	@FindBy(how = How.NAME, using = "address1")
	static WebElement addressLineOne;

	@FindBy(how = How.NAME, using = "address2")
	static WebElement addressLineTwo;

	@FindBy(how = How.NAME, using = "city")
	static WebElement city;

	@FindBy(how = How.ID, using = "id_state")
	static WebElement state;
	
	@FindBy(how = How.NAME, using = "postcode")
	static WebElement postCode;
	
	@FindBy(how = How.ID, using = "id_country")
	static WebElement country;

	@FindBy(how = How.NAME, using = "phone_mobile")
	static WebElement phNumber;

	@FindBy(how = How.NAME, using = "alias")
	static WebElement AddrAlias;
	
	@FindBy(how = How.XPATH, using = "//button[@name='submitAccount']")
	static WebElement registerBtn;
	
	
	@FindBy(how = How.XPATH, using = "//a[@title='Printed Chiffon Dress'][@class='product-name']")
	static WebElement selectDress;
	

	
	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyOnCreateAccountPage() {
		return createAccountText.isDisplayed();
	}

	public void fillMandatoryDetailsOnForm() {

		try {

			ExcelUtils.setExcelFileSheet("UserRegistration");

			// To get the number of rows present in sheet
			// System.out.println(ExcelUtils.getLastRowCount());
			// System.out.println(ExcelUtils.getFirstRowCount());

			int totalNoOfRows = (ExcelUtils.getLastRowCount() - ExcelUtils.getFirstRowCount());
			System.out.println("rownum : " + totalNoOfRows);

			int totalNoOfColumns = ExcelUtils.getLastColumnCount();
			System.out.println("col count:" + totalNoOfColumns);

			for (int currentRow = 1; currentRow <= totalNoOfRows; currentRow++) {
				for (int currentCol = 0; currentCol < totalNoOfColumns; currentCol++) {
					String testdataFromSheet = ExcelUtils.getCellData(currentRow, currentCol);

					// System.out.println(testdataFromSheet);
					//LinkedList<String> testdataList = new LinkedList<String>();
					testdataList.add(testdataFromSheet);


				}

			}
			
			/*
			 * System.out.println(testdataList.get(0));
			 * System.out.println(testdataList.get(1));
			 * System.out.println(testdataList.get(2));
			 * System.out.println(testdataList.get(3));
			 * System.out.println(testdataList.get(4));
			 * System.out.println(testdataList.get(5));
			 * System.out.println(testdataList.get(6));
			 * System.out.println(testdataList.get(7));
			 * System.out.println(testdataList.get(8));
			 * System.out.println(testdataList.get(9));
			 * System.out.println(testdataList.get(10));
			 */
			
			
			firstName.sendKeys(testdataList.get(0));
			lastName.sendKeys(testdataList.get(1));
			password.sendKeys(prop.getProperty("password"));
			Thread.sleep(7000);
			
			//waiting for the green validation
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");

			addressLineOne.sendKeys(testdataList.get(3));
			addressLineTwo.sendKeys(testdataList.get(4));
			city.sendKeys(testdataList.get(5));
			Select slct= new Select(state);
			slct.selectByVisibleText(testdataList.get(6));
			
			state.sendKeys(testdataList.get(6));
			postCode.sendKeys(testdataList.get(7));
			Select slt= new Select(country);
			slt.selectByVisibleText(testdataList.get(8));
			phNumber.sendKeys(testdataList.get(9));
			AddrAlias.sendKeys(testdataList.get(10));
			
			//chooseDress=testdataList.get(11);
			//changeColour=testdataList.get(12);
			
			//System.out.println(chooseDress);
			//System.out.println(changeColour);
			
	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void submitAccCreationForm() {
		WebDriverWait wait = new WebDriverWait(driver, TestUtil.ExplicitWaitTimeOut_pageload);
		wait.until(ExpectedConditions.elementToBeClickable(registerBtn)).click();
		
				
	}
	
	
	public boolean productSelection() {
		
		
		//WebElement dressSelected=
		//driver.findElement(By.xpath("//img[@title='Printed Chiffon Dress']")).click();
		selectDress.click();
		return true;

	}
}
