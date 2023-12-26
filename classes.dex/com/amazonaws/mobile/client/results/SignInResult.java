package com.amazonaws.mobile.client.results;

import java.util.Map;

public class SignInResult {
    public static final SignInResult DONE = new SignInResult(SignInState.DONE);
    private final UserCodeDeliveryDetails codeDetails;
    private final Map<String, String> parameters;
    private final SignInState signInState;

    private SignInResult(SignInState signInState2) {
        this.signInState = signInState2;
        this.parameters = null;
        this.codeDetails = null;
    }

    public SignInResult(SignInState signInState2, Map<String, String> map) {
        this.signInState = signInState2;
        this.parameters = map;
        this.codeDetails = null;
    }

    public SignInResult(SignInState signInState2, UserCodeDeliveryDetails userCodeDeliveryDetails) {
        this.signInState = signInState2;
        this.parameters = null;
        this.codeDetails = userCodeDeliveryDetails;
    }

    public SignInState getSignInState() {
        return this.signInState;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public UserCodeDeliveryDetails getCodeDetails() {
        return this.codeDetails;
    }
}
