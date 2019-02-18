package hellocucumber;

import com.uiautomation.pageObjects.MyAccountPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class MyAccPageStepDef {

	MyAccountPage myAccPage= new MyAccountPage();
	
	@Then("^User navigates to MegaMenu Dresses$")
	public void userNavToMegaMenu_Dresses() throws Throwable {
	  
		//myAccPage.validateMyAcc(); -- commented to run from home page
		myAccPage.traverseToDresses();
	}

	@And("^Selects Summer Dresses SubMenu$")
	public void selectsSummerDressesMenu() throws Throwable {
		myAccPage.traverseToSummerDresses();
	  
	}
	
}
