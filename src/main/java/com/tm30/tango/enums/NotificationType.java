package com.tm30.tango.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum NotificationType {
    WALLET_TRANSACTION("WALLET TRANSACTION"), FUEL_TRANSACTION("FUEL TRANSACTION"), CARD_ISSUANCE("CARD ISSUANCE"), KYC_APPROVALS("KYC APPROVALS");

    private final String value;

    NotificationType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static NotificationType forValue(String value) {
        for (NotificationType type : NotificationType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown NOTIFICATION type: " + value);
    }
}
