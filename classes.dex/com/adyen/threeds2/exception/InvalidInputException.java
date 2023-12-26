package com.adyen.threeds2.exception;

public final class InvalidInputException extends RuntimeException {
    public InvalidInputException(String str, Throwable th) {
        super(str, th);
    }
}
