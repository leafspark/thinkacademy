package com.adyen.threeds2;

public interface ProtocolErrorEvent {
    ErrorMessage getErrorMessage();

    String getSDKTransactionID();
}
