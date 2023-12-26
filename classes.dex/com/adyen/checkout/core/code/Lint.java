package com.adyen.checkout.core.code;

import com.adyen.checkout.core.exception.NoConstructorException;

public final class Lint {
    public static final String MERCHANT_VISIBLE = "WeakerAccess";

    private Lint() {
        throw new NoConstructorException();
    }
}
