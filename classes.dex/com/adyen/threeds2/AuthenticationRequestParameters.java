package com.adyen.threeds2;

public interface AuthenticationRequestParameters {
    String getDeviceData();

    String getMessageVersion();

    String getSDKAppID();

    String getSDKEphemeralPublicKey();

    String getSDKReferenceNumber();

    String getSDKTransactionID();
}
