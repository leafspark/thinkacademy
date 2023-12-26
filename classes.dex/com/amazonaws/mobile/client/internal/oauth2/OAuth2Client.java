package com.amazonaws.mobile.client.internal.oauth2;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.adyen.checkout.components.status.api.StatusResponseUtils;
import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.Callback;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Constants;
import com.amazonaws.mobileconnectors.cognitoauth.util.Pkce;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class OAuth2Client {
    public static final String CREATE_DATE = "createDate";
    public static final String CUSTOM_TABS_PACKAGE_NAME = "com.android.chrome";
    private static final long REFRESH_THRESHOLD = 60000;
    public static final String SHARED_PREFERENCES_KEY = "com.amazonaws.mobile.client.oauth2";
    public static final String SIGN_IN_REDIRECT_URI_KEY = "signInRedirectUri";
    public static final String SIGN_OUT_REDIRECT_URI_KEY = "signOutRedirectUri";
    public static final String TAG = "OAuth2Client";
    public static final String TOKEN_URI_KEY = "tokenUri";
    Callback<AuthorizeResponse> mAuthorizeCallback;
    /* access modifiers changed from: private */
    public boolean mAuthorizeOrSignOutRedirectReceived;
    private String mClientId;
    final Context mContext;
    CustomTabsCallback mCustomTabsCallback;
    CustomTabsClient mCustomTabsClient;
    final CustomTabsServiceConnection mCustomTabsServiceConnection;
    CustomTabsSession mCustomTabsSession;
    private String mError;
    private String mErrorDescription;
    private String mErrorUriString;
    boolean mIsPersistenceEnabled = true;
    final AWSMobileClient mMobileClient;
    PKCEMode mPKCEMode;
    /* access modifiers changed from: private */
    public Callback<Void> mSignOutCallback;
    String mState;
    private final OAuth2ClientStore mStore;
    private String userAgentOverride;

    public OAuth2Client(Context context, AWSMobileClient aWSMobileClient) {
        this.mMobileClient = aWSMobileClient;
        this.mContext = context;
        this.mPKCEMode = PKCEMode.S256;
        this.mStore = new OAuth2ClientStore(this);
        this.mCustomTabsCallback = new CustomTabsCallback() {
            public void onNavigationEvent(int i, Bundle bundle) {
                super.onNavigationEvent(i, bundle);
                if (i == 6 && !OAuth2Client.this.mAuthorizeOrSignOutRedirectReceived) {
                    if (OAuth2Client.this.mSignOutCallback != null) {
                        OAuth2Client.this.mSignOutCallback.onError(new Exception("User cancelled flow or flow interrupted."));
                        Callback unused = OAuth2Client.this.mSignOutCallback = null;
                    } else if (OAuth2Client.this.mAuthorizeCallback != null) {
                        OAuth2Client.this.mAuthorizeCallback.onError(new Exception("User cancelled flow or flow interrupted."));
                        OAuth2Client.this.mAuthorizeCallback = null;
                    }
                }
            }
        };
        AnonymousClass2 r3 = new CustomTabsServiceConnection() {
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                OAuth2Client.this.mCustomTabsClient = customTabsClient;
                OAuth2Client.this.mCustomTabsClient.warmup(0);
                OAuth2Client oAuth2Client = OAuth2Client.this;
                oAuth2Client.mCustomTabsSession = oAuth2Client.mCustomTabsClient.newSession(OAuth2Client.this.mCustomTabsCallback);
            }

            public void onServiceDisconnected(ComponentName componentName) {
                OAuth2Client.this.mCustomTabsClient = null;
            }
        };
        this.mCustomTabsServiceConnection = r3;
        if (!CustomTabsClient.bindCustomTabsService(context, CUSTOM_TABS_PACKAGE_NAME, r3)) {
            Log.d(TAG, "OAuth2Client: Failed to pre-warm custom tab, first page load may be slower");
        }
    }

    public void setPersistenceEnabled(boolean z) {
        this.mIsPersistenceEnabled = z;
        this.mStore.setPersistenceEnabled(z);
    }

    public void setUserAgentOverride(String str) {
        this.userAgentOverride = str;
    }

    public void signOut(Uri uri, Callback<Void> callback) {
        this.mSignOutCallback = callback;
        String queryParameter = uri.getQueryParameter("redirect_uri");
        if (queryParameter != null) {
            this.mStore.set(SIGN_OUT_REDIRECT_URI_KEY, queryParameter);
            Uri.parse(queryParameter);
            open(uri);
            return;
        }
        throw new IllegalArgumentException("The sign-out URI must contain a redirect_uri");
    }

    public void signOut() {
        this.mStore.clear();
        this.mSignOutCallback = null;
        this.mAuthorizeCallback = null;
        this.mPKCEMode = PKCEMode.S256;
        this.mState = null;
        this.mClientId = null;
        this.mError = null;
        this.mErrorDescription = null;
        this.mErrorUriString = null;
    }

    public enum PKCEMode {
        NONE(""),
        S256("S256");
        
        private String encode;

        private PKCEMode(String str) {
            this.encode = str;
        }

        public String toString() {
            return this.encode;
        }

        public boolean equals(PKCEMode pKCEMode) {
            return pKCEMode.encode.equals(this.encode);
        }
    }

    public void setPKCEMode(PKCEMode pKCEMode) {
        this.mPKCEMode = pKCEMode;
    }

    public void authorize(Uri uri, Callback<AuthorizeResponse> callback) {
        this.mAuthorizeCallback = callback;
        try {
            Uri.Builder buildUpon = uri.buildUpon();
            int i = AnonymousClass3.$SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode[this.mPKCEMode.ordinal()];
            if (i == 1) {
                String generateRandom = Pkce.generateRandom();
                String generateHash = Pkce.generateHash(generateRandom);
                this.mStore.set("proofKey", generateRandom);
                this.mStore.set("proofKeyHash", generateHash);
                buildUpon.appendQueryParameter("code_challenge_method", this.mPKCEMode.toString()).appendQueryParameter("code_challenge", generateHash).build();
            } else if (i != 2) {
                throw new IllegalArgumentException("Unsupported PKCE mode was chosen, please choose another");
            }
            Uri build = buildUpon.build();
            String queryParameter = build.getQueryParameter("client_id");
            this.mClientId = queryParameter;
            if (queryParameter != null) {
                String queryParameter2 = build.getQueryParameter("redirect_uri");
                if (queryParameter2 != null) {
                    this.mStore.set(SIGN_IN_REDIRECT_URI_KEY, queryParameter2);
                    Uri.parse(queryParameter2);
                    if (build.getQueryParameter("response_type") == null) {
                        buildUpon.appendQueryParameter("response_type", "code").build();
                    }
                    String queryParameter3 = build.getQueryParameter(TransferTable.COLUMN_STATE);
                    this.mState = queryParameter3;
                    if (queryParameter3 == null) {
                        String generateRandom2 = Pkce.generateRandom();
                        this.mState = generateRandom2;
                        buildUpon.appendQueryParameter(TransferTable.COLUMN_STATE, generateRandom2).build();
                    }
                    this.mStore.set(TransferTable.COLUMN_STATE, this.mState);
                    open(buildUpon.build());
                    return;
                }
                throw new IllegalArgumentException("The authorize URI must contain a redirect_uri");
            }
            throw new IllegalArgumentException("The authorize URI must contain a client_id");
        } catch (Exception e) {
            callback.onError(e);
        }
    }

    /* renamed from: com.amazonaws.mobile.client.internal.oauth2.OAuth2Client$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.amazonaws.mobile.client.internal.oauth2.OAuth2Client$PKCEMode[] r0 = com.amazonaws.mobile.client.internal.oauth2.OAuth2Client.PKCEMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode = r0
                com.amazonaws.mobile.client.internal.oauth2.OAuth2Client$PKCEMode r1 = com.amazonaws.mobile.client.internal.oauth2.OAuth2Client.PKCEMode.S256     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$amazonaws$mobile$client$internal$oauth2$OAuth2Client$PKCEMode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amazonaws.mobile.client.internal.oauth2.OAuth2Client$PKCEMode r1 = com.amazonaws.mobile.client.internal.oauth2.OAuth2Client.PKCEMode.NONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobile.client.internal.oauth2.OAuth2Client.AnonymousClass3.<clinit>():void");
        }
    }

    public void open(Uri uri) {
        CustomTabsIntent build = new CustomTabsIntent.Builder(this.mCustomTabsSession).build();
        build.intent.setPackage(CUSTOM_TABS_PACKAGE_NAME);
        build.intent.addFlags(BasicMeasure.EXACTLY);
        build.intent.addFlags(268435456);
        this.mAuthorizeOrSignOutRedirectReceived = false;
        build.launchUrl(this.mContext, uri);
    }

    public boolean handleRedirect(Uri uri) {
        if (uri == null) {
            return false;
        }
        String str = this.mStore.get(SIGN_IN_REDIRECT_URI_KEY);
        String str2 = this.mStore.get(SIGN_OUT_REDIRECT_URI_KEY);
        if (str != null) {
            Uri parse = Uri.parse(str);
            if (uri.getScheme().equals(parse.getScheme()) && uri.getAuthority().equals(parse.getAuthority()) && uri.getPath().equals(parse.getPath()) && uri.getQueryParameterNames().containsAll(parse.getQueryParameterNames())) {
                String queryParameter = uri.getQueryParameter("code");
                if (!this.mStore.get(TransferTable.COLUMN_STATE).equals(uri.getQueryParameter(TransferTable.COLUMN_STATE))) {
                    return false;
                }
                this.mError = uri.getQueryParameter(StatusResponseUtils.RESULT_ERROR);
                this.mErrorDescription = uri.getQueryParameter("error_description");
                this.mErrorUriString = uri.getQueryParameter("error_uri");
                this.mAuthorizeOrSignOutRedirectReceived = true;
                if (this.mError != null) {
                    Callback<AuthorizeResponse> callback = this.mAuthorizeCallback;
                    if (callback != null) {
                        callback.onError(new OAuth2Exception("Authorization call failed with response from authorization server", this.mError, this.mErrorDescription, this.mErrorUriString));
                        this.mAuthorizeCallback = null;
                    }
                    return true;
                } else if (queryParameter == null) {
                    return false;
                } else {
                    if (this.mAuthorizeCallback != null) {
                        AuthorizeResponse authorizeResponse = new AuthorizeResponse();
                        authorizeResponse.code = queryParameter;
                        authorizeResponse.responseUri = uri;
                        this.mAuthorizeCallback.onResult(authorizeResponse);
                        this.mAuthorizeCallback = null;
                    }
                    return true;
                }
            }
        }
        if (str2 != null) {
            Uri parse2 = Uri.parse(str2);
            if (uri.getScheme().equals(parse2.getScheme()) && uri.getAuthority().equals(parse2.getAuthority()) && uri.getPath().equals(parse2.getPath()) && uri.getQueryParameterNames().containsAll(parse2.getQueryParameterNames())) {
                this.mAuthorizeOrSignOutRedirectReceived = true;
                Callback<Void> callback2 = this.mSignOutCallback;
                if (callback2 != null) {
                    callback2.onResult(null);
                    this.mSignOutCallback = null;
                }
                return true;
            }
        }
        return false;
    }

    public void requestTokens(Uri uri, Map<String, String> map, Map<String, String> map2, String str, Callback<OAuth2Tokens> callback) {
        String str2 = this.mStore.get("proofKey");
        if (str2 == null && !this.mPKCEMode.equals(PKCEMode.NONE)) {
            callback.onError(new Exception("Proof key could not be found from current session."));
        }
        try {
            if (map2.get("client_id") == null) {
                throw new IllegalArgumentException("The token exchange must contain a client_id");
            } else if (map2.get("redirect_uri") != null) {
                if (map2.get("code") == null) {
                    if (str != null) {
                        map2.put("code", str);
                    } else {
                        throw new IllegalArgumentException("The token exchange must contain a code");
                    }
                }
                if (map2.get("code_verifier") == null) {
                    if (str2 != null) {
                        map2.put("code_verifier", str2);
                    } else {
                        throw new IllegalStateException("The token exchange must contain a code verifier");
                    }
                }
                if (map2.get(OAuth2Constants.GRANT_TYPE) == null) {
                    map2.put(OAuth2Constants.GRANT_TYPE, OAuth2Constants.GrantTypes.AUTHORIZATION_CODE.toString());
                }
                this.mStore.set(TOKEN_URI_KEY, uri.toString());
                OAuth2Tokens parseHttpResponse = HTTPUtil.parseHttpResponse(HTTPUtil.httpPost(new URL(uri.toString()), map, map2, this.userAgentOverride));
                this.mStore.set(parseHttpResponse);
                callback.onResult(parseHttpResponse);
            } else {
                throw new IllegalArgumentException("The token exchange must contain a redirect_uri");
            }
        } catch (Exception e) {
            callback.onError(new Exception("Failed to exchange code for tokens", e));
        }
    }

    public void refresh(Uri uri, Map<String, String> map, Map<String, String> map2, Callback<OAuth2Tokens> callback) {
        String str = this.mStore.get(OAuth2Constants.TokenResponseFields.REFRESH_TOKEN.toString());
        if (str == null) {
            callback.onError(new IllegalStateException("Refresh called without refresh token available"));
        }
        try {
            if (map2.get(OAuth2Constants.GRANT_TYPE) == null) {
                map2.put(OAuth2Constants.GRANT_TYPE, OAuth2Constants.GrantTypes.REFRESH_TOKEN.toString());
            }
            if (map2.get("refresh_token") == null) {
                if (str != null) {
                    map2.put("refresh_token", str);
                } else {
                    throw new IllegalArgumentException("The refresh flow must contain a refresh_token");
                }
            }
            OAuth2Tokens parseHttpResponse = HTTPUtil.parseHttpResponse(HTTPUtil.httpPost(new URL(uri.toString()), map, map2, this.userAgentOverride));
            this.mStore.set(parseHttpResponse);
            callback.onResult(parseHttpResponse);
        } catch (Exception e) {
            callback.onError(new Exception("Failed to refresh tokens with service", e));
        }
    }

    public void getTokens(Callback<OAuth2Tokens> callback) {
        String str;
        try {
            OAuth2Tokens tokens = this.mStore.getTokens();
            if (tokens.expiresIn != null && (tokens.createDate.longValue() + tokens.expiresIn.longValue()) - System.currentTimeMillis() < REFRESH_THRESHOLD) {
                if (tokens.refreshToken == null || (str = this.mStore.get((String) TOKEN_URI_KEY)) == null) {
                    callback.onError(new Exception("No cached tokens available, refresh not available."));
                } else {
                    refresh(Uri.parse(str), new HashMap(), new HashMap(), callback);
                }
            }
            callback.onResult(tokens);
        } catch (Exception e) {
            callback.onError(e);
        }
    }
}
