package com.example;

import com.example.UntitledTestSuite.helpers.LoginHelper;
import com.example.UntitledTestSuite.helpers.NavigationHelper;
import com.example.UntitledTestSuite.helpers.TestHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AppManager {
    private final String baseUrl;
    private final StringBuffer verificationErrors;
    private JavascriptExecutor js;
    private WebDriver driver;

    private LoginHelper loginHelper;
    private NavigationHelper navigationHelper;
    private TestHelper testHelper;
    private static ThreadLocal<AppManager> appManagerThreadLocal = new ThreadLocal<>();

    public AppManager() {
        System.setProperty("webdriver.chrome.driver", "/Users/danil/Downloads/chromedriver");
        verificationErrors = new StringBuffer();
        driver = new ChromeDriver();
        baseUrl = "http://localhost:8080";
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        driver.get("http://localhost:8080/home");

        loginHelper = new LoginHelper(this);
        navigationHelper = new NavigationHelper(this, baseUrl);
        testHelper = new TestHelper(this);
    }

    public static AppManager getInstance() {
        AppManager appManager = appManagerThreadLocal.get();

        if (appManager == null) {
            appManager = new AppManager();
            appManager.getNavigationHelper().getHomePage();
            appManagerThreadLocal.set(appManager);
        }

        return appManager;
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public TestHelper getTestHelper() { return testHelper; }
}
