package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler;
import java.util.HashMap;
import java.util.Map;

public class ForgotPasswordContinuation implements CognitoIdentityProviderContinuation<CognitoUserCodeDeliveryDetails> {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private final ForgotPasswordHandler callback;
    private final Map<String, String> clientMetadata;
    private final CognitoUserCodeDeliveryDetails parameters;
    private String password = null;
    private final boolean runInBackground;
    private final CognitoUser user;
    private String verificationCode = null;

    public ForgotPasswordContinuation(CognitoUser cognitoUser, CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails, boolean z, ForgotPasswordHandler forgotPasswordHandler) {
        this.callback = forgotPasswordHandler;
        this.user = cognitoUser;
        this.parameters = cognitoUserCodeDeliveryDetails;
        this.runInBackground = z;
        this.clientMetadata = new HashMap();
    }

    public CognitoUserCodeDeliveryDetails getParameters() {
        return this.parameters;
    }

    public void continueTask() {
        if (this.runInBackground) {
            this.user.confirmPasswordInBackground(this.verificationCode, this.password, this.clientMetadata, this.callback);
        } else {
            this.user.confirmPassword(this.verificationCode, this.password, this.clientMetadata, this.callback);
        }
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public void setVerificationCode(String str) {
        this.verificationCode = str;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata.clear();
        if (map != null) {
            this.clientMetadata.putAll(map);
        }
    }
}
