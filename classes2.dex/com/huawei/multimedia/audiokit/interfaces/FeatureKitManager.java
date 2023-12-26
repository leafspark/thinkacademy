package com.huawei.multimedia.audiokit.interfaces;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import com.huawei.multimedia.audiokit.utils.LogUtils;

public class FeatureKitManager {
    private static final Object BIND_SERVICE_LOCK = new Object();
    private static final String ENGINE_PACKAGE_NAME = "com.huawei.multimedia.audioengine";
    private static final Object NEW_FEATUREMANAGER_LOCK = new Object();
    private static final int PACKAGE_INFO_FLAG = 0;
    private static final Object SET_CALL_BACK_LOCK = new Object();
    private static final String TAG = "HwAudioKit.FeatureKitManager";
    private static final Object UNBIND_SERVICE_LOCK = new Object();
    private static FeatureKitManager sInstance;
    private IAudioKitCallback mCallBack = null;

    private FeatureKitManager() {
    }

    protected static FeatureKitManager getInstance() {
        FeatureKitManager featureKitManager;
        synchronized (NEW_FEATUREMANAGER_LOCK) {
            if (sInstance == null) {
                sInstance = new FeatureKitManager();
            }
            featureKitManager = sInstance;
        }
        return featureKitManager;
    }

    /* access modifiers changed from: protected */
    public <T extends AudioFeaturesKit> T createFeatureKit(int i, Context context) {
        LogUtils.info(TAG, "createFeatureKit, type = {}", Integer.valueOf(i));
        if (context == null) {
            return null;
        }
        if (i != 1) {
            LogUtils.info(TAG, "createFeatureKit, type error");
            return null;
        }
        T hwAudioKaraokeFeatureKit = new HwAudioKaraokeFeatureKit(context);
        hwAudioKaraokeFeatureKit.initialize(context);
        return hwAudioKaraokeFeatureKit;
    }

    /* access modifiers changed from: protected */
    public void bindService(Context context, ServiceConnection serviceConnection, String str) {
        synchronized (BIND_SERVICE_LOCK) {
            if (context != null) {
                Intent intent = new Intent();
                intent.setClassName(ENGINE_PACKAGE_NAME, str);
                try {
                    LogUtils.info(TAG, "bindService");
                    context.bindService(intent, serviceConnection, 1);
                } catch (SecurityException e) {
                    LogUtils.error(TAG, "bindService, SecurityException, {}", e.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        LogUtils.info(TAG, "unbindService");
        synchronized (UNBIND_SERVICE_LOCK) {
            if (context != null) {
                context.unbindService(serviceConnection);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isMediaKitSupport(Context context) {
        if (context == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return true;
        }
        try {
            if (packageManager.getPackageInfo(ENGINE_PACKAGE_NAME, 0) != null) {
                return true;
            }
            LogUtils.info(TAG, "packageInfo is null");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            LogUtils.error(TAG, "isMediaKitSupport ,NameNotFoundException");
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onCallBack(int i) {
        LogUtils.info(TAG, "onCallBack, result = {}", Integer.valueOf(i));
        synchronized (SET_CALL_BACK_LOCK) {
            if (getCallBack() != null) {
                getCallBack().onResult(i);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setCallBack(IAudioKitCallback iAudioKitCallback) {
        this.mCallBack = iAudioKitCallback;
    }

    /* access modifiers changed from: protected */
    public IAudioKitCallback getCallBack() {
        return this.mCallBack;
    }
}
