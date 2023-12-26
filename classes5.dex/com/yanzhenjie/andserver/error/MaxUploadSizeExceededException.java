package com.yanzhenjie.andserver.error;

import com.yanzhenjie.andserver.util.StatusCode;

public class MaxUploadSizeExceededException extends BasicException {
    private final long mMaxSize;

    public MaxUploadSizeExceededException(long j) {
        this(j, (Throwable) null);
    }

    public MaxUploadSizeExceededException(long j, Throwable th) {
        super(StatusCode.SC_REQUEST_ENTITY_TOO_LARGE, "Maximum upload size of " + j + " bytes exceeded", th);
        this.mMaxSize = j;
    }

    public long getMaxSize() {
        return this.mMaxSize;
    }
}
