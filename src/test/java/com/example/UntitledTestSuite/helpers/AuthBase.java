package com.example.UntitledTestSuite.helpers;

import com.example.UntitledTestSuite.Settings;
import com.example.UntitledTestSuite.models.User;
import com.example.UntitledTestSuite.tests.TestBase;
import org.junit.jupiter.api.BeforeAll;

public class AuthBase extends TestBase {

    @BeforeAll
    protected static void setUpAuth() {
        appManager.getNavigationHelper().getLoginPage();
        User user = new User(Settings.getLogin(), Settings.getPassword());
        appManager.getLoginHelper().login(user);
    }
}
