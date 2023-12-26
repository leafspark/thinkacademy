package com.amazonaws.mobile.client;

public enum IdentityProvider {
    AMAZON("www.amazon.com"),
    FACEBOOK("graph.facebook.com"),
    GOOGLE("accounts.google.com"),
    TWITTER("api.twitter.com"),
    DEVELOPER("cognito-identity.amazonaws.com");
    
    private final String key;

    private IdentityProvider(String str) {
        this.key = str;
    }

    public String toString() {
        return this.key;
    }

    public boolean equals(String str) {
        return this.key.equals(str);
    }
}
