package com.tal.app.thinkacademy.common.utils;

import android.media.AudioRecord;
import android.os.Build;
import com.tal.app.thinkacademy.lib.logger.XesLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"com/tal/app/thinkacademy/common/utils/AudioRecordHelper$startRecord$4", "Ljava/lang/Thread;", "mBufferOffset", "", "run", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AudioRecordHelper.kt */
public final class AudioRecordHelper$startRecord$4 extends Thread {
    private int mBufferOffset;
    final /* synthetic */ AudioRecordHelper this$0;

    AudioRecordHelper$startRecord$4(AudioRecordHelper audioRecordHelper) {
        this.this$0 = audioRecordHelper;
    }

    public void run() {
        int i;
        Object access$getMStopRecordObj$p = this.this$0.mStopRecordObj;
        AudioRecordHelper audioRecordHelper = this.this$0;
        synchronized (access$getMStopRecordObj$p) {
            XesLog.it("AudioRecordHelper", Intrinsics.stringPlus("mBufferSize = ", Integer.valueOf(audioRecordHelper.mBufferSize)));
            this.mBufferOffset = 0;
            audioRecordHelper.notifyInit();
            boolean z = false;
            int i2 = 0;
            while (audioRecordHelper.mIsRecording.get()) {
                if (audioRecordHelper.mAudioRecord != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (Build.VERSION.SDK_INT >= 23) {
                        AudioRecord access$getMAudioRecord$p = audioRecordHelper.mAudioRecord;
                        Intrinsics.checkNotNull(access$getMAudioRecord$p);
                        short[] access$getMPCMBuffer$p = audioRecordHelper.mPCMBuffer;
                        Intrinsics.checkNotNull(access$getMPCMBuffer$p);
                        i = access$getMAudioRecord$p.read(access$getMPCMBuffer$p, 0, audioRecordHelper.mBufferSize);
                    } else {
                        AudioRecord access$getMAudioRecord$p2 = audioRecordHelper.mAudioRecord;
                        Intrinsics.checkNotNull(access$getMAudioRecord$p2);
                        short[] access$getMPCMBuffer$p2 = audioRecordHelper.mPCMBuffer;
                        Intrinsics.checkNotNull(access$getMPCMBuffer$p2);
                        i = access$getMAudioRecord$p2.read(access$getMPCMBuffer$p2, 0, audioRecordHelper.mBufferSize);
                    }
                    audioRecordHelper.reportReadTimeout(System.currentTimeMillis() - currentTimeMillis);
                    if (i > 0) {
                        if (i == audioRecordHelper.mBufferSize && this.mBufferOffset == 0) {
                            audioRecordHelper.copyDataToList(audioRecordHelper.mPCMBuffer);
                        } else {
                            int i3 = this.mBufferOffset + i;
                            if (i3 == audioRecordHelper.mBufferSize) {
                                short[] access$getMPCMBuffer$p3 = audioRecordHelper.mPCMBuffer;
                                Intrinsics.checkNotNull(access$getMPCMBuffer$p3);
                                short[] access$getMDstPCMBuffer$p = audioRecordHelper.mDstPCMBuffer;
                                Intrinsics.checkNotNull(access$getMDstPCMBuffer$p);
                                System.arraycopy(access$getMPCMBuffer$p3, 0, access$getMDstPCMBuffer$p, this.mBufferOffset, i);
                                audioRecordHelper.copyDataToList(audioRecordHelper.mDstPCMBuffer);
                                this.mBufferOffset = 0;
                            } else if (i3 > audioRecordHelper.mBufferSize) {
                                int access$getMBufferSize$p = audioRecordHelper.mBufferSize - this.mBufferOffset;
                                short[] access$getMPCMBuffer$p4 = audioRecordHelper.mPCMBuffer;
                                Intrinsics.checkNotNull(access$getMPCMBuffer$p4);
                                short[] access$getMDstPCMBuffer$p2 = audioRecordHelper.mDstPCMBuffer;
                                Intrinsics.checkNotNull(access$getMDstPCMBuffer$p2);
                                System.arraycopy(access$getMPCMBuffer$p4, 0, access$getMDstPCMBuffer$p2, this.mBufferOffset, access$getMBufferSize$p);
                                audioRecordHelper.copyDataToList(audioRecordHelper.mDstPCMBuffer);
                                this.mBufferOffset = 0;
                                this.mBufferOffset = i - access$getMBufferSize$p;
                                short[] access$getMPCMBuffer$p5 = audioRecordHelper.mPCMBuffer;
                                Intrinsics.checkNotNull(access$getMPCMBuffer$p5);
                                short[] access$getMDstPCMBuffer$p3 = audioRecordHelper.mDstPCMBuffer;
                                Intrinsics.checkNotNull(access$getMDstPCMBuffer$p3);
                                System.arraycopy(access$getMPCMBuffer$p5, access$getMBufferSize$p, access$getMDstPCMBuffer$p3, 0, this.mBufferOffset);
                            } else {
                                short[] access$getMPCMBuffer$p6 = audioRecordHelper.mPCMBuffer;
                                Intrinsics.checkNotNull(access$getMPCMBuffer$p6);
                                short[] access$getMDstPCMBuffer$p4 = audioRecordHelper.mDstPCMBuffer;
                                Intrinsics.checkNotNull(access$getMDstPCMBuffer$p4);
                                System.arraycopy(access$getMPCMBuffer$p6, 0, access$getMDstPCMBuffer$p4, this.mBufferOffset, i);
                                this.mBufferOffset += i;
                            }
                        }
                        z = true;
                    } else if (!z) {
                        if (i2 > 20) {
                            audioRecordHelper.showErrorTips();
                            audioRecordHelper.reportError(3, "读取<=0");
                            z = true;
                        }
                        i2++;
                    }
                } else {
                    XesLog.it("AudioRecordHelper", "录音对象为空");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            audioRecordHelper.releaseMic();
            audioRecordHelper.mShortAudioList.clear();
            Unit unit = Unit.INSTANCE;
        }
        XesLog.it("AudioRecordHelper", "record read thread stop finish..");
    }
}
