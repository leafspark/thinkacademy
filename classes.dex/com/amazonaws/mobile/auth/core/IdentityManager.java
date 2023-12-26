package com.amazonaws.mobile.auth.core;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.SDKGlobalConfiguration;
import com.amazonaws.auth.AWSBasicCognitoIdentityProvider;
import com.amazonaws.auth.AWSCognitoIdentityProvider;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.internal.keyvaluestore.AWSKeyValueStore;
import com.amazonaws.mobile.auth.core.internal.util.ThreadUtils;
import com.amazonaws.mobile.auth.core.signin.AuthException;
import com.amazonaws.mobile.auth.core.signin.CognitoAuthException;
import com.amazonaws.mobile.auth.core.signin.ProviderAuthException;
import com.amazonaws.mobile.auth.core.signin.SignInManager;
import com.amazonaws.mobile.auth.core.signin.SignInProvider;
import com.amazonaws.mobile.auth.core.signin.SignInProviderResultHandler;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class IdentityManager {
    private static final String AWS_CONFIGURATION_FILE = "awsconfiguration.json";
    private static final String EXPIRATION_KEY = "expirationDate";
    /* access modifiers changed from: private */
    public static final String LOG_TAG = "IdentityManager";
    private static final String SHARED_PREF_NAME = "com.amazonaws.android.auth";
    private static IdentityManager defaultIdentityManager;
    private final Context appContext;
    private AWSConfiguration awsConfiguration;
    private AWSKeyValueStore awsKeyValueStore;
    private final ClientConfiguration clientConfiguration;
    /* access modifiers changed from: private */
    public final AWSCredentialsProviderHolder credentialsProviderHolder;
    /* access modifiers changed from: private */
    public volatile IdentityProvider currentIdentityProvider = null;
    private final ExecutorService executorService = Executors.newFixedThreadPool(4);
    private boolean isPersistenceEnabled = true;
    /* access modifiers changed from: private */
    public SignInProviderResultAdapter resultsAdapter;
    boolean shouldFederate = true;
    private final Set<Class<? extends SignInProvider>> signInProviderClasses = new HashSet();
    /* access modifiers changed from: private */
    public final HashSet<SignInStateChangeListener> signInStateChangeListeners = new HashSet<>();
    /* access modifiers changed from: private */
    public final CountDownLatch startupAuthTimeoutLatch = new CountDownLatch(1);

    private class AWSCredentialsProviderHolder implements AWSCredentialsProvider {
        private volatile CognitoCachingCredentialsProvider underlyingProvider;

        private AWSCredentialsProviderHolder() {
        }

        public AWSCredentials getCredentials() {
            return this.underlyingProvider.getCredentials();
        }

        public void refresh() {
            this.underlyingProvider.refresh();
        }

        /* access modifiers changed from: private */
        public CognitoCachingCredentialsProvider getUnderlyingProvider() {
            return this.underlyingProvider;
        }

        /* access modifiers changed from: private */
        public void setUnderlyingProvider(CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider) {
            this.underlyingProvider = cognitoCachingCredentialsProvider;
        }
    }

    private class AWSRefreshingCognitoIdentityProvider extends AWSBasicCognitoIdentityProvider {
        private final String LOG_TAG = AWSRefreshingCognitoIdentityProvider.class.getSimpleName();

        public AWSRefreshingCognitoIdentityProvider(String str, String str2, ClientConfiguration clientConfiguration, Regions regions) {
            super(str, str2, clientConfiguration);
            this.cib.setRegion(Region.getRegion(regions));
        }

        public String refresh() {
            if (IdentityManager.this.currentIdentityProvider != null) {
                Log.d(this.LOG_TAG, "Storing the Refresh token in the loginsMap.");
                getLogins().put(IdentityManager.this.currentIdentityProvider.getCognitoLoginKey(), IdentityManager.this.currentIdentityProvider.refreshToken());
            }
            return super.refresh();
        }
    }

    public IdentityManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.awsConfiguration = null;
        this.clientConfiguration = null;
        this.credentialsProviderHolder = null;
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, SHARED_PREF_NAME, this.isPersistenceEnabled);
    }

    public IdentityManager(Context context, AWSConfiguration aWSConfiguration) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.awsConfiguration = aWSConfiguration;
        ClientConfiguration withUserAgentOverride = new ClientConfiguration().withUserAgent(aWSConfiguration.getUserAgent()).withUserAgentOverride(aWSConfiguration.getUserAgentOverride());
        this.clientConfiguration = withUserAgentOverride;
        this.credentialsProviderHolder = new AWSCredentialsProviderHolder();
        createCredentialsProvider(applicationContext, withUserAgentOverride);
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, SHARED_PREF_NAME, this.isPersistenceEnabled);
    }

    public IdentityManager(Context context, AWSConfiguration aWSConfiguration, ClientConfiguration clientConfiguration2) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.awsConfiguration = aWSConfiguration;
        this.clientConfiguration = clientConfiguration2;
        String userAgent = aWSConfiguration.getUserAgent();
        String userAgent2 = clientConfiguration2.getUserAgent();
        userAgent2 = userAgent2 == null ? "" : userAgent2;
        if (!(userAgent == null || userAgent == userAgent2)) {
            clientConfiguration2.setUserAgent(userAgent2.trim() + " " + userAgent);
        }
        this.credentialsProviderHolder = new AWSCredentialsProviderHolder();
        createCredentialsProvider(applicationContext, clientConfiguration2);
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, SHARED_PREF_NAME, this.isPersistenceEnabled);
    }

    public IdentityManager(Context context, CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider, ClientConfiguration clientConfiguration2) {
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        this.clientConfiguration = clientConfiguration2;
        AWSCredentialsProviderHolder aWSCredentialsProviderHolder = new AWSCredentialsProviderHolder();
        this.credentialsProviderHolder = aWSCredentialsProviderHolder;
        aWSCredentialsProviderHolder.setUnderlyingProvider(cognitoCachingCredentialsProvider);
        this.awsKeyValueStore = new AWSKeyValueStore(applicationContext, SHARED_PREF_NAME, this.isPersistenceEnabled);
    }

    public void setPersistenceEnabled(boolean z) {
        this.isPersistenceEnabled = z;
        this.awsKeyValueStore.setPersistenceEnabled(z);
    }

    public void enableFederation(boolean z) {
        this.shouldFederate = z;
    }

    public static IdentityManager getDefaultIdentityManager() {
        return defaultIdentityManager;
    }

    public static void setDefaultIdentityManager(IdentityManager identityManager) {
        defaultIdentityManager = null;
        defaultIdentityManager = identityManager;
    }

    public AWSConfiguration getConfiguration() {
        return this.awsConfiguration;
    }

    public void setConfiguration(AWSConfiguration aWSConfiguration) {
        this.awsConfiguration = aWSConfiguration;
    }

    public boolean areCredentialsExpired() {
        if (this.shouldFederate) {
            Date sessionCredentialsExpiration = this.credentialsProviderHolder.getUnderlyingProvider().getSessionCredentialsExpiration();
            boolean z = true;
            if (sessionCredentialsExpiration == null) {
                Log.d(LOG_TAG, "Credentials are EXPIRED.");
                return true;
            }
            if (sessionCredentialsExpiration.getTime() - (System.currentTimeMillis() - (SDKGlobalConfiguration.getGlobalTimeOffset() * 1000)) >= 0) {
                z = false;
            }
            String str = LOG_TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Credentials are ");
            sb.append(z ? "EXPIRED." : "OK");
            Log.d(str, sb.toString());
            return z;
        }
        throw new IllegalStateException("Federation is not enabled and does not support credentials");
    }

    public AWSCredentialsProvider getCredentialsProvider() {
        return this.credentialsProviderHolder;
    }

    public CognitoCachingCredentialsProvider getUnderlyingProvider() {
        return this.credentialsProviderHolder.getUnderlyingProvider();
    }

    public String getCachedUserID() {
        if (this.shouldFederate) {
            return this.credentialsProviderHolder.getUnderlyingProvider().getCachedIdentityId();
        }
        throw new IllegalStateException("Federation is not enabled and does not support user id");
    }

    public void getUserID(final IdentityHandler identityHandler) {
        if (this.shouldFederate) {
            this.executorService.submit(new Runnable() {
                Exception exception = null;

                public void run() {
                    AnonymousClass1 r0;
                    try {
                        final String identityId = IdentityManager.this.credentialsProviderHolder.getUnderlyingProvider().getIdentityId();
                        String access$500 = IdentityManager.LOG_TAG;
                        Log.d(access$500, "Got Amazon Cognito Federated Identity ID: " + identityId);
                        if (identityHandler != null) {
                            r0 = new Runnable() {
                                public void run() {
                                    if (AnonymousClass1.this.exception != null) {
                                        identityHandler.handleError(AnonymousClass1.this.exception);
                                    } else {
                                        identityHandler.onIdentityId(null);
                                    }
                                }
                            };
                            ThreadUtils.runOnUiThread(r0);
                        }
                    } catch (Exception e) {
                        this.exception = e;
                        Log.e(IdentityManager.LOG_TAG, e.getMessage(), e);
                        String access$5002 = IdentityManager.LOG_TAG;
                        Log.d(access$5002, "Got Amazon Cognito Federated Identity ID: " + null);
                        if (identityHandler != null) {
                            r0 = new Runnable((String) null) {
                                public void run() {
                                    if (AnonymousClass1.this.exception != null) {
                                        identityHandler.handleError(AnonymousClass1.this.exception);
                                    } else {
                                        identityHandler.onIdentityId(null);
                                    }
                                }
                            };
                        }
                    } catch (Throwable th) {
                        String access$5003 = IdentityManager.LOG_TAG;
                        Log.d(access$5003, "Got Amazon Cognito Federated Identity ID: " + null);
                        if (identityHandler != null) {
                            ThreadUtils.runOnUiThread(new Runnable((String) null) {
                                public void run() {
                                    if (AnonymousClass1.this.exception != null) {
                                        identityHandler.handleError(AnonymousClass1.this.exception);
                                    } else {
                                        identityHandler.onIdentityId(null);
                                    }
                                }
                            });
                        }
                        throw th;
                    }
                }
            });
            return;
        }
        throw new IllegalStateException("Federation is not enabled and does not support user id");
    }

    private class SignInProviderResultAdapter implements SignInProviderResultHandler {
        private final SignInProviderResultHandler handler;

        private SignInProviderResultAdapter(SignInProviderResultHandler signInProviderResultHandler) {
            this.handler = signInProviderResultHandler;
        }

        public void onSuccess(IdentityProvider identityProvider) {
            Log.d(IdentityManager.LOG_TAG, String.format("SignInProviderResultAdapter.onSuccess(): %s provider sign-in succeeded.", new Object[]{identityProvider.getDisplayName()}));
            IdentityManager.this.federateWithProvider(identityProvider);
        }

        /* access modifiers changed from: private */
        public void onCognitoSuccess() {
            Log.d(IdentityManager.LOG_TAG, "SignInProviderResultAdapter.onCognitoSuccess()");
            this.handler.onSuccess(IdentityManager.this.currentIdentityProvider);
        }

        /* access modifiers changed from: private */
        public void onCognitoError(Exception exc) {
            Log.d(IdentityManager.LOG_TAG, "SignInProviderResultAdapter.onCognitoError()", exc);
            IdentityProvider access$000 = IdentityManager.this.currentIdentityProvider;
            IdentityManager.this.signOut();
            this.handler.onError(access$000, new CognitoAuthException(access$000, exc));
        }

        public void onCancel(IdentityProvider identityProvider) {
            Log.d(IdentityManager.LOG_TAG, String.format("SignInProviderResultAdapter.onCancel(): %s provider sign-in canceled.", new Object[]{identityProvider.getDisplayName()}));
            this.handler.onCancel(identityProvider);
        }

        public void onError(IdentityProvider identityProvider, Exception exc) {
            Log.e(IdentityManager.LOG_TAG, String.format("SignInProviderResultAdapter.onError(): %s provider error. %s", new Object[]{identityProvider.getDisplayName(), exc.getMessage()}), exc);
            this.handler.onError(identityProvider, new ProviderAuthException(identityProvider, exc));
        }
    }

    public void addSignInStateChangeListener(SignInStateChangeListener signInStateChangeListener) {
        synchronized (this.signInStateChangeListeners) {
            this.signInStateChangeListeners.add(signInStateChangeListener);
        }
    }

    public void removeSignInStateChangeListener(SignInStateChangeListener signInStateChangeListener) {
        synchronized (this.signInStateChangeListeners) {
            this.signInStateChangeListeners.remove(signInStateChangeListener);
        }
    }

    public SignInProviderResultAdapter getResultsAdapter() {
        return this.resultsAdapter;
    }

    public void signOut() {
        Log.d(LOG_TAG, "Signing out...");
        if (this.currentIdentityProvider != null) {
            this.executorService.submit(new Runnable() {
                public void run() {
                    IdentityManager.this.currentIdentityProvider.signOut();
                    if (IdentityManager.this.shouldFederate) {
                        IdentityManager.this.credentialsProviderHolder.getUnderlyingProvider().clear();
                    }
                    IdentityProvider unused = IdentityManager.this.currentIdentityProvider = null;
                    synchronized (IdentityManager.this.signInStateChangeListeners) {
                        Iterator it = IdentityManager.this.signInStateChangeListeners.iterator();
                        while (it.hasNext()) {
                            ((SignInStateChangeListener) it.next()).onUserSignedOut();
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void refreshCredentialWithLogins(Map<String, String> map) {
        CognitoCachingCredentialsProvider access$300 = this.credentialsProviderHolder.getUnderlyingProvider();
        if (this.shouldFederate) {
            access$300.clear();
            access$300.withLogins(map);
            Log.d(LOG_TAG, "refresh credentials");
            access$300.refresh();
            AWSKeyValueStore aWSKeyValueStore = this.awsKeyValueStore;
            aWSKeyValueStore.put(access$300.getIdentityPoolId() + "." + EXPIRATION_KEY, String.valueOf(System.currentTimeMillis() + 510000));
        }
    }

    public void setProviderResultsHandler(SignInProviderResultHandler signInProviderResultHandler) {
        if (signInProviderResultHandler != null) {
            this.resultsAdapter = new SignInProviderResultAdapter(signInProviderResultHandler);
            return;
        }
        throw new IllegalArgumentException("signInProviderResultHandler cannot be null.");
    }

    public void federateWithProvider(IdentityProvider identityProvider) {
        Log.d(LOG_TAG, "federate with provider: Populate loginsMap with token.");
        final HashMap hashMap = new HashMap();
        hashMap.put(identityProvider.getCognitoLoginKey(), identityProvider.getToken());
        this.currentIdentityProvider = identityProvider;
        this.executorService.submit(new Runnable() {
            public void run() {
                try {
                    if (IdentityManager.this.shouldFederate) {
                        IdentityManager.this.refreshCredentialWithLogins(hashMap);
                    }
                    IdentityManager.this.resultsAdapter.onCognitoSuccess();
                    synchronized (IdentityManager.this.signInStateChangeListeners) {
                        Iterator it = IdentityManager.this.signInStateChangeListeners.iterator();
                        while (it.hasNext()) {
                            ((SignInStateChangeListener) it.next()).onUserSignedIn();
                        }
                    }
                } catch (Exception e) {
                    IdentityManager.this.resultsAdapter.onCognitoError(e);
                }
            }
        });
    }

    public IdentityProvider getCurrentIdentityProvider() {
        return this.currentIdentityProvider;
    }

    public void addSignInProvider(Class<? extends SignInProvider> cls) {
        this.signInProviderClasses.add(cls);
    }

    public Collection<Class<? extends SignInProvider>> getSignInProviderClasses() {
        return this.signInProviderClasses;
    }

    public boolean isUserSignedIn() {
        Map<String, String> logins = this.credentialsProviderHolder.getUnderlyingProvider().getLogins();
        return (logins == null || logins.size() == 0) ? false : true;
    }

    /* access modifiers changed from: private */
    public void completeHandler(Activity activity, final StartupAuthResultHandler startupAuthResultHandler, final AuthException authException) {
        runAfterStartupAuthDelay(activity, new Runnable() {
            public void run() {
                startupAuthResultHandler.onComplete(new StartupAuthResult(IdentityManager.this, new StartupAuthErrorDetails(authException, (Exception) null)));
            }
        });
    }

    /* access modifiers changed from: private */
    public void runAfterStartupAuthDelay(final Activity activity, final Runnable runnable) {
        this.executorService.submit(new Runnable() {
            public void run() {
                try {
                    IdentityManager.this.startupAuthTimeoutLatch.await();
                } catch (InterruptedException unused) {
                    Log.d(IdentityManager.LOG_TAG, "Interrupted while waiting for startup auth minimum delay.");
                }
                activity.runOnUiThread(runnable);
            }
        });
    }

    public void resumeSession(Activity activity, StartupAuthResultHandler startupAuthResultHandler, long j) {
        Log.d(LOG_TAG, "Resume Session called.");
        final Activity activity2 = activity;
        final StartupAuthResultHandler startupAuthResultHandler2 = startupAuthResultHandler;
        final long j2 = j;
        this.executorService.submit(new Runnable() {
            public void run() {
                Log.d(IdentityManager.LOG_TAG, "Looking for a previously signed-in session.");
                SignInManager instance = SignInManager.getInstance(activity2.getApplicationContext());
                SignInProvider previouslySignedInProvider = instance.getPreviouslySignedInProvider();
                if (previouslySignedInProvider != null) {
                    String access$500 = IdentityManager.LOG_TAG;
                    Log.d(access$500, "Refreshing credentials with sign-in provider " + previouslySignedInProvider.getDisplayName());
                    instance.refreshCredentialsWithProvider(activity2, previouslySignedInProvider, new SignInProviderResultHandler() {
                        public void onSuccess(IdentityProvider identityProvider) {
                            Log.d(IdentityManager.LOG_TAG, "Successfully got AWS Credentials.");
                            IdentityManager.this.runAfterStartupAuthDelay(activity2, new Runnable() {
                                public void run() {
                                    startupAuthResultHandler2.onComplete(new StartupAuthResult(IdentityManager.this, (StartupAuthErrorDetails) null));
                                }
                            });
                        }

                        public void onCancel(IdentityProvider identityProvider) {
                            Log.wtf(IdentityManager.LOG_TAG, "Cancel can't happen when handling a previously signed-in user.");
                        }

                        public void onError(IdentityProvider identityProvider, Exception exc) {
                            if (identityProvider != null) {
                                Log.e(IdentityManager.LOG_TAG, String.format("Federate with Cognito with %s Sign-in provider failed. Error: %s", new Object[]{identityProvider.getDisplayName(), exc.getMessage()}), exc);
                            } else {
                                Log.e(IdentityManager.LOG_TAG, String.format("Federate with Cognito failed. Error: %s", new Object[]{exc.getMessage()}), exc);
                            }
                            if (exc instanceof AuthException) {
                                IdentityManager.this.completeHandler(activity2, startupAuthResultHandler2, (AuthException) exc);
                            } else {
                                IdentityManager.this.completeHandler(activity2, startupAuthResultHandler2, new AuthException(identityProvider, exc));
                            }
                        }
                    });
                } else {
                    IdentityManager.this.completeHandler(activity2, startupAuthResultHandler2, (AuthException) null);
                }
                long j = j2;
                if (j > 0) {
                    try {
                        Thread.sleep(j);
                    } catch (InterruptedException unused) {
                        Log.i(IdentityManager.LOG_TAG, "Interrupted while waiting for resume session timeout.");
                    }
                }
                IdentityManager.this.startupAuthTimeoutLatch.countDown();
            }
        });
    }

    public void resumeSession(Activity activity, StartupAuthResultHandler startupAuthResultHandler) {
        resumeSession(activity, startupAuthResultHandler, 0);
    }

    @Deprecated
    public void doStartupAuth(Activity activity, StartupAuthResultHandler startupAuthResultHandler) {
        resumeSession(activity, startupAuthResultHandler, 0);
    }

    @Deprecated
    public void doStartupAuth(Activity activity, StartupAuthResultHandler startupAuthResultHandler, long j) {
        resumeSession(activity, startupAuthResultHandler, j);
    }

    public void expireSignInTimeout() {
        this.startupAuthTimeoutLatch.countDown();
    }

    @Deprecated
    public void setUpToAuthenticate(Context context, SignInResultHandler signInResultHandler) {
        login(context, signInResultHandler);
    }

    public void login(Context context, SignInResultHandler signInResultHandler) {
        try {
            SignInManager.getInstance(context.getApplicationContext()).setResultHandler(signInResultHandler);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error in instantiating SignInManager. Check the context and completion handler.", e);
        }
    }

    private void createCredentialsProvider(Context context, ClientConfiguration clientConfiguration2) {
        Log.d(LOG_TAG, "Creating the Cognito Caching Credentials Provider with a refreshing Cognito Identity Provider.");
        if (this.shouldFederate) {
            JSONObject cognitoIdentityPoolConfig = getCognitoIdentityPoolConfig();
            try {
                String string = cognitoIdentityPoolConfig.getString("Region");
                String string2 = cognitoIdentityPoolConfig.getString("PoolId");
                Regions fromName = Regions.fromName(string);
                CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = new CognitoCachingCredentialsProvider(context, (AWSCognitoIdentityProvider) new AWSRefreshingCognitoIdentityProvider((String) null, string2, clientConfiguration2, fromName), fromName, clientConfiguration2);
                cognitoCachingCredentialsProvider.setPersistenceEnabled(this.isPersistenceEnabled);
                if (clientConfiguration2.getUserAgentOverride() != null) {
                    cognitoCachingCredentialsProvider.setUserAgentOverride(clientConfiguration2.getUserAgentOverride());
                }
                this.credentialsProviderHolder.setUnderlyingProvider(cognitoCachingCredentialsProvider);
            } catch (JSONException e) {
                throw new IllegalArgumentException("Failed to read configuration for CognitoIdentity", e);
            }
        }
    }

    private JSONObject getCognitoIdentityPoolConfig() throws IllegalArgumentException {
        try {
            return this.awsConfiguration.optJsonObject("CredentialsProvider").getJSONObject("CognitoIdentity").getJSONObject(this.awsConfiguration.getConfiguration());
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot access Cognito IdentityPoolId from the awsconfiguration.json file.", e);
        }
    }
}
