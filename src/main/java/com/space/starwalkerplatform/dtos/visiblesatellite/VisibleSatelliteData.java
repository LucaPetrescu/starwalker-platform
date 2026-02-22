package com.space.starwalkerplatform.dtos.visiblesatellite;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.space.starwalkerplatform.dtos.singlesatellite.SatelliteInfo;
import com.space.starwalkerplatform.dtos.singlesatellite.SatellitePosition;
import lombok.Data;

import java.util.List;

@Data
public class VisibleSatelliteData {

    @JsonProperty("info")
    private SatelliteInfo info;

    @JsonProperty("positions")
    private List<SatellitePosition> positions;

}
