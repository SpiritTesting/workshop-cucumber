package com.spirittesting.workshop.cucumber;

import io.cucumber.java.de.Und;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class LoginSteps extends AbstractSteps {

	@Given("the application is started")
	public void the_application_is_started() {
		log.info("The application is started");
	}

	@When("a valid credential is entered")
	public void a_valid_credential_is_entered() {
		loginPage.setUsername("tester2-2");
		loginPage.setPassword("geheim");
		loginPage.clickSubmit();
	}

	@Then("the main screen is shown")
	public void the_main_screen_is_shown() {
		mainPage.isVisible();
	}

	@Und("die Anwendung wird geschlossen")
	@Then("the application is closed")
	public void the_application_is_closed() {
		closeApplication();
	}
	
	@When("an invalid credential is entered")
	public void an_invalid_credential_is_entered() {
		loginPage.setUsername("tester2-2");
		loginPage.setPassword("falsch");
		loginPage.clickSubmit();
	}

	@Then("the input fields are cleared")
	public void the_input_fields_are_cleared() {
		assertThat(loginPage.getUsernameValue()).isNullOrEmpty();
		assertThat(loginPage.getPasswordValue()).isNullOrEmpty();
	}

	@Then("the input fields are not cleared")
	public void theInputFieldsAreNotCleared() {
		assertThat(loginPage.getUsernameValue()).isNotBlank();
		assertThat(loginPage.getPasswordValue()).isNotBlank();
	}

	@And("the login error message is shown")
	public void theLoginErrorMessageIsShown() {
		assertThat(loginPage.isErrorMessageShown()).isTrue();
	}
}
