package com.space.starwalkerplatform.dtos.visiblesatellite;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VisibleSatellitePosition {

    @JsonProperty("startAz")
    private Double startAz;

    @JsonProperty("startAzCompass")
    private String startAzCompass;

    @JsonProperty("startEl")
    private Double startEl;

    @JsonProperty("startUTC")
    private Long startUTC;

    @JsonProperty("maxAz")
    private Double maxAz;

    @JsonProperty("maxAzCompass")
    private String maxAzCompass;

    @JsonProperty("maxEl")
    private Double maxEl;

    @JsonProperty("maxUTC")
    private Long maxUTC;

    @JsonProperty("endAz")
    private Double endAz;

    @JsonProperty("endAzCompass")
    private String endAzCompass;

    @JsonProperty("endEl")
    private Double endEl;

    @JsonProperty("endUTC")
    private Long endUTC;

    @JsonProperty("mag")
    private Double magnitude;

    @JsonProperty("duration")
    private Integer duration;
}