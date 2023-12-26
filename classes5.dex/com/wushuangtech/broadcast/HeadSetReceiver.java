package com.wushuangtech.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.wushuangtech.api.ExternalAudioModule;
import com.wushuangtech.api.ExternalAudioModuleImpl;
import com.wushuangtech.constants.LocalSDKConstants;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;

public class HeadSetReceiver extends BroadcastReceiver {
    private static final int NO_VALUE = -100;
    private static final String TAG = "HSR";
    private static final AudioManager.OnAudioFocusChangeListener mAudioFocusListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int i) {
            AudioManager audioManager = (AudioManager) HeadSetReceiver.mContext.getSystemService("audio");
            try {
                GlobalConfig.mLocalAudioFocus = i;
                if (audioManager == null) {
                    return;
                }
                if (i == -3) {
                    HeadSetReceiver.logI("AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                } else if (i == -2) {
                    HeadSetReceiver.logI("AUDIOFOCUS_LOSS_TRANSIENT");
                    if (GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_DJ || GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_JIUJIU) {
                        ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).pauseAudio();
                    }
                } else if (i == -1) {
                    HeadSetReceiver.logI("AUDIOFOCUS_LOSS");
                    if (GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_DJ || GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_JIUJIU) {
                        ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).pauseAudio();
                    }
                } else if (i == 1) {
                    HeadSetReceiver.logI("AUDIOFOCUS_GAIN");
                    if (GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_DJ || GlobalConfig.mBranch == LocalSDKConstants.BRANCH_CLIENT_JIUJIU) {
                        ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).resumeAudio();
                    }
                    if (HeadSetReceiver.isHeadsetOn(HeadSetReceiver.mContext)) {
                        HeadSetReceiver.logD("Watch SpeakerphoneOn fourth, false");
                        audioManager.setSpeakerphoneOn(false);
                        HeadSetReceiver.reportAudioRouteChange(false);
                        return;
                    }
                    HeadSetReceiver.logD("Watch SpeakerphoneOn fifth, " + HeadSetReceiver.mSpeakerphoneOn);
                    audioManager.setSpeakerphoneOn(HeadSetReceiver.mSpeakerphoneOn);
                    HeadSetReceiver.reportAudioRouteChange(HeadSetReceiver.mSpeakerphoneOn);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };
    private static boolean mBlueHeadSet = false;
    /* access modifiers changed from: private */
    public static Context mContext = null;
    private static boolean mHeadSetMic = false;
    private static boolean mIsFocus = false;
    /* access modifiers changed from: private */
    public static boolean mSpeakerphoneOn = true;
    private boolean mHeadSet = false;

    public static void abandonAudioFocus() {
    }

    public static void requestAudioFocus(Context context) {
    }

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        try {
            String action = intent.getAction();
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            if ("android.intent.action.HEADSET_PLUG".equals(action)) {
                int intExtra = intent.getIntExtra("state", NO_VALUE);
                int intExtra2 = intent.getIntExtra("microphone", NO_VALUE);
                logI("Receive broadcast : ACTION_HEADSET_PLUG, state : " + intExtra);
                if (intExtra != NO_VALUE) {
                    if (intExtra == 1) {
                        this.mHeadSet = true;
                    } else if (intExtra == 0) {
                        this.mHeadSet = false;
                    }
                }
                if (intExtra2 != NO_VALUE) {
                    mHeadSetMic = intExtra2 == 1;
                }
            } else if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                int intExtra3 = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                logI("Receive broadcast : ACTION_CONNECTION_STATE_CHANGED, bluetoothState : " + intExtra3);
                if (intExtra3 == 2) {
                    mBlueHeadSet = true;
                    if (audioManager != null) {
                        audioManager.setBluetoothScoOn(false);
                        audioManager.stopBluetoothSco();
                        audioManager.startBluetoothSco();
                        audioManager.setBluetoothScoOn(true);
                        audioManager.setBluetoothA2dpOn(false);
                    }
                } else if (intExtra3 == 0) {
                    mBlueHeadSet = false;
                    if (audioManager != null) {
                        audioManager.setBluetoothScoOn(false);
                        audioManager.stopBluetoothSco();
                        audioManager.setBluetoothA2dpOn(true);
                    }
                }
            }
            logI("Handle broadcast, HeadSet : " + this.mHeadSet + " | BlueHeadSet : " + mBlueHeadSet);
            if (!this.mHeadSet) {
                if (!mBlueHeadSet) {
                    if (audioManager != null) {
                        logD("Watch SpeakerphoneOn second, " + mSpeakerphoneOn);
                        audioManager.setSpeakerphoneOn(mSpeakerphoneOn);
                        reportAudioRouteChange(mSpeakerphoneOn);
                    }
                    ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).setHeadsetStatus(false);
                    return;
                }
            }
            if (audioManager != null) {
                logD("Watch SpeakerphoneOn first, false!");
                audioManager.setSpeakerphoneOn(false);
                reportAudioRouteChange(false);
            }
            ((ExternalAudioModuleImpl) ExternalAudioModule.getInstance()).setHeadsetStatus(true);
        } catch (Exception e) {
            OmniLog.e(TAG, "onReceive -> exception = " + e.getLocalizedMessage());
        }
    }

    public static void setSpeakerphoneOn(boolean z) {
        mSpeakerphoneOn = z;
    }

    public static void autoSetHeadsetOn(AudioManager audioManager, boolean z) {
        boolean z2;
        boolean z3;
        if (audioManager != null) {
            logI("------autoSetHeadsetOn-------");
            try {
                if (Build.VERSION.SDK_INT < 23) {
                    if (!audioManager.isBluetoothScoOn()) {
                        if (!audioManager.isBluetoothA2dpOn()) {
                            z3 = false;
                            z2 = audioManager.isWiredHeadsetOn();
                        }
                    }
                    z3 = true;
                    z2 = audioManager.isWiredHeadsetOn();
                } else {
                    boolean z4 = false;
                    boolean z5 = false;
                    for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                        logI("AudioDeviceInfo device : " + audioDeviceInfo.getType() + " | " + audioDeviceInfo.getProductName() + " | " + audioDeviceInfo.getType());
                        if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 12 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 22) {
                            z5 = true;
                        }
                        if (audioDeviceInfo.getType() == 7 || audioDeviceInfo.getType() == 8) {
                            z4 = true;
                        }
                    }
                    z3 = z4;
                    z2 = z5;
                }
                logI("blueheadset : " + z3 + " | voip : " + z + " | mSpeakerphoneOn : " + mSpeakerphoneOn);
                mBlueHeadSet = z3;
                boolean z6 = z2 | z3;
                logD("headsetOn : " + z6 + " | isSpeakerphoneOn : " + audioManager.isSpeakerphoneOn());
                if (z || z3) {
                    boolean z7 = !z6 && mSpeakerphoneOn;
                    if (z7 != audioManager.isSpeakerphoneOn()) {
                        logD("Watch SpeakerphoneOn, " + z7);
                        audioManager.setSpeakerphoneOn(z7);
                    }
                    reportAudioRouteChange(z7);
                }
                if (!z3) {
                    return;
                }
                if (z) {
                    audioManager.setBluetoothScoOn(false);
                    audioManager.stopBluetoothSco();
                    audioManager.startBluetoothSco();
                    audioManager.setBluetoothScoOn(true);
                    audioManager.setBluetoothA2dpOn(false);
                    return;
                }
                audioManager.setBluetoothScoOn(false);
                audioManager.stopBluetoothSco();
                audioManager.setBluetoothA2dpOn(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isHeadsetOn(Context context) {
        AudioManager audioManager;
        if (context == null || (audioManager = (AudioManager) context.getSystemService("audio")) == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                for (AudioDeviceInfo audioDeviceInfo : audioManager.getDevices(2)) {
                    if (audioDeviceInfo.getType() == 3 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 12 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 22 || audioDeviceInfo.getType() == 7) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        } else if (audioManager.isWiredHeadsetOn() || audioManager.isBluetoothScoOn() || audioManager.isBluetoothA2dpOn()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isAudioFocus() {
        return mIsFocus;
    }

    public static void reportAudioRouteChange(boolean z) {
        int i;
        boolean isHeadsetOn = isHeadsetOn(mContext);
        if (!z) {
            i = isHeadsetOn ? mBlueHeadSet ? 4 : mHeadSetMic ? 0 : 3 : 2;
        } else {
            i = 1;
        }
        GlobalHolder.getInstance().notifyCHAudioRouteChanged(i);
    }

    public static void reset() {
        mBlueHeadSet = false;
        mSpeakerphoneOn = true;
    }

    /* access modifiers changed from: private */
    public static void logI(String str) {
        OmniLog.aw_i(TAG, str);
    }

    /* access modifiers changed from: private */
    public static void logD(String str) {
        OmniLog.aw_d(TAG, str);
    }
}
