package com.wushuangtech.broadcast;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.PhoneStateListener;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;

public class PhoneListener extends PhoneStateListener {
    private static final String TAG = "PhoneListener";

    public void onCallStateChanged(int i, String str) {
        boolean z = true;
        if (i == 0) {
            String str2 = TAG;
            OmniLog.aw_i(str2, "Phone stats change to CALL_STATE_IDLE");
            Context context = GlobalHolder.getInstance().getContext();
            if (context != null) {
                try {
                    AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                    if (audioManager != null) {
                        if (HeadSetReceiver.isHeadsetOn(context)) {
                            z = false;
                        }
                        OmniLog.aw_i(str2, "isHeadsetOn: " + z);
                        audioManager.setSpeakerphoneOn(z);
                        HeadSetReceiver.reportAudioRouteChange(z);
                    }
                } catch (Exception e) {
                    String str3 = TAG;
                    OmniLog.aw_i(str3, "onCallStateChanged.CALL_STATE_IDLE exception : " + e.getLocalizedMessage());
                }
            }
        } else if (i == 1) {
            OmniLog.aw_i(TAG, "Phone stats change to CALL_STATE_RINGING");
        } else if (i == 2) {
            OmniLog.aw_i(TAG, "Phone stats change to CALL_STATE_OFFHOOK");
        }
    }
}
