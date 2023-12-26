package com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.VerifyMfaContinuation;

public interface RegisterMfaHandler {
    void onFailure(Exception exc);

    void onSuccess(String str);

    void onVerify(VerifyMfaContinuation verifyMfaContinuation);
}
