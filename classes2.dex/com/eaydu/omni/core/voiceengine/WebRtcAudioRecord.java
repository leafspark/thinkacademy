package com.eaydu.omni.core.voiceengine;

import android.content.Context;
import android.media.AudioManager;
import com.eaydu.omni.core.utils.ContextUtils;
import com.luck.picture.lib.config.PictureMimeType;
import com.wushuangtech.utils.OmniLog;
import java.nio.ByteBuffer;

class WebRtcAudioRecord {
    private static final String TAG = "WebRtcAudioRecord";
    private ByteBuffer byteBuffer;
    private final Context context;
    private WebRtcAudioEffects effects = WebRtcAudioEffects.create();
    private final long nativeAudioRecord;
    private RtcAudioRecord rtcAudioRecord;

    private native void nativeCacheDirectBufferAddress(ByteBuffer byteBuffer2, long j);

    private native void nativeDataIsRecorded(int i, long j);

    WebRtcAudioRecord(long j) {
        Context applicationContext = ContextUtils.getApplicationContext();
        this.context = applicationContext;
        this.nativeAudioRecord = j;
        RtcAudioStatus.audioManager = (AudioManager) applicationContext.getSystemService(PictureMimeType.MIME_TYPE_PREFIX_AUDIO);
    }

    private boolean enableBuiltInAEC(boolean z) {
        if (RtcAudioStatus.isForceDisableBuiltInAec() || RtcAudioStatus.recordMode() == 1) {
            return false;
        }
        OmniLog.aw_i(TAG, "enableBuiltInAEC(" + z + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setAEC(z);
        }
        OmniLog.aw_e(TAG, "Built-in AEC is not supported on this platform");
        return false;
    }

    private boolean enableBuiltInAGC(boolean z) {
        if (RtcAudioStatus.recServerForceDisableBuiltInAgc || RtcAudioStatus.recordMode() == 1) {
            return false;
        }
        OmniLog.aw_d(TAG, "enableBuiltInAGC(" + z + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setAGC(z);
        }
        OmniLog.aw_e(TAG, "Built-in AGC is not supported on this platform");
        return false;
    }

    private boolean enableBuiltInNS(boolean z) {
        if (RtcAudioStatus.isForceDisableBuiltInAec() || RtcAudioStatus.recServerForceDisableBuiltInNs || RtcAudioStatus.recordMode() == 1) {
            return false;
        }
        OmniLog.aw_d(TAG, "enableBuiltInNS(" + z + ')');
        WebRtcAudioEffects webRtcAudioEffects = this.effects;
        if (webRtcAudioEffects != null) {
            return webRtcAudioEffects.setNS(z);
        }
        OmniLog.aw_e(TAG, "Built-in NS is not supported on this platform");
        return false;
    }

    private int initRecording(int i, int i2, boolean z) {
        if (this.rtcAudioRecord != null) {
            OmniLog.aw_e(TAG, "recAudioRecord not null");
        }
        RtcAudioRecord rtcAudioRecord2 = new RtcAudioRecord(this.context, this);
        this.rtcAudioRecord = rtcAudioRecord2;
        return rtcAudioRecord2.initRecording(i, i2, z);
    }

    private boolean startRecording() {
        RtcAudioRecord rtcAudioRecord2 = this.rtcAudioRecord;
        if (rtcAudioRecord2 != null) {
            return rtcAudioRecord2.startRecording();
        }
        OmniLog.aw_e(TAG, "recAudioRecord null");
        return false;
    }

    private boolean stopRecording() {
        RtcAudioRecord rtcAudioRecord2 = this.rtcAudioRecord;
        if (rtcAudioRecord2 == null) {
            OmniLog.aw_e(TAG, "recAudioRecord null");
            return false;
        }
        boolean stopRecording = rtcAudioRecord2.stopRecording();
        this.rtcAudioRecord = null;
        return stopRecording;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer byteBuffer() {
        return this.byteBuffer;
    }

    /* access modifiers changed from: package-private */
    public WebRtcAudioEffects effects() {
        return this.effects;
    }

    /* access modifiers changed from: package-private */
    public void releaseAudioResources() {
        if (effects() != null) {
            effects().release();
        }
    }

    /* access modifiers changed from: package-private */
    public void requestAndCacheByteBuffer(int i) {
        this.byteBuffer = ByteBuffer.allocateDirect(i);
        OmniLog.aw_d(TAG, "byteBuffer.capacity: " + this.byteBuffer.capacity());
        nativeCacheDirectBufferAddress(this.byteBuffer, this.nativeAudioRecord);
    }

    /* access modifiers changed from: package-private */
    public void notifyDataRecorded(int i) {
        nativeDataIsRecorded(i, this.nativeAudioRecord);
    }
}
