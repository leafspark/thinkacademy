package com.eaydu.omni.jwt;

public class DecodeException extends RuntimeException {
    DecodeException(String str) {
        super(str);
    }

    DecodeException(String str, Throwable th) {
        super(str, th);
    }
}
