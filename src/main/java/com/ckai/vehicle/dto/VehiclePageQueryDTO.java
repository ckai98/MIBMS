package com.ckai.vehicle.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VehiclePageQueryDTO implements Serializable {
    private int page;
    private int pageSize;
}
