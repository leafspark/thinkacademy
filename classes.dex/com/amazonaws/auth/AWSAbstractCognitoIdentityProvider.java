package com.amazonaws.auth;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentity;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.GetIdRequest;
import com.amazonaws.services.cognitoidentity.model.GetIdResult;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenRequest;
import com.amazonaws.services.cognitoidentity.model.GetOpenIdTokenResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AWSAbstractCognitoIdentityProvider implements AWSCognitoIdentityProvider {
    private final String accountId;
    protected final AmazonCognitoIdentity cib;
    protected String identityId;
    private final String identityPoolId;
    protected List<IdentityChangedListener> listeners;
    protected Map<String, String> loginsMap;
    protected String token;

    public abstract String getProviderName();

    /* access modifiers changed from: protected */
    public String getUserAgent() {
        return "";
    }

    public AWSAbstractCognitoIdentityProvider(String str, String str2, AmazonCognitoIdentity amazonCognitoIdentity) {
        this.accountId = str;
        this.identityPoolId = str2;
        this.loginsMap = new HashMap();
        this.listeners = new ArrayList();
        this.cib = amazonCognitoIdentity;
    }

    @Deprecated
    public AWSAbstractCognitoIdentityProvider(String str, String str2, ClientConfiguration clientConfiguration) {
        this(str, str2, (AmazonCognitoIdentity) new AmazonCognitoIdentityClient((AWSCredentials) new AnonymousAWSCredentials(), clientConfiguration));
    }

    public AWSAbstractCognitoIdentityProvider(String str, String str2, ClientConfiguration clientConfiguration, Regions regions) {
        this(str, str2, (AmazonCognitoIdentity) new AmazonCognitoIdentityClient((AWSCredentials) new AnonymousAWSCredentials(), clientConfiguration));
        this.cib.setRegion(Region.getRegion(regions));
    }

    @Deprecated
    public AWSAbstractCognitoIdentityProvider(String str, String str2) {
        this(str, str2, new ClientConfiguration());
    }

    public AWSAbstractCognitoIdentityProvider(String str, String str2, Regions regions) {
        this(str, str2, new ClientConfiguration(), regions);
    }

    public String getIdentityId() {
        if (this.identityId == null) {
            GetIdRequest withLogins = new GetIdRequest().withAccountId(getAccountId()).withIdentityPoolId(getIdentityPoolId()).withLogins(this.loginsMap);
            appendUserAgent(withLogins, getUserAgent());
            GetIdResult id = this.cib.getId(withLogins);
            if (id.getIdentityId() != null) {
                identityChanged(id.getIdentityId());
            }
        }
        return this.identityId;
    }

    /* access modifiers changed from: protected */
    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public String getToken() {
        if (this.token == null) {
            GetOpenIdTokenRequest withLogins = new GetOpenIdTokenRequest().withIdentityId(getIdentityId()).withLogins(this.loginsMap);
            appendUserAgent(withLogins, getUserAgent());
            GetOpenIdTokenResult openIdToken = this.cib.getOpenIdToken(withLogins);
            if (!openIdToken.getIdentityId().equals(getIdentityId())) {
                identityChanged(openIdToken.getIdentityId());
            }
            this.token = openIdToken.getToken();
        }
        return this.token;
    }

    /* access modifiers changed from: protected */
    public void setToken(String str) {
        this.token = str;
    }

    public String getIdentityPoolId() {
        return this.identityPoolId;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public Map<String, String> getLogins() {
        return this.loginsMap;
    }

    public void setLogins(Map<String, String> map) {
        this.loginsMap = map;
    }

    public boolean isAuthenticated() {
        Map<String, String> map = this.loginsMap;
        return map != null && map.size() > 0;
    }

    public void unregisterIdentityChangedListener(IdentityChangedListener identityChangedListener) {
        this.listeners.remove(identityChangedListener);
    }

    public void registerIdentityChangedListener(IdentityChangedListener identityChangedListener) {
        this.listeners.add(identityChangedListener);
    }

    public void identityChanged(String str) {
        String str2 = this.identityId;
        if (str2 == null || !str2.equals(str)) {
            String str3 = this.identityId;
            this.identityId = str;
            for (IdentityChangedListener identityChanged : this.listeners) {
                identityChanged.identityChanged(str3, this.identityId);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void appendUserAgent(AmazonWebServiceRequest amazonWebServiceRequest, String str) {
        amazonWebServiceRequest.getRequestClientOptions().appendUserAgent(str);
    }

    public void clearListeners() {
        this.listeners.clear();
    }

    /* access modifiers changed from: protected */
    public void update(String str, String str2) {
        String str3 = this.identityId;
        if (str3 == null || !str3.equals(str)) {
            identityChanged(str);
        }
        String str4 = this.token;
        if (str4 == null || !str4.equals(str2)) {
            this.token = str2;
        }
    }

    public String refresh() {
        getIdentityId();
        String token2 = getToken();
        update(getIdentityId(), token2);
        return token2;
    }
}
