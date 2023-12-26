package com.eaydu.omni.core.voiceengine;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Build;
import android.os.Process;
import com.eaydu.omni.core.voiceengine.RtcAudioDecision;
import com.wushuangtech.audiocore.MyAudioApi;
import com.wushuangtech.utils.OmniLog;
import java.nio.ByteBuffer;

class RtcAudioRecord {
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int BUFFER_SIZE_FACTOR = 2;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = false;
    private static final int RETRY_WAIT_MS = 200;
    private static final String TAG = "RtcAudioRecord";
    /* access modifiers changed from: private */
    public AudioRecord audioRecord = null;
    private AudioRecordThread audioThread = null;
    private final Context context;
    private long voiceDetectionTimestamp = 0;
    /* access modifiers changed from: private */
    public WebRtcAudioRecord webRtcAudioRecord;

    RtcAudioRecord(Context context2, WebRtcAudioRecord webRtcAudioRecord2) {
        OmniLog.aw_i(TAG, "ctor" + WebRtcAudioUtils.getThreadInfo());
        this.context = context2;
        this.webRtcAudioRecord = webRtcAudioRecord2;
    }

    /* access modifiers changed from: package-private */
    public int initRecording(int i, int i2, boolean z) {
        OmniLog.aw_i(TAG, "Init audio capture... ");
        RtcAudioStatus.recChannels = i2;
        RtcAudioStatus.recSampleRate = i;
        int i3 = i2 == 2 ? 12 : 16;
        if (!WebRtcAudioUtils.hasPermission(this.context, "android.permission.RECORD_AUDIO")) {
            OmniLog.aw_e(TAG, "RECORD_AUDIO permission is missing");
            MyAudioApi.getInstance().reportAudioRecordError(12);
            return -1;
        } else if (this.audioRecord != null) {
            OmniLog.aw_e(TAG, "InitRecording() called twice without StopRecording()");
            MyAudioApi.getInstance().reportAudioRecordError(1);
            releaseAudioResources();
            return -1;
        } else {
            int i4 = i / 100;
            this.webRtcAudioRecord.requestAndCacheByteBuffer(i2 * 2 * i4);
            int minBufferSize = AudioRecord.getMinBufferSize(i, i3, 2);
            if (minBufferSize == -1 || minBufferSize == -2) {
                OmniLog.aw_e(TAG, "AudioRecord.getMinBufferSize failed: " + minBufferSize);
                MyAudioApi.getInstance().reportAudioRecordError(2);
                return -1;
            }
            OmniLog.aw_i(TAG, "AudioRecord.getMinBufferSize: " + minBufferSize);
            int max = Math.max(minBufferSize * 2, this.webRtcAudioRecord.byteBuffer().capacity());
            OmniLog.aw_i(TAG, "bufferSizeInBytes: " + max);
            RtcAudioDecision.getInstance(RtcAudioDecision.DecisionType.Momo).chooseRecAudioSource(z);
            OmniLog.aw_i(TAG, "initRecording(sampleRate=" + i + ", channels=" + i2 + ", use_voip=" + z + ", audioSource=" + RtcAudioStatus.recAudioSource + ")");
            try {
                AudioRecord audioRecord2 = new AudioRecord(RtcAudioStatus.recAudioSource, i, i3, 2, max);
                this.audioRecord = audioRecord2;
                if (audioRecord2.getState() != 1) {
                    OmniLog.aw_e(TAG, "Failed to create a new AudioRecord instance");
                    MyAudioApi.getInstance().reportAudioRecordError(3);
                    releaseAudioResources();
                    return -1;
                }
                OmniLog.aw_i(TAG, "AudioRecord session ID: " + this.audioRecord.getAudioSessionId() + ", audio format: " + this.audioRecord.getAudioFormat() + ", channels: " + this.audioRecord.getChannelCount() + ", sample rate: " + this.audioRecord.getSampleRate());
                if (!(this.webRtcAudioRecord.effects() == null || RtcAudioStatus.recordMode() == 1)) {
                    this.webRtcAudioRecord.effects().enable(this.audioRecord.getAudioSessionId());
                }
                return i4;
            } catch (IllegalArgumentException e) {
                OmniLog.e(TAG, e.getMessage());
                MyAudioApi.getInstance().reportAudioRecordError(13);
                releaseAudioResources();
                return -1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean startRecording() {
        OmniLog.aw_i(TAG, "Start audio capture... ");
        try {
            WebRtcAudioUtils.assertTrue(this.audioRecord != null);
            WebRtcAudioUtils.assertTrue(this.audioThread == null);
            RtcAudioStatus.isCapturing = true;
            this.audioRecord.startRecording();
            int i = 0;
            while (this.audioRecord.getRecordingState() != 3 && (i = i + 1) < 2) {
                threadSleep(200);
            }
            if (this.audioRecord.getRecordingState() != 3) {
                OmniLog.aw_e(TAG, "AudioRecord.startRecording failed");
                MyAudioApi.getInstance().reportAudioRecordError(5);
                return false;
            }
            try {
                AudioRecordThread audioRecordThread = new AudioRecordThread("AudioRecordJavaThread");
                this.audioThread = audioRecordThread;
                audioRecordThread.start();
                MyAudioApi.getInstance().reportAudioRecordError(0);
                return true;
            } catch (IllegalThreadStateException unused) {
                OmniLog.aw_e(TAG, "build AudioRecordThread failed");
                MyAudioApi.getInstance().reportAudioRecordError(11);
                return false;
            }
        } catch (IllegalStateException e) {
            OmniLog.aw_e(TAG, "AudioRecord.startRecording failed: " + e.getMessage());
            MyAudioApi.getInstance().reportAudioRecordError(4);
            return false;
        } catch (AssertionError e2) {
            OmniLog.aw_e(TAG, "AudioRecord.startRecording failed: " + e2.getMessage());
            MyAudioApi.getInstance().reportAudioRecordError(4);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean stopRecording() {
        OmniLog.aw_i(TAG, "Stop audio capture... ");
        if (this.audioThread == null) {
            OmniLog.aw_e(TAG, "AudioRecord.stopRecording audioThread == null");
            return false;
        }
        RtcAudioStatus.isCapturing = false;
        this.audioThread.joinThread();
        this.audioThread = null;
        releaseAudioResources();
        return true;
    }

    private void releaseAudioResources() {
        AudioRecord audioRecord2 = this.audioRecord;
        if (audioRecord2 != null) {
            audioRecord2.release();
            this.audioRecord = null;
        }
        this.webRtcAudioRecord.releaseAudioResources();
    }

    private void threadSleep(long j) {
        try {
            Thread.sleep(j);
        } catch (Exception e) {
            OmniLog.aw_e(TAG, "Thread.sleep failed: " + e.getMessage());
        }
    }

    private int chooseRecAudioSource(boolean z) {
        if (Build.VERSION.SDK_INT <= 19 || WebRtcAudioUtils.isBlackListedVoiceCommunication() || RtcAudioStatus.recServerForceDisableUseVoip || (!RtcAudioStatus.forceRecUseVoip && RtcAudioStatus.headsetOn)) {
            z = false;
        }
        if (z) {
            return 7;
        }
        return RtcAudioStatus.headsetOn ? 1 : 6;
    }

    private class AudioRecordThread extends Thread {
        private volatile boolean keepAlive = true;
        private int recErrorCount = 0;

        AudioRecordThread(String str) {
            super(str);
        }

        public void run() {
            Process.setThreadPriority(-19);
            OmniLog.aw_i(RtcAudioRecord.TAG, "Start audio capture thread... " + WebRtcAudioUtils.getThreadInfo() + " keepAlive:" + this.keepAlive);
            WebRtcAudioUtils.assertTrue(RtcAudioRecord.this.audioRecord.getRecordingState() == 3);
            System.nanoTime();
            while (this.keepAlive) {
                ByteBuffer byteBuffer = RtcAudioRecord.this.webRtcAudioRecord.byteBuffer();
                int read = RtcAudioRecord.this.audioRecord.read(byteBuffer, byteBuffer.capacity());
                if (read == byteBuffer.capacity()) {
                    MyAudioApi.getInstance().writeAudioLocalPcmData(byteBuffer);
                    RtcAudioStatus.recDataSizeInBytes += (long) read;
                    RtcAudioRecord.this.webRtcAudioRecord.notifyDataRecorded(read);
                } else {
                    OmniLog.aw_e(RtcAudioRecord.TAG, "Read audio data failed: " + read);
                    if (this.recErrorCount % 100 == 0) {
                        MyAudioApi.getInstance().reportAudioRecordError(6);
                        this.recErrorCount++;
                    }
                    if (read == -3) {
                        this.keepAlive = false;
                    }
                }
            }
            try {
                RtcAudioRecord.this.audioRecord.stop();
            } catch (IllegalStateException e) {
                OmniLog.aw_e(RtcAudioRecord.TAG, "AudioRecord.stop failed: " + e.getMessage());
                MyAudioApi.getInstance().reportAudioRecordError(7);
            }
        }

        /* access modifiers changed from: package-private */
        public void joinThread() {
            this.keepAlive = false;
            while (isAlive()) {
                try {
                    join();
                } catch (InterruptedException unused) {
                    MyAudioApi.getInstance().reportAudioRecordError(8);
                }
            }
        }
    }
}
