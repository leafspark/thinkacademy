package com.amazonaws.mobileconnectors.cognitoidentityprovider;

public class CognitoUserDetails {
    private CognitoUserAttributes cognitoUserAttributes;
    private CognitoUserSettings cognitoUserSettings;

    protected CognitoUserDetails(CognitoUserAttributes cognitoUserAttributes2, CognitoUserSettings cognitoUserSettings2) {
        this.cognitoUserAttributes = cognitoUserAttributes2;
        this.cognitoUserSettings = cognitoUserSettings2;
    }

    public CognitoUserAttributes getAttributes() {
        return this.cognitoUserAttributes;
    }

    public CognitoUserSettings getSettings() {
        return this.cognitoUserSettings;
    }
}
