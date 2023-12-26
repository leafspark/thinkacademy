package com.sensorsdata.analytics.android.sdk;

import com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey;
import com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.SSLSocketFactory;

abstract class AbstractSAConfigOptions {
    boolean isAutoAddChannelCallbackEvent;
    boolean isAutoTrackWebView;
    boolean isDataCollectEnable = true;
    boolean isDisableSDK = false;
    boolean isSubProcessFlushData = false;
    boolean isWebViewSupportJellyBean;
    String mAnonymousId;
    int mAutoTrackEventType;
    public boolean mDisableDebugAssistant;
    public boolean mDisableRandomTimeRequestRemoteConfig;
    boolean mEnableEncrypt = false;
    boolean mEnableSaveDeepLinkInfo = false;
    boolean mEnableTrackAppCrash;
    public boolean mEnableTrackPush;
    List<SAEncryptListener> mEncryptors = new ArrayList();
    int mFlushBulkSize;
    int mFlushInterval;
    boolean mHeatMapEnabled;
    protected boolean mIsTrackPageLeave = false;
    boolean mLogEnabled;
    long mMaxCacheSize = 33554432;
    public int mMaxRequestInterval = 48;
    public int mMinRequestInterval = 24;
    int mNetworkTypePolicy = 30;
    IPersistentSecretKey mPersistentSecretKey;
    public String mRemoteConfigUrl;
    public SSLSocketFactory mSSLSocketFactory;
    String mServerUrl;
    boolean mTrackScreenOrientationEnabled;
    boolean mVisualizedEnabled;
    boolean mVisualizedPropertiesEnabled;

    AbstractSAConfigOptions() {
    }

    public boolean isDataCollectEnable() {
        return this.isDataCollectEnable;
    }

    public boolean isSaveDeepLinkInfo() {
        return this.mEnableSaveDeepLinkInfo;
    }

    public boolean isMultiProcessFlush() {
        return this.isSubProcessFlushData;
    }

    public boolean isTrackPageLeave() {
        return this.mIsTrackPageLeave;
    }

    public List<SAEncryptListener> getEncryptors() {
        return this.mEncryptors;
    }

    public boolean isDisableSDK() {
        return this.isDisableSDK;
    }

    public boolean isEnableTrackPush() {
        return this.mEnableTrackPush;
    }

    public boolean isVisualizedPropertiesEnabled() {
        return this.mVisualizedPropertiesEnabled;
    }
}
