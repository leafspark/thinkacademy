package com.eaydu.omni.core.voiceengine;

import android.content.Context;
import android.media.AudioManager;
import com.eaydu.omni.core.utils.ContextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.wushuangtech.utils.OmniLog;
import java.nio.ByteBuffer;

class WebRtcAudioTrack {
    private static final String TAG = "WebRtcAudioTrack";
    private final AudioManager audioManager;
    private ByteBuffer byteBuffer;
    private final Context context;
    private final long nativeAudioTrack;
    private RtcAudioTrack rtcAudioTrack;

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer2, long j);

    private native void nativeGetPlayoutData(int i, long j);

    WebRtcAudioTrack(long j) {
        OmniLog.d(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        Context applicationContext = ContextUtils.getApplicationContext();
        this.context = applicationContext;
        this.nativeAudioTrack = j;
        this.audioManager = (AudioManager) applicationContext.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
    }

    private boolean initPlayout(int i, int i2, boolean z) {
        RtcAudioTrack rtcAudioTrack2 = new RtcAudioTrack(this.context, this);
        this.rtcAudioTrack = rtcAudioTrack2;
        return rtcAudioTrack2.initPlayout(i, i2, z);
    }

    private boolean startPlayout() {
        RtcAudioTrack rtcAudioTrack2 = this.rtcAudioTrack;
        if (rtcAudioTrack2 != null) {
            return rtcAudioTrack2.startPlayout();
        }
        OmniLog.e(TAG, "rtcAudioTrack null");
        return false;
    }

    private boolean stopPlayout() {
        RtcAudioTrack rtcAudioTrack2 = this.rtcAudioTrack;
        if (rtcAudioTrack2 != null) {
            return rtcAudioTrack2.stopPlayout();
        }
        OmniLog.e(TAG, "rtcAudioTrack null");
        return false;
    }

    /* access modifiers changed from: package-private */
    public void requestAndCacheByteBuffer(int i) {
        this.byteBuffer = ByteBuffer.allocateDirect(i);
        OmniLog.d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioTrack);
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer byteBuffer() {
        return this.byteBuffer;
    }

    /* access modifiers changed from: package-private */
    public void getPlayoutData(int i) {
        nativeGetPlayoutData(i, this.nativeAudioTrack);
    }

    private int getStreamMaxVolume() {
        OmniLog.d(TAG, "getStreamMaxVolume");
        WebRtcAudioUtils.assertTrue(this.audioManager != null);
        return this.audioManager.getStreamMaxVolume(0);
    }

    private boolean setStreamVolume(int i) {
        OmniLog.d(TAG, "setStreamVolume(" + i + ")");
        WebRtcAudioUtils.assertTrue(this.audioManager != null);
        if (isVolumeFixed()) {
            OmniLog.e(TAG, "The device implements a fixed volume policy.");
            return false;
        }
        this.audioManager.setStreamVolume(0, i, 0);
        return true;
    }

    private boolean isVolumeFixed() {
        if (!WebRtcAudioUtils.runningOnLollipopOrHigher()) {
            return false;
        }
        return this.audioManager.isVolumeFixed();
    }

    private int getStreamVolume() {
        OmniLog.d(TAG, "getStreamVolume");
        WebRtcAudioUtils.assertTrue(this.audioManager != null);
        return this.audioManager.getStreamVolume(0);
    }
}
