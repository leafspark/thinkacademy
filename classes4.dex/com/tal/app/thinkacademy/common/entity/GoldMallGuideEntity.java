package com.tal.app.thinkacademy.common.entity;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import com.tal.app.thinkacademy.common.util.TimeTransformationUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/GoldMallGuideEntity;", "", "showTime", "", "showCount", "", "(JI)V", "getShowCount", "()I", "setShowCount", "(I)V", "getShowTime", "()J", "setShowTime", "(J)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GoldMallGuideEntity.kt */
public final class GoldMallGuideEntity {
    private int showCount;
    private long showTime;

    public GoldMallGuideEntity() {
        this(0, 0, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GoldMallGuideEntity copy$default(GoldMallGuideEntity goldMallGuideEntity, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = goldMallGuideEntity.showTime;
        }
        if ((i2 & 2) != 0) {
            i = goldMallGuideEntity.showCount;
        }
        return goldMallGuideEntity.copy(j, i);
    }

    public final long component1() {
        return this.showTime;
    }

    public final int component2() {
        return this.showCount;
    }

    public final GoldMallGuideEntity copy(long j, int i) {
        return new GoldMallGuideEntity(j, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoldMallGuideEntity)) {
            return false;
        }
        GoldMallGuideEntity goldMallGuideEntity = (GoldMallGuideEntity) obj;
        return this.showTime == goldMallGuideEntity.showTime && this.showCount == goldMallGuideEntity.showCount;
    }

    public int hashCode() {
        return (SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.showTime) * 31) + this.showCount;
    }

    public String toString() {
        return "GoldMallGuideEntity(showTime=" + this.showTime + ", showCount=" + this.showCount + ')';
    }

    public GoldMallGuideEntity(long j, int i) {
        this.showTime = j;
        this.showCount = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoldMallGuideEntity(long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? TimeTransformationUtil.Companion.dateToStamp$default(TimeTransformationUtil.Companion, (String) null, 1, (Object) null) : j, (i2 & 2) != 0 ? 0 : i);
    }

    public final long getShowTime() {
        return this.showTime;
    }

    public final void setShowTime(long j) {
        this.showTime = j;
    }

    public final int getShowCount() {
        return this.showCount;
    }

    public final void setShowCount(int i) {
        this.showCount = i;
    }
}
