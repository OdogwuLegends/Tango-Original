package com.tm30.tango.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CardStatus {
    ACTIVE("ACTIVE"), ISSUED("ISSUED"), PENDING("PENDING"), DEACTIVATED("DEACTIVATED");

    private final String value;

    CardStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public static CardStatus forValue(String value) {
        for (CardStatus cardStatus : CardStatus.values()) {
            if (cardStatus.value.equals(value)) {
                return cardStatus;
            }
        }
        throw new IllegalArgumentException("Unknown CARD status: " + value);
    }
}
