package com.space.starwalkerplatform.controllers;

import com.space.starwalkerplatform.dtos.SatellitePosition;
import com.space.starwalkerplatform.services.SatelliteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/satellites")
@AllArgsConstructor
public class SatelliteController {

    private final SatelliteService satelliteService;

    @GetMapping("/{satelliteId}")
    public ResponseEntity<SatellitePosition> getSatellitePosition(@PathVariable Integer satelliteId, @RequestParam(required = false) Integer seconds ) {

        SatellitePosition position = satelliteService.getSatellitePosition(satelliteId, seconds);
        return ResponseEntity.ok(position);
    }
}
