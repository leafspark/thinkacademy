package com.tal.app.thinkacademy.lib.player.rtcplayer.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0018\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/rtcplayer/entity/RtcVideoData;", "", "width", "", "height", "yStride", "uStride", "vStride", "rotation", "renderTimeMs", "", "data", "", "(IIIIIIJ[B)V", "getData", "()[B", "setData", "([B)V", "getHeight", "()I", "setHeight", "(I)V", "getRenderTimeMs", "()J", "setRenderTimeMs", "(J)V", "getRotation", "setRotation", "getUStride", "setUStride", "getVStride", "setVStride", "getWidth", "setWidth", "getYStride", "setYStride", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RtcVideoData.kt */
public final class RtcVideoData {
    private byte[] data;
    private int height;
    private long renderTimeMs;
    private int rotation;
    private int uStride;
    private int vStride;
    private int width;
    private int yStride;

    public RtcVideoData(int i, int i2, int i3, int i4, int i5, int i6, long j, byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "data");
        this.width = i;
        this.height = i2;
        this.yStride = i3;
        this.uStride = i4;
        this.vStride = i5;
        this.rotation = i6;
        this.renderTimeMs = j;
        this.data = bArr;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final int getYStride() {
        return this.yStride;
    }

    public final void setYStride(int i) {
        this.yStride = i;
    }

    public final int getUStride() {
        return this.uStride;
    }

    public final void setUStride(int i) {
        this.uStride = i;
    }

    public final int getVStride() {
        return this.vStride;
    }

    public final void setVStride(int i) {
        this.vStride = i;
    }

    public final int getRotation() {
        return this.rotation;
    }

    public final void setRotation(int i) {
        this.rotation = i;
    }

    public final long getRenderTimeMs() {
        return this.renderTimeMs;
    }

    public final void setRenderTimeMs(long j) {
        this.renderTimeMs = j;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final void setData(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<set-?>");
        this.data = bArr;
    }
}
