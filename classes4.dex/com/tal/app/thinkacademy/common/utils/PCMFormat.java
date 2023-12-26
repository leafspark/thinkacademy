package com.tal.app.thinkacademy.common.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/tal/app/thinkacademy/common/utils/PCMFormat;", "", "bytesPerFrame", "", "audioFormat", "(Ljava/lang/String;III)V", "getAudioFormat", "()I", "getBytesPerFrame", "PCM_8BIT", "PCM_16BIT", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AudioRecordHelper.kt */
public enum PCMFormat {
    PCM_8BIT(1, 3),
    PCM_16BIT(2, 2);
    
    private final int audioFormat;
    private final int bytesPerFrame;

    private PCMFormat(int i, int i2) {
        this.bytesPerFrame = i;
        this.audioFormat = i2;
    }

    public final int getAudioFormat() {
        return this.audioFormat;
    }

    public final int getBytesPerFrame() {
        return this.bytesPerFrame;
    }
}
