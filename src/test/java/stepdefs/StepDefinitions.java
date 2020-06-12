package stepdefs;

import featurelib.CalFeatureLibrary;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	CalFeatureLibrary calLibrary = new CalFeatureLibrary();
	@Given("I have a configured calculator")
	public void i_have_a_configured_calculator() {
		// Write code here that turns the phrase above into concrete actions
		calLibrary.open_calculator();
//		throw new io.cucumber.java.PendingException();
	}

	@When("I calculate")
	public void i_calculate() {
		// Write code here that turns the phrase above into concrete actions
		calLibrary.calculateNumber();
//		throw new io.cucumber.java.PendingException();
	}

	@Then("I the result")
	public void i_the_result() {
		// Write code here that turns the phrase above into concrete actions
		calLibrary.resultNumber();
//		throw new io.cucumber.java.PendingException();
	}
}
