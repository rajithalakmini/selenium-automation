package com.example.tests;

import com.example.framework.config.ConfigManager;
import com.example.framework.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverFactory.getDriver();
        Reporter.getCurrentTestResult().getTestContext().setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverFactory.cleanup();
    }

    protected String baseUrl() {
        return ConfigManager.env().getBaseUrl();
    }
}