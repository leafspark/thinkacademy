package com.amazonaws.services.s3.model;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;

public class LegacyS3ProgressListener implements ProgressListener {
    private final ProgressListener listener;

    public LegacyS3ProgressListener(ProgressListener progressListener) {
        this.listener = progressListener;
    }

    public ProgressListener unwrap() {
        return this.listener;
    }

    public void progressChanged(ProgressEvent progressEvent) {
        ProgressListener progressListener = this.listener;
        if (progressListener != null) {
            progressListener.progressChanged(transform(progressEvent));
        }
    }

    private ProgressEvent transform(ProgressEvent progressEvent) {
        return new ProgressEvent(progressEvent.getEventCode(), progressEvent.getBytesTransferred());
    }
}
