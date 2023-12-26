package com.tal.app.thinkacademy.common.widget.gold;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import com.tal.app.thinkacademy.lib.entity.AppNetWorkConfigRemoteInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinLineConfig;", "", "direction", "Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinLineDirection;", "offset", "", "animatorDuration", "", "(Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinLineDirection;IJ)V", "getAnimatorDuration", "()J", "getDirection", "()Lcom/tal/app/thinkacademy/common/widget/gold/FlyCoinLineDirection;", "getOffset", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlyCoinLineConfig.kt */
public final class FlyCoinLineConfig {
    private final long animatorDuration;
    private final FlyCoinLineDirection direction;
    private final int offset;

    public FlyCoinLineConfig() {
        this((FlyCoinLineDirection) null, 0, 0, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ FlyCoinLineConfig copy$default(FlyCoinLineConfig flyCoinLineConfig, FlyCoinLineDirection flyCoinLineDirection, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            flyCoinLineDirection = flyCoinLineConfig.direction;
        }
        if ((i2 & 2) != 0) {
            i = flyCoinLineConfig.offset;
        }
        if ((i2 & 4) != 0) {
            j = flyCoinLineConfig.animatorDuration;
        }
        return flyCoinLineConfig.copy(flyCoinLineDirection, i, j);
    }

    public final FlyCoinLineDirection component1() {
        return this.direction;
    }

    public final int component2() {
        return this.offset;
    }

    public final long component3() {
        return this.animatorDuration;
    }

    public final FlyCoinLineConfig copy(FlyCoinLineDirection flyCoinLineDirection, int i, long j) {
        Intrinsics.checkNotNullParameter(flyCoinLineDirection, "direction");
        return new FlyCoinLineConfig(flyCoinLineDirection, i, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlyCoinLineConfig)) {
            return false;
        }
        FlyCoinLineConfig flyCoinLineConfig = (FlyCoinLineConfig) obj;
        return this.direction == flyCoinLineConfig.direction && this.offset == flyCoinLineConfig.offset && this.animatorDuration == flyCoinLineConfig.animatorDuration;
    }

    public int hashCode() {
        return (((this.direction.hashCode() * 31) + this.offset) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.animatorDuration);
    }

    public String toString() {
        return "FlyCoinLineConfig(direction=" + this.direction + ", offset=" + this.offset + ", animatorDuration=" + this.animatorDuration + ')';
    }

    public FlyCoinLineConfig(FlyCoinLineDirection flyCoinLineDirection, int i, long j) {
        Intrinsics.checkNotNullParameter(flyCoinLineDirection, "direction");
        this.direction = flyCoinLineDirection;
        this.offset = i;
        this.animatorDuration = j;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FlyCoinLineConfig(FlyCoinLineDirection flyCoinLineDirection, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? FlyCoinLineDirection.DOWN : flyCoinLineDirection, (i2 & 2) != 0 ? AppNetWorkConfigRemoteInfo.MAX_TIME_OUT : i, (i2 & 4) != 0 ? 1000 : j);
    }

    public final FlyCoinLineDirection getDirection() {
        return this.direction;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final long getAnimatorDuration() {
        return this.animatorDuration;
    }
}
