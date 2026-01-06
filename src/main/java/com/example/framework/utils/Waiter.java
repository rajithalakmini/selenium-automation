package com.example.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Waiter {
    public static <T> T until(WebDriver driver, ExpectedCondition<T> condition, long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(condition);
    }
}