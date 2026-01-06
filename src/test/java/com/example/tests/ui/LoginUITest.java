package com.example.tests.ui;

import com.example.framework.config.ConfigManager;
import com.example.tests.BaseTest;
import com.example.tests.ui.flows.AuthFlow;
import org.testng.annotations.Test;

import static com.example.tests.TestGroups.*;

public class LoginUITest extends BaseTest {

    @Test(groups = {UI, SMOKE})
    public void userCanLogin() {
        new AuthFlow(driver).login(baseUrl(), ConfigManager.env().getUsername(), ConfigManager.env().getPassword());
        // TODO: add assertion verifying login success (URL, visible element, etc.)
    }
}