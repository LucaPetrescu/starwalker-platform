package com.space.starwalkerplatform.dtos;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "n2yo")
@Data
public class Api {

    private String baseUrl;
    private String key;

}
