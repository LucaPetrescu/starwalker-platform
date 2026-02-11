package com.space.starwalkerplatform.services;

import com.space.starwalkerplatform.configuration.N2YOConfig;
import com.space.starwalkerplatform.configuration.RestTemplateConfig;
import com.space.starwalkerplatform.dtos.SatellitePosition;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SatelliteService {

    private final RestTemplateConfig restTemplate;
    private final N2YOConfig n2yoConfig;

    public SatellitePosition getSatellitePosition(Integer satelliteId, Integer seconds) {
        if (seconds == null || seconds < 1) {
            seconds = 1;
        }

        String url = buildUrl(satelliteId, seconds);

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

    public SatellitePosition getISSPosition() {
        return getSatellitePosition(25544, 1);
    }

    private String buildUrl(Integer satelliteId, Integer seconds) {
        return String.format("%s/positions/%d/%f/%f/%f/%d/&apiKey=%s",
                n2yoConfig.getApi().getBaseUrl(),
                satelliteId,
                n2yoConfig.getEarthObserver().getLatitude(),
                n2yoConfig.getEarthObserver().getLongitude(),
                n2yoConfig.getEarthObserver().getAltitude(),
                seconds,
                n2yoConfig.getApi().getKey());
    }
}
