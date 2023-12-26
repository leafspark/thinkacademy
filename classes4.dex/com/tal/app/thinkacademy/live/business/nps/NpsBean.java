package com.tal.app.thinkacademy.live.business.nps;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import com.tal.app.thinkacademy.common.entity.NpsTagConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/nps/NpsBean;", "", "status", "", "npsTime", "", "tagList", "Lcom/tal/app/thinkacademy/common/entity/NpsTagConfig;", "(IJLcom/tal/app/thinkacademy/common/entity/NpsTagConfig;)V", "getNpsTime", "()J", "setNpsTime", "(J)V", "getStatus", "()I", "setStatus", "(I)V", "getTagList", "()Lcom/tal/app/thinkacademy/common/entity/NpsTagConfig;", "setTagList", "(Lcom/tal/app/thinkacademy/common/entity/NpsTagConfig;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NpsBean.kt */
public final class NpsBean {
    private long npsTime;
    private int status;
    private NpsTagConfig tagList;

    public NpsBean() {
        this(0, 0, (NpsTagConfig) null, 7, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ NpsBean copy$default(NpsBean npsBean, int i, long j, NpsTagConfig npsTagConfig, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = npsBean.status;
        }
        if ((i2 & 2) != 0) {
            j = npsBean.npsTime;
        }
        if ((i2 & 4) != 0) {
            npsTagConfig = npsBean.tagList;
        }
        return npsBean.copy(i, j, npsTagConfig);
    }

    public final int component1() {
        return this.status;
    }

    public final long component2() {
        return this.npsTime;
    }

    public final NpsTagConfig component3() {
        return this.tagList;
    }

    public final NpsBean copy(int i, long j, NpsTagConfig npsTagConfig) {
        return new NpsBean(i, j, npsTagConfig);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NpsBean)) {
            return false;
        }
        NpsBean npsBean = (NpsBean) obj;
        return this.status == npsBean.status && this.npsTime == npsBean.npsTime && Intrinsics.areEqual(this.tagList, npsBean.tagList);
    }

    public int hashCode() {
        int m = ((this.status * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.npsTime)) * 31;
        NpsTagConfig npsTagConfig = this.tagList;
        return m + (npsTagConfig == null ? 0 : npsTagConfig.hashCode());
    }

    public String toString() {
        return "NpsBean(status=" + this.status + ", npsTime=" + this.npsTime + ", tagList=" + this.tagList + ')';
    }

    public NpsBean(int i, long j, NpsTagConfig npsTagConfig) {
        this.status = i;
        this.npsTime = j;
        this.tagList = npsTagConfig;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NpsBean(int i, long j, NpsTagConfig npsTagConfig, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0 : j, (i2 & 4) != 0 ? null : npsTagConfig);
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final long getNpsTime() {
        return this.npsTime;
    }

    public final void setNpsTime(long j) {
        this.npsTime = j;
    }

    public final NpsTagConfig getTagList() {
        return this.tagList;
    }

    public final void setTagList(NpsTagConfig npsTagConfig) {
        this.tagList = npsTagConfig;
    }
}
