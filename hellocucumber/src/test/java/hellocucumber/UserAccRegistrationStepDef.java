package hellocucumber;

import com.uiautomation.base.TestBase;
import com.uiautomation.pageObjects.CreateAccountPage;

import cucumber.api.java.en.When;

public class UserAccRegistrationStepDef extends TestBase {

	CreateAccountPage accCreationPage = new CreateAccountPage();
	
	@When("^User enters form details for registration$")
	public void userRegistrationWithValidations() throws Throwable {
	   
		
		accCreationPage.verifyOnCreateAccountPage();
		accCreationPage.fillMandatoryDetailsOnForm();
		accCreationPage.submitAccCreationForm();
		
		
	}

	
}
