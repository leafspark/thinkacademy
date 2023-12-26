package com.adyen.checkout.core.exception;

import org.json.JSONException;

public class ModelSerializationException extends CheckoutException {
    private static final long serialVersionUID = -241916181048458214L;

    public ModelSerializationException(Class cls, JSONException jSONException) {
        super("Unexpected exception while serializing " + cls.getSimpleName() + ".", jSONException);
    }
}
