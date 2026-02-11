package com.space.starwalkerplatform.configuration;

import com.space.starwalkerplatform.dtos.Api;
import com.space.starwalkerplatform.dtos.EarthObserver;
import lombok.Data;
import org.springframework.context.annotation.Configuration;


@Configuration
@Data
public class N2YOConfig {
    private Api api = new Api();
    private EarthObserver earthObserver = new EarthObserver();
}
