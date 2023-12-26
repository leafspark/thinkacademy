package com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserDetails;

public interface GetDetailsHandler {
    void onFailure(Exception exc);

    void onSuccess(CognitoUserDetails cognitoUserDetails);
}
