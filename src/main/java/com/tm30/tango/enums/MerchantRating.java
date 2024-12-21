package com.tm30.tango.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum MerchantRating {
    ONE("ONE"), TWO("TWO"), THREE("THREE"), FOUR("FOUR"), FIVE("FIVE");

    private final String value;

    MerchantRating(String value) {
        this.value = value;
    }

    @JsonCreator
    public static MerchantRating fromString(String value) {
        for (MerchantRating type : values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown MERCHANT rating: " + value);
    }
}
