package com.amazonaws;

public class AbortedException extends AmazonClientException {
    private static final long serialVersionUID = 1;

    public boolean isRetryable() {
        return false;
    }

    public AbortedException(String str, Throwable th) {
        super(str, th);
    }

    public AbortedException(Throwable th) {
        super("", th);
    }

    public AbortedException(String str) {
        super(str);
    }

    public AbortedException() {
        super("");
    }
}
