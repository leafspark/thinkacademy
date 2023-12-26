package com.amazonaws.mobile.client;

public class FederatedSignInOptions {
    private final Builder builder;

    FederatedSignInOptions(Builder builder2) {
        this.builder = builder2;
    }

    public String getCustomRoleARN() {
        return this.builder.customRoleARN;
    }

    public String getCognitoIdentityId() {
        return this.builder.cognitoIdentityId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public String cognitoIdentityId;
        /* access modifiers changed from: private */
        public String customRoleARN;

        public Builder cognitoIdentityId(String str) {
            this.cognitoIdentityId = str;
            return this;
        }

        public Builder customRoleARN(String str) {
            this.customRoleARN = str;
            return this;
        }

        public FederatedSignInOptions build() {
            return new FederatedSignInOptions(this);
        }
    }
}
