package com.ckai.vehicle.dto.warning;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignalData {
    @JsonProperty("Mx")
    private Double Mx;
    @JsonProperty("Mi")
    private Double Mi;
    @JsonProperty("Ix")
    private Double Ix;
    @JsonProperty("Ii")
    private Double Ii;
}
