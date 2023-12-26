package com.adyen.checkout.components;

import com.adyen.checkout.core.exception.CheckoutException;

public class ComponentError {
    private final CheckoutException mException;

    public ComponentError(CheckoutException checkoutException) {
        this.mException = checkoutException;
    }

    public String getErrorMessage() {
        return this.mException.getMessage();
    }

    public CheckoutException getException() {
        return this.mException;
    }
}
