package com.adyen.threeds2.util;

import com.adyen.threeds2.exception.InvalidInputException;

public final class Preconditions {
    private Preconditions() {
    }

    public static void requireNonEmpty(String str, String str2) throws InvalidInputException {
        if (str2 == null || str2.length() == 0) {
            throw new InvalidInputException(str + " must not be empty.", (Throwable) null);
        }
    }

    public static void requireNonLessThan(String str, int i, int i2) throws InvalidInputException {
        if (i < i2) {
            throw new InvalidInputException(str + " must not be less than " + i2 + ".", (Throwable) null);
        }
    }

    public static void requireNonNegative(String str, int i) throws InvalidInputException {
        if (i < 0) {
            throw new InvalidInputException(str + " must not be negative.", (Throwable) null);
        }
    }

    public static void requireNonNull(String str, Object obj) throws InvalidInputException {
        if (obj == null) {
            throw new InvalidInputException(str + " must not be null.", (Throwable) null);
        }
    }
}
