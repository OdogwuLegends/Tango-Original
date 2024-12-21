package com.tm30.tango.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum LimitType {
    DAILY("DAILY"), WEEKLY("WEEKLY"), MONTHLY("MONTHLY"),CUSTOM("CUSTOM");

    private final String value;

    LimitType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static LimitType forValue(String value) {
        for (LimitType type : LimitType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown LIMIT type: " + value);
    }
}
