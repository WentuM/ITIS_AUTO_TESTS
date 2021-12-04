package com.example.UntitledTestSuite.tests;

import com.example.UntitledTestSuite.models.User;
import org.junit.jupiter.api.Test;

public class LoginTest extends TestBase {

    @Test
    public void loginTestCase() throws Exception {
        appManager.getNavigationHelper().getLoginPage();
        User user = new User("examplE@mail.ru", "qwertY123");
        appManager.getLoginHelper().login(user);
    }
}
