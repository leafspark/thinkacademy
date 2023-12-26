package com.wushuangtech.api;

import com.wushuangtech.api.ExternalVideoModuleCallback;
import java.lang.ref.WeakReference;

public class AVRecorderModule {
    private AudioSender mAudioSender;
    private WeakReference<AVRecorderModuleCallback> mCallback;
    private boolean mInited;
    private boolean mRecording;

    private native boolean Initialize(AVRecorderModule aVRecorderModule);

    private native boolean StartRecorde(String str);

    private native boolean StopRecorde();

    private native void Uninitialize();

    /* access modifiers changed from: private */
    public native void WriteEncodedAudioData(byte[] bArr, int i);

    private native void WriteEncodedVideoData(byte[] bArr, int i, int i2, int i3, int i4);

    public boolean init() {
        boolean Initialize = Initialize(this);
        this.mInited = Initialize;
        return Initialize;
    }

    public void unInit() {
        if (this.mInited) {
            Uninitialize();
        }
    }

    public void setAVRecorderModuleCallback(AVRecorderModuleCallback aVRecorderModuleCallback) {
        this.mCallback = new WeakReference<>(aVRecorderModuleCallback);
    }

    public void pushEncodedVideoData(byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, int i, int i2, int i3) {
        WriteEncodedVideoData(bArr, bArr.length, videoFrameType == ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I ? 1 : 0, i, i2);
    }

    public boolean startRecorde(String str) {
        if (!this.mInited) {
            return false;
        }
        if (this.mRecording) {
            return true;
        }
        if (!StartRecorde(str)) {
            return false;
        }
        this.mAudioSender = new LocalAudioSenderImpl(this);
        this.mRecording = true;
        return true;
    }

    public boolean stopRecorde() {
        if (!this.mInited) {
            return false;
        }
        if (!this.mRecording) {
            return true;
        }
        StopRecorde();
        this.mAudioSender = null;
        this.mRecording = false;
        return true;
    }

    private void RecordeStatus(int i) {
        AVRecorderModuleCallback aVRecorderModuleCallback;
        WeakReference<AVRecorderModuleCallback> weakReference = this.mCallback;
        if (weakReference != null && (aVRecorderModuleCallback = (AVRecorderModuleCallback) weakReference.get()) != null) {
            aVRecorderModuleCallback.recordeStatus(i);
        }
    }

    private static class LocalAudioSenderImpl implements AudioSender {
        private final WeakReference<AVRecorderModule> mOutReference;

        public void SetAudioFractionLoss(int i) {
        }

        public void sendNACKData(byte[] bArr, int i, long j) {
        }

        public void sendRTCPData(byte[] bArr, int i, long j) {
        }

        public LocalAudioSenderImpl(AVRecorderModule aVRecorderModule) {
            this.mOutReference = new WeakReference<>(aVRecorderModule);
        }

        public void pushEncodedAudioData(byte[] bArr) {
            AVRecorderModule aVRecorderModule = (AVRecorderModule) this.mOutReference.get();
            if (aVRecorderModule != null) {
                aVRecorderModule.WriteEncodedAudioData(bArr, bArr.length);
            }
        }
    }
}
