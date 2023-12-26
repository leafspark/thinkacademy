package com.amazonaws.mobile.client;

import java.util.Map;

public class HostedUIOptions {
    private final Builder builder;

    HostedUIOptions(Builder builder2) {
        this.builder = builder2;
    }

    public String[] getScopes() {
        return this.builder.scopes;
    }

    public String getIdentityProvider() {
        return this.builder.identityProvider;
    }

    public String getIdpIdentifier() {
        return this.builder.idpIdentifier;
    }

    public Boolean getFederationEnabled() {
        return this.builder.disableFederation;
    }

    public String getFederationProviderName() {
        return this.builder.federationProviderName;
    }

    public Map<String, String> getSignInQueryParameters() {
        return this.builder.signInQueryParameters;
    }

    public Map<String, String> getSignOutQueryParameters() {
        return this.builder.signOutQueryParameters;
    }

    public Map<String, String> getTokenQueryParameters() {
        return this.builder.tokenQueryParameters;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public Boolean disableFederation;
        /* access modifiers changed from: private */
        public String federationProviderName;
        /* access modifiers changed from: private */
        public String identityProvider;
        /* access modifiers changed from: private */
        public String idpIdentifier;
        /* access modifiers changed from: private */
        public String[] scopes;
        /* access modifiers changed from: private */
        public Map<String, String> signInQueryParameters;
        /* access modifiers changed from: private */
        public Map<String, String> signOutQueryParameters;
        /* access modifiers changed from: private */
        public Map<String, String> tokenQueryParameters;

        public Builder signInQueryParameters(Map<String, String> map) {
            this.signInQueryParameters = map;
            return this;
        }

        public Builder signOutQueryParameters(Map<String, String> map) {
            this.signOutQueryParameters = map;
            return this;
        }

        public Builder tokenQueryParameters(Map<String, String> map) {
            this.tokenQueryParameters = map;
            return this;
        }

        public Builder scopes(String... strArr) {
            this.scopes = strArr;
            return this;
        }

        public Builder identityProvider(String str) {
            this.identityProvider = str;
            return this;
        }

        public Builder idpIdentifier(String str) {
            this.idpIdentifier = str;
            return this;
        }

        public Builder disableFederation(boolean z) {
            this.disableFederation = Boolean.valueOf(z);
            return this;
        }

        public Builder federationProviderName(String str) {
            this.federationProviderName = str;
            return this;
        }

        public HostedUIOptions build() {
            return new HostedUIOptions(this);
        }
    }
}
