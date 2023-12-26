package com.adyen.threeds2;

public interface RuntimeErrorEvent {
    String getErrorCode();

    String getErrorMessage();
}
