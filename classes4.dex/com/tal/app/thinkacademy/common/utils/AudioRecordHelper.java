package com.tal.app.thinkacademy.common.utils;

import android.media.AudioRecord;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 =2\u00020\u0001:\u0001=B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0014J\u000e\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020\nH\u0002J\u0006\u0010*\u001a\u00020\bJ\b\u0010+\u001a\u00020 H\u0002J\b\u0010,\u001a\u00020 H\u0002J\b\u0010-\u001a\u00020 H\u0002J\b\u0010.\u001a\u00020 H\u0002J\u0006\u0010/\u001a\u00020 J\u000e\u00100\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0014J\u000e\u00101\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0016J\u0018\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020\b2\u0006\u00104\u001a\u000205H\u0002J\u0010\u00106\u001a\u00020 2\u0006\u00107\u001a\u00020\u0004H\u0002J\u0010\u00108\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\fJ\b\u00109\u001a\u00020 H\u0002J\b\u0010:\u001a\u00020 H\u0002J\b\u0010;\u001a\u00020 H\u0002J\b\u0010<\u001a\u00020 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0013X\u0004¢\u0006\u0002\n\u0000R2\u0010\u0017\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\n0\n \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\n0\n\u0018\u00010\u00190\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/AudioRecordHelper;", "", "()V", "mAudioInitStartTime", "", "mAudioRecord", "Landroid/media/AudioRecord;", "mBufferSize", "", "mDstPCMBuffer", "", "mInitListener", "Lcom/tal/app/thinkacademy/common/utils/InitListener;", "mIsRecording", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mIsSending", "", "mPCMBuffer", "mPCMByteListeners", "", "Lcom/tal/app/thinkacademy/common/utils/PCMByteListener;", "mPCMShortListeners", "Lcom/tal/app/thinkacademy/common/utils/PCMShortListener;", "mShortAudioList", "kotlin.jvm.PlatformType", "", "mStartRecordObj", "mStopRecordObj", "mStopSentObj", "mSyncPCMByte", "mSyncPCMShort", "addPCMByteListener", "", "listener", "addPCMShortListener", "copyDataToList", "data", "dispatchPcmByte", "byteAudioData", "", "dispatchPcmShort", "audioData", "getBufferSize", "notifyError", "notifyInit", "refreshAudioStatus", "releaseMic", "removeAllPcmListener", "removePCMByteListener", "removePCMShortListener", "reportError", "code", "msg", "", "reportReadTimeout", "diff", "setInitListener", "showErrorTips", "startRecord", "stopMic", "stopRecord", "Companion", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AudioRecordHelper.kt */
public final class AudioRecordHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final PCMFormat DEFAULT_AUDIO_FORMAT = PCMFormat.PCM_16BIT;
    private static final int DEFAULT_AUDIO_SOURCE = 1;
    private static final int DEFAULT_CHANNEL_CONFIG = 1;
    private static final int DEFAULT_SAMPLING_RATE = 16000;
    private static final int ERROR_INIT = 1;
    private static final int ERROR_READ = 3;
    private static final int ERROR_START = 2;
    private static final int FRAME_COUNT = 2560;
    private static final String TAG = "AudioRecordHelper";
    /* access modifiers changed from: private */
    public static final Lazy<AudioRecordHelper> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AudioRecordHelper$Companion$instance$2.INSTANCE);
    private long mAudioInitStartTime;
    /* access modifiers changed from: private */
    public AudioRecord mAudioRecord;
    /* access modifiers changed from: private */
    public int mBufferSize;
    /* access modifiers changed from: private */
    public short[] mDstPCMBuffer;
    private InitListener mInitListener;
    /* access modifiers changed from: private */
    public final AtomicBoolean mIsRecording;
    /* access modifiers changed from: private */
    public volatile boolean mIsSending;
    /* access modifiers changed from: private */
    public short[] mPCMBuffer;
    /* access modifiers changed from: private */
    public final List<PCMByteListener> mPCMByteListeners;
    private final List<PCMShortListener> mPCMShortListeners;
    /* access modifiers changed from: private */
    public final List<short[]> mShortAudioList;
    private final Object mStartRecordObj;
    /* access modifiers changed from: private */
    public final Object mStopRecordObj;
    /* access modifiers changed from: private */
    public final Object mStopSentObj;
    private final Object mSyncPCMByte;
    private final Object mSyncPCMShort;

    public /* synthetic */ AudioRecordHelper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AudioRecordHelper() {
        this.mIsRecording = new AtomicBoolean(false);
        this.mStartRecordObj = new Object();
        this.mStopRecordObj = new Object();
        this.mStopSentObj = new Object();
        this.mSyncPCMByte = new Object();
        this.mSyncPCMShort = new Object();
        this.mPCMByteListeners = new ArrayList();
        this.mPCMShortListeners = new ArrayList();
        this.mShortAudioList = Collections.synchronizedList(new ArrayList());
        this.mAudioInitStartTime = System.currentTimeMillis();
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/AudioRecordHelper$Companion;", "", "()V", "DEFAULT_AUDIO_FORMAT", "Lcom/tal/app/thinkacademy/common/utils/PCMFormat;", "DEFAULT_AUDIO_SOURCE", "", "DEFAULT_CHANNEL_CONFIG", "DEFAULT_SAMPLING_RATE", "ERROR_INIT", "ERROR_READ", "ERROR_START", "FRAME_COUNT", "TAG", "", "instance", "Lcom/tal/app/thinkacademy/common/utils/AudioRecordHelper;", "getInstance", "()Lcom/tal/app/thinkacademy/common/utils/AudioRecordHelper;", "instance$delegate", "Lkotlin/Lazy;", "get", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AudioRecordHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final AudioRecordHelper getInstance() {
            return (AudioRecordHelper) AudioRecordHelper.instance$delegate.getValue();
        }

        public final AudioRecordHelper get() {
            return getInstance();
        }
    }

    public final int getBufferSize() {
        PCMFormat pCMFormat = DEFAULT_AUDIO_FORMAT;
        int minBufferSize = AudioRecord.getMinBufferSize(DEFAULT_SAMPLING_RATE, 1, pCMFormat.getAudioFormat());
        int bytesPerFrame = pCMFormat.getBytesPerFrame();
        int i = minBufferSize / bytesPerFrame;
        int i2 = i % FRAME_COUNT;
        if (i2 != 0) {
            i += 2560 - i2;
        }
        return (i * bytesPerFrame) / 2;
    }

    public final void addPCMByteListener(PCMByteListener pCMByteListener) {
        Intrinsics.checkNotNullParameter(pCMByteListener, "listener");
        XesLog.it(TAG, "addPCMByteListener start");
        synchronized (this.mSyncPCMByte) {
            XesLog.it(TAG, Intrinsics.stringPlus("addPCMByteListener size : ", Integer.valueOf(this.mPCMByteListeners.size())));
            this.mPCMByteListeners.add(pCMByteListener);
            XesLog.it(TAG, Intrinsics.stringPlus("addPCMByteListener size : ", Integer.valueOf(this.mPCMByteListeners.size())));
            Unit unit = Unit.INSTANCE;
        }
        refreshAudioStatus();
    }

    public final void removePCMByteListener(PCMByteListener pCMByteListener) {
        Intrinsics.checkNotNullParameter(pCMByteListener, "listener");
        XesLog.it(TAG, "removePCMByteListener start");
        synchronized (this.mSyncPCMByte) {
            XesLog.it(TAG, Intrinsics.stringPlus("removePCMByteListener size : ", Integer.valueOf(this.mPCMByteListeners.size())));
            if (this.mPCMByteListeners.contains(pCMByteListener)) {
                this.mPCMByteListeners.remove(pCMByteListener);
                XesLog.it(TAG, Intrinsics.stringPlus("removePCMByteListener size : ", Integer.valueOf(this.mPCMByteListeners.size())));
            }
            Unit unit = Unit.INSTANCE;
        }
        refreshAudioStatus();
    }

    public final void addPCMShortListener(PCMShortListener pCMShortListener) {
        Intrinsics.checkNotNullParameter(pCMShortListener, "listener");
        boolean z = false;
        XesLog.it(TAG, "addPCMShortListener start");
        this.mAudioInitStartTime = System.currentTimeMillis();
        synchronized (this.mSyncPCMShort) {
            XesLog.it(TAG, Intrinsics.stringPlus("addPCMShortListener size : ", Integer.valueOf(this.mPCMShortListeners.size())));
            if (!this.mPCMShortListeners.contains(pCMShortListener)) {
                boolean add = this.mPCMShortListeners.add(pCMShortListener);
                XesLog.it(TAG, Intrinsics.stringPlus("addPCMShortListener size : ", Integer.valueOf(this.mPCMShortListeners.size())));
                z = add;
            }
            Unit unit = Unit.INSTANCE;
        }
        if (this.mPCMShortListeners.size() + this.mPCMByteListeners.size() > 1) {
            notifyInit();
        }
        if (z) {
            refreshAudioStatus();
        }
    }

    /* access modifiers changed from: private */
    public final void notifyInit() {
        synchronized (this.mSyncPCMShort) {
            int i = 0;
            int size = this.mPCMShortListeners.size();
            while (i < size) {
                int i2 = i + 1;
                PCMShortListener pCMShortListener = this.mPCMShortListeners.get(i);
                if (pCMShortListener instanceof PCMShortFulListener) {
                    ((PCMShortFulListener) pCMShortListener).onInit(System.currentTimeMillis() - this.mAudioInitStartTime);
                }
                i = i2;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void notifyError() {
        synchronized (this.mSyncPCMShort) {
            int i = 0;
            int size = this.mPCMShortListeners.size();
            while (i < size) {
                int i2 = i + 1;
                PCMShortListener pCMShortListener = this.mPCMShortListeners.get(i);
                if (pCMShortListener instanceof PCMShortFulListener) {
                    ((PCMShortFulListener) pCMShortListener).onError();
                }
                i = i2;
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void removePCMShortListener(PCMShortListener pCMShortListener) {
        Intrinsics.checkNotNullParameter(pCMShortListener, "listener");
        XesLog.it(TAG, "removePCMShortListener start");
        synchronized (this.mSyncPCMShort) {
            XesLog.it(TAG, Intrinsics.stringPlus("removePCMShortListener size : ", Integer.valueOf(this.mPCMShortListeners.size())));
            if (this.mPCMShortListeners.contains(pCMShortListener)) {
                this.mPCMShortListeners.remove(pCMShortListener);
                XesLog.it(TAG, Intrinsics.stringPlus("removePCMShortListener size : ", Integer.valueOf(this.mPCMShortListeners.size())));
            }
            Unit unit = Unit.INSTANCE;
        }
        refreshAudioStatus();
    }

    public final void removeAllPcmListener() {
        synchronized (this.mSyncPCMShort) {
            this.mPCMShortListeners.clear();
            Unit unit = Unit.INSTANCE;
        }
        synchronized (this.mSyncPCMByte) {
            this.mPCMByteListeners.clear();
            Unit unit2 = Unit.INSTANCE;
        }
        refreshAudioStatus();
    }

    private final void refreshAudioStatus() {
        synchronized (this.mStartRecordObj) {
            XesLog.it(TAG, "refreshAudioStatus mPCMByteListeners =" + this.mPCMByteListeners.size() + ",mPCMShortListeners = " + this.mPCMShortListeners.size() + ",mIsRecording=" + this.mIsRecording.get());
            if (this.mPCMByteListeners.size() + this.mPCMShortListeners.size() == 0 && this.mIsRecording.get()) {
                stopRecord();
            }
            if (this.mPCMByteListeners.size() + this.mPCMShortListeners.size() > 0 && !this.mIsRecording.get()) {
                startRecord();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void dispatchPcmByte(byte[] bArr) {
        synchronized (this.mSyncPCMByte) {
            for (PCMByteListener onAudio : this.mPCMByteListeners) {
                onAudio.onAudio(bArr);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void dispatchPcmShort(short[] sArr) {
        synchronized (this.mSyncPCMShort) {
            for (PCMShortListener onAudio : this.mPCMShortListeners) {
                onAudio.onAudio(sArr);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final void showErrorTips() {
        notifyError();
    }

    private final void startRecord() {
        XesLog.it(TAG, "startRecord开始录音");
        synchronized (this.mStopRecordObj) {
            this.mIsRecording.set(true);
            Unit unit = Unit.INSTANCE;
        }
        XesLog.it(TAG, "确认录音线程结束");
        synchronized (this.mStopSentObj) {
            this.mIsSending = true;
            Unit unit2 = Unit.INSTANCE;
        }
        XesLog.it(TAG, "确认发送线程结束");
        releaseMic();
        if (this.mAudioRecord == null) {
            PCMFormat pCMFormat = DEFAULT_AUDIO_FORMAT;
            int minBufferSize = AudioRecord.getMinBufferSize(DEFAULT_SAMPLING_RATE, 1, pCMFormat.getAudioFormat());
            this.mBufferSize = minBufferSize;
            XesLog.it(TAG, Intrinsics.stringPlus("getMinBufferSize = ", Integer.valueOf(minBufferSize)));
            int bytesPerFrame = pCMFormat.getBytesPerFrame();
            int i = this.mBufferSize / bytesPerFrame;
            int i2 = i % FRAME_COUNT;
            if (i2 != 0) {
                i += 2560 - i2;
            }
            this.mBufferSize = (i * bytesPerFrame) / 2;
            try {
                this.mAudioRecord = new AudioRecord(DEFAULT_AUDIO_SOURCE, DEFAULT_SAMPLING_RATE, 1, pCMFormat.getAudioFormat(), this.mBufferSize);
            } catch (Exception e) {
                XesLog.et(TAG, e, "初始化异常 error");
                showErrorTips();
                reportError(1, e.toString());
            }
        }
        int i3 = this.mBufferSize;
        this.mPCMBuffer = new short[i3];
        this.mDstPCMBuffer = new short[i3];
        try {
            AudioRecord audioRecord = this.mAudioRecord;
            if (audioRecord != null) {
                Intrinsics.checkNotNull(audioRecord);
                audioRecord.startRecording();
            }
        } catch (Exception e2) {
            showErrorTips();
            XesLog.et(TAG, e2, "startRecording error");
            reportError(2, e2.toString());
        }
        new AudioRecordHelper$startRecord$3(this).start();
        new AudioRecordHelper$startRecord$4(this).start();
    }

    /* access modifiers changed from: private */
    public final void reportError(int i, String str) {
        InitListener initListener = this.mInitListener;
        if (initListener != null) {
            Intrinsics.checkNotNull(initListener);
            initListener.reportError(i, str);
        }
        XesLog.it(TAG, "error code = " + i + "msg = " + str);
    }

    /* access modifiers changed from: private */
    public final void reportReadTimeout(long j) {
        InitListener initListener;
        if (j >= 2000 && (initListener = this.mInitListener) != null) {
            Intrinsics.checkNotNull(initListener);
            initListener.reportReadMicTimeout(j);
        }
    }

    private final void stopMic() {
        XesLog.it(TAG, "开始停止麦克风");
        try {
            AudioRecord audioRecord = this.mAudioRecord;
            if (audioRecord != null) {
                Intrinsics.checkNotNull(audioRecord);
                audioRecord.stop();
                return;
            }
            XesLog.it(TAG, "stopMic 已经停止");
        } catch (Exception e) {
            XesLog.it(TAG, Intrinsics.stringPlus("releaseMic 停止录音器：error = ", e));
        }
    }

    /* access modifiers changed from: private */
    public final void releaseMic() {
        XesLog.it(TAG, "开始释放麦克风");
        try {
            AudioRecord audioRecord = this.mAudioRecord;
            if (audioRecord != null) {
                Intrinsics.checkNotNull(audioRecord);
                audioRecord.stop();
            } else {
                XesLog.it(TAG, "releaseMic 已经停止");
            }
        } catch (Exception e) {
            XesLog.it(TAG, Intrinsics.stringPlus("releaseMic 停止录音器：error = ", e));
        }
        try {
            AudioRecord audioRecord2 = this.mAudioRecord;
            if (audioRecord2 != null) {
                Intrinsics.checkNotNull(audioRecord2);
                audioRecord2.release();
            } else {
                XesLog.it(TAG, "releaseMic 已经释放");
            }
        } catch (Exception e2) {
            XesLog.it(TAG, Intrinsics.stringPlus("releaseMic 释放录音器：error = ", e2));
        }
        this.mAudioRecord = null;
    }

    /* access modifiers changed from: private */
    public final void copyDataToList(short[] sArr) {
        int i;
        if (sArr != null && sArr.length == (i = this.mBufferSize)) {
            short[] sArr2 = new short[i];
            System.arraycopy(sArr, 0, sArr2, 0, i);
            this.mShortAudioList.add(sArr2);
        }
    }

    private final void stopRecord() {
        XesLog.it(TAG, "结束录音");
        stopMic();
        this.mIsRecording.set(false);
        this.mIsSending = false;
    }

    public final void setInitListener(InitListener initListener) {
        this.mInitListener = initListener;
    }
}
