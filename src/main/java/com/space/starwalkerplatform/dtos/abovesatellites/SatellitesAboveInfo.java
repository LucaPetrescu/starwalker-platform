package com.space.starwalkerplatform.dtos.abovesatellites;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SatellitesAboveInfo {

    @JsonProperty("category")
    private String category;

    @JsonProperty("transactioncount")
    private String transactionCount;

    @JsonProperty("satcount")
    private Integer satCount;

}
