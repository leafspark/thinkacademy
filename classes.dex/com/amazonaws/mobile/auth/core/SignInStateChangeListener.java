package com.amazonaws.mobile.auth.core;

public interface SignInStateChangeListener {
    void onUserSignedIn();

    void onUserSignedOut();
}
