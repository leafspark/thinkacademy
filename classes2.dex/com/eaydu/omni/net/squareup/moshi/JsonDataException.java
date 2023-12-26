package com.eaydu.omni.net.squareup.moshi;

public final class JsonDataException extends RuntimeException {
    public JsonDataException() {
    }

    public JsonDataException(String str) {
        super(str);
    }

    public JsonDataException(Throwable th) {
        super(th);
    }

    public JsonDataException(String str, Throwable th) {
        super(str, th);
    }
}
