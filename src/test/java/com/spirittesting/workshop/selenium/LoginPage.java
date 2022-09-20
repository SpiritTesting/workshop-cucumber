package com.spirittesting.workshop.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends PageObject {

    @FindBy(css = "h1")
    WebElement caption;
    @FindBy(id = "anmeldung.name")
    WebElement inputName;
    @FindBy(id = "anmeldung.passwort")
    WebElement inputPasswort;
    @FindBy(id = "anmeldung.aktion.submit")
    WebElement submitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String username) {
        wait.until(visibilityOf(inputName)).sendKeys(username);
    }

    public void setPassword(String password) {
        wait.until(visibilityOf(inputPasswort)).sendKeys(password);
    }

    public void clickSubmit() {
        wait.until(elementToBeClickable(submitButton)).click();
    }

    public String getUsernameValue() {
        return inputName.getAttribute("value");
    }

    public String getPasswordValue() {
        return inputPasswort.getAttribute("value");
    }

    public String getCaption() {
        return caption.getText();
    }
}
