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
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class OverviewSteps extends AbstractSteps {

    @Angenommen("der User {string} mit dem Passwort {string} ist angemeldet")
    @Given("the user {string} with password {string} is logged in")
    public void theUserIsLoggedIn(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickSubmit();
    }

    @Angenommen("der User {string} ist angemeldet")
    @Given("the user {string} with is logged in")
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
    @SneakyThrows
    public void heIsLoggedOutOfTheApplication() {
        Thread.sleep(500);
        assertThat(loginPage.getCaption()).contains("Willkommen in der Buggybank");
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
                entry.get("Name"),
                entry.get("Kontonummer"),
                entry.get("Waehrung"),
                entry.get("Betrag"));
    }

    @Angenommen("der User schickt einen POST request an {string} mit")
    public void derUserSchicktEinenPOSTRequestAnMit(String endpoint, String body) {
        log.info("Der Endpoint lautet {} und der Body {}", endpoint, body);
    }
}
