package com.space.starwalkerplatform.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "n2yo")
@Component
@Data
public class N2YOConfig {
    private ApiConfig api = new ApiConfig();

    @Data
    public static class ApiConfig {            // ← static is correct & recommended
        private String baseUrl;
        private String key;
    }
}
