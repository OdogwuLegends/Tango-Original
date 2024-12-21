package com.tm30.tango.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UserStatus {

    INDIVIDUAL("INDIVIDUAL"), CORPORATE("CORPORATE");

    private final String value;

    UserStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public static UserStatus forValue(String value) {
        for (UserStatus userStatus : UserStatus.values()) {
            if (userStatus.value.equals(value)) {
                return userStatus;
            }
        }
        throw new IllegalArgumentException("Unknown USER status: " + value);
    }
}
