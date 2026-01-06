package com.example.framework.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private final int maxRetryCount = 1;
    private int currentRetry = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (currentRetry < maxRetryCount) {
            currentRetry++;
            return true;
        }
        return false;
    }
}