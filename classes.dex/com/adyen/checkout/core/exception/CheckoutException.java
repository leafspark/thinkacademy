package com.adyen.checkout.core.exception;

public class CheckoutException extends RuntimeException {
    private static final long serialVersionUID = -2465223452079546925L;

    public CheckoutException(String str) {
        this(str, (Throwable) null);
    }

    public CheckoutException(String str, Throwable th) {
        super(str, th);
    }
}
