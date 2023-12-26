package com.adyen.checkout.core.exception;

public class ApiCallException extends CheckoutException {
    private static final long serialVersionUID = 4060450855496938503L;

    public ApiCallException(String str) {
        super(str);
    }

    public ApiCallException(String str, Throwable th) {
        super(str, th);
    }
}
