package com.adyen.checkout.core.exception;

public class NoConstructorException extends IllegalStateException {
    private static final long serialVersionUID = -5460575792365783947L;

    public NoConstructorException() {
        super("No instances allowed.");
    }
}
