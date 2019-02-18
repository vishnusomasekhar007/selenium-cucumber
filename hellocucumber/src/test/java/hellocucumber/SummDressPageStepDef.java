package hellocucumber;

import com.uiautomation.base.TestBase;
import com.uiautomation.pageObjects.CreateAccountPage;
import com.uiautomation.pageObjects.SummerDressesPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class SummDressPageStepDef extends TestBase {

	SummerDressesPage sdPage = new SummerDressesPage();
	CreateAccountPage cAccPage= new CreateAccountPage();

	@And("^Verify if grid view is selected$")
	public void verifyGridVew() throws Throwable {
		sdPage.verifyGridView();

	}

	@Then("^User sorts items by price$")
	public void sortByPrice_highestFirst() throws Throwable {

		sdPage.sortByPrice();
	}

	@Then("^validate if product grid is arranged properly$")
	public void validateGridPostSort() throws Throwable {

		sdPage.verifyGridArrangementAfterSort_LowestFirst();

	}
	

	@Then("^User selects a product$")
	public void user_selects_a_product() throws Throwable {
		cAccPage.productSelection();
	}

}
