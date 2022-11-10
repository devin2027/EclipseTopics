package stepDefinations;


import org.junit.runner.RunWith;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefination {
	
	@Given("^User is on landing page$")
	public void user_is_on_landing_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("landing page");
	}

	@When("^User login into applicaion with username and password$")
	public void user_login_into_accoutn_using_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("username and password");
	}

	@Then("^Home page is populated$")
	public void my_account_page_is_populated() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("home page populated");
	}
	
	@And("^Cards are displayed$")
	public void Cards_are_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Cards are displayed");
	}
	
	
}
