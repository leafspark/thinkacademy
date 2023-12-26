package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ChallengeContinuation implements CognitoIdentityProviderContinuation<Map<String, String>> {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    /* access modifiers changed from: private */
    public final AuthenticationHandler callback;
    protected final Map<String, String> challengeResponses = new HashMap();
    private final RespondToAuthChallengeResult challengeResult;
    private final String clientId;
    /* access modifiers changed from: private */
    public final Map<String, String> clientMetaData = new HashMap();
    /* access modifiers changed from: private */
    public final Context context;
    private final boolean runInBackground;
    private final String secretHash;
    /* access modifiers changed from: private */
    public final CognitoUser user;
    private final String username;

    public ChallengeContinuation(CognitoUser cognitoUser, Context context2, String str, String str2, String str3, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        this.challengeResult = respondToAuthChallengeResult;
        this.context = context2;
        this.clientId = str2;
        this.secretHash = str3;
        this.user = cognitoUser;
        this.username = str;
        this.callback = authenticationHandler;
        this.runInBackground = z;
    }

    public Map<String, String> getClientMetaData() {
        return Collections.unmodifiableMap(this.clientMetaData);
    }

    public void setClientMetaData(Map<String, String> map) {
        this.clientMetaData.clear();
        if (map != null) {
            this.clientMetaData.putAll(map);
        }
    }

    public Map<String, String> getParameters() {
        return this.challengeResult.getChallengeParameters();
    }

    public String getChallengeName() {
        return this.challengeResult.getChallengeName();
    }

    public void setChallengeResponse(String str, String str2) {
        this.challengeResponses.put(str, str2);
    }

    public void continueTask() {
        Runnable runnable;
        final RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
        this.challengeResponses.put("USERNAME", this.username);
        this.challengeResponses.put("SECRET_HASH", this.secretHash);
        respondToAuthChallengeRequest.setChallengeName(this.challengeResult.getChallengeName());
        respondToAuthChallengeRequest.setSession(this.challengeResult.getSession());
        respondToAuthChallengeRequest.setClientId(this.clientId);
        respondToAuthChallengeRequest.setChallengeResponses(this.challengeResponses);
        if (!this.clientMetaData.isEmpty()) {
            respondToAuthChallengeRequest.setClientMetadata(this.clientMetaData);
        }
        if (this.runInBackground) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    Runnable runnable;
                    Handler handler = new Handler(ChallengeContinuation.this.context.getMainLooper());
                    try {
                        runnable = ChallengeContinuation.this.user.respondToChallenge(ChallengeContinuation.this.clientMetaData, respondToAuthChallengeRequest, ChallengeContinuation.this.callback, true);
                    } catch (Exception e) {
                        runnable = new Runnable() {
                            public void run() {
                                ChallengeContinuation.this.callback.onFailure(e);
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
                runnable = this.user.respondToChallenge(this.clientMetaData, respondToAuthChallengeRequest, this.callback, false);
            } catch (Exception e) {
                runnable = new Runnable() {
                    public void run() {
                        ChallengeContinuation.this.callback.onFailure(e);
                    }
                };
            }
            runnable.run();
        }
    }

    public void setResponseSessionCode(String str) {
        this.challengeResult.setSession(str);
    }
}
