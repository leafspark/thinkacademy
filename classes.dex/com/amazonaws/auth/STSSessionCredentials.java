package com.amazonaws.auth;

import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;

@Deprecated
public class STSSessionCredentials implements AWSRefreshableSessionCredentials {
    public static final int DEFAULT_DURATION_SECONDS = 3600;
    private final AWSSecurityTokenService securityTokenService;
    private Credentials sessionCredentials;
    private final int sessionDurationSeconds;

    public STSSessionCredentials(AWSCredentials aWSCredentials) {
        this(aWSCredentials, 3600);
    }

    public STSSessionCredentials(AWSCredentials aWSCredentials, int i) {
        this.securityTokenService = new AWSSecurityTokenServiceClient(aWSCredentials);
        this.sessionDurationSeconds = i;
    }

    public STSSessionCredentials(AWSSecurityTokenService aWSSecurityTokenService) {
        this(aWSSecurityTokenService, 3600);
    }

    public STSSessionCredentials(AWSSecurityTokenService aWSSecurityTokenService, int i) {
        this.securityTokenService = aWSSecurityTokenService;
        this.sessionDurationSeconds = i;
    }

    public synchronized String getAWSAccessKeyId() {
        return getSessionCredentials().getAccessKeyId();
    }

    public synchronized String getAWSSecretKey() {
        return getSessionCredentials().getSecretAccessKey();
    }

    public synchronized String getSessionToken() {
        return getSessionCredentials().getSessionToken();
    }

    public synchronized AWSSessionCredentials getImmutableCredentials() {
        Credentials sessionCredentials2;
        sessionCredentials2 = getSessionCredentials();
        return new BasicSessionCredentials(sessionCredentials2.getAccessKeyId(), sessionCredentials2.getSecretAccessKey(), sessionCredentials2.getSessionToken());
    }

    public synchronized void refreshCredentials() {
        this.sessionCredentials = this.securityTokenService.getSessionToken(new GetSessionTokenRequest().withDurationSeconds(Integer.valueOf(this.sessionDurationSeconds))).getCredentials();
    }

    private synchronized Credentials getSessionCredentials() {
        if (needsNewSession()) {
            refreshCredentials();
        }
        return this.sessionCredentials;
    }

    private boolean needsNewSession() {
        Credentials credentials = this.sessionCredentials;
        if (credentials != null && credentials.getExpiration().getTime() - System.currentTimeMillis() >= 60000) {
            return false;
        }
        return true;
    }
}
