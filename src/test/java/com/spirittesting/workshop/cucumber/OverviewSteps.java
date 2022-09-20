package com.spirittesting.workshop.cucumber;

import com.spirittesting.workshop.cucumber.data.Account;
import io.cucumber.java.DataTableType;
import io.cucumber.java.de.Angenommen;
import io.cucumber.java.de.Dann;
import io.cucumber.java.de.Wenn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class OverviewSteps extends AbstractSteps {

    @Angenommen("der User {string} ist angemeldet")
    @Given("the user {string} is logged in")
    public void theUserIsLoggedIn(String username) {
        loginPage.setUsername(username);
        loginPage.setPassword("geheim");
        loginPage.clickSubmit();
    }

    @Wenn("er den Abmelden Knopf drückt")
    @When("he presses the logout button")
    public void hePressesTheLogoutButton() {
        mainPage.logout();
    }

    @Dann("ist er abgemeldet")
    @Then("he is logged out of the application")
    public void heIsLoggedOutOfTheApplication() {
        assertThat(loginPage.getCaption()).contains("verehrter Kunde");
    }

    @Then("the following accounts are shown")
    @Dann("sieht er die folgenden Konten")
    public void theFollowingAccountsAreShown(List<Account> expectedAccounts) {
        List<Account> actualAccounts = mainPage.getAccounts();
        assertThat(actualAccounts).containsAll(expectedAccounts);
    }

    @When("he presses the button to add a USD account")
    public void hePressesTheButtonToAddAUSDAccount() {
    }

    @Then("a new account is shown")
    public void aNewAccountIsShown() {
    }

    @And("it has a balance of {string}")
    public void itHasABalanceOf(String balance) {
    }

    @DataTableType
    public Account accountEntryTransformer(Map<String, String> entry) {
        return new Account(
                entry.get("Kontonummer"),
                entry.get("Waehrung"),
                entry.get("Betrag"));
    }

}
