package com.space.starwalkerplatform.controllers;

import com.space.starwalkerplatform.dtos.SatellitePosition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/satellites")
public class SatelliteController {

    private final SatelliteService satelliteService;

    @GetMapping("/{satelliteId}")
    public ResponseEntity<SatellitePosition> getSatellitePosition(@PathVariable Integer satelliteId, @RequestParam(required = false) Integer seconds ) {

        SatellitePosition position = satelliteService.getSatellitePosition(satelliteId, seconds);
        return ResponseEntity.ok(position);
    }

    @GetMapping("/iss")
    public ResponseEntity<SatellitePosition> getISSPosition() {

        SatellitePosition position = satelliteService.getISSPosition();
        return ResponseEntity.ok(position);
    }

}
