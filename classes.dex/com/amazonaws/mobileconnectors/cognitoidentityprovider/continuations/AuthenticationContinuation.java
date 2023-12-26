package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationContinuation implements CognitoIdentityProviderContinuation<String> {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    /* access modifiers changed from: private */
    public AuthenticationDetails authenticationDetails = null;
    /* access modifiers changed from: private */
    public final AuthenticationHandler callback;
    /* access modifiers changed from: private */
    public final Map<String, String> clientMetadata;
    /* access modifiers changed from: private */
    public final Context context;
    private final boolean runInBackground;
    /* access modifiers changed from: private */
    public final CognitoUser user;

    public String getParameters() {
        return "AuthenticationDetails";
    }

    public AuthenticationContinuation(CognitoUser cognitoUser, Context context2, boolean z, AuthenticationHandler authenticationHandler) {
        this.user = cognitoUser;
        this.context = context2;
        this.runInBackground = z;
        this.callback = authenticationHandler;
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

    public void continueTask() {
        Runnable runnable;
        if (this.runInBackground) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(AuthenticationContinuation.this.context.getMainLooper());
                    try {
                        runnable = AuthenticationContinuation.this.user.initiateUserAuthentication(AuthenticationContinuation.this.clientMetadata, AuthenticationContinuation.this.authenticationDetails, AuthenticationContinuation.this.callback, true);
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                AuthenticationContinuation.this.callback.onFailure(e);
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
                runnable = this.user.initiateUserAuthentication(this.clientMetadata, this.authenticationDetails, this.callback, false);
            } catch (Exception e) {
                runnable = new Runnable() {
                    public void run() {
                        AuthenticationContinuation.this.callback.onFailure(e);
                    }
                };
            }
            runnable.run();
        }
    }

    public void setAuthenticationDetails(AuthenticationDetails authenticationDetails2) {
        this.authenticationDetails = authenticationDetails2;
    }
}
