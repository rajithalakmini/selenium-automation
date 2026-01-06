package com.example.framework.utils;

import java.util.UUID;

public class DataGenerator {
    public static String randomEmail() { return "user+" + UUID.randomUUID() + "@example.com"; }
    public static String randomName() { return "User-" + UUID.randomUUID().toString().substring(0, 8); }
}