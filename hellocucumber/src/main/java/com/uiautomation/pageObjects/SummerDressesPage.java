package com.uiautomation.pageObjects;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.uiautomation.base.TestBase;
import com.uiautomation.util.ExcelUtils;

public class SummerDressesPage extends TestBase {
	
	
	//CreateAccountPage caccPage= new CreateAccountPage();
	//String dressType= caccPage.testdataList.get(11);
	
	@FindBy(how = How.XPATH, using = "//div/ol/li[contains(text(),'Invalid email address.')]")
	static WebElement alertInvalidEmail;

	@FindBy(how = How.ID, using = "SubmitCreate")
	static WebElement createAccBtn;

	@FindBy(how = How.XPATH, using = "//li[@id='grid']")
	static WebElement gridVieW;

	@FindBy(how = How.ID, using = "selectProductSort")
	static WebElement productSort;

	@FindBy(how = How.XPATH, using = "//div[@class='right-block']//span[@class='price product-price'][contains(text(),'$')]")
	public List<WebElement> listPrice;


	public SummerDressesPage() {
		PageFactory.initElements(driver, this);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

	}

	public boolean verifyGridView() {
		return gridVieW.isEnabled();

	}

	public void sortByPrice() {
		String sortBy = prop.getProperty("sortGrid");
		Select slct = new Select(productSort);
		slct.selectByVisibleText(sortBy);
	}

	public boolean verifyGridArrangementAfterSort_LowestFirst() throws Exception {
		boolean flag = true;
		System.out.println("printing list size" + listPrice.size());

		for (int i = 0; i < listPrice.size(); i++) {

			System.out.println(listPrice.get(i).getText());

			String x = listPrice.get(0).getText();
			String xx = listPrice.get(i).getText();

			String replacedX = removeInvalidCharacters(x);
			String replacedXX = removeInvalidCharacters(xx);

			double firstListedPrice = Double.parseDouble(replacedX);
			double inLoopPriceCheck = Double.parseDouble(replacedXX);

			System.out.println("double value : " + firstListedPrice);
			System.out.println("double value : " + inLoopPriceCheck);

			if (firstListedPrice == inLoopPriceCheck) {
				System.out.println("sorted less first");

			} else if (firstListedPrice > inLoopPriceCheck) {
				System.out.println("sorted highest first");

			} else if (firstListedPrice < inLoopPriceCheck) {
				System.out.println("sorted lowest first");

			} else {
				System.out.println();
				flag = false;
			}
		}

		ExcelUtils.setExcelFileSheet("UIValidations");

		int totalNoOfRows = (ExcelUtils.getLastRowCount() - ExcelUtils.getFirstRowCount());
		System.out.println("rownum : " + totalNoOfRows);

		int totalNoOfColumns = ExcelUtils.getLastColumnCount();
		System.out.println("col count:" + totalNoOfColumns);

		if (flag == true) {

			// write to excel sheet

			String status = "Pass";
			ExcelUtils.setCellData(status, totalNoOfRows, 1);
		} else {
			String status = "Fail";
			ExcelUtils.setCellData(status, totalNoOfRows, 1);
		}

		return flag;

	}

	public String removeInvalidCharacters(String outputString) {
		String[] exclude = { "$" };
		for (String s : exclude) {
			outputString = outputString.replace(s, "");
		}
		return outputString;

	}

	/*public boolean productSelection() {

		
		driver.findElement(By.xpath("//img[@title='"+dressType+"']")).click();
		return true;

	}*/
}
