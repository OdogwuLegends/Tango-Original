package com.tm30.tango.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum FuelType {
    PETROL("PETROL"),DIESEL("DIESEL"),GAS("GAS");

    private final String value;

    FuelType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static FuelType fromString(String value) {
        for (FuelType type : FuelType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown FUEL type: " + value);
    }
}
