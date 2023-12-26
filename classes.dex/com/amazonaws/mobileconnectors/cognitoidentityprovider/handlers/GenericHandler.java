package com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers;

public interface GenericHandler {
    void onFailure(Exception exc);

    void onSuccess();
}
