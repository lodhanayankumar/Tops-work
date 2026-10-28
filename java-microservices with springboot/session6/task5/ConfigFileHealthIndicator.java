package com.example.userprofileservice;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ConfigFileHealthIndicator implements HealthIndicator {

    @Value("${app.health.config-file:config/config.txt}")
    private String configFilePath;

    @Override
    public Health health() {

        Path path = Paths.get(configFilePath);

        if (Files.exists(path) && Files.isRegularFile(path)) {

            return Health.up()
                    .withDetail("file", configFilePath)
                    .withDetail("message", "Configuration file exists")
                    .build();

        } else {

            return Health.down()
                    .withDetail("file", configFilePath)
                    .withDetail("message", "Configuration file is missing")
                    .build();
        }
    }
}
