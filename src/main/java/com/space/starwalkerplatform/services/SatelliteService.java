package com.space.starwalkerplatform.services;

import com.space.starwalkerplatform.configuration.N2YOConfig;
import com.space.starwalkerplatform.dtos.EarthObserverConstants;
import com.space.starwalkerplatform.dtos.abovesatellites.SatellitesAboveData;
import com.space.starwalkerplatform.dtos.abovesatellites.SatellitesAbovePosition;
import com.space.starwalkerplatform.dtos.singlesatellite.SatelliteData;
import com.space.starwalkerplatform.dtos.visiblesatellite.VisibleSatelliteData;
import org.springframework.web.util.UriComponentsBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SatelliteService {

    private final RestTemplate restTemplate;
    private final N2YOConfig n2yoConfig;

    public SatelliteData getSatelliteData(Integer satelliteId, Integer seconds) {

        String url = buildUrlForSingleSatellite(satelliteId, seconds);

        log.info("Fetching satellite position for ID: {} from N2YO API", satelliteId);
        log.debug("Request URL: {}", url);

        try {
            return restTemplate.getForObject(url, SatelliteData.class);
        } catch (Exception e) {
            log.error("Error fetching satellite position for ID: {}", satelliteId, e);
            throw new RuntimeException("Failed to fetch satellite data: " + e.getMessage(), e);
        }
    }

    public SatellitesAboveData getSatelliteAboveData() {

        String url = buildUrlForSatellitesInObserverRadius();

        log.info("Fetching satellite Above data from N2YO API for current observer radius: {}", url);
        log.debug("Request URL: {}", url);

        try {
            return restTemplate.getForObject(url, SatellitesAboveData.class);
        } catch (Exception e) {
            log.error("Error fetching satellite Above data from N2YO API", e);
            throw new RuntimeException("Failed to fetch satellite data: " + e.getMessage(), e);
        }
    }

    public SatellitesAboveData getClosestSatellites(Integer limit) {
        SatellitesAboveData response = getSatelliteAboveData();

        if(response == null) {
            log.warn("No satellite Above data found for limit: {}", limit);
            return response;
        }

        List<SatellitesAbovePosition> sorted = response.getSatellitesAbovePosition()
                .stream()
                .sorted(Comparator.comparing(SatellitesAbovePosition::getSatAltitude))
                .limit(limit != null ? limit : 12)
                .toList();

        SatellitesAboveData result = new SatellitesAboveData();
        result.setSatellitesAboveInfo(response.getSatellitesAboveInfo());
        result.setSatellitesAbovePosition(sorted);

        log.info("Satellites Above data found for limit: {}", limit);

        return result;
    }

    public List<VisibleSatelliteData> getVisibleSatellites() {
        System.out.println("This is supposed to work");
        return null;
    }

    private String buildUrlForSingleSatellite(Integer satelliteId, Integer seconds) {

        return UriComponentsBuilder.fromUriString(n2yoConfig.getApi().getBaseUrl())
                .path("/positions/{satId}/{lat}/{lng}/{alt}/{seconds}/")
                .queryParam("apiKey", n2yoConfig.getApi().getKey())
                .buildAndExpand(satelliteId, EarthObserverConstants.LATITUDE, EarthObserverConstants.LONGITUDE, EarthObserverConstants.ALTITUDE, seconds)
                .toUriString();
    }

    private String buildUrlForSatellitesInObserverRadius() {
        return UriComponentsBuilder.fromUriString(n2yoConfig.getApi().getBaseUrl())
                .path("/above/{lat}/{lng}/{alt}/{rad}/{categoryId}/")
                .queryParam("apiKey", n2yoConfig.getApi().getKey())
                .buildAndExpand(EarthObserverConstants.LATITUDE, EarthObserverConstants.LONGITUDE, EarthObserverConstants.ALTITUDE, EarthObserverConstants.RADIUS, EarthObserverConstants.CATEGORY)
                .toUriString();
    }

    private String buildUrlForSatelliteVisualPass(Integer satelliteId, Integer seconds, Integer minimumVisibility) {
        return UriComponentsBuilder.fromUriString(n2yoConfig.getApi().getBaseUrl())
                .path("/visualpasses/{satId}/{lat}/{lng}/{alt}/{days}/{minVis}")
                .queryParam("apiKey", n2yoConfig.getApi().getKey())
                .buildAndExpand(satelliteId, EarthObserverConstants.LATITUDE, EarthObserverConstants.LONGITUDE, EarthObserverConstants.ALTITUDE, seconds, minimumVisibility)
                .toUriString();
    }
}
