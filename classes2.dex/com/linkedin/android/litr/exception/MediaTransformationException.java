package com.linkedin.android.litr.exception;

public abstract class MediaTransformationException extends Exception {
    private String jobId;

    public MediaTransformationException(Throwable th) {
        super(th);
    }

    public void setJobId(String str) {
        this.jobId = str;
    }

    public String toString() {
        return super.toString() + "Media transformation failed for job id: " + this.jobId;
    }
}
