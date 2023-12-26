package com.amazonaws.mobile.auth.core;

public interface IdentityHandler {
    void handleError(Exception exc);

    void onIdentityId(String str);
}
