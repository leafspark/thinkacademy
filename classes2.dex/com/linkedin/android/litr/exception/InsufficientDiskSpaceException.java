package com.linkedin.android.litr.exception;

import java.util.Locale;

public class InsufficientDiskSpaceException extends MediaTransformationException {
    private final long availableDiskSpaceInBytes;
    private final long estimatedTargetFileSizeInBytes;

    public InsufficientDiskSpaceException(long j, long j2) {
        this(j, j2, new Throwable());
    }

    public InsufficientDiskSpaceException(long j, long j2, Throwable th) {
        super(th);
        this.estimatedTargetFileSizeInBytes = j;
        this.availableDiskSpaceInBytes = j2;
    }

    public String getMessage() {
        return String.format(Locale.ENGLISH, "Insufficient disk space, estimated file size in bytes %d, available disk space in bytes %d", new Object[]{Long.valueOf(this.estimatedTargetFileSizeInBytes), Long.valueOf(this.availableDiskSpaceInBytes)});
    }
}
