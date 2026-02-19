package com.space.starwalkerplatform.services;

import com.space.starwalkerplatform.configuration.N2YOConfig;
import com.space.starwalkerplatform.dtos.SatellitePosition;
import org.springframework.web.util.UriComponentsBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class SatelliteService {

    private final RestTemplate restTemplate;
    private final N2YOConfig n2yoConfig;

    public SatellitePosition getSatellitePosition(Integer satelliteId) {

        log.info("Fetching satellite position for ID: {} from N2YO API", satelliteId);
        log.debug("Request URL: {}", url);

        try {
            SatellitePosition response = restTemplate.getForObject(url, SatellitePosition.class);
            log.info("Successfully fetched position for satellite: {}",
                    response != null && response.getInfo() != null ? response.getInfo().getSatName() : satelliteId);
            return response;
        } catch (Exception e) {
            log.error("Error fetching satellite position for ID: {}", satelliteId, e);
            throw new RuntimeException("Failed to fetch satellite data: " + e.getMessage(), e);
        }
    }

    private String buildUrl(Integer satelliteId, Integer seconds) {
        return UriComponentsBuilder.fromUriString(n2yoConfig.getApi().getBaseUrl()).path("/positions/{satId}/{lat}/{lng}/{alt}/{seconds}/").queryParam("apiKey")
    }
}
