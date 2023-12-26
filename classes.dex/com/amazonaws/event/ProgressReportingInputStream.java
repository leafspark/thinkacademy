package com.amazonaws.event;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProgressReportingInputStream extends SdkFilterInputStream {
    private static final int BYTES_IN_KB = 1024;
    private static final int THRESHOLD_IN_KB = 8;
    private boolean fireCompletedEvent;
    private final ProgressListenerCallbackExecutor listenerCallbackExecutor;
    private int notificationThreshold = 8192;
    private int unnotifiedByteCount;

    public ProgressReportingInputStream(InputStream inputStream, ProgressListenerCallbackExecutor progressListenerCallbackExecutor) {
        super(inputStream);
        this.listenerCallbackExecutor = progressListenerCallbackExecutor;
    }

    public void setNotificationThreshold(int i) {
        this.notificationThreshold = i * 1024;
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
        } else {
            notify(1);
        }
        return read;
    }

    public void reset() throws IOException {
        super.reset();
        ProgressEvent progressEvent = new ProgressEvent((long) this.unnotifiedByteCount);
        progressEvent.setEventCode(32);
        this.listenerCallbackExecutor.progressChanged(progressEvent);
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
        int i = this.unnotifiedByteCount;
        if (i > 0) {
            this.listenerCallbackExecutor.progressChanged(new ProgressEvent((long) i));
            this.unnotifiedByteCount = 0;
        }
        super.close();
    }

    private void notifyCompleted() {
        if (this.fireCompletedEvent) {
            ProgressEvent progressEvent = new ProgressEvent((long) this.unnotifiedByteCount);
            progressEvent.setEventCode(4);
            this.unnotifiedByteCount = 0;
            this.listenerCallbackExecutor.progressChanged(progressEvent);
        }
    }

    private void notify(int i) {
        int i2 = this.unnotifiedByteCount + i;
        this.unnotifiedByteCount = i2;
        if (i2 >= this.notificationThreshold) {
            this.listenerCallbackExecutor.progressChanged(new ProgressEvent((long) i2));
            this.unnotifiedByteCount = 0;
        }
    }
}
