package com.adyen.checkout.core.exception;

public class BadModelException extends CheckoutException {
    private static final long serialVersionUID = -1161500360463809921L;

    public BadModelException(Class<?> cls, Throwable th) {
        super("ModelObject protocol requires a ModelObject.Serializer object called SERIALIZER on class " + cls.getSimpleName(), th);
    }
}
