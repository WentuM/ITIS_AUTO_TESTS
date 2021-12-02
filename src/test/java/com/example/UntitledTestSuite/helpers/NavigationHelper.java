package com.example.UntitledTestSuite.helpers;

import com.example.AppManager;

public class NavigationHelper extends BaseHelper {
    private final String baseUrl;

    public NavigationHelper(AppManager appManager, String baseUrl) {
        super(appManager);
        this.baseUrl = baseUrl;
    }

    public void getHomePage() {
        this.driver.get(baseUrl + "/home");
    }

    public void getLoginPage() {
        this.driver.get(baseUrl + "/signIn");
    }

    public void getLogoutPage() {
        this.driver.get(baseUrl + "/signIn?logout");
    }

    public void getPostGenerateEntityPage() {
        this.driver.get(baseUrl + "/home");
    }
}
