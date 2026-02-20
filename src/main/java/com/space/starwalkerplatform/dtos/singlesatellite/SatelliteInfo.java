package com.space.starwalkerplatform.dtos.singlesatellite;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SatelliteInfo {

    @JsonProperty("satname")
    private String satName;

    @JsonProperty("satid")
    private Integer satId;

    @JsonProperty("transactionscount")
    private Integer transactionsCount;

}
