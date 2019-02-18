package hellocucumber;

import com.uiautomation.base.TestBase;
import com.uiautomation.pageObjects.AddToCartPage;

import cucumber.api.java.en.Then;

public class AddToCartPageStepDef extends TestBase {

	AddToCartPage addCartPage= new AddToCartPage();
	
	

@Then("^User changes colour of product$")
public void changeProductColour() throws Throwable {
	addCartPage.changeDressColour();
	
}

@Then("^Add product to cart and checkout$")
public void checkoutProduct() throws Throwable {
  
	addCartPage.addToCartAndCheckOut();
	
}




}
