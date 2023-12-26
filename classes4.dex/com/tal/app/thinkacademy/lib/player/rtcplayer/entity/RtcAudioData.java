package com.tal.app.thinkacademy.lib.player.rtcplayer.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0017\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u0019\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0012\"\u0004\b!\u0010\u0014¨\u0006\""}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcAudioData;", "", "samples", "", "bytesPerSample", "channels", "samplesPerSec", "bufferLength", "renderTimesMs", "", "buffer", "", "(IIIIIJ[B)V", "getBuffer", "()[B", "setBuffer", "([B)V", "getBufferLength", "()I", "setBufferLength", "(I)V", "getBytesPerSample", "setBytesPerSample", "getChannels", "setChannels", "renderTimeMs", "getRenderTimeMs", "()J", "setRenderTimeMs", "(J)V", "getSamples", "setSamples", "getSamplesPerSec", "setSamplesPerSec", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcAudioData.kt */
public final class RtcAudioData {
    private byte[] buffer;
    private int bufferLength;
    private int bytesPerSample;
    private int channels;
    private long renderTimeMs = this.renderTimeMs;
    private int samples;
    private int samplesPerSec;

    public RtcAudioData(int i, int i2, int i3, int i4, int i5, long j, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        this.samples = i;
        this.bytesPerSample = i2;
        this.channels = i3;
        this.samplesPerSec = i4;
        this.bufferLength = i5;
        this.buffer = bArr;
    }

    public final int getSamples() {
        return this.samples;
    }

    public final void setSamples(int i) {
        this.samples = i;
    }

    public final int getBytesPerSample() {
        return this.bytesPerSample;
    }

    public final void setBytesPerSample(int i) {
        this.bytesPerSample = i;
    }

    public final int getChannels() {
        return this.channels;
    }

    public final void setChannels(int i) {
        this.channels = i;
    }

    public final int getSamplesPerSec() {
        return this.samplesPerSec;
    }

    public final void setSamplesPerSec(int i) {
        this.samplesPerSec = i;
    }

    public final int getBufferLength() {
        return this.bufferLength;
    }

    public final void setBufferLength(int i) {
        this.bufferLength = i;
    }

    public final long getRenderTimeMs() {
        return this.renderTimeMs;
    }

    public final void setRenderTimeMs(long j) {
        this.renderTimeMs = j;
    }

    public final byte[] getBuffer() {
        return this.buffer;
    }

    public final void setBuffer(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.buffer = bArr;
    }
}
