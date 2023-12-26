package com.eaydu.omni.core.voiceengine;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Process;
import com.wushuangtech.audiocore.MyAudioApi;
import com.wushuangtech.utils.OmniLog;
import java.nio.ByteBuffer;

class RtcAudioTrack {
    private static final int BITS_PER_SAMPLE = 16;
    private static final int BUFFERS_PER_SECOND = 100;
    private static final int CALLBACK_BUFFER_SIZE_MS = 10;
    private static final boolean DEBUG = false;
    private static final String TAG = "RtcAudioTrack";
    private AudioTrackThread audioThread;
    /* access modifiers changed from: private */
    public AudioTrack audioTrack = null;
    /* access modifiers changed from: private */
    public WebRtcAudioTrack webRtcAudioTrack;

    private class AudioTrackThread extends Thread {
        private volatile boolean keepAlive;
        private long last_ts;

        private AudioTrackThread(String str) {
            super(str);
            this.keepAlive = true;
            this.last_ts = 0;
        }

        public void run() {
            int i;
            Process.setThreadPriority(-19);
            OmniLog.aw_d(RtcAudioTrack.TAG, "AudioTrackThread" + WebRtcAudioUtils.getThreadInfo());
            try {
                RtcAudioTrack.this.audioTrack.play();
                boolean z = true;
                WebRtcAudioUtils.assertTrue(RtcAudioTrack.this.audioTrack.getPlayState() == 3);
                ByteBuffer byteBuffer = RtcAudioTrack.this.webRtcAudioTrack.byteBuffer();
                int capacity = byteBuffer.capacity();
                while (this.keepAlive) {
                    long nanoTime = System.nanoTime();
                    RtcAudioTrack.this.webRtcAudioTrack.getPlayoutData(capacity);
                    this.last_ts = nanoTime;
                    WebRtcAudioUtils.assertTrue(capacity <= byteBuffer.remaining());
                    if (WebRtcAudioUtils.runningOnLollipopOrHigher()) {
                        i = writeOnLollipop(RtcAudioTrack.this.audioTrack, byteBuffer, capacity);
                    } else {
                        i = writePreLollipop(RtcAudioTrack.this.audioTrack, byteBuffer, capacity);
                    }
                    if (i != capacity) {
                        OmniLog.e(RtcAudioTrack.TAG, "AudioTrack.write failed: " + i);
                        if (i == -3) {
                            this.keepAlive = false;
                        }
                    }
                    byteBuffer.rewind();
                }
                try {
                    RtcAudioTrack.this.audioTrack.stop();
                } catch (IllegalStateException e) {
                    OmniLog.e(RtcAudioTrack.TAG, "AudioTrack.stop failed: " + e.getMessage());
                }
                if (RtcAudioTrack.this.audioTrack.getPlayState() != 1) {
                    z = false;
                }
                WebRtcAudioUtils.assertTrue(z);
                RtcAudioTrack.this.audioTrack.flush();
            } catch (IllegalStateException e2) {
                OmniLog.e(RtcAudioTrack.TAG, "AudioTrack.play failed: " + e2.getMessage());
            }
        }

        private int writeOnLollipop(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
            return audioTrack.write(byteBuffer, i, 0);
        }

        private int writePreLollipop(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
            return audioTrack.write(byteBuffer.array(), byteBuffer.arrayOffset(), i);
        }

        /* access modifiers changed from: private */
        public void joinThread() {
            this.keepAlive = false;
            while (isAlive()) {
                try {
                    join();
                    OmniLog.d(RtcAudioTrack.TAG, "join end");
                } catch (InterruptedException e) {
                    OmniLog.e(RtcAudioTrack.TAG, "InterruptedException msg : " + e.getLocalizedMessage());
                }
            }
        }
    }

    RtcAudioTrack(Context context, WebRtcAudioTrack webRtcAudioTrack2) {
        this.webRtcAudioTrack = webRtcAudioTrack2;
    }

    /* access modifiers changed from: package-private */
    public boolean initPlayout(int i, int i2, boolean z) {
        int i3 = i2 == 2 ? 12 : 4;
        OmniLog.aw_d(TAG, "initPlayout(sampleRate=" + i + ", channels=" + i2 + ",  use_voip=" + z + ")");
        this.webRtcAudioTrack.requestAndCacheByteBuffer(i2 * 2 * (i / 100));
        int minBufferSize = AudioTrack.getMinBufferSize(i, i3, 2);
        StringBuilder sb = new StringBuilder();
        sb.append("AudioTrack.getMinBufferSize: ");
        sb.append(minBufferSize);
        OmniLog.d(TAG, sb.toString());
        try {
            WebRtcAudioUtils.assertTrue(this.audioTrack == null);
            WebRtcAudioUtils.assertTrue(this.webRtcAudioTrack.byteBuffer().capacity() < minBufferSize);
            this.audioTrack = new AudioTrack(z ? 0 : 3, i, i3, 2, minBufferSize, 1);
            return true;
        } catch (IllegalArgumentException e) {
            OmniLog.d(TAG, e.getMessage());
            return false;
        } catch (AssertionError e2) {
            OmniLog.d(TAG, e2.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean startPlayout() {
        OmniLog.aw_d(TAG, "startPlayout");
        AudioTrack audioTrack2 = this.audioTrack;
        if (audioTrack2 == null || this.audioThread != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("startPlayout audioTrack:");
            String str = "null";
            sb.append(this.audioTrack == null ? str : "");
            sb.append(" audioThread:");
            if (this.audioThread != null) {
                str = "";
            }
            sb.append(str);
            OmniLog.aw_e(TAG, sb.toString());
            MyAudioApi.getInstance().reportAudioPlayError(1109);
            return false;
        }
        if (!(audioTrack2.getState() == 1 && this.audioTrack.getPlayState() == 1)) {
            OmniLog.aw_e(TAG, "startPlayout audio state:" + this.audioTrack.getState());
        }
        AudioTrackThread audioTrackThread = new AudioTrackThread("AudioTrackJavaThread");
        this.audioThread = audioTrackThread;
        audioTrackThread.start();
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean stopPlayout() {
        OmniLog.aw_d(TAG, "stopPlayout");
        AudioTrackThread audioTrackThread = this.audioThread;
        if (audioTrackThread == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("stopPlayout audioThread:");
            sb.append(this.audioThread == null ? "null" : "");
            OmniLog.aw_e(TAG, sb.toString());
            return false;
        }
        audioTrackThread.joinThread();
        this.audioThread = null;
        if (this.audioTrack == null) {
            return true;
        }
        OmniLog.aw_d(TAG, "audio track state=" + this.audioTrack.getState() + " sessionid=" + this.audioTrack.getAudioSessionId());
        this.audioTrack.flush();
        this.audioTrack.release();
        this.audioTrack = null;
        return true;
    }
}
