package com.amazonaws.mobile.client;

import com.amazonaws.mobile.auth.core.IdentityManager;

@Deprecated
public class AWSStartupResult {
    private IdentityManager identityManager;

    public AWSStartupResult(IdentityManager identityManager2) {
        this.identityManager = identityManager2;
    }

    public boolean isIdentityIdAvailable() {
        return this.identityManager.getCachedUserID() != null;
    }
}
