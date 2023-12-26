package com.wushuangtech.audiocore;

import android.content.Context;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.wushuangtech.audiocore.callback.ExternalAudioProcessCallback;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.utils.OmniLog;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AudioEncoder extends Thread implements ExternalAudioProcessCallback {
    private static final boolean DEBUG = false;
    private static final int RECORD_BUFFER_SIZE = 2048;
    private static final int RECORD_CHANNEL = 1;
    private static final int RECORD_SAMPLERATE = 48000;
    private static final String TAG = "AudioEncoder";
    private LinkedList<AudioFrame> mAudioDatas;
    private AudioEncodeCallBack mAudioEncodeCallBack;
    private int mAudioQuality;
    private int mDelayTime = 500;
    private long mDurationTime;
    private String mFilePath;
    private float mFrameTime;
    private boolean mIsRecording = true;
    private boolean mIsThreadStart;
    private Lock mListLock = new ReentrantLock();
    private float mRecordTime;
    private long mStartRecordTime;
    private MediaCodec m_mediaEncoder = null;

    public interface AudioEncodeCallBack {
        void onAudioRecordStopFinish();
    }

    private void debug(String str) {
    }

    public byte[] onPlaybackPCMData(byte[] bArr, int i, int i2, int i3, boolean z) {
        return null;
    }

    public byte[] onRecordPCMData(byte[] bArr, int i, int i2, int i3, boolean z) {
        return null;
    }

    public AudioEncoder(String str, int i) {
        this.mFilePath = str;
        this.mAudioQuality = i;
        this.mAudioDatas = new LinkedList<>();
    }

    public boolean startReocrding() {
        this.mIsRecording = true;
        this.mStartRecordTime = System.currentTimeMillis();
        this.mFrameTime = 21.333334f;
        MyAudioApi instance = MyAudioApi.getInstance((Context) null);
        instance.setExternalAudioProcessCallback(this);
        instance.setRemoteAndLocalMixParamatars(48000, 1, 2048);
        instance.startRemoteAndLocalMix();
        String str = TAG;
        OmniLog.d(str, "startReocrding invoked over! mFrameTime : " + this.mFrameTime);
        return true;
    }

    public boolean stopRecording(AudioEncodeCallBack audioEncodeCallBack) {
        if (!this.mIsRecording) {
            return true;
        }
        this.mAudioEncodeCallBack = audioEncodeCallBack;
        this.mDurationTime = System.currentTimeMillis() - this.mStartRecordTime;
        this.mIsRecording = false;
        OmniLog.d(TAG, "stopRecording invoked over!");
        return true;
    }

    private boolean InitEncoder() {
        try {
            int minBufferSize = AudioRecord.getMinBufferSize(48000, 1, 2);
            this.m_mediaEncoder = MediaCodec.createEncoderByType("audio/mp4a-latm");
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", "audio/mp4a-latm");
            mediaFormat.setInteger("channel-count", 1);
            int i = 24;
            int i2 = this.mAudioQuality;
            if (i2 == 0) {
                i = 16;
            } else if (i2 == 1) {
                i = 32;
            } else if (i2 == 2) {
                i = 64;
            }
            mediaFormat.setInteger("sample-rate", 48000);
            mediaFormat.setInteger("bitrate", i * 1000);
            mediaFormat.setInteger("aac-profile", 2);
            mediaFormat.setInteger("max-input-size", 2048);
            if (Build.VERSION.SDK_INT >= 21) {
                mediaFormat.setInteger("bitrate-mode", 2);
            }
            this.m_mediaEncoder.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 1);
            this.m_mediaEncoder.start();
            String str = TAG;
            OmniLog.d(str, "InitEncoder KEY_MAX_INPUT_SIZE : " + minBufferSize + " | KEY_BIT_RATE : " + i);
            return true;
        } catch (IOException e) {
            String str2 = TAG;
            OmniLog.d(str2, "InitEncoder failed! msg : " + e.getLocalizedMessage());
            return false;
        }
    }

    public static void addADTStoPacket(byte[] bArr, int i) {
        bArr[0] = -1;
        bArr[1] = -7;
        bArr[2] = (byte) 76;
        bArr[3] = (byte) (64 + (i >> 11));
        bArr[4] = (byte) ((i & 2047) >> 3);
        bArr[5] = (byte) (((i & 7) << 5) + 31);
        bArr[6] = -4;
    }

    /* JADX INFO: finally extract failed */
    public void run() {
        if (InitEncoder()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mFilePath, true);
                long nanoTime = System.nanoTime();
                while (checkState()) {
                    try {
                        this.mListLock.lock();
                        AudioFrame poll = this.mAudioDatas.poll();
                        if (poll == null) {
                            try {
                                sleep(10);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            debug("mIsRecording : " + this.mIsRecording + " | mAudioDatas.size() : " + this.mAudioDatas.size() + " | mDelayTime : " + this.mDelayTime + " | mRecordTime : " + this.mRecordTime + " | mDurationTime : " + this.mDurationTime);
                            long j = this.mDurationTime;
                            if (j == 0 || this.mRecordTime < ((float) j)) {
                                int dequeueInputBuffer = this.m_mediaEncoder.dequeueInputBuffer(0);
                                if (dequeueInputBuffer >= 0) {
                                    ByteBuffer byteBuffer = this.m_mediaEncoder.getInputBuffers()[dequeueInputBuffer];
                                    byteBuffer.clear();
                                    byteBuffer.put(poll.mDatas);
                                    byteBuffer.limit(poll.mDatas.length);
                                    this.m_mediaEncoder.queueInputBuffer(dequeueInputBuffer, 0, poll.mDatas.length, System.nanoTime() - nanoTime, 0);
                                }
                                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                                int dequeueOutputBuffer = this.m_mediaEncoder.dequeueOutputBuffer(bufferInfo, 0);
                                while (dequeueOutputBuffer >= 0) {
                                    if ((bufferInfo.flags & 2) != 0) {
                                        this.m_mediaEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                                        dequeueOutputBuffer = this.m_mediaEncoder.dequeueOutputBuffer(bufferInfo, 0);
                                    } else {
                                        ByteBuffer[] outputBuffers = this.m_mediaEncoder.getOutputBuffers();
                                        int i = bufferInfo.size;
                                        int i2 = i + 7;
                                        ByteBuffer byteBuffer2 = outputBuffers[dequeueOutputBuffer];
                                        byteBuffer2.position(bufferInfo.offset);
                                        byteBuffer2.limit(bufferInfo.offset + i);
                                        byte[] bArr = new byte[i2];
                                        addADTStoPacket(bArr, i2);
                                        byteBuffer2.get(bArr, 7, i);
                                        byteBuffer2.position(bufferInfo.offset);
                                        try {
                                            this.mRecordTime += this.mFrameTime;
                                            debug("write data : " + i2);
                                            fileOutputStream.write(bArr, 0, i2);
                                            fileOutputStream.flush();
                                            this.m_mediaEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                                            dequeueOutputBuffer = this.m_mediaEncoder.dequeueOutputBuffer(bufferInfo, 0);
                                        } catch (IOException e2) {
                                            OmniLog.w(TAG, "fos write data failed! msg : " + e2.getLocalizedMessage());
                                        }
                                    }
                                }
                            } else {
                                debug("Audio record time is ok! " + this.mRecordTime + " | mDurationTime : " + this.mDurationTime);
                            }
                        }
                    } finally {
                        this.mListLock.unlock();
                    }
                }
                debug("mIsRecording : " + this.mIsRecording + " | mAudioDatas.size() : " + this.mAudioDatas.size() + " | mDelayTime : " + this.mDelayTime + " | mRecordTime : " + this.mRecordTime + " | mDurationTime : " + this.mDurationTime);
                OmniLog.d(TAG, "Audio record over, clear resource!");
                MyAudioApi.getInstance((Context) null).stopRemoteAndLocalMix();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                this.m_mediaEncoder.stop();
                this.m_mediaEncoder.release();
                this.m_mediaEncoder = null;
                this.mListLock.lock();
                try {
                    this.mAudioDatas.clear();
                    this.mAudioDatas = null;
                    this.mListLock.unlock();
                    AudioEncodeCallBack audioEncodeCallBack = this.mAudioEncodeCallBack;
                    if (audioEncodeCallBack != null) {
                        audioEncodeCallBack.onAudioRecordStopFinish();
                    }
                    GlobalHolder.getInstance().notifyAudioRecordFinish();
                } catch (Throwable th) {
                    this.mListLock.unlock();
                    throw th;
                }
            } catch (Exception e4) {
                OmniLog.w(TAG, "FileOutputStream create failed! msg : " + e4.getLocalizedMessage());
            }
        }
    }

    private boolean checkState() {
        if (this.mIsRecording || this.mAudioDatas.size() > 0) {
            return true;
        }
        this.mDelayTime -= 50;
        debug("mDelayTime last : " + this.mDelayTime);
        if (this.mDelayTime > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    public byte[] OnRemoteAndLocalMixPCMData(byte[] bArr, int i, int i2, int i3, boolean z) {
        debug("OnRemoteAndLocalMixPCMData data : " + bArr.length + " | dataOffset : " + i + " | sizeInBytes : " + i2 + " | samplingFreq ： " + i3 + " | isStereo ： " + z);
        if (!this.mIsThreadStart) {
            this.mIsThreadStart = true;
            start();
        }
        this.mListLock.lock();
        try {
            LinkedList<AudioFrame> linkedList = this.mAudioDatas;
            if (linkedList != null) {
                linkedList.add(new AudioFrame(bArr, i, i2));
                debug("add AudioFrame : " + this.mAudioDatas.size());
            }
            this.mListLock.unlock();
            return null;
        } catch (Throwable th) {
            this.mListLock.unlock();
            throw th;
        }
    }

    static class AudioFrame {
        int mDataLen;
        int mDataOffset;
        byte[] mDatas;

        public AudioFrame(byte[] bArr, int i, int i2) {
            this.mDatas = bArr;
            this.mDataOffset = i;
            this.mDataLen = i2;
        }
    }
}
