package com.space.starwalkerplatform.controllers;

import com.space.starwalkerplatform.dtos.abovesatellites.SatellitesAboveData;
import com.space.starwalkerplatform.dtos.abovesatellites.SatellitesAbovePosition;
import com.space.starwalkerplatform.dtos.singlesatellite.SatelliteData;
import com.space.starwalkerplatform.services.SatelliteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/satellites")
@AllArgsConstructor
public class SatelliteController {

    private final SatelliteService satelliteService;

    @GetMapping("/{satelliteId}/{seconds}")
    public ResponseEntity<SatelliteData> getSatelliteData(@PathVariable Integer satelliteId, @PathVariable Integer seconds ) {

        SatelliteData satelliteData = satelliteService.getSatelliteData(satelliteId, seconds);
        return ResponseEntity.ok(satelliteData);
    }

    @GetMapping("/satellites-above")
    public ResponseEntity<SatellitesAboveData> getSatellitesAbovePosition() {

        SatellitesAboveData satellitesAboveData = satelliteService.getSatelliteAboveData();
        return ResponseEntity.ok(satellitesAboveData);
    }

    @GetMapping("/closest-satellites-above")
    public ResponseEntity<SatellitesAboveData>  getClosestSatellitesAbovePosition() {

        SatellitesAboveData closestSatellitesAboveData = satelliteService.getClosestSatellites(12);
        return ResponseEntity.ok(closestSatellitesAboveData);
    }
}
