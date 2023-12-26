package com.yanzhenjie.andserver.error;

public class InvalidMediaTypeException extends IllegalArgumentException {
    private String mMediaType;

    public InvalidMediaTypeException(String str, String str2) {
        super("Invalid media type \"" + str + "\": " + str2);
        this.mMediaType = str;
    }

    public InvalidMediaTypeException(InvalidMimeTypeException invalidMimeTypeException) {
        super(invalidMimeTypeException.getMessage(), invalidMimeTypeException);
        this.mMediaType = invalidMimeTypeException.getMimeType();
    }

    public String getMediaType() {
        return this.mMediaType;
    }
}
