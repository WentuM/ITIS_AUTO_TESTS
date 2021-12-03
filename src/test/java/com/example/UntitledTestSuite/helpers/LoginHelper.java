package com.example.UntitledTestSuite.helpers;

import com.example.AppManager;
import com.example.UntitledTestSuite.models.User;
import org.openqa.selenium.By;

public class LoginHelper extends BaseHelper {

    public LoginHelper(AppManager appManager) {
        super(appManager);
    }

    public void login(User user) {
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(user.getUsername());
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector(".login__groups")).submit();
    }

    public boolean isLoggedIn() {
        return !driver.getCurrentUrl().contains("login");
    }

    public boolean isLoggedIn(String email) {
        driver.get("http://localhost:8080/home");
        if (isLoggedIn()) {
            String currentUserEmail = driver.findElement(By.name("email")).getAttribute("value");

            return currentUserEmail.equals(email);
        }

        return false;
    }

    public void logout() {
        driver.get("http://school-sotka.herokuapp.com/logout");
    }
}