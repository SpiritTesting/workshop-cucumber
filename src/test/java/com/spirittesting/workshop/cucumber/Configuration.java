package com.spirittesting.workshop.cucumber;

import com.spirittesting.workshop.selenium.LoginPage;
import com.spirittesting.workshop.selenium.MainPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.OutputStream;
import java.io.PrintStream;

public class Configuration {

    @BeforeAll
    public static void initialize() {
        System.setErr(
                new PrintStream(new OutputStream() {
                    @Override
                    public void close() {
                    }

                    @Override
                    public void flush() {
                    }

                    @Override
                    public void write(byte[] b) {
                    }

                    @Override
                    public void write(byte[] b, int off, int len) {
                    }

                    @Override
                    public void write(int b) {
                    }

                }));
        AbstractSteps.driver = WebDriverManager.edgedriver().create();
        AbstractSteps.loginPage = new LoginPage(AbstractSteps.driver);
        AbstractSteps.mainPage = new MainPage(AbstractSteps.driver);
    }

    @AfterAll
    public static void destroyDriver() {
        AbstractSteps.driver.close();
        AbstractSteps.driver = null;
        AbstractSteps.loginPage = null;
        AbstractSteps.mainPage = null;
    }

}
