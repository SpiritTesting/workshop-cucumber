package com.spirittesting.workshop.selenium;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public abstract class PageObject {

    protected final Wait<WebDriver> wait;
    protected final WebDriver driver;

    protected PageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(3)).pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
        PageFactory.initElements(driver, this);
    }

}
