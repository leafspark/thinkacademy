package com.amazonaws.mobileconnectors.cognitoidentityprovider.tokens;

public class CognitoUserToken {
    private final String token;

    public CognitoUserToken(String str) {
        this.token = str;
    }

    /* access modifiers changed from: protected */
    public String getToken() {
        return this.token;
    }
}
