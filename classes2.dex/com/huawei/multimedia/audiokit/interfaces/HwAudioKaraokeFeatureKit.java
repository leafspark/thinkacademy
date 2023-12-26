package com.huawei.multimedia.audiokit.interfaces;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.multimedia.audioengine.IHwAudioKaraokeFeature;
import com.huawei.multimedia.audiokit.config.ResultCode;
import com.huawei.multimedia.audiokit.utils.LogUtils;

public class HwAudioKaraokeFeatureKit extends AudioFeaturesKit {
    private static final String ENGINE_CLASS_NAME = "com.huawei.multimedia.audioengine.HwAudioKaraokeFeatureService";
    private static final String TAG = "HwAudioKit.HwAudioKaraokeFeatureKit";
    private ServiceConnection mConnection;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public IBinder.DeathRecipient mDeathRecipient;
    /* access modifiers changed from: private */
    public FeatureKitManager mFeatureKitManager;
    /* access modifiers changed from: private */
    public IHwAudioKaraokeFeature mIHwAudioKaraokeFeatureAidl;
    /* access modifiers changed from: private */
    public boolean mIsServiceConnected;
    /* access modifiers changed from: private */
    public IBinder mService;

    public enum ParameName {
        CMD_SET_AUDIO_EFFECT_MODE_BASE("Karaoke_reverb_mode="),
        CMD_SET_VOCAL_VOLUME_BASE("Karaoke_volume="),
        CMD_SET_VOCAL_EQUALIZER_MODE("Karaoke_eq_mode=");
        
        private String mParameName;

        private ParameName(String str) {
            this.mParameName = str;
        }

        public String getParameName() {
            return this.mParameName;
        }
    }

    protected HwAudioKaraokeFeatureKit(Context context) {
        this.mFeatureKitManager = null;
        this.mIsServiceConnected = false;
        this.mService = null;
        this.mConnection = new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                LogUtils.info(HwAudioKaraokeFeatureKit.TAG, "onServiceConnected");
                IHwAudioKaraokeFeature unused = HwAudioKaraokeFeatureKit.this.mIHwAudioKaraokeFeatureAidl = IHwAudioKaraokeFeature.Stub.asInterface(iBinder);
                if (HwAudioKaraokeFeatureKit.this.mIHwAudioKaraokeFeatureAidl != null) {
                    boolean unused2 = HwAudioKaraokeFeatureKit.this.mIsServiceConnected = true;
                    HwAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(ResultCode.KARAOKE_SUCCESS);
                    HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = HwAudioKaraokeFeatureKit.this;
                    hwAudioKaraokeFeatureKit.serviceInit(hwAudioKaraokeFeatureKit.mContext.getPackageName());
                    HwAudioKaraokeFeatureKit.this.serviceLinkToDeath(iBinder);
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                LogUtils.info(HwAudioKaraokeFeatureKit.TAG, "onServiceDisconnected");
                boolean unused = HwAudioKaraokeFeatureKit.this.mIsServiceConnected = false;
                if (HwAudioKaraokeFeatureKit.this.mFeatureKitManager != null) {
                    HwAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1001);
                }
            }
        };
        this.mDeathRecipient = new IBinder.DeathRecipient() {
            public void binderDied() {
                LogUtils.error(HwAudioKaraokeFeatureKit.TAG, "binderDied");
                HwAudioKaraokeFeatureKit.this.mService.unlinkToDeath(HwAudioKaraokeFeatureKit.this.mDeathRecipient, 0);
                HwAudioKaraokeFeatureKit.this.mFeatureKitManager.onCallBack(1003);
                IBinder unused = HwAudioKaraokeFeatureKit.this.mService = null;
            }
        };
        this.mFeatureKitManager = FeatureKitManager.getInstance();
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public void serviceLinkToDeath(IBinder iBinder) {
        this.mService = iBinder;
        if (iBinder != null) {
            try {
                iBinder.linkToDeath(this.mDeathRecipient, 0);
            } catch (RemoteException unused) {
                this.mFeatureKitManager.onCallBack(1002);
                LogUtils.error(TAG, "serviceLinkToDeath, RemoteException");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initialize(Context context) {
        LogUtils.info(TAG, "initialize");
        if (context == null) {
            LogUtils.info(TAG, "initialize, context is null");
        } else if (!this.mFeatureKitManager.isMediaKitSupport(context)) {
            this.mFeatureKitManager.onCallBack(2);
            LogUtils.info(TAG, "initialize, not install AudioEngine");
        } else {
            bindService(context);
        }
    }

    private void bindService(Context context) {
        LogUtils.info(TAG, "bindService");
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

    public boolean isKaraokeFeatureSupport() {
        LogUtils.info(TAG, "isKaraokeFeatureSupport");
        try {
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature != null && this.mIsServiceConnected) {
                return iHwAudioKaraokeFeature.isKaraokeFeatureSupport();
            }
        } catch (RemoteException e) {
            LogUtils.error(TAG, "isFeatureSupported,RemoteException ex : {}", e.getMessage());
        }
        return false;
    }

    public int enableKaraokeFeature(boolean z) {
        LogUtils.info(TAG, "enableKaraokeFeature, enable = {}", Boolean.valueOf(z));
        try {
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature == null || !this.mIsServiceConnected) {
                return -2;
            }
            return iHwAudioKaraokeFeature.enableKaraokeFeature(z);
        } catch (RemoteException e) {
            LogUtils.error(TAG, "enableKaraokeFeature,RemoteException ex : {}", e.getMessage());
            return -2;
        }
    }

    public int getKaraokeLatency() {
        LogUtils.info(TAG, "getKaraokeLatency");
        try {
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature == null || !this.mIsServiceConnected) {
                return -1;
            }
            return iHwAudioKaraokeFeature.getKaraokeLatency();
        } catch (RemoteException e) {
            LogUtils.error(TAG, "getKaraokeLatency,RemoteException ex : {}", e.getMessage());
            return -1;
        }
    }

    public int setParameter(ParameName parameName, int i) {
        try {
            LogUtils.info(TAG, "parame.getParameName() = {}, parameValue = {}", parameName.getParameName(), Integer.valueOf(i));
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature == null || !this.mIsServiceConnected) {
                return -2;
            }
            return iHwAudioKaraokeFeature.setParameter(parameName.getParameName(), i);
        } catch (RemoteException e) {
            LogUtils.error(TAG, "setParameter,RemoteException ex : {}", e.getMessage());
            return -2;
        }
    }

    /* access modifiers changed from: private */
    public void serviceInit(String str) {
        try {
            IHwAudioKaraokeFeature iHwAudioKaraokeFeature = this.mIHwAudioKaraokeFeatureAidl;
            if (iHwAudioKaraokeFeature != null && this.mIsServiceConnected) {
                iHwAudioKaraokeFeature.init(str);
            }
        } catch (RemoteException e) {
            LogUtils.error(TAG, "isFeatureSupported,RemoteException ex : {}", e.getMessage());
        }
    }
}
