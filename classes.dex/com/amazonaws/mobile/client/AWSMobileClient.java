package com.amazonaws.mobile.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.amazonaws.AmazonClientException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCognitoIdentityProvider;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AnonymousAWSCredentials;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.IdentityProvider;
import com.amazonaws.mobile.auth.core.SignInStateChangeListener;
import com.amazonaws.mobile.auth.core.StartupAuthResultHandler;
import com.amazonaws.mobile.auth.core.signin.SignInProvider;
import com.amazonaws.mobile.auth.facebook.FacebookButton;
import com.amazonaws.mobile.auth.facebook.FacebookSignInProvider;
import com.amazonaws.mobile.auth.google.GoogleButton;
import com.amazonaws.mobile.auth.google.GoogleSignInProvider;
import com.amazonaws.mobile.auth.ui.AuthUIConfiguration;
import com.amazonaws.mobile.auth.ui.SignInUI;
import com.amazonaws.mobile.auth.userpools.CognitoUserPoolsSignInProvider;
import com.amazonaws.mobile.client.internal.InternalCallback;
import com.amazonaws.mobile.client.internal.ReturningRunnable;
import com.amazonaws.mobile.client.internal.oauth2.AuthorizeResponse;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Client;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Tokens;
import com.amazonaws.mobile.client.results.ForgotPasswordResult;
import com.amazonaws.mobile.client.results.ForgotPasswordState;
import com.amazonaws.mobile.client.results.SignInResult;
import com.amazonaws.mobile.client.results.SignInState;
import com.amazonaws.mobile.client.results.SignUpResult;
import com.amazonaws.mobile.client.results.Tokens;
import com.amazonaws.mobile.client.results.UserCodeDeliveryDetails;
import com.amazonaws.mobile.config.AWSConfigurable;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.cognitoauth.Auth;
import com.amazonaws.mobileconnectors.cognitoauth.AuthUserSession;
import com.amazonaws.mobileconnectors.cognitoauth.handlers.AuthHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoDevice;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ForgotPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.NewPasswordContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.ForgotPasswordHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GenericHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GetDetailsHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.UpdateAttributesHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.VerificationHandler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoJWTParser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoPinpointSharedContext;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.util.CognitoServiceConstants;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidentity.AmazonCognitoIdentityClient;
import com.amazonaws.services.cognitoidentity.model.NotAuthorizedException;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProvider;
import com.amazonaws.services.cognitoidentityprovider.AmazonCognitoIdentityProviderClient;
import com.amazonaws.services.cognitoidentityprovider.model.GlobalSignOutRequest;
import com.amazonaws.util.StringUtils;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.bonree.sdk.agent.engine.external.JSONObjectInstrumentation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AWSMobileClient implements AWSCredentialsProvider {
    static final String AUTH_KEY = "Auth";
    public static final String CHALLENGE_RESPONSE_NEW_PASSWORD_KEY = "NEW_PASSWORD";
    public static final String CHALLENGE_RESPONSE_USER_ATTRIBUTES_PREFIX_KEY = "userAttributes.";
    private static final String COGNITO_USERPOOL_CUSTOM_ENDPOINT = "Endpoint";
    private static final String CUSTOM_ROLE_ARN_KEY = "customRoleArn";
    public static final String DEFAULT_USER_AGENT = "AWSMobileClient";
    private static final String FACEBOOK = "FacebookSignIn";
    static final String FEDERATION_ENABLED_KEY = "isFederationEnabled";
    private static final String GOOGLE = "GoogleSignIn";
    private static final String GOOGLE_WEBAPP_CONFIG_KEY = "ClientId-WebApp";
    public static final String HOSTED_UI_KEY = "hostedUI";
    static final String IDENTITY_ID_KEY = "cognitoIdentityId";
    static final String PROVIDER_KEY = "provider";
    static final String SHARED_PREFERENCES_KEY = "com.amazonaws.mobile.client";
    static final String SIGN_IN_MODE = "signInMode";
    /* access modifiers changed from: private */
    public static final String TAG = "AWSMobileClient";
    static final String TOKEN_KEY = "token";
    private static final String USER_POOLS = "CognitoUserPool";
    private static volatile AWSMobileClient singleton;
    AWSConfiguration awsConfiguration;
    private AWSCredentialsProvider awsCredentialsProvider;
    private AWSStartupHandler awsStartupHandler;
    private final LinkedHashMap<Class<? extends AWSConfigurable>, AWSConfigurable> clientMap;
    CognitoCachingCredentialsProvider cognitoIdentity;
    private Object federateWithCognitoIdentityLockObject;
    /* access modifiers changed from: private */
    public Callback<ForgotPasswordResult> forgotPasswordCallback;
    /* access modifiers changed from: private */
    public ForgotPasswordContinuation forgotPasswordContinuation;
    Auth hostedUI;
    /* access modifiers changed from: private */
    public Object initLockObject;
    List<UserStateListener> listeners;
    CognitoUserSession mCognitoUserSession;
    Context mContext;
    DeviceOperations mDeviceOperations;
    Map<String, String> mFederatedLoginsMap;
    private boolean mIsLegacyMode;
    boolean mIsPersistenceEnabled = true;
    OAuth2Client mOAuth2Client;
    private volatile CountDownLatch mSignedOutWaitLatch;
    KeyValueStore mStore;
    String mUserPoolPoolId;
    private Lock mWaitForSignInLock;
    AWSMobileClientCognitoIdentityProvider provider;
    /* access modifiers changed from: private */
    public Object showSignInLockObject;
    /* access modifiers changed from: private */
    public volatile CountDownLatch showSignInWaitLatch;
    /* access modifiers changed from: private */
    public Callback<SignInResult> signInCallback;
    /* access modifiers changed from: private */
    public ChallengeContinuation signInChallengeContinuation;
    /* access modifiers changed from: private */
    public MultiFactorAuthenticationContinuation signInMfaContinuation;
    private SignInProviderConfig[] signInProviderConfig;
    /* access modifiers changed from: private */
    public SignInState signInState;
    /* access modifiers changed from: private */
    public CognitoUser signUpUser;
    private StartupAuthResultHandler startupAuthResultHandler;
    String userAgentOverride;
    private UserStateDetails userStateDetails;
    CognitoUserPool userpool;
    AmazonCognitoIdentityProvider userpoolLL;
    String userpoolsLoginKey;

    enum SignInMode {
        SIGN_IN("0"),
        FEDERATED_SIGN_IN("1"),
        HOSTED_UI(ExifInterface.GPS_MEASUREMENT_2D),
        OAUTH2(ExifInterface.GPS_MEASUREMENT_3D),
        UNKNOWN("-1");
        
        String encode;

        private SignInMode(String str) {
            this.encode = str;
        }

        public String toString() {
            return this.encode;
        }

        static SignInMode fromString(String str) {
            if ("0".equals(str)) {
                return SIGN_IN;
            }
            if ("1".equals(str)) {
                return FEDERATED_SIGN_IN;
            }
            if (ExifInterface.GPS_MEASUREMENT_2D.equals(str)) {
                return HOSTED_UI;
            }
            if (ExifInterface.GPS_MEASUREMENT_3D.equals(str)) {
                return OAUTH2;
            }
            return UNKNOWN;
        }
    }

    private AWSMobileClient() {
        if (singleton == null) {
            this.clientMap = new LinkedHashMap<>();
            this.userpoolsLoginKey = "";
            this.mWaitForSignInLock = new ReentrantLock();
            this.mFederatedLoginsMap = new HashMap();
            this.listeners = new ArrayList();
            this.showSignInLockObject = new Object();
            this.federateWithCognitoIdentityLockObject = new Object();
            this.showSignInWaitLatch = new CountDownLatch(1);
            this.initLockObject = new Object();
            this.mStore = new DummyStore();
            return;
        }
        throw new AssertionError();
    }

    public static synchronized AWSMobileClient getInstance() {
        AWSMobileClient aWSMobileClient;
        synchronized (AWSMobileClient.class) {
            if (singleton == null) {
                singleton = new AWSMobileClient();
            }
            aWSMobileClient = singleton;
        }
        return aWSMobileClient;
    }

    static synchronized AWSMobileClient getInstance(boolean z) {
        AWSMobileClient aWSMobileClient;
        synchronized (AWSMobileClient.class) {
            if (z) {
                singleton = null;
            }
            aWSMobileClient = new AWSMobileClient();
        }
        return aWSMobileClient;
    }

    /* access modifiers changed from: package-private */
    public void setUserPool(CognitoUserPool cognitoUserPool) {
        this.userpool = cognitoUserPool;
    }

    public AWSConfiguration getConfiguration() {
        return this.awsConfiguration;
    }

    public AWSCredentials getCredentials() {
        if (isLegacyMode()) {
            return IdentityManager.getDefaultIdentityManager().getCredentialsProvider().getCredentials();
        }
        if (this.cognitoIdentity != null) {
            try {
                if (waitForSignIn()) {
                    Log.d(TAG, "getCredentials: Validated user is signed-in");
                }
                AWSSessionCredentials credentials = this.cognitoIdentity.getCredentials();
                this.mStore.set(IDENTITY_ID_KEY, this.cognitoIdentity.getIdentityId());
                return credentials;
            } catch (NotAuthorizedException e) {
                Log.w(TAG, "getCredentials: Failed to getCredentials from Cognito Identity", e);
                throw new AmazonClientException("Failed to get credentials from Cognito Identity", e);
            } catch (Exception e2) {
                throw new AmazonClientException("Failed to get credentials from Cognito Identity", e2);
            }
        } else {
            throw new AmazonClientException("Cognito Identity not configured");
        }
    }

    public void refresh() {
        if (isLegacyMode()) {
            IdentityManager.getDefaultIdentityManager().getCredentialsProvider().refresh();
            return;
        }
        CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = this.cognitoIdentity;
        if (cognitoCachingCredentialsProvider != null) {
            cognitoCachingCredentialsProvider.refresh();
            this.mStore.set(IDENTITY_ID_KEY, this.cognitoIdentity.getIdentityId());
            return;
        }
        throw new AmazonClientException("Cognito Identity not configured");
    }

    public AWSCredentials getAWSCredentials() throws Exception {
        return _getAWSCredentials().await();
    }

    public void getAWSCredentials(Callback<AWSCredentials> callback) {
        _getAWSCredentials().async(callback);
    }

    private ReturningRunnable<AWSCredentials> _getAWSCredentials() {
        return new ReturningRunnable<AWSCredentials>() {
            public AWSCredentials run() {
                return AWSMobileClient.this.getCredentials();
            }
        };
    }

    public String getIdentityId() {
        if (isLegacyMode()) {
            return IdentityManager.getDefaultIdentityManager().getCachedUserID();
        }
        CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = this.cognitoIdentity;
        if (cognitoCachingCredentialsProvider != null) {
            String cachedIdentityId = cognitoCachingCredentialsProvider.getCachedIdentityId();
            return cachedIdentityId == null ? this.mStore.get(IDENTITY_ID_KEY) : cachedIdentityId;
        }
        throw new RuntimeException("Cognito Identity not configured");
    }

    /* access modifiers changed from: package-private */
    public boolean isLegacyMode() {
        return this.mIsLegacyMode;
    }

    public void initialize(Context context, Callback<UserStateDetails> callback) {
        Context applicationContext = context.getApplicationContext();
        initialize(applicationContext, new AWSConfiguration(applicationContext), callback);
    }

    public void initialize(Context context, AWSConfiguration aWSConfiguration, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_initialize(context, aWSConfiguration, internalCallback));
    }

    /* access modifiers changed from: package-private */
    public CountDownLatch getSignInUILatch() {
        return this.showSignInWaitLatch;
    }

    /* access modifiers changed from: protected */
    public Runnable _initialize(final Context context, final AWSConfiguration aWSConfiguration, final Callback<UserStateDetails> callback) {
        return new Runnable() {
            public void run() {
                synchronized (AWSMobileClient.this.initLockObject) {
                    if (AWSMobileClient.this.awsConfiguration != null) {
                        callback.onResult(AWSMobileClient.this.getUserStateDetails(true));
                        return;
                    }
                    AWSMobileClient.this.mIsPersistenceEnabled = true;
                    try {
                        if (aWSConfiguration.optJsonObject(AWSMobileClient.AUTH_KEY) != null && aWSConfiguration.optJsonObject(AWSMobileClient.AUTH_KEY).has("Persistence")) {
                            AWSMobileClient.this.mIsPersistenceEnabled = aWSConfiguration.optJsonObject(AWSMobileClient.AUTH_KEY).getBoolean("Persistence");
                        }
                        AWSMobileClient.this.userAgentOverride = aWSConfiguration.getUserAgentOverride();
                        AWSMobileClient.this.mContext = context.getApplicationContext();
                        AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                        aWSMobileClient.mStore = new AWSMobileClientStore(aWSMobileClient);
                        final IdentityManager identityManager = new IdentityManager(AWSMobileClient.this.mContext);
                        identityManager.enableFederation(false);
                        identityManager.setConfiguration(aWSConfiguration);
                        identityManager.setPersistenceEnabled(AWSMobileClient.this.mIsPersistenceEnabled);
                        IdentityManager.setDefaultIdentityManager(identityManager);
                        AWSMobileClient.this.registerConfigSignInProviders(aWSConfiguration);
                        identityManager.addSignInStateChangeListener(new SignInStateChangeListener() {
                            public void onUserSignedIn() {
                                Log.d(AWSMobileClient.TAG, "onUserSignedIn: Updating user state from drop-in UI");
                                SignInState unused = AWSMobileClient.this.signInState = SignInState.DONE;
                                IdentityProvider currentIdentityProvider = identityManager.getCurrentIdentityProvider();
                                String token = currentIdentityProvider.getToken();
                                AWSMobileClient.this.federatedSignInWithoutAssigningState(currentIdentityProvider.getCognitoLoginKey(), token, new Callback<UserStateDetails>() {
                                    public void onResult(UserStateDetails userStateDetails) {
                                        Log.d(AWSMobileClient.TAG, "onResult: showSignIn federated");
                                        AWSMobileClient.this.setUserState(AWSMobileClient.this.getUserStateDetails(false));
                                        AWSMobileClient.this.getSignInUILatch().countDown();
                                    }

                                    public void onError(Exception exc) {
                                        Log.w(AWSMobileClient.TAG, "onError: User sign-in had errors from drop-in UI", exc);
                                        AWSMobileClient.this.setUserState(AWSMobileClient.this.getUserStateDetails(false));
                                        AWSMobileClient.this.getSignInUILatch().countDown();
                                    }
                                });
                            }

                            public void onUserSignedOut() {
                                Log.d(AWSMobileClient.TAG, "onUserSignedOut: Updating user state from drop-in UI");
                                AWSMobileClient.this.setUserState(AWSMobileClient.this.getUserStateDetails(false));
                                AWSMobileClient.this.showSignInWaitLatch.countDown();
                            }
                        });
                        if (!(aWSConfiguration.optJsonObject("CredentialsProvider") == null || aWSConfiguration.optJsonObject("CredentialsProvider").optJSONObject("CognitoIdentity") == null)) {
                            try {
                                JSONObject jSONObject = aWSConfiguration.optJsonObject("CredentialsProvider").getJSONObject("CognitoIdentity").getJSONObject(aWSConfiguration.getConfiguration());
                                String string = jSONObject.getString("PoolId");
                                String string2 = jSONObject.getString("Region");
                                ClientConfiguration clientConfiguration = new ClientConfiguration();
                                clientConfiguration.setUserAgent("AWSMobileClient " + aWSConfiguration.getUserAgent());
                                if (AWSMobileClient.this.userAgentOverride != null) {
                                    clientConfiguration.setUserAgentOverride(AWSMobileClient.this.userAgentOverride);
                                }
                                AmazonCognitoIdentityClient amazonCognitoIdentityClient = new AmazonCognitoIdentityClient((AWSCredentials) new AnonymousAWSCredentials(), clientConfiguration);
                                amazonCognitoIdentityClient.setRegion(Region.getRegion(string2));
                                AWSMobileClient.this.provider = new AWSMobileClientCognitoIdentityProvider((String) null, string, amazonCognitoIdentityClient);
                                AWSMobileClient.this.cognitoIdentity = new CognitoCachingCredentialsProvider(AWSMobileClient.this.mContext, (AWSCognitoIdentityProvider) AWSMobileClient.this.provider, Regions.fromName(string2));
                                AWSMobileClient.this.cognitoIdentity.setPersistenceEnabled(AWSMobileClient.this.mIsPersistenceEnabled);
                                if (AWSMobileClient.this.userAgentOverride != null) {
                                    AWSMobileClient.this.cognitoIdentity.setUserAgentOverride(AWSMobileClient.this.userAgentOverride);
                                }
                            } catch (Exception e) {
                                callback.onError(new RuntimeException("Failed to initialize Cognito Identity; please check your awsconfiguration.json", e));
                                return;
                            }
                        }
                        JSONObject optJsonObject = aWSConfiguration.optJsonObject(AWSMobileClient.USER_POOLS);
                        if (optJsonObject != null) {
                            try {
                                AWSMobileClient.this.mUserPoolPoolId = optJsonObject.getString("PoolId");
                                String string3 = optJsonObject.getString("AppClientId");
                                String optString = optJsonObject.optString("AppClientSecret");
                                String pinpointEndpoint = CognitoPinpointSharedContext.getPinpointEndpoint(context, optJsonObject.optString("PinpointAppId"));
                                String optString2 = optJsonObject.optString(AWSMobileClient.COGNITO_USERPOOL_CUSTOM_ENDPOINT);
                                ClientConfiguration clientConfiguration2 = new ClientConfiguration();
                                clientConfiguration2.setUserAgent("AWSMobileClient " + aWSConfiguration.getUserAgent());
                                if (AWSMobileClient.this.userAgentOverride != null) {
                                    clientConfiguration2.setUserAgentOverride(AWSMobileClient.this.userAgentOverride);
                                }
                                AWSMobileClient.this.userpoolLL = new AmazonCognitoIdentityProviderClient((AWSCredentials) new AnonymousAWSCredentials(), clientConfiguration2);
                                AWSMobileClient.this.userpoolLL.setRegion(Region.getRegion(Regions.fromName(optJsonObject.getString("Region"))));
                                AWSMobileClient.this.userpoolsLoginKey = String.format("cognito-idp.%s.amazonaws.com/%s", new Object[]{optJsonObject.getString("Region"), optJsonObject.getString("PoolId")});
                                AWSMobileClient.this.userpool = new CognitoUserPool(AWSMobileClient.this.mContext, AWSMobileClient.this.mUserPoolPoolId, string3, optString, AWSMobileClient.this.userpoolLL, pinpointEndpoint, optString2);
                                AWSMobileClient.this.userpool.setPersistenceEnabled(AWSMobileClient.this.mIsPersistenceEnabled);
                                AWSMobileClient aWSMobileClient2 = AWSMobileClient.this;
                                aWSMobileClient2.mDeviceOperations = new DeviceOperations(aWSMobileClient2, aWSMobileClient2.userpoolLL);
                            } catch (Exception e2) {
                                callback.onError(new RuntimeException("Failed to initialize Cognito Userpool; please check your awsconfiguration.json", e2));
                                return;
                            }
                        }
                        JSONObject hostedUIJSON = AWSMobileClient.this.getHostedUIJSON(aWSConfiguration);
                        if (hostedUIJSON != null) {
                            try {
                                if (hostedUIJSON.has("TokenURI")) {
                                    Log.d(AWSMobileClient.TAG, "initialize: OAuth2 client detected");
                                    AWSMobileClient.this.mOAuth2Client = new OAuth2Client(AWSMobileClient.this.mContext, AWSMobileClient.this);
                                    AWSMobileClient.this.mOAuth2Client.setPersistenceEnabled(AWSMobileClient.this.mIsPersistenceEnabled);
                                    AWSMobileClient.this.mOAuth2Client.setUserAgentOverride(AWSMobileClient.this.userAgentOverride);
                                } else {
                                    AWSMobileClient.this._initializeHostedUI(hostedUIJSON);
                                }
                            } catch (Exception e3) {
                                callback.onError(new RuntimeException("Failed to initialize OAuth, please check your awsconfiguration.json", e3));
                            }
                        }
                        if (AWSMobileClient.this.cognitoIdentity == null && AWSMobileClient.this.userpool == null) {
                            callback.onError(new RuntimeException("Neither Cognito Identity or Cognito UserPool was used. At least one must be present to use AWSMobileClient."));
                            return;
                        }
                        AWSMobileClient.this.awsConfiguration = aWSConfiguration;
                        UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(true);
                        callback.onResult(userStateDetails);
                        AWSMobileClient.this.setUserState(userStateDetails);
                    } catch (Exception e4) {
                        callback.onError(new RuntimeException("Failed to initialize AWSMobileClient; please check your awsconfiguration.json", e4));
                    }
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void _initializeHostedUI(JSONObject jSONObject) throws JSONException {
        Log.d(TAG, "initialize: Cognito HostedUI client detected");
        JSONArray jSONArray = jSONObject.getJSONArray("Scopes");
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        if (this.mUserPoolPoolId != null) {
            this.hostedUI = getHostedUI(jSONObject).setPersistenceEnabled(this.mIsPersistenceEnabled).setAuthHandler(new AuthHandler() {
                public void onFailure(Exception exc) {
                }

                public void onSignout() {
                }

                public void onSuccess(AuthUserSession authUserSession) {
                }
            }).build();
            return;
        }
        throw new IllegalStateException("User pool Id must be available through user pool setting");
    }

    /* access modifiers changed from: package-private */
    public JSONObject getHostedUIJSONFromJSON() {
        return getHostedUIJSONFromJSON(this.awsConfiguration);
    }

    /* access modifiers changed from: package-private */
    public JSONObject getHostedUIJSONFromJSON(AWSConfiguration aWSConfiguration) {
        JSONObject optJsonObject = aWSConfiguration.optJsonObject(AUTH_KEY);
        if (optJsonObject == null || !optJsonObject.has("OAuth")) {
            return null;
        }
        try {
            return optJsonObject.getJSONObject("OAuth");
        } catch (Exception e) {
            Log.w(TAG, "getHostedUIJSONFromJSON: Failed to read config", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject getHostedUIJSON() {
        return getHostedUIJSON(this.awsConfiguration);
    }

    /* access modifiers changed from: package-private */
    public JSONObject getHostedUIJSON(AWSConfiguration aWSConfiguration) {
        JSONObject jSONObject;
        try {
            JSONObject hostedUIJSONFromJSON = getHostedUIJSONFromJSON(aWSConfiguration);
            if (hostedUIJSONFromJSON == null) {
                return null;
            }
            try {
                jSONObject = new JSONObject(this.mStore.get(HOSTED_UI_KEY));
            } catch (Exception e) {
                Log.w(TAG, "Failed to parse HostedUI settings from store. Defaulting to awsconfiguration.json", e);
                jSONObject = null;
            }
            if (jSONObject == null && hostedUIJSONFromJSON != null) {
                jSONObject = new JSONObject(!(hostedUIJSONFromJSON instanceof JSONObject) ? hostedUIJSONFromJSON.toString() : JSONObjectInstrumentation.toString(hostedUIJSONFromJSON));
                this.mStore.set(HOSTED_UI_KEY, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
            }
            return jSONObject;
        } catch (Exception e2) {
            Log.d(TAG, "getHostedUIJSON: Failed to read config", e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public Auth.Builder getHostedUI(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = jSONObject.getJSONArray("Scopes");
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.getString(i));
        }
        return new Auth.Builder().setApplicationContext(this.mContext).setUserPoolId(this.mUserPoolPoolId).setAppClientId(jSONObject.getString("AppClientId")).setAppClientSecret(jSONObject.optString("AppClientSecret", (String) null)).setAppCognitoWebDomain(jSONObject.getString("WebDomain")).setSignInRedirect(jSONObject.getString("SignInRedirectURI")).setSignOutRedirect(jSONObject.getString("SignOutRedirectURI")).setScopes(hashSet).setAdvancedSecurityDataCollection(false).setIdentityProvider(jSONObject.optString("IdentityProvider")).setIdpIdentifier(jSONObject.optString("IdpIdentifier"));
    }

    public DeviceOperations getDeviceOperations() {
        DeviceOperations deviceOperations = this.mDeviceOperations;
        if (deviceOperations != null) {
            return deviceOperations;
        }
        throw new AmazonClientException("Please check if userpools is configured.");
    }

    public void releaseSignInWait() {
        if (this.mSignedOutWaitLatch != null) {
            this.mSignedOutWaitLatch.countDown();
        }
    }

    /* access modifiers changed from: protected */
    public void setUserState(final UserStateDetails userStateDetails2) {
        boolean z = !userStateDetails2.equals(this.userStateDetails);
        this.userStateDetails = userStateDetails2;
        if (z) {
            synchronized (this.listeners) {
                for (final UserStateListener next : this.listeners) {
                    Thread thread = new Thread(new Runnable() {
                        public void run() {
                            next.onUserStateChanged(userStateDetails2);
                        }
                    });
                    if (!(thread instanceof Thread)) {
                        thread.start();
                    } else {
                        AsynchronousInstrumentation.threadStart(thread);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isNetworkAvailable(Context context) {
        if (Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            Log.w(TAG, "Could not access network state", e);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isUserpoolsSignedIn() {
        return this.userpoolsLoginKey.equals(this.mStore.get(PROVIDER_KEY));
    }

    public String getUsername() {
        try {
            if (this.userpoolsLoginKey.equals(this.mStore.get(PROVIDER_KEY))) {
                return this.userpool.getCurrentUser().getUserId();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public String getUserSub() {
        try {
            if (this.userpoolsLoginKey.equals(this.mStore.get(PROVIDER_KEY))) {
                return CognitoJWTParser.getClaim(this.mStore.get(TOKEN_KEY), "sub");
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public UserStateDetails currentUserState() {
        try {
            return _currentUserState().await();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve user state.", e);
        }
    }

    public void currentUserState(Callback<UserStateDetails> callback) {
        _currentUserState().async(callback);
    }

    /* access modifiers changed from: package-private */
    public ReturningRunnable<UserStateDetails> _currentUserState() {
        return new ReturningRunnable<UserStateDetails>() {
            public UserStateDetails run() throws Exception {
                return AWSMobileClient.this.getUserStateDetails(false);
            }
        };
    }

    public void addUserStateListener(UserStateListener userStateListener) {
        synchronized (this.listeners) {
            this.listeners.add(userStateListener);
        }
    }

    public boolean removeUserStateListener(UserStateListener userStateListener) {
        synchronized (this.listeners) {
            int indexOf = this.listeners.indexOf(userStateListener);
            if (indexOf == -1) {
                return false;
            }
            this.listeners.remove(indexOf);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public String getLoginKey() {
        return this.userpoolsLoginKey;
    }

    public boolean isSignedIn() {
        int i = AnonymousClass28.$SwitchMap$com$amazonaws$mobile$client$UserState[getUserStateDetails(true).getUserState().ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return true;
        }
        if (i == 4 || i == 5) {
            return false;
        }
        throw new IllegalStateException("Unknown user state, please report this exception");
    }

    /* access modifiers changed from: protected */
    public boolean waitForSignIn() {
        try {
            this.mWaitForSignInLock.lock();
            this.mSignedOutWaitLatch = new CountDownLatch(1);
            boolean z = false;
            UserStateDetails userStateDetails2 = getUserStateDetails(false);
            String str = TAG;
            Log.d(str, "waitForSignIn: userState:" + userStateDetails2.getUserState());
            int i = AnonymousClass28.$SwitchMap$com$amazonaws$mobile$client$UserState[userStateDetails2.getUserState().ordinal()];
            if (i != 1) {
                if (i == 2 || i == 3) {
                    if (userStateDetails2.getException() != null) {
                        if (!isSignedOutRelatedException(userStateDetails2.getException())) {
                            throw userStateDetails2.getException();
                        }
                    }
                    setUserState(userStateDetails2);
                    this.mSignedOutWaitLatch.await();
                    z = getUserStateDetails(false).getUserState().equals(UserState.SIGNED_IN);
                } else if (i == 4 || i == 5) {
                    setUserState(userStateDetails2);
                } else {
                    this.mWaitForSignInLock.unlock();
                    return false;
                }
                this.mWaitForSignInLock.unlock();
                return z;
            }
            setUserState(userStateDetails2);
            this.mWaitForSignInLock.unlock();
            return true;
        } catch (Exception e) {
            throw new AmazonClientException("Operation requires a signed-in state", e);
        } catch (Throwable th) {
            this.mWaitForSignInLock.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> getSignInDetailsMap() {
        return this.mStore.get(PROVIDER_KEY, TOKEN_KEY);
    }

    /* access modifiers changed from: package-private */
    public String _getCachedIdentityId() {
        return this.mStore.get(IDENTITY_ID_KEY);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00fd A[Catch:{ all -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0100 A[Catch:{ all -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x010d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.mobile.client.UserStateDetails getUserStateDetails(boolean r11) {
        /*
            r10 = this;
            java.util.Map r0 = r10.getSignInDetailsMap()
            java.lang.String r1 = "provider"
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "token"
            java.lang.Object r3 = r0.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = r10._getCachedIdentityId()
            boolean r5 = r10.isFederationEnabled()
            java.lang.String r6 = TAG
            java.lang.String r7 = "Inspecting user state details"
            android.util.Log.d(r6, r7)
            r7 = 0
            if (r1 == 0) goto L_0x002a
            if (r3 == 0) goto L_0x002a
            r8 = 1
            goto L_0x002b
        L_0x002a:
            r8 = r7
        L_0x002b:
            r9 = 0
            if (r11 != 0) goto L_0x0146
            android.content.Context r11 = r10.mContext
            boolean r11 = r10.isNetworkAvailable(r11)
            if (r11 != 0) goto L_0x0038
            goto L_0x0146
        L_0x0038:
            if (r8 == 0) goto L_0x00ac
            java.lang.String r11 = r10.userpoolsLoginKey
            boolean r11 = r11.equals(r1)
            if (r11 != 0) goto L_0x00ac
            if (r5 != 0) goto L_0x0045
            goto L_0x0089
        L_0x0045:
            android.content.Context r11 = r10.mContext     // Catch:{ Exception -> 0x0091 }
            com.amazonaws.mobile.auth.core.signin.SignInManager r11 = com.amazonaws.mobile.auth.core.signin.SignInManager.getInstance(r11)     // Catch:{ Exception -> 0x0091 }
            com.amazonaws.mobile.auth.core.signin.SignInProvider r11 = r11.getPreviouslySignedInProvider()     // Catch:{ Exception -> 0x0091 }
            if (r11 == 0) goto L_0x0064
            java.lang.String r2 = r11.getCognitoLoginKey()     // Catch:{ Exception -> 0x0091 }
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x0091 }
            if (r2 == 0) goto L_0x0064
            java.lang.String r3 = r11.getToken()     // Catch:{ Exception -> 0x0091 }
            java.lang.String r11 = "Token was refreshed using drop-in UI internal mechanism"
            android.util.Log.i(r6, r11)     // Catch:{ Exception -> 0x0091 }
        L_0x0064:
            if (r3 != 0) goto L_0x0073
            java.lang.String r11 = "Token used for federation has become null"
            android.util.Log.i(r6, r11)     // Catch:{ Exception -> 0x0091 }
            com.amazonaws.mobile.client.UserStateDetails r11 = new com.amazonaws.mobile.client.UserStateDetails     // Catch:{ Exception -> 0x0091 }
            com.amazonaws.mobile.client.UserState r1 = com.amazonaws.mobile.client.UserState.SIGNED_OUT_FEDERATED_TOKENS_INVALID     // Catch:{ Exception -> 0x0091 }
            r11.<init>(r1, r0)     // Catch:{ Exception -> 0x0091 }
            return r11
        L_0x0073:
            boolean r11 = r10.hasFederatedToken(r1, r3)     // Catch:{ Exception -> 0x0091 }
            if (r11 == 0) goto L_0x0086
            java.lang.String r11 = "getUserStateDetails: token already federated just fetch credentials"
            android.util.Log.d(r6, r11)     // Catch:{ Exception -> 0x0091 }
            com.amazonaws.auth.CognitoCachingCredentialsProvider r11 = r10.cognitoIdentity     // Catch:{ Exception -> 0x0091 }
            if (r11 == 0) goto L_0x0089
            r11.getCredentials()     // Catch:{ Exception -> 0x0091 }
            goto L_0x0089
        L_0x0086:
            r10.federateWithCognitoIdentity(r1, r3)     // Catch:{ Exception -> 0x0091 }
        L_0x0089:
            com.amazonaws.mobile.client.UserStateDetails r11 = new com.amazonaws.mobile.client.UserStateDetails     // Catch:{ Exception -> 0x0091 }
            com.amazonaws.mobile.client.UserState r1 = com.amazonaws.mobile.client.UserState.SIGNED_IN     // Catch:{ Exception -> 0x0091 }
            r11.<init>(r1, r0)     // Catch:{ Exception -> 0x0091 }
            return r11
        L_0x0091:
            r11 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r2 = "Failed to federate the tokens."
            android.util.Log.w(r1, r2, r11)
            com.amazonaws.mobile.client.UserState r1 = com.amazonaws.mobile.client.UserState.SIGNED_IN
            boolean r2 = r10.isSignedOutRelatedException(r11)
            if (r2 == 0) goto L_0x00a3
            com.amazonaws.mobile.client.UserState r1 = com.amazonaws.mobile.client.UserState.SIGNED_OUT_FEDERATED_TOKENS_INVALID
        L_0x00a3:
            com.amazonaws.mobile.client.UserStateDetails r2 = new com.amazonaws.mobile.client.UserStateDetails
            r2.<init>(r1, r0)
            r2.setException(r11)
            return r2
        L_0x00ac:
            if (r8 == 0) goto L_0x0128
            com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool r11 = r10.userpool
            if (r11 == 0) goto L_0x0128
            com.amazonaws.mobile.client.results.Tokens r11 = r10.getTokens((boolean) r7)     // Catch:{ Exception -> 0x00f7 }
            com.amazonaws.mobile.client.results.Token r3 = r11.getIdToken()     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r3 = r3.getTokenString()     // Catch:{ Exception -> 0x00f5 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x00f5 }
            if (r5 != 0) goto L_0x00c4
            goto L_0x00e2
        L_0x00c4:
            boolean r2 = r10.hasFederatedToken(r1, r3)     // Catch:{ Exception -> 0x00f5 }
            if (r2 == 0) goto L_0x00db
            com.amazonaws.auth.CognitoCachingCredentialsProvider r1 = r10.cognitoIdentity     // Catch:{ Exception -> 0x00d2 }
            if (r1 == 0) goto L_0x00e2
            r1.getCredentials()     // Catch:{ Exception -> 0x00d2 }
            goto L_0x00e2
        L_0x00d2:
            r1 = move-exception
            java.lang.String r2 = TAG     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r3 = "Failed to get or refresh credentials from Cognito Identity"
            android.util.Log.w(r2, r3, r1)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x00e2
        L_0x00db:
            com.amazonaws.auth.CognitoCachingCredentialsProvider r2 = r10.cognitoIdentity     // Catch:{ Exception -> 0x00f5 }
            if (r2 == 0) goto L_0x00e2
            r10.federateWithCognitoIdentity(r1, r3)     // Catch:{ Exception -> 0x00f5 }
        L_0x00e2:
            com.amazonaws.mobile.client.UserState r11 = com.amazonaws.mobile.client.UserState.SIGNED_IN
            boolean r1 = r10.isSignedOutRelatedException(r9)
            if (r1 == 0) goto L_0x00ec
            com.amazonaws.mobile.client.UserState r11 = com.amazonaws.mobile.client.UserState.SIGNED_OUT_USER_POOLS_TOKENS_INVALID
        L_0x00ec:
            com.amazonaws.mobile.client.UserStateDetails r1 = new com.amazonaws.mobile.client.UserStateDetails
            r1.<init>(r11, r0)
        L_0x00f1:
            r1.setException(r9)
            return r1
        L_0x00f5:
            r1 = move-exception
            goto L_0x00f9
        L_0x00f7:
            r1 = move-exception
            r11 = r9
        L_0x00f9:
            java.lang.String r2 = TAG     // Catch:{ all -> 0x0118 }
            if (r11 != 0) goto L_0x0100
            java.lang.String r11 = "Tokens are invalid, please sign-in again."
            goto L_0x0102
        L_0x0100:
            java.lang.String r11 = "Failed to federate the tokens"
        L_0x0102:
            android.util.Log.w(r2, r11, r1)     // Catch:{ all -> 0x0118 }
            com.amazonaws.mobile.client.UserState r11 = com.amazonaws.mobile.client.UserState.SIGNED_IN
            boolean r2 = r10.isSignedOutRelatedException(r1)
            if (r2 == 0) goto L_0x010f
            com.amazonaws.mobile.client.UserState r11 = com.amazonaws.mobile.client.UserState.SIGNED_OUT_USER_POOLS_TOKENS_INVALID
        L_0x010f:
            com.amazonaws.mobile.client.UserStateDetails r2 = new com.amazonaws.mobile.client.UserStateDetails
            r2.<init>(r11, r0)
            r2.setException(r1)
            return r2
        L_0x0118:
            com.amazonaws.mobile.client.UserState r11 = com.amazonaws.mobile.client.UserState.SIGNED_IN
            boolean r1 = r10.isSignedOutRelatedException(r9)
            if (r1 == 0) goto L_0x0122
            com.amazonaws.mobile.client.UserState r11 = com.amazonaws.mobile.client.UserState.SIGNED_OUT_USER_POOLS_TOKENS_INVALID
        L_0x0122:
            com.amazonaws.mobile.client.UserStateDetails r1 = new com.amazonaws.mobile.client.UserStateDetails
            r1.<init>(r11, r0)
            goto L_0x00f1
        L_0x0128:
            com.amazonaws.auth.CognitoCachingCredentialsProvider r11 = r10.cognitoIdentity
            if (r11 != 0) goto L_0x0134
            com.amazonaws.mobile.client.UserStateDetails r11 = new com.amazonaws.mobile.client.UserStateDetails
            com.amazonaws.mobile.client.UserState r1 = com.amazonaws.mobile.client.UserState.SIGNED_OUT
            r11.<init>(r1, r0)
            return r11
        L_0x0134:
            if (r4 == 0) goto L_0x013e
            com.amazonaws.mobile.client.UserStateDetails r11 = new com.amazonaws.mobile.client.UserStateDetails
            com.amazonaws.mobile.client.UserState r1 = com.amazonaws.mobile.client.UserState.GUEST
            r11.<init>(r1, r0)
            return r11
        L_0x013e:
            com.amazonaws.mobile.client.UserStateDetails r11 = new com.amazonaws.mobile.client.UserStateDetails
            com.amazonaws.mobile.client.UserState r0 = com.amazonaws.mobile.client.UserState.SIGNED_OUT
            r11.<init>(r0, r9)
            return r11
        L_0x0146:
            if (r8 == 0) goto L_0x0150
            com.amazonaws.mobile.client.UserStateDetails r11 = new com.amazonaws.mobile.client.UserStateDetails
            com.amazonaws.mobile.client.UserState r1 = com.amazonaws.mobile.client.UserState.SIGNED_IN
            r11.<init>(r1, r0)
            return r11
        L_0x0150:
            if (r4 == 0) goto L_0x015a
            com.amazonaws.mobile.client.UserStateDetails r11 = new com.amazonaws.mobile.client.UserStateDetails
            com.amazonaws.mobile.client.UserState r1 = com.amazonaws.mobile.client.UserState.GUEST
            r11.<init>(r1, r0)
            return r11
        L_0x015a:
            com.amazonaws.mobile.client.UserStateDetails r11 = new com.amazonaws.mobile.client.UserStateDetails
            com.amazonaws.mobile.client.UserState r0 = com.amazonaws.mobile.client.UserState.SIGNED_OUT
            r11.<init>(r0, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobile.client.AWSMobileClient.getUserStateDetails(boolean):com.amazonaws.mobile.client.UserStateDetails");
    }

    /* access modifiers changed from: package-private */
    public boolean isSignedOutRelatedException(Exception exc) {
        if (exc == null) {
            return false;
        }
        if (exc instanceof NotAuthorizedException) {
            return true;
        }
        return "No cached session.".equals(exc.getMessage()) && exc.getCause() == null;
    }

    /* access modifiers changed from: package-private */
    public boolean isFederationEnabled() {
        String str = this.mStore.get(FEDERATION_ENABLED_KEY);
        if (str != null) {
            return str.equals("true");
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public SignInMode getSignInMode() {
        return SignInMode.fromString(this.mStore.get(SIGN_IN_MODE));
    }

    private boolean hasFederatedToken(String str, String str2) {
        if (str2 == null || str2.isEmpty()) {
            return false;
        }
        boolean equals = str2.equals(this.mFederatedLoginsMap.get(str));
        String str3 = TAG;
        Log.d(str3, "hasFederatedToken: " + equals + " provider: " + str);
        return equals;
    }

    public void signIn(String str, String str2, Map<String, String> map, Callback<SignInResult> callback) {
        signIn(str, str2, map, Collections.emptyMap(), callback);
    }

    public void signIn(String str, String str2, Map<String, String> map, Map<String, String> map2, Callback<SignInResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_signIn(str, str2, map, map2, internalCallback));
    }

    public SignInResult signIn(String str, String str2, Map<String, String> map) throws Exception {
        return signIn(str, str2, map, (Map<String, String>) Collections.emptyMap());
    }

    public SignInResult signIn(String str, String str2, Map<String, String> map, Map<String, String> map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_signIn(str, str2, map, map2, internalCallback));
    }

    private Runnable _signIn(String str, String str2, Map<String, String> map, Map<String, String> map2, Callback<SignInResult> callback) {
        this.signInCallback = callback;
        this.signInState = null;
        this.mStore.set(SIGN_IN_MODE, SignInMode.SIGN_IN.toString());
        final String str3 = str;
        final Map<String, String> map3 = map2;
        final String str4 = str2;
        final Map<String, String> map4 = map;
        final Callback<SignInResult> callback2 = callback;
        return new Runnable() {
            public void run() {
                try {
                    AWSMobileClient.this.userpool.getUser(str3).getSession(map3, new AuthenticationHandler() {
                        public void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
                            UserStateDetails userStateDetails;
                            AWSMobileClient aWSMobileClient;
                            try {
                                AWSMobileClient.this.mCognitoUserSession = cognitoUserSession;
                                SignInState unused = AWSMobileClient.this.signInState = SignInState.DONE;
                            } catch (Exception e) {
                                AWSMobileClient.this.signInCallback.onError(e);
                                Callback unused2 = AWSMobileClient.this.signInCallback = null;
                            }
                            try {
                                if (AWSMobileClient.this.isFederationEnabled()) {
                                    AWSMobileClient.this.federatedSignInWithoutAssigningState(AWSMobileClient.this.userpoolsLoginKey, AWSMobileClient.this.mCognitoUserSession.getIdToken().getJWTToken());
                                }
                                AWSMobileClient.this.releaseSignInWait();
                                aWSMobileClient = AWSMobileClient.this;
                                userStateDetails = new UserStateDetails(UserState.SIGNED_IN, AWSMobileClient.this.getSignInDetailsMap());
                            } catch (Exception e2) {
                                Log.w(AWSMobileClient.TAG, "Failed to federate tokens during sign-in", e2);
                                aWSMobileClient = AWSMobileClient.this;
                                userStateDetails = new UserStateDetails(UserState.SIGNED_IN, AWSMobileClient.this.getSignInDetailsMap());
                            } catch (Throwable th) {
                                AWSMobileClient.this.setUserState(new UserStateDetails(UserState.SIGNED_IN, AWSMobileClient.this.getSignInDetailsMap()));
                                throw th;
                            }
                            aWSMobileClient.setUserState(userStateDetails);
                            AWSMobileClient.this.signInCallback.onResult(SignInResult.DONE);
                        }

                        public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String str) {
                            String str2;
                            Log.d(AWSMobileClient.TAG, "Sending password.");
                            HashMap hashMap = new HashMap();
                            boolean z = AWSMobileClient.this.awsConfiguration.optJsonObject(AWSMobileClient.AUTH_KEY) != null && AWSMobileClient.this.awsConfiguration.optJsonObject(AWSMobileClient.AUTH_KEY).has("authenticationFlowType");
                            if (z) {
                                try {
                                    str2 = AWSMobileClient.this.awsConfiguration.optJsonObject(AWSMobileClient.AUTH_KEY).getString("authenticationFlowType");
                                } catch (JSONException e) {
                                    Log.w(AWSMobileClient.TAG, "Exception while attempting to read authenticationFlowType from config.", e);
                                }
                            } else {
                                str2 = null;
                            }
                            if (!z || !CognitoServiceConstants.AUTH_TYPE_INIT_CUSTOM_AUTH.equals(str2)) {
                                if (!z || !CognitoServiceConstants.AUTH_TYPE_INIT_USER_PASSWORD.equals(str2)) {
                                    Log.d(AWSMobileClient.TAG, "Using USER_SRP_AUTH for flow type.");
                                    authenticationContinuation.setAuthenticationDetails(new AuthenticationDetails(str3, str4, (Map<String, String>) map4));
                                } else {
                                    AuthenticationDetails authenticationDetails = new AuthenticationDetails(str3, str4, (Map<String, String>) map4);
                                    authenticationDetails.setAuthenticationType(CognitoServiceConstants.CHLG_TYPE_USER_PASSWORD);
                                    authenticationContinuation.setAuthenticationDetails(authenticationDetails);
                                }
                                authenticationContinuation.continueTask();
                            }
                            if (str4 != null) {
                                authenticationContinuation.setAuthenticationDetails(new AuthenticationDetails(str3, str4, hashMap, map4));
                            } else {
                                authenticationContinuation.setAuthenticationDetails(new AuthenticationDetails(str3, (Map<String, String>) hashMap, (Map<String, String>) map4));
                            }
                            authenticationContinuation.continueTask();
                        }

                        public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
                            MultiFactorAuthenticationContinuation unused = AWSMobileClient.this.signInMfaContinuation = multiFactorAuthenticationContinuation;
                            CognitoUserCodeDeliveryDetails parameters = multiFactorAuthenticationContinuation.getParameters();
                            SignInState unused2 = AWSMobileClient.this.signInState = SignInState.SMS_MFA;
                            AWSMobileClient.this.signInCallback.onResult(new SignInResult(SignInState.SMS_MFA, new UserCodeDeliveryDetails(parameters.getDestination(), parameters.getDeliveryMedium(), parameters.getAttributeName())));
                        }

                        public void authenticationChallenge(ChallengeContinuation challengeContinuation) {
                            try {
                                SignInState unused = AWSMobileClient.this.signInState = SignInState.valueOf(challengeContinuation.getChallengeName());
                                ChallengeContinuation unused2 = AWSMobileClient.this.signInChallengeContinuation = challengeContinuation;
                                AWSMobileClient.this.signInCallback.onResult(new SignInResult(AWSMobileClient.this.signInState, (Map<String, String>) challengeContinuation.getParameters()));
                            } catch (IllegalArgumentException e) {
                                AWSMobileClient.this.signInCallback.onError(e);
                            }
                        }

                        public void onFailure(Exception exc) {
                            AWSMobileClient.this.signInCallback.onError(exc);
                        }
                    });
                } catch (Exception e) {
                    callback2.onError(e);
                }
            }
        };
    }

    public void confirmSignIn(String str, Callback<SignInResult> callback) {
        confirmSignIn(str, (Map<String, String>) Collections.emptyMap(), callback);
    }

    public void confirmSignIn(String str, Map<String, String> map, Callback<SignInResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignIn(str, map, Collections.emptyMap(), internalCallback));
    }

    public void confirmSignIn(String str, Map<String, String> map, Map<String, String> map2, Callback<SignInResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignIn(str, map, map2, internalCallback));
    }

    public SignInResult confirmSignIn(String str) throws Exception {
        return confirmSignIn(str, (Map<String, String>) Collections.emptyMap());
    }

    public SignInResult confirmSignIn(String str, Map<String, String> map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_confirmSignIn(str, map, Collections.emptyMap(), internalCallback));
    }

    public SignInResult confirmSignIn(String str, Map<String, String> map, Map<String, String> map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_confirmSignIn(str, map, map2, internalCallback));
    }

    private Runnable _confirmSignIn(String str, Map<String, String> map, Map<String, String> map2, Callback<SignInResult> callback) {
        final Callback<SignInResult> callback2 = callback;
        final String str2 = str;
        final Map<String, String> map3 = map;
        final Map<String, String> map4 = map2;
        return new Runnable() {
            public void run() {
                CognitoIdentityProviderContinuation cognitoIdentityProviderContinuation;
                if (AWSMobileClient.this.signInState == null) {
                    callback2.onError(new IllegalStateException("Cannot call confirmSignIn(String, Callback) without initiating sign-in. This call is used for SMS_MFA and NEW_PASSWORD_REQUIRED sign-in state."));
                    return;
                }
                int i = AnonymousClass28.$SwitchMap$com$amazonaws$mobile$client$results$SignInState[AWSMobileClient.this.signInState.ordinal()];
                if (i == 1) {
                    AWSMobileClient.this.signInMfaContinuation.setMfaCode(str2);
                    AWSMobileClient.this.signInMfaContinuation.setClientMetaData(map3);
                    cognitoIdentityProviderContinuation = AWSMobileClient.this.signInMfaContinuation;
                    Callback unused = AWSMobileClient.this.signInCallback = new InternalCallback(callback2);
                } else if (i == 2) {
                    ((NewPasswordContinuation) AWSMobileClient.this.signInChallengeContinuation).setPassword(str2);
                    AWSMobileClient.this.signInChallengeContinuation.setClientMetaData(map3);
                    for (String str : map4.keySet()) {
                        ChallengeContinuation access$800 = AWSMobileClient.this.signInChallengeContinuation;
                        access$800.setChallengeResponse("userAttributes." + str, (String) map4.get(str));
                    }
                    cognitoIdentityProviderContinuation = AWSMobileClient.this.signInChallengeContinuation;
                    Callback unused2 = AWSMobileClient.this.signInCallback = new InternalCallback(callback2);
                } else if (i == 3) {
                    AWSMobileClient.this.signInChallengeContinuation.setChallengeResponse(CognitoServiceConstants.CHLG_RESP_ANSWER, str2);
                    cognitoIdentityProviderContinuation = AWSMobileClient.this.signInChallengeContinuation;
                    Callback unused3 = AWSMobileClient.this.signInCallback = new InternalCallback(callback2);
                    if (map3 != null) {
                        AWSMobileClient.this.signInChallengeContinuation.setClientMetaData(map3);
                    }
                } else if (i != 4) {
                    callback2.onError(new IllegalStateException("confirmSignIn called on unsupported operation, please file a feature request"));
                    return;
                } else {
                    callback2.onError(new IllegalStateException("confirmSignIn called after signIn has succeeded"));
                    return;
                }
                if (cognitoIdentityProviderContinuation != null) {
                    cognitoIdentityProviderContinuation.continueTask();
                }
            }
        };
    }

    /* renamed from: com.amazonaws.mobile.client.AWSMobileClient$28  reason: invalid class name */
    static /* synthetic */ class AnonymousClass28 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$UserState;
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$results$SignInState;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|22|23|24|25|26|28) */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0062 */
        static {
            /*
                com.amazonaws.mobile.client.results.SignInState[] r0 = com.amazonaws.mobile.client.results.SignInState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$amazonaws$mobile$client$results$SignInState = r0
                r1 = 1
                com.amazonaws.mobile.client.results.SignInState r2 = com.amazonaws.mobile.client.results.SignInState.SMS_MFA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$amazonaws$mobile$client$results$SignInState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amazonaws.mobile.client.results.SignInState r3 = com.amazonaws.mobile.client.results.SignInState.NEW_PASSWORD_REQUIRED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$amazonaws$mobile$client$results$SignInState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.amazonaws.mobile.client.results.SignInState r4 = com.amazonaws.mobile.client.results.SignInState.CUSTOM_CHALLENGE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$com$amazonaws$mobile$client$results$SignInState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.amazonaws.mobile.client.results.SignInState r5 = com.amazonaws.mobile.client.results.SignInState.DONE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.amazonaws.mobile.client.UserState[] r4 = com.amazonaws.mobile.client.UserState.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$com$amazonaws$mobile$client$UserState = r4
                com.amazonaws.mobile.client.UserState r5 = com.amazonaws.mobile.client.UserState.SIGNED_IN     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                int[] r1 = $SwitchMap$com$amazonaws$mobile$client$UserState     // Catch:{ NoSuchFieldError -> 0x004e }
                com.amazonaws.mobile.client.UserState r4 = com.amazonaws.mobile.client.UserState.SIGNED_OUT_USER_POOLS_TOKENS_INVALID     // Catch:{ NoSuchFieldError -> 0x004e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r1[r4] = r0     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                int[] r0 = $SwitchMap$com$amazonaws$mobile$client$UserState     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.amazonaws.mobile.client.UserState r1 = com.amazonaws.mobile.client.UserState.SIGNED_OUT_FEDERATED_TOKENS_INVALID     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$com$amazonaws$mobile$client$UserState     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.amazonaws.mobile.client.UserState r1 = com.amazonaws.mobile.client.UserState.GUEST     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r0 = $SwitchMap$com$amazonaws$mobile$client$UserState     // Catch:{ NoSuchFieldError -> 0x006d }
                com.amazonaws.mobile.client.UserState r1 = com.amazonaws.mobile.client.UserState.SIGNED_OUT     // Catch:{ NoSuchFieldError -> 0x006d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobile.client.AWSMobileClient.AnonymousClass28.<clinit>():void");
        }
    }

    public void confirmSignIn(Map<String, String> map, Map<String, String> map2, Callback<SignInResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignIn(map, internalCallback, map2));
    }

    public SignInResult confirmSignIn(Map<String, String> map, Map<String, String> map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_confirmSignIn(map, internalCallback, map2));
    }

    public void confirmSignIn(Map<String, String> map, Callback<SignInResult> callback) {
        confirmSignIn(map, (Map<String, String>) null, callback);
    }

    public SignInResult confirmSignIn(Map<String, String> map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignInResult) internalCallback.await(_confirmSignIn(map, internalCallback, (Map<String, String>) null));
    }

    private Runnable _confirmSignIn(final Map<String, String> map, final Callback<SignInResult> callback, final Map<String, String> map2) {
        return new Runnable() {
            /* JADX WARNING: Removed duplicated region for block: B:26:0x00af  */
            /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r4 = this;
                    com.amazonaws.mobile.client.AWSMobileClient r0 = com.amazonaws.mobile.client.AWSMobileClient.this
                    com.amazonaws.mobile.client.results.SignInState r0 = r0.signInState
                    if (r0 != 0) goto L_0x0015
                    com.amazonaws.mobile.client.Callback r0 = r3
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "Cannot call confirmSignIn(Map<String, String>, Callback) without initiating sign-in. This call is used for CUSTOM_CHALLENGE sign-in state."
                    r1.<init>(r2)
                    r0.onError(r1)
                    return
                L_0x0015:
                    int[] r0 = com.amazonaws.mobile.client.AWSMobileClient.AnonymousClass28.$SwitchMap$com$amazonaws$mobile$client$results$SignInState
                    com.amazonaws.mobile.client.AWSMobileClient r1 = com.amazonaws.mobile.client.AWSMobileClient.this
                    com.amazonaws.mobile.client.results.SignInState r1 = r1.signInState
                    int r1 = r1.ordinal()
                    r0 = r0[r1]
                    r1 = 1
                    if (r0 == r1) goto L_0x004a
                    r1 = 2
                    if (r0 == r1) goto L_0x0056
                    r1 = 3
                    if (r0 == r1) goto L_0x0056
                    r1 = 4
                    if (r0 == r1) goto L_0x003c
                    com.amazonaws.mobile.client.Callback r0 = r3
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "confirmSignIn called on unsupported operation, please file a feature request"
                    r1.<init>(r2)
                    r0.onError(r1)
                    return
                L_0x003c:
                    r0 = 0
                    com.amazonaws.mobile.client.Callback r1 = r3
                    java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                    java.lang.String r3 = "confirmSignIn called after signIn has succeeded"
                    r2.<init>(r3)
                    r1.onError(r2)
                    goto L_0x00ad
                L_0x004a:
                    com.amazonaws.mobile.client.Callback r0 = r3
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "Please use confirmSignIn(String, Callback) for SMS_MFA challenges"
                    r1.<init>(r2)
                    r0.onError(r1)
                L_0x0056:
                    java.util.Map r0 = r2
                    java.util.Set r0 = r0.keySet()
                    java.util.Iterator r0 = r0.iterator()
                L_0x0060:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L_0x007e
                    java.lang.Object r1 = r0.next()
                    java.lang.String r1 = (java.lang.String) r1
                    com.amazonaws.mobile.client.AWSMobileClient r2 = com.amazonaws.mobile.client.AWSMobileClient.this
                    com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation r2 = r2.signInChallengeContinuation
                    java.util.Map r3 = r2
                    java.lang.Object r3 = r3.get(r1)
                    java.lang.String r3 = (java.lang.String) r3
                    r2.setChallengeResponse(r1, r3)
                    goto L_0x0060
                L_0x007e:
                    com.amazonaws.mobile.client.AWSMobileClient r0 = com.amazonaws.mobile.client.AWSMobileClient.this
                    com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation r0 = r0.signInChallengeContinuation
                    com.amazonaws.mobile.client.AWSMobileClient r1 = com.amazonaws.mobile.client.AWSMobileClient.this
                    com.amazonaws.mobile.client.internal.InternalCallback r2 = new com.amazonaws.mobile.client.internal.InternalCallback
                    com.amazonaws.mobile.client.Callback r3 = r3
                    r2.<init>(r3)
                    com.amazonaws.mobile.client.Callback unused = r1.signInCallback = r2
                    com.amazonaws.mobile.client.results.SignInState r1 = com.amazonaws.mobile.client.results.SignInState.CUSTOM_CHALLENGE
                    com.amazonaws.mobile.client.AWSMobileClient r2 = com.amazonaws.mobile.client.AWSMobileClient.this
                    com.amazonaws.mobile.client.results.SignInState r2 = r2.signInState
                    boolean r1 = r1.equals(r2)
                    if (r1 == 0) goto L_0x00ad
                    java.util.Map r1 = r4
                    if (r1 == 0) goto L_0x00ad
                    com.amazonaws.mobile.client.AWSMobileClient r1 = com.amazonaws.mobile.client.AWSMobileClient.this
                    com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation r1 = r1.signInChallengeContinuation
                    java.util.Map r2 = r4
                    r1.setClientMetaData(r2)
                L_0x00ad:
                    if (r0 == 0) goto L_0x00b2
                    r0.continueTask()
                L_0x00b2:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobile.client.AWSMobileClient.AnonymousClass8.run():void");
            }
        };
    }

    public void signOut() {
        String str = null;
        this.mCognitoUserSession = null;
        CognitoUserPool cognitoUserPool = this.userpool;
        if (cognitoUserPool != null) {
            cognitoUserPool.getCurrentUser().signOut();
            this.userpool.getUser().signOut();
        }
        CognitoCachingCredentialsProvider cognitoCachingCredentialsProvider = this.cognitoIdentity;
        if (cognitoCachingCredentialsProvider != null) {
            cognitoCachingCredentialsProvider.clear();
        }
        if (IdentityManager.getDefaultIdentityManager() != null) {
            IdentityManager.getDefaultIdentityManager().signOut();
        }
        this.mFederatedLoginsMap.clear();
        this.mStore.clear();
        if (this.awsConfiguration.optJsonObject(AUTH_KEY) != null && this.awsConfiguration.optJsonObject(AUTH_KEY).has("OAuth")) {
            try {
                JSONObject jSONObject = this.awsConfiguration.optJsonObject(AUTH_KEY).getJSONObject("OAuth");
                str = !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Auth auth = this.hostedUI;
            if (auth != null) {
                auth.signOut(true);
            }
            OAuth2Client oAuth2Client = this.mOAuth2Client;
            if (oAuth2Client != null) {
                oAuth2Client.signOut();
            }
        }
        this.mStore.set(HOSTED_UI_KEY, str);
        setUserState(getUserStateDetails(false));
        releaseSignInWait();
    }

    public void signOut(SignOutOptions signOutOptions) throws Exception {
        _signOut(signOutOptions).await();
    }

    public void signOut(SignOutOptions signOutOptions, Callback<Void> callback) {
        _signOut(signOutOptions).async(callback);
    }

    private ReturningRunnable<Void> _signOut(final SignOutOptions signOutOptions) {
        return new ReturningRunnable<Void>() {
            public Void run() throws Exception {
                if (signOutOptions.isSignOutGlobally()) {
                    GlobalSignOutRequest globalSignOutRequest = new GlobalSignOutRequest();
                    globalSignOutRequest.setAccessToken(AWSMobileClient.this.getTokens().getAccessToken().getTokenString());
                    AWSMobileClient.this.userpoolLL.globalSignOut(globalSignOutRequest);
                }
                if (signOutOptions.isInvalidateTokens()) {
                    if (AWSMobileClient.this.userpool != null) {
                        AWSMobileClient.this.userpool.getCurrentUser().revokeTokens();
                    }
                    if (AWSMobileClient.this.hostedUI != null) {
                        if (signOutOptions.getBrowserPackage() != null) {
                            AWSMobileClient.this.hostedUI.setBrowserPackage(signOutOptions.getBrowserPackage());
                        }
                        AWSMobileClient.this.hostedUI.signOut();
                    } else if (AWSMobileClient.this.mOAuth2Client != null) {
                        final CountDownLatch countDownLatch = new CountDownLatch(1);
                        JSONObject hostedUIJSON = AWSMobileClient.this.getHostedUIJSON();
                        Uri.Builder buildUpon = Uri.parse(hostedUIJSON.getString("SignOutURI")).buildUpon();
                        if (AWSMobileClient.this.getHostedUIJSON().optString("SignOutRedirectURI", (String) null) != null) {
                            buildUpon.appendQueryParameter("redirect_uri", AWSMobileClient.this.getHostedUIJSON().getString("SignOutRedirectURI"));
                        }
                        JSONObject jSONObject = hostedUIJSON.getJSONObject("SignOutQueryParameters");
                        if (jSONObject != null) {
                            Iterator<String> keys = jSONObject.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                buildUpon.appendQueryParameter(next, jSONObject.getString(next));
                            }
                        }
                        final Exception[] excArr = new Exception[1];
                        AWSMobileClient.this.mOAuth2Client.signOut(buildUpon.build(), new Callback<Void>() {
                            public void onResult(Void voidR) {
                                countDownLatch.countDown();
                            }

                            public void onError(Exception exc) {
                                excArr[0] = exc;
                                countDownLatch.countDown();
                            }
                        });
                        countDownLatch.await();
                        if (excArr[0] != null) {
                            throw excArr[0];
                        }
                    }
                }
                AWSMobileClient.this.signOut();
                return null;
            }
        };
    }

    public void federatedSignIn(String str, String str2, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_federatedSignIn(str, str2, (FederatedSignInOptions) null, internalCallback, true));
    }

    public UserStateDetails federatedSignIn(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_federatedSignIn(str, str2, (FederatedSignInOptions) null, internalCallback, true));
    }

    public void federatedSignIn(String str, String str2, FederatedSignInOptions federatedSignInOptions, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_federatedSignIn(str, str2, federatedSignInOptions, internalCallback, true));
    }

    public UserStateDetails federatedSignIn(String str, String str2, FederatedSignInOptions federatedSignInOptions) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_federatedSignIn(str, str2, federatedSignInOptions, internalCallback, true));
    }

    /* access modifiers changed from: protected */
    public void federatedSignInWithoutAssigningState(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_federatedSignIn(str, str2, (FederatedSignInOptions) null, internalCallback, false));
    }

    /* access modifiers changed from: protected */
    public void federatedSignInWithoutAssigningState(String str, String str2, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_federatedSignIn(str, str2, (FederatedSignInOptions) null, internalCallback, false));
    }

    private Runnable _federatedSignIn(String str, String str2, FederatedSignInOptions federatedSignInOptions, Callback<UserStateDetails> callback, boolean z) {
        final HashMap hashMap = new HashMap();
        this.mStore.set(SIGN_IN_MODE, SignInMode.FEDERATED_SIGN_IN.toString());
        try {
            hashMap.put(str, str2);
            Log.d(TAG, String.format("_federatedSignIn: Putting provider and token in store", new Object[0]));
            HashMap hashMap2 = new HashMap();
            hashMap2.put(PROVIDER_KEY, str);
            hashMap2.put(TOKEN_KEY, str2);
            hashMap2.put(FEDERATION_ENABLED_KEY, "true");
            if (IdentityProvider.DEVELOPER.equals(str)) {
                if (federatedSignInOptions == null) {
                    callback.onError(new Exception("Developer authenticated identities require theidentity id to be specified in FederatedSignInOptions"));
                }
                hashMap2.put(IDENTITY_ID_KEY, federatedSignInOptions.getCognitoIdentityId());
            }
            if (federatedSignInOptions != null && !StringUtils.isBlank(federatedSignInOptions.getCustomRoleARN())) {
                hashMap2.put(CUSTOM_ROLE_ARN_KEY, federatedSignInOptions.getCustomRoleARN());
            }
            this.mStore.set(hashMap2);
        } catch (Exception e) {
            callback.onError(e);
        }
        final Callback<UserStateDetails> callback2 = callback;
        final String str3 = str2;
        final String str4 = str;
        final boolean z2 = z;
        return new Runnable() {
            public void run() {
                try {
                    if (AWSMobileClient.this.cognitoIdentity == null) {
                        callback2.onError(new Exception("Federation is not enabled, please check if you have CognitoIdentity configured."));
                        return;
                    }
                    if (!str3.equals(AWSMobileClient.this.mFederatedLoginsMap.get(str4))) {
                        AWSMobileClient.this.cognitoIdentity.clear();
                        AWSMobileClient.this.cognitoIdentity.setLogins(hashMap);
                    }
                    UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(true);
                    AWSMobileClient.this.federateWithCognitoIdentity(str4, str3);
                    callback2.onResult(userStateDetails);
                    end(userStateDetails);
                } catch (Exception e) {
                    HashMap hashMap = new HashMap();
                    hashMap.put(AWSMobileClient.PROVIDER_KEY, (Object) null);
                    hashMap.put(AWSMobileClient.TOKEN_KEY, (Object) null);
                    hashMap.put(AWSMobileClient.FEDERATION_ENABLED_KEY, (Object) null);
                    hashMap.put(AWSMobileClient.IDENTITY_ID_KEY, (Object) null);
                    hashMap.put(AWSMobileClient.CUSTOM_ROLE_ARN_KEY, (Object) null);
                    AWSMobileClient.this.mStore.set(hashMap);
                    callback2.onError(new RuntimeException("Error in federating the token.", e));
                }
            }

            private void end(UserStateDetails userStateDetails) {
                if (z2) {
                    AWSMobileClient.this.setUserState(userStateDetails);
                }
            }
        };
    }

    /* access modifiers changed from: protected */
    public void federateWithCognitoIdentity(String str, String str2) {
        synchronized (this.federateWithCognitoIdentityLockObject) {
            if (!hasFederatedToken(str, str2)) {
                if (IdentityProvider.DEVELOPER.equals(str)) {
                    this.provider.setDeveloperAuthenticated(this.mStore.get(IDENTITY_ID_KEY), str2);
                } else {
                    this.provider.setNotDeveloperAuthenticated();
                }
                String str3 = this.mStore.get(CUSTOM_ROLE_ARN_KEY);
                if (!StringUtils.isBlank(str3)) {
                    this.cognitoIdentity.setCustomRoleArn(str3);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(str, str2);
                this.cognitoIdentity.setLogins(hashMap);
                this.cognitoIdentity.refresh();
                this.mStore.set(IDENTITY_ID_KEY, this.cognitoIdentity.getIdentityId());
                this.mFederatedLoginsMap = this.cognitoIdentity.getLogins();
            }
        }
    }

    public Tokens getTokens() throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (Tokens) internalCallback.await(_getTokens(internalCallback, false));
    }

    public void getTokens(Callback<Tokens> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_getTokens(internalCallback, false));
    }

    /* access modifiers changed from: protected */
    public Tokens getTokens(boolean z) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (Tokens) internalCallback.await(_getTokens(internalCallback, z));
    }

    private Runnable _getTokens(final Callback<Tokens> callback, final boolean z) {
        return new Runnable() {
            public void run() {
                String str = AWSMobileClient.this.getSignInDetailsMap().get(AWSMobileClient.PROVIDER_KEY);
                if (str != null && !AWSMobileClient.this.userpoolsLoginKey.equals(str)) {
                    callback.onError(new Exception("getTokens does not support retrieving tokens for federated sign-in"));
                } else if (!z || AWSMobileClient.this.waitForSignIn()) {
                    if (!AWSMobileClient.this.isUserpoolsSignedIn()) {
                        callback.onError(new Exception("You must be signed-in with Cognito Userpools to be able to use getTokens"));
                    }
                    if (AWSMobileClient.this.getSignInMode().equals(SignInMode.HOSTED_UI)) {
                        AWSMobileClient.this._getHostedUITokens(callback);
                    } else if (AWSMobileClient.this.getSignInMode().equals(SignInMode.OAUTH2)) {
                        callback.onError(new Exception("Tokens are not supported for OAuth2"));
                    } else {
                        try {
                            AWSMobileClient.this.userpool.getCurrentUser().getSession(Collections.emptyMap(), new AuthenticationHandler() {
                                public void onSuccess(CognitoUserSession cognitoUserSession, CognitoDevice cognitoDevice) {
                                    try {
                                        AWSMobileClient.this.mCognitoUserSession = cognitoUserSession;
                                        callback.onResult(new Tokens(cognitoUserSession.getAccessToken().getJWTToken(), cognitoUserSession.getIdToken().getJWTToken(), cognitoUserSession.getRefreshToken().getToken()));
                                    } catch (Exception e) {
                                        callback.onError(e);
                                    }
                                }

                                public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String str) {
                                    signalTokensNotAvailable((Exception) null);
                                }

                                public void getMFACode(MultiFactorAuthenticationContinuation multiFactorAuthenticationContinuation) {
                                    signalTokensNotAvailable((Exception) null);
                                }

                                public void authenticationChallenge(ChallengeContinuation challengeContinuation) {
                                    signalTokensNotAvailable((Exception) null);
                                }

                                public void onFailure(Exception exc) {
                                    signalTokensNotAvailable(exc);
                                }

                                private void signalTokensNotAvailable(Exception exc) {
                                    Log.w(AWSMobileClient.TAG, "signalTokensNotAvailable");
                                    callback.onError(new Exception("No cached session.", exc));
                                }
                            });
                        } catch (Exception e) {
                            callback.onError(e);
                        }
                    }
                } else {
                    callback.onError(new Exception("getTokens does not support retrieving tokens while signed-out"));
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void _getHostedUITokens(final Callback<Tokens> callback) {
        Auth currentUser = this.hostedUI.getCurrentUser();
        this.hostedUI = currentUser;
        currentUser.setAuthHandler(new AuthHandler() {
            public void onSuccess(AuthUserSession authUserSession) {
                callback.onResult(new Tokens(authUserSession.getAccessToken().getJWTToken(), authUserSession.getIdToken().getJWTToken(), authUserSession.getRefreshToken().getToken()));
            }

            public void onSignout() {
                callback.onError(new Exception("No cached session."));
            }

            public void onFailure(Exception exc) {
                callback.onError(new Exception("No cached session.", exc));
            }
        });
        this.hostedUI.getSessionWithoutWebUI();
    }

    public void signUp(String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Callback<SignUpResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_signUp(str, str2, map, map2, map3, internalCallback));
    }

    public SignUpResult signUp(String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignUpResult) internalCallback.await(_signUp(str, str2, map, map3, map2, internalCallback));
    }

    public void signUp(String str, String str2, Map<String, String> map, Map<String, String> map2, Callback<SignUpResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_signUp(str, str2, map, map2, Collections.emptyMap(), internalCallback));
    }

    public SignUpResult signUp(String str, String str2, Map<String, String> map, Map<String, String> map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignUpResult) internalCallback.await(_signUp(str, str2, map, map2, Collections.emptyMap(), internalCallback));
    }

    private Runnable _signUp(String str, String str2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Callback<SignUpResult> callback) {
        final Map<String, String> map4 = map;
        final String str3 = str;
        final String str4 = str2;
        final Map<String, String> map5 = map2;
        final Map<String, String> map6 = map3;
        final Callback<SignUpResult> callback2 = callback;
        return new Runnable() {
            public void run() {
                CognitoUserAttributes cognitoUserAttributes = new CognitoUserAttributes();
                for (String str : map4.keySet()) {
                    cognitoUserAttributes.addAttribute(str, (String) map4.get(str));
                }
                AWSMobileClient.this.userpool.signUp(str3, str4, cognitoUserAttributes, map5, map6, new SignUpHandler() {
                    public void onSuccess(CognitoUser cognitoUser, com.amazonaws.services.cognitoidentityprovider.model.SignUpResult signUpResult) {
                        CognitoUser unused = AWSMobileClient.this.signUpUser = cognitoUser;
                        if (signUpResult == null) {
                            callback2.onError(new Exception("SignUpResult received is null"));
                        } else if (signUpResult.getCodeDeliveryDetails() == null) {
                            callback2.onResult(new SignUpResult(signUpResult.getUserConfirmed().booleanValue(), (UserCodeDeliveryDetails) null, signUpResult.getUserSub()));
                        } else {
                            callback2.onResult(new SignUpResult(signUpResult.getUserConfirmed().booleanValue(), new UserCodeDeliveryDetails(signUpResult.getCodeDeliveryDetails().getDestination(), signUpResult.getCodeDeliveryDetails().getDeliveryMedium(), signUpResult.getCodeDeliveryDetails().getAttributeName()), signUpResult.getUserSub()));
                        }
                    }

                    public void onFailure(Exception exc) {
                        callback2.onError(exc);
                    }
                });
            }
        };
    }

    public void confirmSignUp(String str, String str2, Map<String, String> map, Callback<SignUpResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignUp(str, str2, map, internalCallback));
    }

    public SignUpResult confirmSignUp(String str, String str2, Map<String, String> map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignUpResult) internalCallback.await(_confirmSignUp(str, str2, map, internalCallback));
    }

    public void confirmSignUp(String str, String str2, Callback<SignUpResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmSignUp(str, str2, Collections.emptyMap(), internalCallback));
    }

    public SignUpResult confirmSignUp(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignUpResult) internalCallback.await(_confirmSignUp(str, str2, Collections.emptyMap(), internalCallback));
    }

    private Runnable _confirmSignUp(String str, String str2, Map<String, String> map, Callback<SignUpResult> callback) {
        final String str3 = str;
        final String str4 = str2;
        final Map<String, String> map2 = map;
        final Callback<SignUpResult> callback2 = callback;
        return new Runnable() {
            public void run() {
                AWSMobileClient.this.userpool.getUser(str3).confirmSignUp(str4, false, map2, new GenericHandler() {
                    public void onSuccess() {
                        callback2.onResult(new SignUpResult(true, (UserCodeDeliveryDetails) null, (String) null));
                        CognitoUser unused = AWSMobileClient.this.signUpUser = null;
                    }

                    public void onFailure(Exception exc) {
                        callback2.onError(exc);
                    }
                });
            }
        };
    }

    public void resendSignUp(String str, Callback<SignUpResult> callback) {
        resendSignUp(str, Collections.emptyMap(), callback);
    }

    public void resendSignUp(String str, Map<String, String> map, Callback<SignUpResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_resendSignUp(str, map, internalCallback));
    }

    public SignUpResult resendSignUp(String str) throws Exception {
        return resendSignUp(str, (Map<String, String>) Collections.emptyMap());
    }

    public SignUpResult resendSignUp(String str, Map<String, String> map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (SignUpResult) internalCallback.await(_resendSignUp(str, map, internalCallback));
    }

    private Runnable _resendSignUp(final String str, final Map<String, String> map, final Callback<SignUpResult> callback) {
        return new Runnable() {
            public void run() {
                AWSMobileClient.this.userpool.getUser(str).resendConfirmationCodeInBackground(map, new VerificationHandler() {
                    public void onSuccess(CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
                        callback.onResult(new SignUpResult(false, new UserCodeDeliveryDetails(cognitoUserCodeDeliveryDetails.getDestination(), cognitoUserCodeDeliveryDetails.getDeliveryMedium(), cognitoUserCodeDeliveryDetails.getAttributeName()), (String) null));
                    }

                    public void onFailure(Exception exc) {
                        callback.onError(exc);
                    }
                });
            }
        };
    }

    public void forgotPassword(String str, Map<String, String> map, Callback<ForgotPasswordResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_forgotPassword(str, map, internalCallback));
    }

    public ForgotPasswordResult forgotPassword(String str, Map<String, String> map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_forgotPassword(str, map, internalCallback));
    }

    public void forgotPassword(String str, Callback<ForgotPasswordResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_forgotPassword(str, Collections.emptyMap(), internalCallback));
    }

    public ForgotPasswordResult forgotPassword(String str) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_forgotPassword(str, Collections.emptyMap(), internalCallback));
    }

    private Runnable _forgotPassword(final String str, final Map<String, String> map, final Callback<ForgotPasswordResult> callback) {
        return new Runnable() {
            public void run() {
                Callback unused = AWSMobileClient.this.forgotPasswordCallback = new InternalCallback(callback);
                AWSMobileClient.this.userpool.getUser(str).forgotPasswordInBackground(map, new ForgotPasswordHandler() {
                    public void onSuccess() {
                        AWSMobileClient.this.forgotPasswordCallback.onResult(new ForgotPasswordResult(ForgotPasswordState.DONE));
                    }

                    public void getResetCode(ForgotPasswordContinuation forgotPasswordContinuation) {
                        ForgotPasswordContinuation unused = AWSMobileClient.this.forgotPasswordContinuation = forgotPasswordContinuation;
                        ForgotPasswordResult forgotPasswordResult = new ForgotPasswordResult(ForgotPasswordState.CONFIRMATION_CODE);
                        CognitoUserCodeDeliveryDetails parameters = forgotPasswordContinuation.getParameters();
                        forgotPasswordResult.setParameters(new UserCodeDeliveryDetails(parameters.getDestination(), parameters.getDeliveryMedium(), parameters.getAttributeName()));
                        AWSMobileClient.this.forgotPasswordCallback.onResult(forgotPasswordResult);
                    }

                    public void onFailure(Exception exc) {
                        AWSMobileClient.this.forgotPasswordCallback.onError(exc);
                    }
                });
            }
        };
    }

    public void confirmForgotPassword(String str, String str2, Map<String, String> map, Callback<ForgotPasswordResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmForgotPassword(str, str2, map, internalCallback));
    }

    public ForgotPasswordResult confirmForgotPassword(String str, Map<String, String> map, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_confirmForgotPassword(str, str2, map, internalCallback));
    }

    @Deprecated
    public void confirmForgotPassword(String str, String str2, Callback<ForgotPasswordResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmForgotPassword(str, str2, Collections.emptyMap(), internalCallback));
    }

    public void confirmForgotPassword(String str, String str2, String str3, final Callback<ForgotPasswordResult> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        this.forgotPasswordContinuation = new ForgotPasswordContinuation(this.userpool.getUser(str), (CognitoUserCodeDeliveryDetails) null, true, new ForgotPasswordHandler() {
            public void onSuccess() {
                callback.onResult(new ForgotPasswordResult(ForgotPasswordState.DONE));
            }

            public void getResetCode(ForgotPasswordContinuation forgotPasswordContinuation) {
                callback.onResult(new ForgotPasswordResult(ForgotPasswordState.CONFIRMATION_CODE));
            }

            public void onFailure(Exception exc) {
                callback.onError(exc);
            }
        });
        internalCallback.async(_confirmForgotPassword(str2, str3, Collections.emptyMap(), internalCallback));
    }

    public ForgotPasswordResult confirmForgotPassword(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (ForgotPasswordResult) internalCallback.await(_confirmForgotPassword(str, str2, Collections.emptyMap(), internalCallback));
    }

    private Runnable _confirmForgotPassword(String str, String str2, Map<String, String> map, Callback<ForgotPasswordResult> callback) {
        final Callback<ForgotPasswordResult> callback2 = callback;
        final String str3 = str;
        final String str4 = str2;
        final Map<String, String> map2 = map;
        return new Runnable() {
            public void run() {
                if (AWSMobileClient.this.forgotPasswordContinuation == null) {
                    callback2.onError(new IllegalStateException("confirmForgotPassword called before initiating forgotPassword"));
                    return;
                }
                AWSMobileClient.this.forgotPasswordContinuation.setPassword(str3);
                AWSMobileClient.this.forgotPasswordContinuation.setVerificationCode(str4);
                AWSMobileClient.this.forgotPasswordContinuation.setClientMetadata(map2);
                Callback unused = AWSMobileClient.this.forgotPasswordCallback = new InternalCallback(callback2);
                AWSMobileClient.this.forgotPasswordContinuation.continueTask();
            }
        };
    }

    public void changePassword(String str, String str2, Callback<Void> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_changePassword(str, str2, internalCallback));
    }

    public void changePassword(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_changePassword(str, str2, internalCallback));
    }

    private Runnable _changePassword(final String str, final String str2, final Callback<Void> callback) {
        return new Runnable() {
            public void run() {
                AWSMobileClient.this.userpool.getCurrentUser().changePassword(str, str2, new GenericHandler() {
                    public void onSuccess() {
                        callback.onResult(null);
                    }

                    public void onFailure(Exception exc) {
                        callback.onError(exc);
                    }
                });
            }
        };
    }

    public void getUserAttributes(Callback<Map<String, String>> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_getUserAttributes(internalCallback));
    }

    public Map<String, String> getUserAttributes() throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (Map) internalCallback.await(_getUserAttributes(internalCallback));
    }

    private Runnable _getUserAttributes(final Callback<Map<String, String>> callback) {
        return new Runnable() {
            public void run() {
                if (!AWSMobileClient.this.waitForSignIn()) {
                    callback.onError(new Exception("Operation requires a signed-in state"));
                } else {
                    AWSMobileClient.this.userpool.getCurrentUser().getDetails(new GetDetailsHandler() {
                        public void onSuccess(CognitoUserDetails cognitoUserDetails) {
                            callback.onResult(cognitoUserDetails.getAttributes().getAttributes());
                        }

                        public void onFailure(Exception exc) {
                            callback.onError(exc);
                        }
                    });
                }
            }
        };
    }

    public void updateUserAttributes(Map<String, String> map, Callback<List<UserCodeDeliveryDetails>> callback) {
        updateUserAttributes(map, Collections.emptyMap(), callback);
    }

    public void updateUserAttributes(Map<String, String> map, Map<String, String> map2, Callback<List<UserCodeDeliveryDetails>> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_updateUserAttributes(map, map2, internalCallback));
    }

    public List<UserCodeDeliveryDetails> updateUserAttributes(Map<String, String> map) throws Exception {
        return updateUserAttributes(map, (Map<String, String>) Collections.emptyMap());
    }

    public List<UserCodeDeliveryDetails> updateUserAttributes(Map<String, String> map, Map<String, String> map2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (List) internalCallback.await(_updateUserAttributes(map, map2, internalCallback));
    }

    private Runnable _updateUserAttributes(final Map<String, String> map, final Map<String, String> map2, final Callback<List<UserCodeDeliveryDetails>> callback) {
        return new Runnable() {
            public void run() {
                if (!AWSMobileClient.this.waitForSignIn()) {
                    callback.onError(new Exception("Operation requires a signed-in state"));
                    return;
                }
                CognitoUserAttributes cognitoUserAttributes = new CognitoUserAttributes();
                Map map = map;
                if (map != null) {
                    for (String str : map.keySet()) {
                        cognitoUserAttributes.addAttribute(str, (String) map.get(str));
                    }
                }
                AWSMobileClient.this.userpool.getCurrentUser().updateAttributes(cognitoUserAttributes, map2, new UpdateAttributesHandler() {
                    public void onSuccess(List<CognitoUserCodeDeliveryDetails> list) {
                        LinkedList linkedList = new LinkedList();
                        for (CognitoUserCodeDeliveryDetails next : list) {
                            linkedList.add(new UserCodeDeliveryDetails(next.getDestination(), next.getDeliveryMedium(), next.getAttributeName()));
                        }
                        callback.onResult(linkedList);
                    }

                    public void onFailure(Exception exc) {
                        callback.onError(exc);
                    }
                });
            }
        };
    }

    public void verifyUserAttribute(String str, Callback<UserCodeDeliveryDetails> callback) {
        verifyUserAttribute(str, Collections.emptyMap(), callback);
    }

    public void verifyUserAttribute(String str, Map<String, String> map, Callback<UserCodeDeliveryDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_verifyUserAttribute(str, map, internalCallback));
    }

    public UserCodeDeliveryDetails verifyUserAttribute(String str) throws Exception {
        return verifyUserAttribute(str, (Map<String, String>) Collections.emptyMap());
    }

    public UserCodeDeliveryDetails verifyUserAttribute(String str, Map<String, String> map) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserCodeDeliveryDetails) internalCallback.await(_verifyUserAttribute(str, map, internalCallback));
    }

    private Runnable _verifyUserAttribute(final String str, final Map<String, String> map, final Callback<UserCodeDeliveryDetails> callback) {
        return new Runnable() {
            public void run() {
                if (!AWSMobileClient.this.waitForSignIn()) {
                    callback.onError(new Exception("Operation requires a signed-in state"));
                } else {
                    AWSMobileClient.this.userpool.getCurrentUser().getAttributeVerificationCodeInBackground(map, str, new VerificationHandler() {
                        public void onSuccess(CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {
                            callback.onResult(new UserCodeDeliveryDetails(cognitoUserCodeDeliveryDetails.getDestination(), cognitoUserCodeDeliveryDetails.getDeliveryMedium(), cognitoUserCodeDeliveryDetails.getAttributeName()));
                        }

                        public void onFailure(Exception exc) {
                            callback.onError(exc);
                        }
                    });
                }
            }
        };
    }

    public void confirmUpdateUserAttribute(String str, String str2, Callback<Void> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmUserAttribute(str, str2, internalCallback));
    }

    public void confirmUpdateUserAttribute(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_confirmUserAttribute(str, str2, internalCallback));
    }

    public void confirmVerifyUserAttribute(String str, String str2, Callback<Void> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_confirmUserAttribute(str, str2, internalCallback));
    }

    public void confirmVerifyUserAttribute(String str, String str2) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        internalCallback.await(_confirmUserAttribute(str, str2, internalCallback));
    }

    private Runnable _confirmUserAttribute(final String str, final String str2, final Callback<Void> callback) {
        return new Runnable() {
            public void run() {
                if (!AWSMobileClient.this.waitForSignIn()) {
                    callback.onError(new Exception("Operation requires a signed-in state"));
                } else {
                    AWSMobileClient.this.userpool.getCurrentUser().verifyAttribute(str, str2, new GenericHandler() {
                        public void onSuccess() {
                            callback.onResult(null);
                        }

                        public void onFailure(Exception exc) {
                            callback.onError(exc);
                        }
                    });
                }
            }
        };
    }

    public boolean handleAuthResponse(Intent intent) {
        Auth auth = this.hostedUI;
        if (auth != null) {
            if (intent != null) {
                auth.getTokens(intent.getData());
            } else {
                auth.handleFlowCancelled();
            }
            return true;
        }
        OAuth2Client oAuth2Client = this.mOAuth2Client;
        if (oAuth2Client == null || intent == null || !oAuth2Client.handleRedirect(intent.getData())) {
            return false;
        }
        return true;
    }

    public void showSignIn(Activity activity, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_showSignIn(activity, SignInUIOptions.builder().build(), internalCallback));
    }

    public UserStateDetails showSignIn(Activity activity) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_showSignIn(activity, SignInUIOptions.builder().build(), internalCallback));
    }

    public void showSignIn(Activity activity, SignInUIOptions signInUIOptions, Callback<UserStateDetails> callback) {
        InternalCallback internalCallback = new InternalCallback(callback);
        internalCallback.async(_showSignIn(activity, signInUIOptions, internalCallback));
    }

    public UserStateDetails showSignIn(Activity activity, SignInUIOptions signInUIOptions) throws Exception {
        InternalCallback internalCallback = new InternalCallback();
        return (UserStateDetails) internalCallback.await(_showSignIn(activity, signInUIOptions, internalCallback));
    }

    private Runnable _showSignIn(Activity activity, SignInUIOptions signInUIOptions, final Callback<UserStateDetails> callback) {
        if (signInUIOptions.getHostedUIOptions() == null) {
            return _showSignInDropInUI(activity, signInUIOptions, callback);
        }
        JSONObject hostedUIJSON = getHostedUIJSON();
        if (hostedUIJSON == null) {
            return new Runnable() {
                public void run() {
                    callback.onError(new Exception("showSignIn called with HostedUI options in awsconfiguration.json"));
                }
            };
        }
        if (hostedUIJSON.optString("TokenURI", (String) null) != null) {
            return _showSignInOAuth2UI(activity, signInUIOptions, callback);
        }
        return _showSignInHostedUI(activity, signInUIOptions, callback);
    }

    private Runnable _showSignInOAuth2UI(Activity activity, final SignInUIOptions signInUIOptions, final Callback<UserStateDetails> callback) {
        return new Runnable() {
            public void run() {
                final HostedUIOptions hostedUIOptions = signInUIOptions.getHostedUIOptions();
                JSONObject hostedUIJSONFromJSON = AWSMobileClient.this.getHostedUIJSONFromJSON();
                if (hostedUIJSONFromJSON == null) {
                    callback.onError(new Exception("Could not create OAuth configuration object"));
                }
                String str = "true";
                if (hostedUIOptions.getFederationEnabled() != null) {
                    KeyValueStore keyValueStore = AWSMobileClient.this.mStore;
                    if (!hostedUIOptions.getFederationEnabled().booleanValue()) {
                        str = "false";
                    }
                    keyValueStore.set(AWSMobileClient.FEDERATION_ENABLED_KEY, str);
                } else {
                    AWSMobileClient.this.mStore.set(AWSMobileClient.FEDERATION_ENABLED_KEY, str);
                }
                AWSMobileClient.this.mStore.set(AWSMobileClient.SIGN_IN_MODE, SignInMode.OAUTH2.toString());
                if (!AWSMobileClient.this.isFederationEnabled() || hostedUIOptions.getFederationProviderName() != null) {
                    if (hostedUIOptions.getSignOutQueryParameters() != null) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            for (Map.Entry next : hostedUIOptions.getSignOutQueryParameters().entrySet()) {
                                jSONObject.put((String) next.getKey(), next.getValue());
                            }
                            hostedUIJSONFromJSON.put("SignOutQueryParameters", jSONObject);
                        } catch (JSONException e) {
                            callback.onError(new Exception("Failed to construct sign-out query parameters", e));
                            return;
                        }
                    }
                    if (hostedUIOptions.getTokenQueryParameters() != null) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            for (Map.Entry next2 : hostedUIOptions.getTokenQueryParameters().entrySet()) {
                                jSONObject2.put((String) next2.getKey(), next2.getValue());
                            }
                            hostedUIJSONFromJSON.put("TokenQueryParameters", jSONObject2);
                        } catch (JSONException e2) {
                            callback.onError(new Exception("Failed to construct token query parameters", e2));
                            return;
                        }
                    }
                    AWSMobileClient.this.mStore.set(AWSMobileClient.HOSTED_UI_KEY, !(hostedUIJSONFromJSON instanceof JSONObject) ? hostedUIJSONFromJSON.toString() : JSONObjectInstrumentation.toString(hostedUIJSONFromJSON));
                    try {
                        Uri.Builder buildUpon = Uri.parse(hostedUIJSONFromJSON.getString("SignInURI")).buildUpon();
                        if (hostedUIOptions.getSignInQueryParameters() != null) {
                            for (Map.Entry next3 : hostedUIOptions.getSignInQueryParameters().entrySet()) {
                                buildUpon.appendQueryParameter((String) next3.getKey(), (String) next3.getValue());
                            }
                        }
                        buildUpon.appendQueryParameter("redirect_uri", hostedUIJSONFromJSON.getString("SignInRedirectURI"));
                        buildUpon.appendQueryParameter(OAuth2Constants.SCOPES, hostedUIJSONFromJSON.getJSONArray("Scopes").join(" "));
                        buildUpon.appendQueryParameter("client_id", hostedUIJSONFromJSON.getString("AppClientId"));
                        final HashMap hashMap = new HashMap();
                        try {
                            Uri.Builder buildUpon2 = Uri.parse(hostedUIJSONFromJSON.getString("TokenURI")).buildUpon();
                            if (hostedUIOptions.getTokenQueryParameters() != null) {
                                for (Map.Entry next4 : hostedUIOptions.getTokenQueryParameters().entrySet()) {
                                    buildUpon2.appendQueryParameter((String) next4.getKey(), (String) next4.getValue());
                                }
                            }
                            hashMap.put("client_id", hostedUIJSONFromJSON.getString("AppClientId"));
                            hashMap.put("redirect_uri", hostedUIJSONFromJSON.getString("SignInRedirectURI"));
                            final Uri build = buildUpon2.build();
                            AWSMobileClient.this.mOAuth2Client.authorize(buildUpon.build(), new Callback<AuthorizeResponse>() {
                                public void onResult(AuthorizeResponse authorizeResponse) {
                                    Log.i(AWSMobileClient.TAG, "onResult: OAuth2 callback occurred, exchanging code for token");
                                    AWSMobileClient.this.mOAuth2Client.requestTokens(build, new HashMap(), hashMap, authorizeResponse.getCode(), new Callback<OAuth2Tokens>() {
                                        public void onResult(OAuth2Tokens oAuth2Tokens) {
                                            if (AWSMobileClient.this.isFederationEnabled()) {
                                                AWSMobileClient.this.federatedSignInWithoutAssigningState(hostedUIOptions.getFederationProviderName(), oAuth2Tokens.getIdToken(), new Callback<UserStateDetails>() {
                                                    public void onResult(UserStateDetails userStateDetails) {
                                                        UserStateDetails userStateDetails2 = AWSMobileClient.this.getUserStateDetails(false);
                                                        callback.onResult(userStateDetails2);
                                                        AWSMobileClient.this.setUserState(userStateDetails2);
                                                    }

                                                    public void onError(Exception exc) {
                                                        UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(false);
                                                        callback.onResult(userStateDetails);
                                                        AWSMobileClient.this.setUserState(userStateDetails);
                                                    }
                                                });
                                                return;
                                            }
                                            UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(false);
                                            callback.onResult(userStateDetails);
                                            AWSMobileClient.this.setUserState(userStateDetails);
                                        }

                                        public void onError(Exception exc) {
                                            callback.onError(exc);
                                        }
                                    });
                                }

                                public void onError(Exception exc) {
                                    callback.onError(exc);
                                }
                            });
                        } catch (Exception e3) {
                            throw new RuntimeException("Failed to construct tokens url for OAuth", e3);
                        }
                    } catch (Exception e4) {
                        throw new RuntimeException("Failed to construct authorization url for OAuth", e4);
                    }
                } else {
                    throw new IllegalArgumentException("OAuth flow requires a federation provider name if federation is enabled.");
                }
            }
        };
    }

    private Runnable _showSignInHostedUI(final Activity activity, final SignInUIOptions signInUIOptions, final Callback<UserStateDetails> callback) {
        return new Runnable() {
            public void run() {
                JSONObject jSONObject;
                HostedUIOptions hostedUIOptions = signInUIOptions.getHostedUIOptions();
                HashSet hashSet = null;
                try {
                    JSONObject hostedUIJSONFromJSON = AWSMobileClient.this.getHostedUIJSONFromJSON();
                    jSONObject = new JSONObject(!(hostedUIJSONFromJSON instanceof JSONObject) ? hostedUIJSONFromJSON.toString() : JSONObjectInstrumentation.toString(hostedUIJSONFromJSON));
                } catch (JSONException e) {
                    callback.onError(new Exception("Could not create OAuth configuration object", e));
                    jSONObject = null;
                }
                String str = "true";
                if (hostedUIOptions.getFederationEnabled() != null) {
                    KeyValueStore keyValueStore = AWSMobileClient.this.mStore;
                    if (!hostedUIOptions.getFederationEnabled().booleanValue()) {
                        str = "false";
                    }
                    keyValueStore.set(AWSMobileClient.FEDERATION_ENABLED_KEY, str);
                } else {
                    AWSMobileClient.this.mStore.set(AWSMobileClient.FEDERATION_ENABLED_KEY, str);
                }
                if (hostedUIOptions.getSignOutQueryParameters() != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        for (Map.Entry next : hostedUIOptions.getSignOutQueryParameters().entrySet()) {
                            jSONObject2.put((String) next.getKey(), next.getValue());
                        }
                        jSONObject.put("SignOutQueryParameters", jSONObject2);
                    } catch (JSONException e2) {
                        callback.onError(new Exception("Failed to construct sign-out query parameters", e2));
                        return;
                    }
                }
                if (hostedUIOptions.getTokenQueryParameters() != null) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        for (Map.Entry next2 : hostedUIOptions.getTokenQueryParameters().entrySet()) {
                            jSONObject3.put((String) next2.getKey(), next2.getValue());
                        }
                        jSONObject.put("TokenQueryParameters", jSONObject3);
                    } catch (JSONException e3) {
                        callback.onError(new Exception("Failed to construct token query parameters", e3));
                        return;
                    }
                }
                AWSMobileClient.this.mStore.set(AWSMobileClient.HOSTED_UI_KEY, !(jSONObject instanceof JSONObject) ? jSONObject.toString() : JSONObjectInstrumentation.toString(jSONObject));
                if (hostedUIOptions.getScopes() != null) {
                    hashSet = new HashSet();
                    Collections.addAll(hashSet, hostedUIOptions.getScopes());
                }
                String identityProvider = hostedUIOptions.getIdentityProvider();
                String idpIdentifier = hostedUIOptions.getIdpIdentifier();
                AWSMobileClient.this.mStore.set(AWSMobileClient.SIGN_IN_MODE, SignInMode.HOSTED_UI.toString());
                try {
                    Auth.Builder hostedUI = AWSMobileClient.this.getHostedUI(jSONObject);
                    hostedUI.setPersistenceEnabled(AWSMobileClient.this.mIsPersistenceEnabled).setAuthHandler(new AuthHandler() {
                        boolean hasSucceededOnce = false;

                        public void onSuccess(AuthUserSession authUserSession) {
                            Log.d(AWSMobileClient.TAG, "onSuccess: HostedUI signed-in");
                            this.hasSucceededOnce = true;
                            if (AWSMobileClient.this.isFederationEnabled()) {
                                AWSMobileClient.this.federatedSignInWithoutAssigningState(AWSMobileClient.this.userpoolsLoginKey, authUserSession.getIdToken().getJWTToken(), new Callback<UserStateDetails>() {
                                    public void onResult(UserStateDetails userStateDetails) {
                                        Log.d(AWSMobileClient.TAG, "onResult: Federation from the Hosted UI succeeded");
                                    }

                                    public void onError(Exception exc) {
                                        Log.e(AWSMobileClient.TAG, "onError: Federation from the Hosted UI failed", exc);
                                    }
                                });
                            }
                            Thread thread = new Thread(new Runnable() {
                                public void run() {
                                    UserStateDetails userStateDetails = AWSMobileClient.this.getUserStateDetails(false);
                                    callback.onResult(userStateDetails);
                                    AWSMobileClient.this.setUserState(userStateDetails);
                                }
                            });
                            if (!(thread instanceof Thread)) {
                                thread.start();
                            } else {
                                AsynchronousInstrumentation.threadStart(thread);
                            }
                        }

                        public void onSignout() {
                            Log.d(AWSMobileClient.TAG, "onSignout: HostedUI signed-out");
                        }

                        public void onFailure(final Exception exc) {
                            if (this.hasSucceededOnce) {
                                Log.d(AWSMobileClient.TAG, "onFailure: Ignoring failure because HostedUI has signaled success at least once.");
                                return;
                            }
                            Thread thread = new Thread(new Runnable() {
                                public void run() {
                                    callback.onError(exc);
                                }
                            });
                            if (!(thread instanceof Thread)) {
                                thread.start();
                            } else {
                                AsynchronousInstrumentation.threadStart(thread);
                            }
                        }
                    });
                    if (hashSet != null) {
                        hostedUI.setScopes(hashSet);
                    }
                    if (identityProvider != null) {
                        hostedUI.setIdentityProvider(identityProvider);
                    }
                    if (idpIdentifier != null) {
                        hostedUI.setIdpIdentifier(idpIdentifier);
                    }
                    AWSMobileClient.this.hostedUI = hostedUI.build();
                    if (signInUIOptions.getBrowserPackage() != null) {
                        AWSMobileClient.this.hostedUI.setBrowserPackage(signInUIOptions.getBrowserPackage());
                    }
                    AWSMobileClient.this.hostedUI.getSession(activity);
                } catch (JSONException e4) {
                    throw new RuntimeException("Failed to construct HostedUI from awsconfiguration.json", e4);
                }
            }
        };
    }

    private Runnable _showSignInDropInUI(final Activity activity, final SignInUIOptions signInUIOptions, final Callback<UserStateDetails> callback) {
        return new Runnable() {
            public void run() {
                synchronized (AWSMobileClient.this.showSignInLockObject) {
                    if (UserState.SIGNED_IN.equals(AWSMobileClient.this.getUserStateDetails(false).getUserState())) {
                        callback.onError(new RuntimeException("Called showSignIn while user is already signed-in"));
                        return;
                    }
                    AuthUIConfiguration.Builder isBackgroundColorFullScreen = new AuthUIConfiguration.Builder().canCancel(signInUIOptions.canCancel()).isBackgroundColorFullScreen(false);
                    if (signInUIOptions.getLogo() != null) {
                        isBackgroundColorFullScreen.logoResId(signInUIOptions.getLogo().intValue());
                    }
                    if (signInUIOptions.getBackgroundColor() != null) {
                        isBackgroundColorFullScreen.backgroundColor(signInUIOptions.getBackgroundColor().intValue());
                    }
                    if (AWSMobileClient.this.isConfigurationKeyPresent(AWSMobileClient.USER_POOLS)) {
                        isBackgroundColorFullScreen.userPools(true);
                    }
                    if (AWSMobileClient.this.isConfigurationKeyPresent(AWSMobileClient.FACEBOOK)) {
                        isBackgroundColorFullScreen.signInButton(FacebookButton.class);
                    }
                    if (AWSMobileClient.this.isConfigurationKeyPresent(AWSMobileClient.GOOGLE)) {
                        isBackgroundColorFullScreen.signInButton(GoogleButton.class);
                    }
                    Class cls = signInUIOptions.nextActivity() == null ? activity.getClass() : signInUIOptions.nextActivity();
                    AWSMobileClient aWSMobileClient = AWSMobileClient.this;
                    aWSMobileClient.getClient(aWSMobileClient.mContext, SignInUI.class).login(activity, cls).authUIConfiguration(isBackgroundColorFullScreen.build()).enableFederation(false).execute();
                    CountDownLatch unused = AWSMobileClient.this.showSignInWaitLatch = new CountDownLatch(1);
                    try {
                        AWSMobileClient.this.showSignInWaitLatch.await();
                        callback.onResult(AWSMobileClient.this.getUserStateDetails(false));
                        Log.d(AWSMobileClient.TAG, "run: showSignIn completed");
                    } catch (InterruptedException e) {
                        callback.onError(e);
                    }
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void initializeWithBuilder(InitializeBuilder initializeBuilder) {
        if (initializeBuilder.getAwsConfiguration() != null) {
            this.awsConfiguration = initializeBuilder.getAwsConfiguration();
        }
        if (initializeBuilder.getSignInProviderConfig() != null) {
            this.signInProviderConfig = initializeBuilder.getSignInProviderConfig();
        }
        try {
            fetchCognitoIdentity(initializeBuilder.getContext(), this.startupAuthResultHandler);
        } catch (Exception unused) {
            Log.e(TAG, "Error in initializing the AWSMobileClient. Check if AWS Cloud Config `awsconfiguration.json` is present in the application.");
        }
    }

    public AWSConfigurable getClient(Context context, Class<? extends AWSConfigurable> cls) {
        String str = TAG;
        Log.d(str, "Retrieving the client instance for class: " + cls);
        AWSConfigurable aWSConfigurable = this.clientMap.get(cls);
        if (aWSConfigurable != null) {
            return aWSConfigurable;
        }
        try {
            aWSConfigurable = ((AWSConfigurable) cls.newInstance()).initialize(context.getApplicationContext(), this.awsConfiguration);
            this.clientMap.put(cls, aWSConfigurable);
            Log.d(str, "Created the new client: " + aWSConfigurable.toString());
            return aWSConfigurable;
        } catch (Exception e) {
            String str2 = TAG;
            Log.e(str2, "Error occurred in creating and initializing client. Check the context and the clientClass passed in: " + cls, e);
            return aWSConfigurable;
        }
    }

    private void fetchCognitoIdentity(Context context, StartupAuthResultHandler startupAuthResultHandler2) {
        try {
            Log.d(TAG, "Fetching the Cognito Identity.");
            IdentityManager.setDefaultIdentityManager(new IdentityManager(context, this.awsConfiguration));
            if (this.signInProviderConfig == null) {
                registerConfigSignInProviders(this.awsConfiguration);
            } else {
                registerUserSignInProvidersWithPermissions();
            }
            resumeSession((Activity) context, startupAuthResultHandler2);
        } catch (Exception e) {
            Log.e(TAG, "Error occurred in fetching the Cognito Identity and resuming the auth session", e);
        }
    }

    private void registerUserSignInProvidersWithPermissions() {
        Log.d(TAG, "Using the SignInProviderConfig supplied by the user.");
        IdentityManager defaultIdentityManager = IdentityManager.getDefaultIdentityManager();
        for (SignInProviderConfig signInProviderConfig2 : this.signInProviderConfig) {
            defaultIdentityManager.addSignInProvider(signInProviderConfig2.getSignInProviderClass());
            if (signInProviderConfig2.getProviderPermissions() != null) {
                if (FacebookSignInProvider.class.isInstance(signInProviderConfig2.getSignInProviderClass())) {
                    FacebookSignInProvider.setPermissions(signInProviderConfig2.getProviderPermissions());
                }
                if (GoogleSignInProvider.class.isInstance(signInProviderConfig2.getSignInProviderClass())) {
                    GoogleSignInProvider.setPermissions(signInProviderConfig2.getProviderPermissions());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void registerConfigSignInProviders(AWSConfiguration aWSConfiguration) {
        Log.d(TAG, "Using the SignInProviderConfig from `awsconfiguration.json`.");
        IdentityManager defaultIdentityManager = IdentityManager.getDefaultIdentityManager();
        try {
            if (isConfigurationKeyPresent(USER_POOLS, aWSConfiguration)) {
                defaultIdentityManager.addSignInProvider(CognitoUserPoolsSignInProvider.class);
            }
            if (isConfigurationKeyPresent(FACEBOOK, aWSConfiguration)) {
                defaultIdentityManager.addSignInProvider(FacebookSignInProvider.class);
            }
            if (isConfigurationKeyPresent(GOOGLE, aWSConfiguration)) {
                defaultIdentityManager.addSignInProvider(GoogleSignInProvider.class);
            }
        } catch (NoClassDefFoundError unused) {
        }
    }

    /* access modifiers changed from: private */
    public boolean isConfigurationKeyPresent(String str) {
        return isConfigurationKeyPresent(str, this.awsConfiguration);
    }

    private boolean isConfigurationKeyPresent(String str, AWSConfiguration aWSConfiguration) {
        try {
            JSONObject optJsonObject = aWSConfiguration.optJsonObject(str);
            if (str.equals(GOOGLE)) {
                if (optJsonObject == null || optJsonObject.getString(GOOGLE_WEBAPP_CONFIG_KEY) == null) {
                    return false;
                }
                return true;
            } else if (optJsonObject != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception unused) {
            String str2 = TAG;
            Log.d(str2, str + " not found in `awsconfiguration.json`");
            return false;
        }
    }

    private void resumeSession(Activity activity, StartupAuthResultHandler startupAuthResultHandler2) {
        IdentityManager.getDefaultIdentityManager().resumeSession(activity, startupAuthResultHandler2);
    }

    @Deprecated
    public class InitializeBuilder {
        private AWSConfiguration awsConfiguration;
        private Context context;
        private SignInProviderConfig[] signInProviderConfig;

        @Deprecated
        public InitializeBuilder() {
            this.context = null;
            this.awsConfiguration = null;
            this.signInProviderConfig = null;
        }

        @Deprecated
        public InitializeBuilder(Context context2) {
            this.context = context2;
            this.awsConfiguration = null;
            this.signInProviderConfig = null;
        }

        @Deprecated
        public InitializeBuilder awsConfiguration(AWSConfiguration aWSConfiguration) {
            this.awsConfiguration = aWSConfiguration;
            return this;
        }

        @Deprecated
        public InitializeBuilder signInProviders(SignInProviderConfig... signInProviderConfigArr) {
            this.signInProviderConfig = signInProviderConfigArr;
            return this;
        }

        @Deprecated
        public AWSConfiguration getAwsConfiguration() {
            return this.awsConfiguration;
        }

        @Deprecated
        public SignInProviderConfig[] getSignInProviderConfig() {
            return this.signInProviderConfig;
        }

        @Deprecated
        public Context getContext() {
            return this.context;
        }

        @Deprecated
        public void execute() {
            AWSMobileClient.this.initializeWithBuilder(this);
        }
    }

    @Deprecated
    public class SignInProviderConfig {
        @Deprecated
        private String[] providerPermissions;
        @Deprecated
        private Class<? extends SignInProvider> signInProvider;

        @Deprecated
        public SignInProviderConfig(Class<? extends SignInProvider> cls, String... strArr) {
            this.signInProvider = cls;
            this.providerPermissions = strArr;
        }

        @Deprecated
        public Class<? extends SignInProvider> getSignInProviderClass() {
            return this.signInProvider;
        }

        @Deprecated
        public String[] getProviderPermissions() {
            return this.providerPermissions;
        }
    }
}
