package hellocucumber;

import com.uiautomation.base.TestBase;
import com.uiautomation.pageObjects.SignInPage;

import cucumber.api.java.en.Given;

public class SignInPageStepDef extends TestBase {

	SignInPage spage = new SignInPage();

	@Given("^User registers with valid emailID post validation for incorrect emailID$")
	public void registerEmailID() throws Throwable {

		spage.enterEmailID();
	}

}
