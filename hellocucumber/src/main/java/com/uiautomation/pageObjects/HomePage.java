package com.uiautomation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiautomation.base.TestBase;
import com.uiautomation.util.TestUtil;

public class HomePage extends TestBase {

	@FindBy(how = How.XPATH, using = "//img[@class='logo img-responsive']")
	static WebElement autoPractLogo;

	@FindBy(how = How.XPATH, using = "//a[@title='Log in to your customer account']")
	static WebElement signInLink;

	public HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public void clickSignIn() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, TestUtil.ExplicitWaitTimeOut_pageload);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Log in to your customer account']")))
				.click();

	}

}
