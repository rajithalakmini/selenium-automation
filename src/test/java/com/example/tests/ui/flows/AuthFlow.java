package com.example.tests.ui.flows;

import com.example.tests.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class AuthFlow {
    private final WebDriver driver;
    public AuthFlow(WebDriver driver) { this.driver = driver; }

    public void login(String baseUrl, String user, String pass) {
        new LoginPage(driver)
                .open(baseUrl)
                .login(user, pass);
    }
}