package com.tm30.tango.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TransactionStatus {
    PENDING("PENDING"), COMPLETED("COMPLETED"), FAILED("FAILED");

    private final String value;

    TransactionStatus(String value) {
        this.value = value;
    }

    @JsonCreator
    public static TransactionStatus forValue(String value) {
        for (TransactionStatus transactionStatus : TransactionStatus.values()) {
            if (transactionStatus.value.equals(value)) {
                return transactionStatus;
            }
        }
        throw new IllegalArgumentException("Unknown TRANSACTION status: " + value);
    }
}
