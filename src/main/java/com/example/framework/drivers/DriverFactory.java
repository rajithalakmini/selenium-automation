package com.example.framework.drivers;

import com.example.framework.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
            DRIVER.set(create());
        }
        return DRIVER.get();
    }

    private static WebDriver create() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (ConfigManager.env().isHeadless()) {
            options.addArguments("--headless=new");
        }
        String chromiumBinary = ConfigManager.env().getChromiumBinary();
        if (chromiumBinary != null && !chromiumBinary.isBlank()) {
            options.setBinary(chromiumBinary);
        }
        // If using WebDriverManager, you can initialize here; otherwise ensure chromedriver is on PATH.
        return new ChromeDriver(options);
    }

    public static void cleanup() {
        WebDriver d = DRIVER.get();
        if (d != null) {
            d.quit();
            DRIVER.remove();
        }
    }
}