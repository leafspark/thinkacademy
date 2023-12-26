package com.tal.app.thinkacademy.common.utils;

import com.tal.app.thinkacademy.lib.logger.XesLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/tal/app/thinkacademy/common/utils/AudioRecordHelper$startRecord$3", "Ljava/lang/Thread;", "run", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AudioRecordHelper.kt */
public final class AudioRecordHelper$startRecord$3 extends Thread {
    final /* synthetic */ AudioRecordHelper this$0;

    AudioRecordHelper$startRecord$3(AudioRecordHelper audioRecordHelper) {
        this.this$0 = audioRecordHelper;
    }

    public void run() {
        Object access$getMStopSentObj$p = this.this$0.mStopSentObj;
        AudioRecordHelper audioRecordHelper = this.this$0;
        synchronized (access$getMStopSentObj$p) {
            while (audioRecordHelper.mIsSending) {
                if (audioRecordHelper.mShortAudioList.size() > 0) {
                    short[] sArr = new short[0];
                    try {
                        sArr = (short[]) audioRecordHelper.mShortAudioList.remove(0);
                    } catch (Exception e) {
                        XesLog.it("AudioRecordHelper", Intrinsics.stringPlus("remove error = ", e));
                    }
                    if (sArr != null) {
                        if (!(sArr.length == 0)) {
                            short[] sArr2 = new short[sArr.length];
                            if (true ^ (sArr.length == 0)) {
                                audioRecordHelper.dispatchPcmShort(sArr);
                                if (audioRecordHelper.mPCMByteListeners.size() > 0) {
                                    ByteBuffer allocate = ByteBuffer.allocate(sArr.length * 2);
                                    allocate.order(ByteOrder.LITTLE_ENDIAN);
                                    allocate.asShortBuffer().put(sArr);
                                    byte[] bArr = new byte[(sArr.length * 2)];
                                    allocate.get(bArr, 0, sArr.length * 2);
                                    audioRecordHelper.dispatchPcmByte(bArr);
                                }
                            }
                        }
                    }
                }
            }
            XesLog.it("AudioRecordHelper", "record sent thread stop finish..");
            Unit unit = Unit.INSTANCE;
        }
    }
}
