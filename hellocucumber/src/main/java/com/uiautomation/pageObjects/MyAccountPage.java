package com.uiautomation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.uiautomation.base.TestBase;

public class MyAccountPage extends TestBase {

	@FindBy(how = How.XPATH, using = "//div/h1[contains(text(),'My account')]")
	static WebElement myAccLogo;

	@FindBy(how = How.XPATH, using = "(//a[starts-with(@title,'Dresses')])[2]")
	static WebElement dressesLink;
	

	@FindBy(how = How.XPATH, using = "(//a[starts-with(@title,'Short dress')])[1]")
	static WebElement summerDressesLink;
	
	public MyAccountPage() {
		PageFactory.initElements(driver, this);

	}

	public boolean validateMyAcc() {
		//WebDriverWait wait = new WebDriverWait(driver, TestUtil.ExplicitWaitTimeOut_pageload);
		//wait.until(ExpectedConditions.textToBePresentInElement(myAccLogo, "My Account"));
		return myAccLogo.isDisplayed();
	}

	public void traverseToDresses(){

		Actions action = new Actions(driver);
		action.moveToElement(dressesLink).click().build().perform();
		
	}

	public void traverseToSummerDresses() {
		Actions action = new Actions(driver);
		action.moveToElement(summerDressesLink).click( ).build().perform();
		
	}

}
