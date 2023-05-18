package StepDefination;

import Helper.BaseNewLook;
import Page.SignUpPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignupSteps extends BaseNewLook {
	SignUpPage signup=new SignUpPage();
	@Given("User launch the site URL")
	public void user_launch_the_site_url() {
		setup();
	  
	}

	@When("click on the user Account button")
	public void click_on_the_user_account_button() throws InterruptedException {
		signup.click_on_the_user_account_button();
	    
		
	}

	@When("click on the Create An Account Button")
	public void click_on_the_create_an_account_button() throws InterruptedException {
		signup.click_on_the_create_an_account_button();
	    
	}

	@When("Fill all the mandatary details for sign up a user")
	public void fill_all_the_mandatary_details_for_sign_up_a_user() throws InterruptedException {
		signup.fill_all_the_mandatary_details_for_sign_up_a_user();
	    
	}

	@Then("click on the sign Up button")
	public void click_on_the_sign_up_button() throws InterruptedException {
		signup.click_on_the_sign_up_button();
	
	}

	@Then("Verify the success text")
	public void verify_the_success_text() {
		signup.verify_the_success_text();
	    
	}

}
