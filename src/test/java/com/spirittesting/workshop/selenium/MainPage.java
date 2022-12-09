package com.spirittesting.workshop.selenium;

import com.spirittesting.workshop.cucumber.data.Account;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@Slf4j
public class MainPage extends PageObject {

    @FindBy(id = "aktion.abmelden")
    WebElement logoutButton;
    @FindBy(id = "konten.tabelle")
    WebElement accountTable;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @SneakyThrows
    public void isVisible() {
        wait.until(presenceOfElementLocated(By.id("aktion.abmelden")));
    }

    public void logout() {
        wait.until(elementToBeClickable(logoutButton)).click();
    }

    public List<Account> getAccounts() {
        wait.until(presenceOfElementLocated(By.id("konten.tabelle")));
        List<Account> result = new ArrayList<>();
        Account account = new Account();
        for (WebElement td : accountTable.findElements(By.tagName("td"))) {
            String id = td.getAttribute("id");
            id = id.substring(id.lastIndexOf('.') + 1);
            switch (id) {
                case "name":
                    account.setName(td.getText());
                    break;
                case "kontonummer":
                    account.setAccountNumber(td.getText());
                    break;
                case "kontostand":
                    account.setCurrency(td.getText().substring(0, 3));
                    account.setAmount(td.getText().substring(4));
                    break;
                case "aktionen":
                    result.add(account);
                    account = new Account();
                    break;
            }
        }
        return result;
    }

}
