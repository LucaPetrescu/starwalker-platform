package com.space.starwalkerplatform.dtos.visiblesatellite;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VisibleSatelliteInfo {

    @JsonProperty("satid")
    private Integer satid;

    @JsonProperty("satname")
    private String satName;

    @JsonProperty("transactionscount")
    private Integer transactionsCount;

    @JsonProperty("passescount")
    private Integer passesCount;

}
