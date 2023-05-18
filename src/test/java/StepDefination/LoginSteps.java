package StepDefination;



import Helper.BaseNewLook;
import Page.LginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseNewLook {
	LginPage login=new LginPage();

	@Given("User launch site URL")
	public void user_launch_site_url() {
		setup();
		
	   
	}
	@Then("Verify the new look logo is present or not")
	public void verify_the_new_look_logo_is_present_or_not() {
		login.verify_the_new_look_logo_is_present_or_not();
	    
	}

	@Then("Click on the user Account button")
	public void click_on_the_user_account_button() throws InterruptedException {
		login.click_on_the_user_account_button();
	  
	}

	@When("User enter unvalid username and password")
	public void user_enter_unvalid_username_and_password() throws InterruptedException {
		login.user_enter_unvalid_username_and_password();
	  
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		login.user_click_on_login_button();
	  
	}

	@Then("verify the error message")
	public void verify_the_error_message() {
		login.verify_the_error_message();
	   
	}

}
