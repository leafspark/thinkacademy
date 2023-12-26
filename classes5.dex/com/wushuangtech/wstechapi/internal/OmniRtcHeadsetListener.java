package com.wushuangtech.wstechapi.internal;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Process;
import android.os.SystemClock;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.wushuangtech.audiocore.MyAudioApi;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import com.wushuangtech.wstechapi.OmniRtcEngine;

class OmniRtcHeadsetListener {
    /* access modifiers changed from: private */
    public static final String TAG = "OmniRtcHeadsetListener";
    /* access modifiers changed from: private */
    public boolean isBluetoothHeadsetConnected;
    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    private Context mContext;
    private HeadsetListenerBroadcast mHeadsetListenerBroadcast;
    private int mLastAudioRoute;
    private OmniRtcEngine mOmniRtcEngine;

    private void controlAudioSpeaker(String str, AudioManager audioManager, Boolean bool) {
    }

    OmniRtcHeadsetListener(Context context, OmniRtcEngine omniRtcEngine) {
        BluetoothAdapter bluetoothAdapter;
        this.mContext = context;
        this.mOmniRtcEngine = omniRtcEngine;
        recordLastAudioRoute("onCreate");
        String str = TAG;
        OmniLog.i(str, "oncreate mLastAudioRoute: " + this.mLastAudioRoute + " | mIsSpeakerphoneEnabled : " + GlobalConfig.mIsSpeakerphoneEnabled + " | mDefaultAudioRoute : " + GlobalConfig.mDefaultAudioRoute);
        if (selfPermissionGranted(context, "android.permission.BLUETOOTH") && (bluetoothAdapter = this.mBluetoothAdapter) != null && bluetoothAdapter.isEnabled() && this.mBluetoothAdapter.getProfileConnectionState(1) == 2) {
            this.isBluetoothHeadsetConnected = true;
        }
    }

    public void setmLastAudioRoute(int i) {
        this.mLastAudioRoute = i;
    }

    /* access modifiers changed from: package-private */
    public void registerReceiver() {
        this.mHeadsetListenerBroadcast = new HeadsetListenerBroadcast();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        this.mContext.registerReceiver(this.mHeadsetListenerBroadcast, intentFilter);
    }

    /* access modifiers changed from: package-private */
    public void unregisterReceiver() {
        try {
            HeadsetListenerBroadcast headsetListenerBroadcast = this.mHeadsetListenerBroadcast;
            if (headsetListenerBroadcast != null) {
                this.mContext.unregisterReceiver(headsetListenerBroadcast);
            }
        } catch (Exception e) {
            String str = TAG;
            OmniLog.w(str, "unregisterReceiver -- unregist failed!! trace : " + e.getLocalizedMessage());
        }
    }

    /* access modifiers changed from: package-private */
    public void headsetAndBluetoothHeadsetHandle() {
        BluetoothAdapter bluetoothAdapter;
        AudioManager audioManager = (AudioManager) this.mContext.getSystemService("audio");
        GlobalHolder instance = GlobalHolder.getInstance();
        if (instance == null) {
            OmniLog.e(TAG, "headsetAndBluetoothHeadsetHandle -> GlobalHolder is null!");
        } else if (audioManager.isWiredHeadsetOn()) {
            recordLastAudioRoute("有线耳机");
            if (GlobalConfig.mIsSpeakerphoneEnabled) {
                controlAudioSpeaker("切换到了有线耳机，但强制扬声器输出", audioManager, true);
                MyAudioApi.getInstance((Context) null).setHeadsetStatus(false);
                instance.notifyCHAudioRouteChanged(1);
                OmniLog.i(TAG, "切换到了有线耳机，但强制扬声器输出");
                return;
            }
            controlAudioSpeaker("切换到了有线耳机", audioManager, false);
            MyAudioApi.getInstance((Context) null).setHeadsetStatus(true);
            instance.notifyCHAudioRouteChanged(0);
            OmniLog.i(TAG, "切换到了有线耳机");
        } else if (this.isBluetoothHeadsetConnected && !audioManager.isBluetoothA2dpOn()) {
            SystemClock.sleep(500);
            recordLastAudioRoute("SCO链路蓝牙耳机");
            if (GlobalConfig.mIsSpeakerphoneEnabled) {
                controlAudioSpeaker("切换到SCO链路蓝牙耳机，但强制扬声器输出", audioManager, true);
                MyAudioApi.getInstance((Context) null).setHeadsetStatus(false);
                instance.notifyCHAudioRouteChanged(1);
                OmniLog.i(TAG, "切换到SCO链路蓝牙耳机，但强制扬声器输出");
                return;
            }
            controlAudioSpeaker("切换到SCO链路蓝牙耳机，扬声器关闭", audioManager, false);
            audioManager.startBluetoothSco();
            audioManager.setBluetoothScoOn(true);
            MyAudioApi.getInstance((Context) null).setHeadsetStatus(true);
            instance.notifyCHAudioRouteChanged(0);
            OmniLog.i(TAG, "切换到SCO链路蓝牙耳机，扬声器关闭");
        } else if (this.isBluetoothHeadsetConnected && audioManager.isBluetoothA2dpOn()) {
            recordLastAudioRoute("A2DP蓝牙耳机");
            if (GlobalConfig.mIsSpeakerphoneEnabled) {
                controlAudioSpeaker("切换到SCO链路蓝牙耳机，扬声器关闭", audioManager, true);
                MyAudioApi.getInstance((Context) null).setHeadsetStatus(false);
                instance.notifyCHAudioRouteChanged(1);
                OmniLog.i(TAG, "切换到了ACL链路的A2DP蓝牙耳机，但强制扬声器输出");
                return;
            }
            instance.setBluetoothAudioMode("headsetAndBluetoothHeadsetHandle", audioManager, true);
            controlAudioSpeaker("切换到了ACL链路的A2DP蓝牙耳机，扬声器关闭", audioManager, false);
            audioManager.startBluetoothSco();
            audioManager.setBluetoothScoOn(true);
            MyAudioApi.getInstance((Context) null).setHeadsetStatus(true);
            instance.notifyCHAudioRouteChanged(0);
            OmniLog.i(TAG, "切换到了ACL链路的A2DP蓝牙耳机，扬声器关闭");
        } else if (!selfPermissionGranted(this.mContext, "android.permission.BLUETOOTH") || (bluetoothAdapter = this.mBluetoothAdapter) == null || !bluetoothAdapter.isEnabled() || this.mBluetoothAdapter.getProfileConnectionState(1) != 2) {
            instance.setBluetoothAudioMode("headsetAndBluetoothHeadsetHandle 3", audioManager, false);
            MyAudioApi.getInstance((Context) null).setHeadsetStatus(false);
            String str = TAG;
            OmniLog.i(str, "else audio mBluetoothAdapter : " + this.mBluetoothAdapter + " | isBluetoothHeadsetConnected : " + this.isBluetoothHeadsetConnected);
            if (audioManager.isBluetoothScoOn()) {
                OmniLog.i(str, "else stop stopBluetoothSco!");
                audioManager.stopBluetoothSco();
                audioManager.setBluetoothScoOn(false);
            }
            if (this.mLastAudioRoute == 1) {
                this.mOmniRtcEngine.setEnableSpeakerphone(true);
                instance.notifyCHAudioRouteChanged(1);
                OmniLog.i(str, "audio -> 默认音频路由扬声器!");
            } else {
                OmniLog.i(str, "audio -> 默认音频路由听筒!");
                this.mOmniRtcEngine.setEnableSpeakerphone(false);
                instance.notifyCHAudioRouteChanged(2);
            }
            this.mLastAudioRoute = GlobalConfig.mDefaultAudioRoute;
            OmniLog.i(str, "else mLastAudioRoute: " + this.mLastAudioRoute);
        } else {
            recordLastAudioRoute("蓝牙耳机");
            controlAudioSpeaker("蓝牙耳机，扬声器关闭", audioManager, false);
            MyAudioApi.getInstance((Context) null).setHeadsetStatus(true);
            if (!audioManager.isBluetoothA2dpOn()) {
                OmniLog.i(TAG, "切换到SCO链路蓝牙耳机 ， 扬声器关闭");
                audioManager.startBluetoothSco();
                audioManager.setBluetoothScoOn(true);
                return;
            }
            instance.setBluetoothAudioMode("headsetAndBluetoothHeadsetHandle 2", audioManager, true);
            OmniLog.i(TAG, "切换到了ACL链路的A2DP蓝牙耳机 ， 扬声器关闭");
        }
    }

    private void recordLastAudioRoute(String str) {
        if (GlobalConfig.mIsSpeakerphoneEnabled) {
            this.mLastAudioRoute = 1;
            String str2 = TAG;
            OmniLog.i(str2, str + "-> recordLastAudioRoute audio -> AUDIO_ROUTE_SPEAKER!");
            return;
        }
        this.mLastAudioRoute = 2;
        String str3 = TAG;
        OmniLog.i(str3, str + "-> recordLastAudioRoute audio -> AUDIO_ROUTE_HEADPHONE!");
    }

    class HeadsetListenerBroadcast extends BroadcastReceiver {
        HeadsetListenerBroadcast() {
        }

        public void onReceive(Context context, Intent intent) {
            PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
            String action = intent.getAction();
            if ("android.intent.action.HEADSET_PLUG".equals(action)) {
                if (intent.hasExtra("state")) {
                    int intExtra = intent.getIntExtra("state", 0);
                    if (intExtra == 1) {
                        OmniLog.i(OmniRtcHeadsetListener.TAG, "插入耳机");
                        OmniRtcHeadsetListener.this.headsetAndBluetoothHeadsetHandle();
                    } else if (intExtra == 0) {
                        OmniLog.i(OmniRtcHeadsetListener.TAG, "拔出耳机");
                        OmniRtcHeadsetListener.this.headsetAndBluetoothHeadsetHandle();
                    }
                }
            } else if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(action)) {
                int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
                if (intExtra2 == 2) {
                    boolean unused = OmniRtcHeadsetListener.this.isBluetoothHeadsetConnected = true;
                    OmniLog.i(OmniRtcHeadsetListener.TAG, "蓝牙耳机已连接");
                    OmniRtcHeadsetListener.this.headsetAndBluetoothHeadsetHandle();
                } else if (intExtra2 == 0) {
                    OmniLog.i(OmniRtcHeadsetListener.TAG, "蓝牙耳机已断开");
                    boolean unused2 = OmniRtcHeadsetListener.this.isBluetoothHeadsetConnected = false;
                    OmniRtcHeadsetListener.this.headsetAndBluetoothHeadsetHandle();
                }
            }
        }
    }

    private boolean selfPermissionGranted(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
