package com.tm30.tango.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum VehicleType {
    AUTO("AUTO"), MANUAL("MANUAL"); //ASK ADAMS FOR THE REAL VALUES

    private final String value;

    VehicleType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static VehicleType fromString(String value) {
        for (VehicleType type : VehicleType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown VEHICLE type: " + value);
    }
}
