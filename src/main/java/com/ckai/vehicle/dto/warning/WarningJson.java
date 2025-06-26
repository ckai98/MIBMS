package com.ckai.vehicle.dto.warning;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@JsonIgnoreProperties(ignoreUnknown = true)
public class WarningJson {
    private String carVid;
    private Integer warnId;
    private String signal;
    // private Map<String, Double> signal;
    private SignalData signalData;


    public void setSignalData(String signal) {
        this.signal = signal;
        try {
            ObjectMapper mapper = new ObjectMapper();
            this.signalData = mapper.readValue(signal, SignalData.class);
        } catch (Exception e){
            this.signalData = new SignalData();
        }
    }
    public SignalData getSignalData() {
        return signalData;
    }

    public Integer getWarnId() {
        return warnId;
    }

    public String getCarVid() {
        return carVid;
    }

    public String getSignal() {
        return signal;
    }

    public void setCarVid(String carVid) {
        this.carVid = carVid;
    }

    public void setWarnId(Integer warnId) {
        this.warnId = warnId;
    }
    public void setSignal(String signal) {
        this.signal = signal;
    }
}
