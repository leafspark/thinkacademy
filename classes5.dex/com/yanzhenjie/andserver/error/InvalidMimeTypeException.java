package com.yanzhenjie.andserver.error;

public class InvalidMimeTypeException extends IllegalArgumentException {
    private final String mMimeType;

    public InvalidMimeTypeException(String str, String str2) {
        super("Invalid mime type \"" + str + "\": " + str2);
        this.mMimeType = str;
    }

    public String getMimeType() {
        return this.mMimeType;
    }
}
