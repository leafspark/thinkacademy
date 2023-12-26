package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

public interface CognitoIdentityProviderContinuation<T> {
    void continueTask();

    T getParameters();
}
