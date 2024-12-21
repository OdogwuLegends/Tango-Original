package com.tm30.tango.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ChargeBackStatus {
    APPROVED("APPROVED"), PENDING("PENDING"),IN_PROGRESS("IN PROGRESS"), RESOLVED("RESOLVED"), REJECTED("REJECTED");

    private final String value;

    ChargeBackStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public static ChargeBackStatus fromString(String value) {
        for (ChargeBackStatus status : ChargeBackStatus.values()) {
            if (status.value.equals(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown CHARGE BACK status: " + value);
    }
}
