package com.amazonaws.mobileconnectors.s3.transferutility;

public class TransferUtilityException extends Exception {
    public TransferUtilityException() {
    }

    public TransferUtilityException(String str) {
        super(str);
    }

    public TransferUtilityException(String str, Throwable th) {
        super(str, th);
    }

    public TransferUtilityException(Throwable th) {
        super(th);
    }
}
