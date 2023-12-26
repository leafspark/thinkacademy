package com.sensorsdata.analytics.android.sdk;

import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.advert.utils.ChannelUtils;
import com.sensorsdata.analytics.android.sdk.encrypt.IPersistentSecretKey;
import com.sensorsdata.analytics.android.sdk.encrypt.SAEncryptListener;
import com.tal.app.thinkacademy.live.util.ViewLevelCons;
import java.util.List;
import javax.net.ssl.SSLSocketFactory;

public final class SAConfigOptions extends AbstractSAConfigOptions implements Cloneable {
    boolean mInvokeHeatMapEnabled;
    boolean mInvokeLog;
    boolean mInvokeVisualizedEnabled;

    public /* bridge */ /* synthetic */ List getEncryptors() {
        return super.getEncryptors();
    }

    public /* bridge */ /* synthetic */ boolean isDataCollectEnable() {
        return super.isDataCollectEnable();
    }

    public /* bridge */ /* synthetic */ boolean isDisableSDK() {
        return super.isDisableSDK();
    }

    public /* bridge */ /* synthetic */ boolean isEnableTrackPush() {
        return super.isEnableTrackPush();
    }

    public /* bridge */ /* synthetic */ boolean isMultiProcessFlush() {
        return super.isMultiProcessFlush();
    }

    public /* bridge */ /* synthetic */ boolean isSaveDeepLinkInfo() {
        return super.isSaveDeepLinkInfo();
    }

    public /* bridge */ /* synthetic */ boolean isTrackPageLeave() {
        return super.isTrackPageLeave();
    }

    public /* bridge */ /* synthetic */ boolean isVisualizedPropertiesEnabled() {
        return super.isVisualizedPropertiesEnabled();
    }

    private SAConfigOptions() {
    }

    public SAConfigOptions(String str) {
        this.mServerUrl = str;
    }

    public SAConfigOptions setRemoteConfigUrl(String str) {
        this.mRemoteConfigUrl = str;
        return this;
    }

    public SAConfigOptions setServerUrl(String str) {
        this.mServerUrl = str;
        return this;
    }

    public SAConfigOptions setAutoTrackEventType(int i) {
        this.mAutoTrackEventType = i;
        return this;
    }

    public SAConfigOptions enableTrackAppCrash() {
        this.mEnableTrackAppCrash = true;
        return this;
    }

    public SAConfigOptions setFlushInterval(int i) {
        this.mFlushInterval = Math.max(ViewLevelCons.LEVEL_GiftLivePluginDriver_openGift, i);
        return this;
    }

    public SAConfigOptions setFlushBulkSize(int i) {
        this.mFlushBulkSize = Math.max(50, i);
        return this;
    }

    public SAConfigOptions setMaxCacheSize(long j) {
        this.mMaxCacheSize = Math.max(16777216, j);
        return this;
    }

    public SAConfigOptions setMinRequestInterval(int i) {
        if (i > 0) {
            this.mMinRequestInterval = Math.min(i, 168);
        }
        return this;
    }

    public SAConfigOptions setMaxRequestInterval(int i) {
        if (i > 0) {
            this.mMaxRequestInterval = Math.min(i, 168);
        }
        return this;
    }

    public SAConfigOptions disableRandomTimeRequestRemoteConfig() {
        this.mDisableRandomTimeRequestRemoteConfig = true;
        return this;
    }

    public SAConfigOptions disableDebugAssistant() {
        this.mDisableDebugAssistant = true;
        return this;
    }

    public SAConfigOptions enableHeatMap(boolean z) {
        this.mHeatMapEnabled = z;
        this.mInvokeHeatMapEnabled = true;
        return this;
    }

    public SAConfigOptions enableVisualizedProperties(boolean z) {
        this.mVisualizedPropertiesEnabled = z;
        return this;
    }

    public SAConfigOptions enableVisualizedAutoTrack(boolean z) {
        this.mVisualizedEnabled = z;
        this.mInvokeVisualizedEnabled = true;
        return this;
    }

    public SAConfigOptions enableLog(boolean z) {
        this.mLogEnabled = z;
        this.mInvokeLog = true;
        return this;
    }

    public SAConfigOptions enableTrackScreenOrientation(boolean z) {
        this.mTrackScreenOrientationEnabled = z;
        return this;
    }

    public SAConfigOptions setNetworkTypePolicy(int i) {
        this.mNetworkTypePolicy = i;
        return this;
    }

    public SAConfigOptions setAnonymousId(String str) {
        this.mAnonymousId = str;
        return this;
    }

    public SAConfigOptions enableSaveDeepLinkInfo(boolean z) {
        this.mEnableSaveDeepLinkInfo = z;
        return this;
    }

    public SAConfigOptions setSourceChannels(String... strArr) {
        ChannelUtils.setSourceChannelKeys(strArr);
        return this;
    }

    public SAConfigOptions enableJavaScriptBridge(boolean z) {
        this.isAutoTrackWebView = true;
        this.isWebViewSupportJellyBean = z;
        return this;
    }

    public SAConfigOptions enableAutoAddChannelCallbackEvent(boolean z) {
        this.isAutoAddChannelCallbackEvent = z;
        return this;
    }

    public SAConfigOptions enableEncrypt(boolean z) {
        this.mEnableEncrypt = z;
        return this;
    }

    public SAConfigOptions persistentSecretKey(IPersistentSecretKey iPersistentSecretKey) {
        this.mPersistentSecretKey = iPersistentSecretKey;
        return this;
    }

    public SAConfigOptions enableSubProcessFlushData() {
        this.isSubProcessFlushData = true;
        return this;
    }

    @Deprecated
    public SAConfigOptions disableDataCollect() {
        this.isDataCollectEnable = false;
        return this;
    }

    public SAConfigOptions setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.mSSLSocketFactory = sSLSocketFactory;
        return this;
    }

    public SAConfigOptions enableTrackPush(boolean z) {
        this.mEnableTrackPush = z;
        return this;
    }

    public SAConfigOptions disableSDK(boolean z) {
        this.isDisableSDK = z;
        return this;
    }

    public SAConfigOptions enableTrackPageLeave(boolean z) {
        this.mIsTrackPageLeave = z;
        return this;
    }

    public SAConfigOptions registerEncryptor(SAEncryptListener sAEncryptListener) {
        if (sAEncryptListener != null && !TextUtils.isEmpty(sAEncryptListener.asymmetricEncryptType()) && !TextUtils.isEmpty(sAEncryptListener.symmetricEncryptType()) && !this.mEncryptors.contains(sAEncryptListener)) {
            this.mEncryptors.add(0, sAEncryptListener);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public SAConfigOptions clone() {
        try {
            return (SAConfigOptions) super.clone();
        } catch (CloneNotSupportedException e) {
            SALog.printStackTrace(e);
            return this;
        }
    }
}
