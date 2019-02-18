package hellocucumber;

import com.uiautomation.base.TestBase;
import com.uiautomation.pageObjects.CartSummaryPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class CartSummaryPageStepDef extends TestBase {

	CartSummaryPage csmPage= new CartSummaryPage();
	@Then("^Validate Cart Summary details for selected product details$")
	public void validateCartSummary() throws Throwable {

		csmPage.validateCartDetails();
		
		
	}

	@And("^User SignsOut$")
	public void signOut() throws Throwable {
		
		csmPage.signOut();
		csmPage.browserCloses();
		
	}
	
}
