package com.space.starwalkerplatform.dtos.abovesatellites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SatellitesAbovePosition {

    @JsonProperty("satid")
    private Integer satId;

    @JsonProperty("satname")
    private String satName;

    @JsonProperty("intDesignator")
    private String intDesignator;

    @JsonProperty("launchDate")
    private String launchDate;

    @JsonProperty("satlat")
    private Double satLatitude;

    @JsonProperty("satlng")
    private Double satLongitude;

    @JsonProperty("satalt")
    private Double satAltitude;

}
