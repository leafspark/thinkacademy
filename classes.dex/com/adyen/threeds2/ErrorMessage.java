package com.adyen.threeds2;

public interface ErrorMessage {
    String getErrorCode();

    String getErrorDescription();

    String getErrorDetails();

    String getTransactionID();
}
