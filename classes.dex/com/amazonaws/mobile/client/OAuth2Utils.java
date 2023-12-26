package com.amazonaws.mobile.client;

import android.content.ComponentName;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.adyen.checkout.components.status.api.StatusResponseUtils;
import com.amazonaws.mobile.client.internal.oauth2.OAuth2Client;
import com.amazonaws.mobileconnectors.cognitoauth.util.Pkce;
import java.util.Map;

/* compiled from: AWSMobileClient */
class OAuth2Utils {
    /* access modifiers changed from: private */
    public CustomTabsCallback customTabsCallback = new CustomTabsCallback();
    private final Context mContext;
    /* access modifiers changed from: private */
    public CustomTabsClient mCustomTabsClient;
    private CustomTabsServiceConnection mCustomTabsServiceConnection;
    /* access modifiers changed from: private */
    public CustomTabsSession mCustomTabsSession;
    private String mError;
    private String mErrorDescription;
    private final Uri mSignInRedirectUri;
    private String mState;

    /* access modifiers changed from: package-private */
    public Uri exchangeCode(String str) {
        return null;
    }

    OAuth2Utils(Context context, Uri uri) {
        this.mContext = context;
        this.mSignInRedirectUri = uri;
    }

    /* access modifiers changed from: package-private */
    public void preWarm() {
        AnonymousClass1 r0 = new CustomTabsServiceConnection() {
            public void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
                CustomTabsClient unused = OAuth2Utils.this.mCustomTabsClient = customTabsClient;
                OAuth2Utils.this.mCustomTabsClient.warmup(0);
                OAuth2Utils oAuth2Utils = OAuth2Utils.this;
                CustomTabsSession unused2 = oAuth2Utils.mCustomTabsSession = oAuth2Utils.mCustomTabsClient.newSession(OAuth2Utils.this.customTabsCallback);
            }

            public void onServiceDisconnected(ComponentName componentName) {
                CustomTabsClient unused = OAuth2Utils.this.mCustomTabsClient = null;
            }
        };
        this.mCustomTabsServiceConnection = r0;
        CustomTabsClient.bindCustomTabsService(this.mContext, OAuth2Client.CUSTOM_TABS_PACKAGE_NAME, r0);
    }

    /* access modifiers changed from: package-private */
    public void authorize(String str, String str2, Map<String, String> map) {
        this.mState = Pkce.generateRandom();
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        if (!map.containsKey("code")) {
            buildUpon.appendQueryParameter("response_type", "code");
        }
        if (!map.containsKey("client_id")) {
            if (str2 != null) {
                buildUpon.appendQueryParameter("client_id", str2);
            } else {
                throw new IllegalArgumentException("Client id must be specified for an authorization request.");
            }
        }
        buildUpon.appendQueryParameter(TransferTable.COLUMN_STATE, this.mState);
        navigate(buildUpon.build());
    }

    /* access modifiers changed from: package-private */
    public void navigate(Uri uri) {
        CustomTabsIntent build = new CustomTabsIntent.Builder(this.mCustomTabsSession).build();
        build.intent.setPackage(OAuth2Client.CUSTOM_TABS_PACKAGE_NAME);
        build.intent.addFlags(BasicMeasure.EXACTLY);
        build.intent.addFlags(268435456);
        build.launchUrl(this.mContext, uri);
    }

    /* access modifiers changed from: package-private */
    public boolean parse(Uri uri) {
        if (uri.getScheme().equals(this.mSignInRedirectUri.getScheme()) && uri.getAuthority().equals(this.mSignInRedirectUri.getAuthority()) && uri.getPath().equals(this.mSignInRedirectUri.getPath()) && uri.getQueryParameterNames().containsAll(this.mSignInRedirectUri.getQueryParameterNames())) {
            uri.getQueryParameter("code");
            if (!this.mState.equals(uri.getQueryParameter(TransferTable.COLUMN_STATE))) {
                return false;
            }
            this.mError = uri.getQueryParameter(StatusResponseUtils.RESULT_ERROR);
            this.mErrorDescription = uri.getQueryParameter("error_description");
            if (this.mError != null) {
                return true;
            }
        }
        return false;
    }
}
