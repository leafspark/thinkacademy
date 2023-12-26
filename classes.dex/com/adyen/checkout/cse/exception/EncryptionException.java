package com.adyen.checkout.cse.exception;

import com.adyen.checkout.core.exception.CheckoutException;

public class EncryptionException extends CheckoutException {
    private static final long serialVersionUID = 604047691381396990L;

    public EncryptionException(String str, Throwable th) {
        super(str, th);
    }
}
