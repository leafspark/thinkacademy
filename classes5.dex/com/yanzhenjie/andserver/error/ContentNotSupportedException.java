package com.yanzhenjie.andserver.error;

import com.yanzhenjie.andserver.util.MediaType;
import com.yanzhenjie.andserver.util.StatusCode;

public class ContentNotSupportedException extends BasicException {
    private static final String MESSAGE = "The content type [%s] is not supported.";

    public ContentNotSupportedException(MediaType mediaType) {
        super((int) StatusCode.SC_UNSUPPORTED_MEDIA_TYPE, String.format(MESSAGE, new Object[]{mediaType}));
    }

    public ContentNotSupportedException(MediaType mediaType, Throwable th) {
        super(StatusCode.SC_UNSUPPORTED_MEDIA_TYPE, String.format(MESSAGE, new Object[]{mediaType}), th);
    }
}
