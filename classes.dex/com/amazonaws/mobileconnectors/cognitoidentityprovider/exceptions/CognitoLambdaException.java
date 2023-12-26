package com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions;

public class CognitoLambdaException extends CognitoIdentityProviderException {
    private static final long serialVersionUID = -2401240885762953890L;

    public CognitoLambdaException(String str, Throwable th) {
        super(str, th);
    }

    public CognitoLambdaException(String str) {
        super(str);
    }
}
