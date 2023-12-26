package com.amazonaws.mobile.auth.core;

import android.app.Activity;
import android.util.Log;

public abstract class DefaultSignInResultHandler implements SignInResultHandler {
    private static final String LOG_TAG = "DefaultSignInResultHandler";

    public void onIntermediateProviderCancel(Activity activity, IdentityProvider identityProvider) {
        Log.d(LOG_TAG, String.format("%s Sign-In flow is canceled", new Object[]{identityProvider.getDisplayName()}));
    }

    public void onIntermediateProviderError(Activity activity, IdentityProvider identityProvider, Exception exc) {
        String string = activity.getString(R.string.sign_in_failure_message_format);
        Log.e(LOG_TAG, String.format(string, new Object[]{identityProvider.getDisplayName(), exc.getMessage()}), exc);
    }
}
