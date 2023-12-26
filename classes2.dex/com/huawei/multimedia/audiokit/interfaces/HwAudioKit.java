package com.huawei.multimedia.audiokit.interfaces;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.multimedia.audioengine.IHwAudioEngine;
import com.huawei.multimedia.audiokit.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class HwAudioKit {
    private static final List<Integer> DEFAULT_FEATURE_LIST = new ArrayList(0);
    private static final String ENGINE_CLASS_NAME = "com.huawei.multimedia.audioengine.HwAudioEngineService";
    private static final String TAG = "HwAudioKit.HwAudioKit";
    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IHwAudioEngine unused = HwAudioKit.this.mIHwAudioEngine = IHwAudioEngine.Stub.asInterface(iBinder);
            LogUtils.info(HwAudioKit.TAG, "onServiceConnected");
            if (HwAudioKit.this.mIHwAudioEngine != null) {
                boolean unused2 = HwAudioKit.this.mIsServiceConnected = true;
                LogUtils.info(HwAudioKit.TAG, "onServiceConnected, mIHwAudioEngine is not null");
                HwAudioKit.this.mFeatureKitManager.onCallBack(0);
                HwAudioKit hwAudioKit = HwAudioKit.this;
                hwAudioKit.serviceInit(hwAudioKit.mContext.getPackageName(), "1.0.1");
                HwAudioKit.this.serviceLinkToDeath(iBinder);
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            LogUtils.info(HwAudioKit.TAG, "onServiceDisconnected");
            IHwAudioEngine unused = HwAudioKit.this.mIHwAudioEngine = null;
            boolean unused2 = HwAudioKit.this.mIsServiceConnected = false;
            HwAudioKit.this.mFeatureKitManager.onCallBack(4);
        }
    };
    /* access modifiers changed from: private */
    public Context mContext = null;
    /* access modifiers changed from: private */
    public IBinder.DeathRecipient mDeathRecipient = new IBinder.DeathRecipient() {
        public void binderDied() {
            HwAudioKit.this.mService.unlinkToDeath(HwAudioKit.this.mDeathRecipient, 0);
            HwAudioKit.this.mFeatureKitManager.onCallBack(6);
            LogUtils.error(HwAudioKit.TAG, "service binder died");
            IBinder unused = HwAudioKit.this.mService = null;
        }
    };
    /* access modifiers changed from: private */
    public FeatureKitManager mFeatureKitManager;
    /* access modifiers changed from: private */
    public IHwAudioEngine mIHwAudioEngine = null;
    /* access modifiers changed from: private */
    public boolean mIsServiceConnected = false;
    /* access modifiers changed from: private */
    public IBinder mService = null;

    public enum FeatureType {
        HWAUDIO_FEATURE_KARAOKE(1);
        
        private int mFeatureType;

        private FeatureType(int i) {
            this.mFeatureType = i;
        }

        public int getFeatureType() {
            return this.mFeatureType;
        }
    }

    public HwAudioKit(Context context, IAudioKitCallback iAudioKitCallback) {
        FeatureKitManager instance = FeatureKitManager.getInstance();
        this.mFeatureKitManager = instance;
        instance.setCallBack(iAudioKitCallback);
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public void serviceLinkToDeath(IBinder iBinder) {
        this.mService = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(this.mDeathRecipient, 0);
            } catch (RemoteException unused) {
                this.mFeatureKitManager.onCallBack(5);
                LogUtils.error(TAG, "serviceLinkToDeath, RemoteException");
            }
        }
    }

    public void initialize() {
        LogUtils.info(TAG, "initialize");
        Context context = this.mContext;
        if (context == null) {
            LogUtils.info(TAG, "mContext is null");
            this.mFeatureKitManager.onCallBack(7);
        } else if (!this.mFeatureKitManager.isMediaKitSupport(context)) {
            LogUtils.info(TAG, "not install AudioKitEngine");
            this.mFeatureKitManager.onCallBack(2);
        } else {
            bindService(this.mContext);
        }
    }

    private void bindService(Context context) {
        LogUtils.info(TAG, "bindService, mIsServiceConnected = {}", Boolean.valueOf(this.mIsServiceConnected));
        FeatureKitManager featureKitManager = this.mFeatureKitManager;
        if (featureKitManager != null && !this.mIsServiceConnected) {
            featureKitManager.bindService(context, this.mConnection, ENGINE_CLASS_NAME);
        }
    }

    public void destroy() {
        LogUtils.info(TAG, "destroy, mIsServiceConnected = {}", Boolean.valueOf(this.mIsServiceConnected));
        if (this.mIsServiceConnected) {
            this.mIsServiceConnected = false;
            this.mFeatureKitManager.unbindService(this.mContext, this.mConnection);
        }
    }

    public List<Integer> getSupportedFeatures() {
        LogUtils.info(TAG, "getSupportedFeatures");
        try {
            IHwAudioEngine iHwAudioEngine = this.mIHwAudioEngine;
            if (iHwAudioEngine != null && this.mIsServiceConnected) {
                return iHwAudioEngine.getSupportedFeatures();
            }
        } catch (RemoteException unused) {
            LogUtils.error(TAG, "getSupportedFeatures, createFeature,wait bind service fail");
        }
        LogUtils.info(TAG, "getSupportedFeatures, service not bind");
        return DEFAULT_FEATURE_LIST;
    }

    public boolean isFeatureSupported(FeatureType featureType) {
        LogUtils.info(TAG, "isFeatureSupported, type = {}", Integer.valueOf(featureType.getFeatureType()));
        try {
            IHwAudioEngine iHwAudioEngine = this.mIHwAudioEngine;
            if (iHwAudioEngine != null && this.mIsServiceConnected) {
                return iHwAudioEngine.isFeatureSupported(featureType.getFeatureType());
            }
        } catch (RemoteException e) {
            LogUtils.error(TAG, "isFeatureSupported,RemoteException ex : {}", e.getMessage());
        }
        return false;
    }

    public <T extends AudioFeaturesKit> T createFeature(FeatureType featureType) {
        return this.mFeatureKitManager.createFeatureKit(featureType.getFeatureType(), this.mContext);
    }

    /* access modifiers changed from: private */
    public void serviceInit(String str, String str2) {
        LogUtils.info(TAG, "serviceInit");
        try {
            IHwAudioEngine iHwAudioEngine = this.mIHwAudioEngine;
            if (iHwAudioEngine != null && this.mIsServiceConnected) {
                iHwAudioEngine.init(str, str2);
            }
        } catch (RemoteException e) {
            LogUtils.error(TAG, "isFeatureSupported,RemoteException ex : {}", e.getMessage());
        }
    }
}
