package com.amazonaws.mobile.auth.core;

public class StartupAuthResult {
    private final StartupAuthErrorDetails errors;
    private final IdentityManager identityManager;

    public StartupAuthResult(IdentityManager identityManager2, StartupAuthErrorDetails startupAuthErrorDetails) {
        this.identityManager = identityManager2;
        this.errors = startupAuthErrorDetails;
    }

    public boolean isUserSignedIn() {
        return this.identityManager.isUserSignedIn();
    }

    public boolean isUserAnonymous() {
        return isIdentityIdAvailable() && !isUserSignedIn();
    }

    public boolean isIdentityIdAvailable() {
        return this.identityManager.getCachedUserID() != null;
    }

    public IdentityManager getIdentityManager() {
        return this.identityManager;
    }

    public StartupAuthErrorDetails getErrorDetails() {
        return this.errors;
    }
}
