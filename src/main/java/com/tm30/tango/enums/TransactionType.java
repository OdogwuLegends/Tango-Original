package com.tm30.tango.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TransactionType {
    PURCHASE("PURCHASE"),REFUND("REFUND");

    private final String value;

    TransactionType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static TransactionType forValue(String value) {
        for (TransactionType transactionType : TransactionType.values()) {
            if (transactionType.value.equals(value)) {
                return transactionType;
            }
        }
        throw new IllegalArgumentException("Unknown TRANSACTION type: " + value);
    }
}
