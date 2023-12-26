package com.amazonaws.services.s3.model;

@Deprecated
public class ProgressEvent extends com.amazonaws.event.ProgressEvent {
    public ProgressEvent(int i) {
        super((long) i);
    }

    public ProgressEvent(int i, long j) {
        super(i, j);
    }

    @Deprecated
    public void setBytesTransfered(int i) {
        setBytesTransferred((long) i);
    }

    @Deprecated
    public int getBytesTransfered() {
        return (int) getBytesTransferred();
    }
}
