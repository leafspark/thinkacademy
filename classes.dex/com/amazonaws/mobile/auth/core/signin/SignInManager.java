package com.amazonaws.mobile.auth.core.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.IdentityProvider;
import com.amazonaws.mobile.auth.core.SignInResultHandler;
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SignInManager {
    private static final String LOG_TAG = "SignInManager";
    private static volatile SignInManager singleton;
    private final SparseArray<SignInPermissionsHandler> providersHandlingPermissions = new SparseArray<>();
    private SignInProviderResultAdapter resultsAdapter;
    private final Map<Class<? extends SignInProvider>, SignInProvider> signInProviders = new HashMap();
    private volatile SignInResultHandler signInResultHandler;

    private SignInManager(Context context) {
        for (Class next : IdentityManager.getDefaultIdentityManager().getSignInProviderClasses()) {
            try {
                SignInProvider signInProvider = (SignInProvider) next.newInstance();
                if (signInProvider != null) {
                    signInProvider.initialize(context, IdentityManager.getDefaultIdentityManager().getConfiguration());
                    this.signInProviders.put(next, signInProvider);
                    if (signInProvider instanceof SignInPermissionsHandler) {
                        SignInPermissionsHandler signInPermissionsHandler = (SignInPermissionsHandler) signInProvider;
                        this.providersHandlingPermissions.put(signInPermissionsHandler.getPermissionRequestCode(), signInPermissionsHandler);
                    }
                }
            } catch (IllegalAccessException unused) {
                String str = LOG_TAG;
                Log.e(str, "Unable to instantiate " + next.getSimpleName() + " . Skipping this provider.");
            } catch (InstantiationException unused2) {
                String str2 = LOG_TAG;
                Log.e(str2, "Unable to instantiate " + next.getSimpleName() + " . Skipping this provider.");
            }
        }
        singleton = this;
    }

    public static synchronized SignInManager getInstance() {
        SignInManager signInManager;
        synchronized (SignInManager.class) {
            signInManager = singleton;
        }
        return signInManager;
    }

    public static synchronized SignInManager getInstance(Context context) {
        SignInManager signInManager;
        synchronized (SignInManager.class) {
            if (singleton == null) {
                singleton = new SignInManager(context);
            }
            signInManager = singleton;
        }
        return signInManager;
    }

    public void setResultHandler(SignInResultHandler signInResultHandler2) {
        this.signInResultHandler = signInResultHandler2;
    }

    public SignInResultHandler getResultHandler() {
        return this.signInResultHandler;
    }

    public static synchronized void dispose() {
        synchronized (SignInManager.class) {
            singleton = null;
        }
    }

    public SignInProvider getPreviouslySignedInProvider() {
        String str = LOG_TAG;
        Log.d(str, "Providers: " + Collections.singletonList(this.signInProviders));
        for (SignInProvider next : this.signInProviders.values()) {
            if (next.refreshUserSignInState()) {
                String str2 = LOG_TAG;
                Log.d(str2, "Refreshing provider: " + next.getDisplayName());
                return next;
            }
        }
        return null;
    }

    private class SignInProviderResultAdapter implements SignInProviderResultHandler {
        private final Activity activity;
        /* access modifiers changed from: private */
        public final SignInProviderResultHandler handler;

        private SignInProviderResultAdapter(Activity activity2, SignInProviderResultHandler signInProviderResultHandler) {
            this.handler = signInProviderResultHandler;
            this.activity = activity2;
        }

        /* access modifiers changed from: private */
        public Activity getActivity() {
            return this.activity;
        }

        public void onSuccess(final IdentityProvider identityProvider) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    SignInProviderResultAdapter.this.handler.onSuccess(identityProvider);
                }
            });
        }

        public void onCancel(final IdentityProvider identityProvider) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    SignInProviderResultAdapter.this.handler.onCancel(identityProvider);
                }
            });
        }

        public void onError(final IdentityProvider identityProvider, final Exception exc) {
            ThreadUtils.runOnUiThread(new Runnable() {
                public void run() {
                    SignInProviderResultAdapter.this.handler.onError(identityProvider, exc);
                }
            });
        }
    }

    public void refreshCredentialsWithProvider(Activity activity, IdentityProvider identityProvider, SignInProviderResultHandler signInProviderResultHandler) {
        if (identityProvider != null) {
            if (identityProvider.getToken() == null) {
                signInProviderResultHandler.onError(identityProvider, new IllegalArgumentException("Given provider not previously logged in."));
            }
            this.resultsAdapter = new SignInProviderResultAdapter(activity, signInProviderResultHandler);
            IdentityManager.getDefaultIdentityManager().setProviderResultsHandler(this.resultsAdapter);
            IdentityManager.getDefaultIdentityManager().federateWithProvider(identityProvider);
            return;
        }
        throw new IllegalArgumentException("The sign-in provider cannot be null.");
    }

    public void setProviderResultsHandler(Activity activity, SignInProviderResultHandler signInProviderResultHandler) {
        this.resultsAdapter = new SignInProviderResultAdapter(activity, signInProviderResultHandler);
        IdentityManager.getDefaultIdentityManager().setProviderResultsHandler(this.resultsAdapter);
    }

    public View.OnClickListener initializeSignInButton(Class<? extends SignInProvider> cls, View view) {
        return findProvider(cls).initializeSignInButton(this.resultsAdapter.getActivity(), view, IdentityManager.getDefaultIdentityManager().getResultsAdapter());
    }

    private SignInProvider findProvider(Class<? extends SignInProvider> cls) {
        SignInProvider signInProvider = this.signInProviders.get(cls);
        if (signInProvider != null) {
            return signInProvider;
        }
        throw new IllegalArgumentException("No such provider : " + cls.getName());
    }

    public boolean handleActivityResult(int i, int i2, Intent intent) {
        for (SignInProvider next : this.signInProviders.values()) {
            if (next.isRequestCodeOurs(i)) {
                next.handleActivityResult(i, i2, intent);
                return true;
            }
        }
        return false;
    }

    public void handleRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        SignInPermissionsHandler signInPermissionsHandler = this.providersHandlingPermissions.get(i);
        if (signInPermissionsHandler != null) {
            signInPermissionsHandler.handleRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
