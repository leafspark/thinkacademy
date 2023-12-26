package com.amazonaws.transform;

import com.amazonaws.AmazonServiceException;

public abstract class AbstractErrorUnmarshaller<T> implements Unmarshaller<AmazonServiceException, T> {
    protected final Class<? extends AmazonServiceException> exceptionClass;

    public AbstractErrorUnmarshaller() {
        this(AmazonServiceException.class);
    }

    public AbstractErrorUnmarshaller(Class<? extends AmazonServiceException> cls) {
        this.exceptionClass = cls;
    }

    /* access modifiers changed from: protected */
    public AmazonServiceException newException(String str) throws Exception {
        return this.exceptionClass.getConstructor(new Class[]{String.class}).newInstance(new Object[]{str});
    }
}
