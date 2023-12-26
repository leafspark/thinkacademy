package com.amazonaws.mobile.auth.core;

import com.amazonaws.mobile.auth.core.signin.AuthException;

public class StartupAuthErrorDetails {
    private final AuthException authException;
    private final Exception unauthException;

    public StartupAuthErrorDetails(AuthException authException2, Exception exc) {
        this.authException = authException2;
        this.unauthException = exc;
    }

    public boolean didErrorOccurRefreshingProvider() {
        return this.authException != null;
    }

    public AuthException getProviderRefreshException() {
        return this.authException;
    }

    public boolean didErrorOccurObtainingUnauthenticatedIdentity() {
        return this.unauthException != null;
    }

    public Exception getUnauthenticatedErrorException() {
        return this.unauthException;
    }
}
