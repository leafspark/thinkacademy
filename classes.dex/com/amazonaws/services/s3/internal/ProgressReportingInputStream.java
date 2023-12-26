package com.amazonaws.services.s3.internal;

import com.amazonaws.internal.SdkFilterInputStream;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.ProgressListener;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
public class ProgressReportingInputStream extends SdkFilterInputStream {
    private static final int NOTIFICATION_THRESHOLD = 8192;
    private boolean fireCompletedEvent;
    private final ProgressListener listener;
    private int unnotifiedByteCount;

    public ProgressReportingInputStream(InputStream inputStream, ProgressListener progressListener) {
        super(inputStream);
        this.listener = progressListener;
    }

    public void setFireCompletedEvent(boolean z) {
        this.fireCompletedEvent = z;
    }

    public boolean getFireCompletedEvent() {
        return this.fireCompletedEvent;
    }

    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            notifyCompleted();
        }
        if (read != -1) {
            notify(1);
        }
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        ProgressEvent progressEvent = new ProgressEvent(this.unnotifiedByteCount);
        progressEvent.setEventCode(32);
        this.listener.progressChanged(progressEvent);
        this.unnotifiedByteCount = 0;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read == -1) {
            notifyCompleted();
        }
        if (read != -1) {
            notify(read);
        }
        return read;
    }

    public void close() throws IOException {
        if (this.unnotifiedByteCount > 0) {
            this.listener.progressChanged(new ProgressEvent(this.unnotifiedByteCount));
            this.unnotifiedByteCount = 0;
        }
        super.close();
    }

    private void notifyCompleted() {
        if (this.fireCompletedEvent) {
            ProgressEvent progressEvent = new ProgressEvent(this.unnotifiedByteCount);
            progressEvent.setEventCode(4);
            this.unnotifiedByteCount = 0;
            this.listener.progressChanged(progressEvent);
        }
    }

    private void notify(int i) {
        int i2 = this.unnotifiedByteCount + i;
        this.unnotifiedByteCount = i2;
        if (i2 >= 8192) {
            this.listener.progressChanged(new ProgressEvent(this.unnotifiedByteCount));
            this.unnotifiedByteCount = 0;
        }
    }
}
