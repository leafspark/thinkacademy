package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.exceptions.CognitoParameterInvalidException;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.RegisterMfaHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.util.StringUtils;
import java.util.Map;

public class VerifyMfaContinuation implements CognitoIdentityProviderContinuation<Map<String, String>> {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private final RegisterMfaHandler callback;
    private final String clientId;
    private final Context context;
    private String friendlyName = CognitoServiceConstants.DEFAULT_TOTP_DEVICE_FRIENDLY_NAME;
    private final Map<String, String> mfaSetupDetails;
    private final boolean runInBackground;
    private final String sessionToken;
    private final boolean useSessionToken;
    private final CognitoUser user;
    private String verificationCode;

    public VerifyMfaContinuation(Context context2, String str, CognitoUser cognitoUser, RegisterMfaHandler registerMfaHandler, Map<String, String> map, boolean z, String str2, boolean z2) {
        this.context = context2;
        this.clientId = str;
        this.user = cognitoUser;
        this.callback = registerMfaHandler;
        this.mfaSetupDetails = map;
        this.useSessionToken = z;
        this.sessionToken = str2;
        this.runInBackground = z2;
    }

    public void setVerificationResponse(String str, String str2) {
        if (!StringUtils.isBlank(str)) {
            this.verificationCode = str;
            if (!StringUtils.isBlank(str2)) {
                this.friendlyName = str2;
                return;
            }
            return;
        }
        throw new CognitoParameterInvalidException("verification code is invalid");
    }

    public Map<String, String> getParameters() {
        return this.mfaSetupDetails;
    }

    public void continueTask() {
        if (!this.runInBackground) {
            this.user.verifySoftwareTokenInBackground((String) null, this.verificationCode, this.friendlyName, this.callback);
        } else if (this.useSessionToken) {
            this.user.verifySoftwareTokenInBackground(this.sessionToken, this.verificationCode, this.friendlyName, this.callback);
        } else {
            this.user.verifySoftwareTokenInBackground((String) null, this.verificationCode, this.friendlyName, this.callback);
        }
    }
}
