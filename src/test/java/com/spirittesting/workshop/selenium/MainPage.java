package com.spirittesting.workshop.selenium;

import com.spirittesting.workshop.cucumber.data.Account;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@Slf4j
public class MainPage extends PageObject {

    @FindBy(id = "home.abmelden")
    WebElement logoutButton;
    @FindBy(css = "table")
    WebElement accountTable;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @SneakyThrows
    public void isVisible() {
        wait.until(presenceOfElementLocated(By.id("home.abmelden")));
    }

    public void logout() {
        wait.until(elementToBeClickable(logoutButton)).click();
    }

    public List<Account> getAccounts() {
        wait.until(presenceOfElementLocated(By.tagName("table")));
        Map<String, Account> accounts = new HashMap<>();
        accountTable.findElements(By.tagName("td")).forEach(td -> {
            String accountNumber = td.getAttribute("id").substring(13,21);
            String columnType = td.getAttribute("id").substring(22);
            String value = td.getText();
            if (!accounts.containsKey(accountNumber)) accounts.put(accountNumber, new Account());
            switch (columnType) {
                case "kontonummer" -> accounts.get(accountNumber).setAccountNumber(value);
                case "betrag" -> {
                    accounts.get(accountNumber).setCurrency(value.substring(0,3));
                    accounts.get(accountNumber).setAmount(value.substring(4));
                }
                default -> {}
            }
        });
        return accounts.values().stream().toList();
    }

}
