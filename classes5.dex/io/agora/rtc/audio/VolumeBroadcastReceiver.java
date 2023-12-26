package io.agora.rtc.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.lang.ref.WeakReference;

public class VolumeBroadcastReceiver extends BroadcastReceiver {
    private WeakReference<AudioDevice> mAudioDevice;

    public VolumeBroadcastReceiver(AudioDevice audioDevice) {
        this.mAudioDevice = new WeakReference<>(audioDevice);
    }

    public void onReceive(Context context, Intent intent) {
        PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
        AudioDevice audioDevice = (AudioDevice) this.mAudioDevice.get();
        if (audioDevice != null) {
            audioDevice.notifyPlayoutVolumeChange();
        }
    }
}
