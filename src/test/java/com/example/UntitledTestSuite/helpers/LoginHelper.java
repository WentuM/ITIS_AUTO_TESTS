package com.example.UntitledTestSuite.helpers;

import com.example.AppManager;
import com.example.UntitledTestSuite.models.User;
import org.openqa.selenium.By;

public class LoginHelper extends BaseHelper {

    public LoginHelper(AppManager appManager) {
        super(appManager);
    }

    public void login(User user) {
        if (isLoggedIn()) {
            if (isLoggedIn(user.getUsername())) {
                return;
            }
            logout();
        }

        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(user.getUsername());
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(user.getPassword());
        driver.findElement(By.cssSelector(".login__groups")).submit();
    }

    public boolean isLoggedIn() {
        return !driver.getCurrentUrl().contains("signIn");
    }

    public boolean isLoggedIn(String email) {
        driver.get("http://localhost:8080/home");
        if (isLoggedIn()) {
            String currentUserEmail = driver.findElement(By.className("small__profile-alies")).getText();

            return currentUserEmail.equals(email);
        }

        return false;
    }

    public void logout() {
        driver.get("http://localhost:8080/signIn?logout");
    }
}