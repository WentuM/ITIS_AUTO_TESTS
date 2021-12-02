package com.example.UntitledTestSuite.tests;

import com.example.AppManager;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    protected static AppManager appManager;

    @BeforeAll
    protected static void setUp() throws Exception {
        appManager = AppManager.getInstance();
    }
}
