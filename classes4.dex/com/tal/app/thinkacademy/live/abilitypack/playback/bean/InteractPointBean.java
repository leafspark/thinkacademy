package com.tal.app.thinkacademy.live.abilitypack.playback.bean;

import com.kwai.koom.javaoom.monitor.tracker.model.SystemInfo$JavaHeap$;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/abilitypack/playback/bean/InteractPointBean;", "", "ircType", "", "interactId", "pub", "", "beginTime", "", "ircMsg", "(Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;)V", "getBeginTime", "()J", "getInteractId", "()Ljava/lang/String;", "getIrcMsg", "getIrcType", "getPub", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractPointBean.kt */
public final class InteractPointBean {
    private final long beginTime;
    private final String interactId;
    private final String ircMsg;
    private final String ircType;
    private final boolean pub;

    public static /* synthetic */ InteractPointBean copy$default(InteractPointBean interactPointBean, String str, String str2, boolean z, long j, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = interactPointBean.ircType;
        }
        if ((i & 2) != 0) {
            str2 = interactPointBean.interactId;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            z = interactPointBean.pub;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            j = interactPointBean.beginTime;
        }
        long j2 = j;
        if ((i & 16) != 0) {
            str3 = interactPointBean.ircMsg;
        }
        return interactPointBean.copy(str, str4, z2, j2, str3);
    }

    public final String component1() {
        return this.ircType;
    }

    public final String component2() {
        return this.interactId;
    }

    public final boolean component3() {
        return this.pub;
    }

    public final long component4() {
        return this.beginTime;
    }

    public final String component5() {
        return this.ircMsg;
    }

    public final InteractPointBean copy(String str, String str2, boolean z, long j, String str3) {
        Intrinsics.checkNotNullParameter(str, "ircType");
        Intrinsics.checkNotNullParameter(str2, "interactId");
        Intrinsics.checkNotNullParameter(str3, "ircMsg");
        return new InteractPointBean(str, str2, z, j, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InteractPointBean)) {
            return false;
        }
        InteractPointBean interactPointBean = (InteractPointBean) obj;
        return Intrinsics.areEqual(this.ircType, interactPointBean.ircType) && Intrinsics.areEqual(this.interactId, interactPointBean.interactId) && this.pub == interactPointBean.pub && this.beginTime == interactPointBean.beginTime && Intrinsics.areEqual(this.ircMsg, interactPointBean.ircMsg);
    }

    public int hashCode() {
        int hashCode = ((this.ircType.hashCode() * 31) + this.interactId.hashCode()) * 31;
        boolean z = this.pub;
        if (z) {
            z = true;
        }
        return ((((hashCode + (z ? 1 : 0)) * 31) + SystemInfo$JavaHeap$.ExternalSyntheticBackport0.m(this.beginTime)) * 31) + this.ircMsg.hashCode();
    }

    public String toString() {
        return "InteractPointBean(ircType=" + this.ircType + ", interactId=" + this.interactId + ", pub=" + this.pub + ", beginTime=" + this.beginTime + ", ircMsg=" + this.ircMsg + ')';
    }

    public InteractPointBean(String str, String str2, boolean z, long j, String str3) {
        Intrinsics.checkNotNullParameter(str, "ircType");
        Intrinsics.checkNotNullParameter(str2, "interactId");
        Intrinsics.checkNotNullParameter(str3, "ircMsg");
        this.ircType = str;
        this.interactId = str2;
        this.pub = z;
        this.beginTime = j;
        this.ircMsg = str3;
    }

    public final String getIrcType() {
        return this.ircType;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final boolean getPub() {
        return this.pub;
    }

    public final long getBeginTime() {
        return this.beginTime;
    }

    public final String getIrcMsg() {
        return this.ircMsg;
    }
}
