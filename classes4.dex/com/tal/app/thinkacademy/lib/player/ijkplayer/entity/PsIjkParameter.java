package com.tal.app.thinkacademy.lib.player.ijkplayer.entity;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/tal/app/thinkacademy/lib/player/ijkplayer/entity/PsIjkParameter;", "", "()V", "duration", "", "maxWaterMark", "minWaterMark", "getDuration", "getMaxWaterMark", "getMinWaterMark", "setDuration", "", "setMaxWaterMark", "lib_player_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PsIjkParameter.kt */
public final class PsIjkParameter {
    private long duration;
    private long maxWaterMark;
    private long minWaterMark = -123;

    public final long getMinWaterMark() {
        if (this.minWaterMark == -123) {
            this.minWaterMark = this.maxWaterMark;
        }
        return this.minWaterMark;
    }

    public final long getMaxWaterMark() {
        return this.maxWaterMark;
    }

    public final void setMaxWaterMark(long j) {
        this.maxWaterMark = j;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }
}
