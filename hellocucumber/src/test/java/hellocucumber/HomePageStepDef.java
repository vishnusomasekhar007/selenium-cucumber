package hellocucumber;



//import junit.framework.Assert;

import com.uiautomation.base.TestBase;
import com.uiautomation.pageObjects.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


public class HomePageStepDef extends TestBase {

	HomePage hpage = new HomePage();

	@Given("^User is on Homepage$")
	public void homePageValidation() throws Throwable {
		TestBase.initialization();
		String pageTitle = hpage.validateLoginPageTitle();
		//Assert.assertEquals("My Store", pageTitle);
		
	}

	@And("^User navigates to SignIn Page$")
	public void clickSignInLink() throws Throwable {
		hpage.clickSignIn();

	}

}
