package com.spirittesting.workshop.cucumber;

import com.spirittesting.workshop.selenium.LoginPage;
import com.spirittesting.workshop.selenium.MainPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractSteps {

    protected static WebDriver driver = null;
    protected static LoginPage loginPage = null;
    protected static MainPage mainPage = null;

    protected AbstractSteps() {
        driver.get("http://buggybank-1.spirit-indianer.com");
    }

    protected void closeApplication() {
        mainPage.logout();
        driver.manage().deleteAllCookies();
    }

}
