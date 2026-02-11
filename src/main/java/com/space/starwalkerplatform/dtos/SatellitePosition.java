package com.space.starwalkerplatform.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.swing.text.Position;
import java.util.List;

@Data
public class SatellitePosition {

    @JsonProperty("info")
    private SatelliteInfo info;

    @JsonProperty("positions")
    private List<Position> positions;

}
