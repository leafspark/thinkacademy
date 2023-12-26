package com.amazonaws.mobile.client;

import com.amazonaws.auth.AWSAbstractCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;

/* compiled from: AWSMobileClient */
class AWSMobileClientCognitoIdentityProvider extends AWSAbstractCognitoIdentityProvider {
    boolean isDeveloperAuthenticated;

    public String getProviderName() {
        return "Cognito";
    }

    /* access modifiers changed from: protected */
    public String getUserAgent() {
        return AWSMobileClient.DEFAULT_USER_AGENT;
    }

    public AWSMobileClientCognitoIdentityProvider(String str, String str2, AmazonCognitoIdentity amazonCognitoIdentity) {
        super(str, str2, amazonCognitoIdentity);
    }

    /* access modifiers changed from: package-private */
    public void setDeveloperAuthenticated(String str, String str2) {
        super.setIdentityId(str);
        super.setToken(str2);
        this.isDeveloperAuthenticated = true;
    }

    /* access modifiers changed from: package-private */
    public void setNotDeveloperAuthenticated() {
        this.isDeveloperAuthenticated = false;
    }

    public String refresh() {
        if (this.isDeveloperAuthenticated) {
            return this.token;
        }
        getIdentityId();
        return null;
    }
}
