package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MultiFactorAuthenticationContinuation implements CognitoIdentityProviderContinuation<CognitoUserCodeDeliveryDetails> {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    /* access modifiers changed from: private */
    public final AuthenticationHandler callback;
    /* access modifiers changed from: private */
    public final RespondToAuthChallengeResult challenge;
    /* access modifiers changed from: private */
    public final Map<String, String> clientMetadata;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public String mfaCode = null;
    private final boolean runInBackground;
    /* access modifiers changed from: private */
    public final CognitoUser user;

    public MultiFactorAuthenticationContinuation(CognitoUser cognitoUser, Context context2, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        this.user = cognitoUser;
        this.context = context2;
        this.callback = authenticationHandler;
        this.runInBackground = z;
        this.challenge = respondToAuthChallengeResult;
        this.clientMetadata = new HashMap();
    }

    public Map<String, String> getClientMetaData() {
        return Collections.unmodifiableMap(this.clientMetadata);
    }

    public void setClientMetaData(Map<String, String> map) {
        this.clientMetadata.clear();
        if (map != null) {
            this.clientMetadata.putAll(map);
        }
    }

    public CognitoUserCodeDeliveryDetails getParameters() {
        if (CognitoServiceConstants.CHLG_TYPE_SOFTWARE_TOKEN_MFA.equals(this.challenge.getChallengeName())) {
            return new CognitoUserCodeDeliveryDetails("Time-based One-time Password", this.challenge.getChallengeParameters().get("FRIENDLY_DEVICE_NAME"), (String) null);
        }
        if ("SMS_MFA".equals(this.challenge.getChallengeName())) {
            return new CognitoUserCodeDeliveryDetails(this.challenge.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_CODE_DEL_DESTINATION), this.challenge.getChallengeParameters().get(CognitoServiceConstants.CHLG_PARAM_CODE_DEL_MEDIUM), (String) null);
        }
        return new CognitoUserCodeDeliveryDetails("", "", "");
    }

    public void continueTask() {
        Runnable runnable;
        if (this.runInBackground) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(MultiFactorAuthenticationContinuation.this.context.getMainLooper());
                    try {
                        runnable = MultiFactorAuthenticationContinuation.this.user.respondToMfaChallenge(MultiFactorAuthenticationContinuation.this.clientMetadata, MultiFactorAuthenticationContinuation.this.mfaCode, MultiFactorAuthenticationContinuation.this.challenge, MultiFactorAuthenticationContinuation.this.callback, true);
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                MultiFactorAuthenticationContinuation.this.callback.onFailure(e);
                            }
                        };
                    }
                    if (!(handler instanceof Handler)) {
                        handler.post(runnable);
                    } else {
                        AsynchronousInstrumentation.handlerPost(handler, runnable);
                    }
                }
            });
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
        } else {
            try {
                runnable = this.user.respondToMfaChallenge(this.clientMetadata, this.mfaCode, this.challenge, this.callback, false);
            } catch (Exception e) {
                runnable = new Runnable() {
                    public void run() {
                        MultiFactorAuthenticationContinuation.this.callback.onFailure(e);
                    }
                };
            }
            runnable.run();
        }
    }

    public void setMfaCode(String str) {
        this.mfaCode = str;
    }
}
