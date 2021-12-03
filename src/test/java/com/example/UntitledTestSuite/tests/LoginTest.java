package com.example.UntitledTestSuite.tests;

import com.example.UntitledTestSuite.Settings;
import com.example.UntitledTestSuite.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends TestBase {
    @BeforeEach
    public void logout() {
        appManager.getLoginHelper().logout();
    }

    @Test
    public void loginWithValidData() throws Exception {
        User user = new User(Settings.getLogin(), Settings.getPassword());

        appManager.getLoginHelper().login(user);

        assertTrue(appManager.getLoginHelper().isLoggedIn(user.getUsername()));
    }

    @Test
    public void loginWithInvalidData() throws Exception {
        User accountData = new User("NOT", "WORK");

        appManager.getLoginHelper().login(accountData);

        assertFalse(appManager.getLoginHelper().isLoggedIn());
    }
}