package com.example.framework.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.InputStream;
import java.util.Optional;

public class ConfigManager {
    private static Environment env;
    public static Environment env() {
        if (env == null) env = load();
        return env;
    }
    private static Environment load() {
       /* String targetEnv = Optional.ofNullable(System.getProperty("env"))
                .orElse(System.getenv("ENV"))
                .orElse("qa");*/
           String targetEnv = Optional.ofNullable(System.getProperty("env"))
        .or(() -> Optional.ofNullable(System.getenv("ENV")))
        .orElse("qa");     
        String path = String.format("/config/%s.yaml", targetEnv);
        try (InputStream is = ConfigManager.class.getResourceAsStream(path)) {
            if (is == null) throw new RuntimeException("Config not found: " + path);
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            return mapper.readValue(is, Environment.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config for env: " + targetEnv, e);
        }
    }
}