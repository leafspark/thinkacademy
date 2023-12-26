package com.adyen.checkout.core.exception;

public class ComponentException extends CheckoutException {
    private static final long serialVersionUID = -2906708092144840124L;

    public ComponentException(String str) {
        super(str);
    }

    public ComponentException(String str, Throwable th) {
        super(str, th);
    }
}
