package com.adyen.threeds2;

public interface CompletionEvent {
    String getSDKTransactionID();

    String getTransactionStatus();
}
