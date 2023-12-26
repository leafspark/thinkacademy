package com.tal.app.thinkacademy.live.business.drawing;

import com.tal.app.thinkacademy.live.business.livemessage.entity.LiveMessageCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b-\b\b\u0018\u00002\u00020\u0001Ba\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0002\u0010\u0010J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010*\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J~\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0007HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0018R\u001a\u0010\r\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0012R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$¨\u00066"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/drawing/GraffitiBean;", "", "interactId", "", "pub", "", "totalTime", "", "beginTime", "", "imageUrl", "planId", "realCountDownTime", "isRevise", "dbkey", "isEnd", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;IZLjava/lang/String;Z)V", "getBeginTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDbkey", "()Ljava/lang/String;", "getImageUrl", "getInteractId", "()Z", "setRevise", "(Z)V", "getPlanId", "getPub", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRealCountDownTime", "()I", "setRealCountDownTime", "(I)V", "getTotalTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;IZLjava/lang/String;Z)Lcom/tal/app/thinkacademy/live/business/drawing/GraffitiBean;", "equals", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GraffitiBean.kt */
public final class GraffitiBean {
    private final Long beginTime;
    private final String dbkey;
    private final String imageUrl;
    private final String interactId;
    private final boolean isEnd;
    private boolean isRevise;
    private final Long planId;
    private final Boolean pub;
    private int realCountDownTime;
    private final Integer totalTime;

    public static /* synthetic */ GraffitiBean copy$default(GraffitiBean graffitiBean, String str, Boolean bool, Integer num, Long l, String str2, Long l2, int i, boolean z, String str3, boolean z2, int i2, Object obj) {
        GraffitiBean graffitiBean2 = graffitiBean;
        int i3 = i2;
        return graffitiBean.copy((i3 & 1) != 0 ? graffitiBean2.interactId : str, (i3 & 2) != 0 ? graffitiBean2.pub : bool, (i3 & 4) != 0 ? graffitiBean2.totalTime : num, (i3 & 8) != 0 ? graffitiBean2.beginTime : l, (i3 & 16) != 0 ? graffitiBean2.imageUrl : str2, (i3 & 32) != 0 ? graffitiBean2.planId : l2, (i3 & 64) != 0 ? graffitiBean2.realCountDownTime : i, (i3 & LiveMessageCode.LIVE_BUSINESS_VOTE_ALL_THUMBS_UP) != 0 ? graffitiBean2.isRevise : z, (i3 & 256) != 0 ? graffitiBean2.dbkey : str3, (i3 & 512) != 0 ? graffitiBean2.isEnd : z2);
    }

    public final String component1() {
        return this.interactId;
    }

    public final boolean component10() {
        return this.isEnd;
    }

    public final Boolean component2() {
        return this.pub;
    }

    public final Integer component3() {
        return this.totalTime;
    }

    public final Long component4() {
        return this.beginTime;
    }

    public final String component5() {
        return this.imageUrl;
    }

    public final Long component6() {
        return this.planId;
    }

    public final int component7() {
        return this.realCountDownTime;
    }

    public final boolean component8() {
        return this.isRevise;
    }

    public final String component9() {
        return this.dbkey;
    }

    public final GraffitiBean copy(String str, Boolean bool, Integer num, Long l, String str2, Long l2, int i, boolean z, String str3, boolean z2) {
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str4, "dbkey");
        return new GraffitiBean(str, bool, num, l, str2, l2, i, z, str4, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GraffitiBean)) {
            return false;
        }
        GraffitiBean graffitiBean = (GraffitiBean) obj;
        return Intrinsics.areEqual(this.interactId, graffitiBean.interactId) && Intrinsics.areEqual(this.pub, graffitiBean.pub) && Intrinsics.areEqual(this.totalTime, graffitiBean.totalTime) && Intrinsics.areEqual(this.beginTime, graffitiBean.beginTime) && Intrinsics.areEqual(this.imageUrl, graffitiBean.imageUrl) && Intrinsics.areEqual(this.planId, graffitiBean.planId) && this.realCountDownTime == graffitiBean.realCountDownTime && this.isRevise == graffitiBean.isRevise && Intrinsics.areEqual(this.dbkey, graffitiBean.dbkey) && this.isEnd == graffitiBean.isEnd;
    }

    public int hashCode() {
        String str = this.interactId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.pub;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num = this.totalTime;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Long l = this.beginTime;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        String str2 = this.imageUrl;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l2 = this.planId;
        if (l2 != null) {
            i = l2.hashCode();
        }
        int i2 = (((hashCode5 + i) * 31) + this.realCountDownTime) * 31;
        boolean z = this.isRevise;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode6 = (((i2 + (z ? 1 : 0)) * 31) + this.dbkey.hashCode()) * 31;
        boolean z3 = this.isEnd;
        if (!z3) {
            z2 = z3;
        }
        return hashCode6 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "GraffitiBean(interactId=" + this.interactId + ", pub=" + this.pub + ", totalTime=" + this.totalTime + ", beginTime=" + this.beginTime + ", imageUrl=" + this.imageUrl + ", planId=" + this.planId + ", realCountDownTime=" + this.realCountDownTime + ", isRevise=" + this.isRevise + ", dbkey=" + this.dbkey + ", isEnd=" + this.isEnd + ')';
    }

    public GraffitiBean(String str, Boolean bool, Integer num, Long l, String str2, Long l2, int i, boolean z, String str3, boolean z2) {
        Intrinsics.checkNotNullParameter(str3, "dbkey");
        this.interactId = str;
        this.pub = bool;
        this.totalTime = num;
        this.beginTime = l;
        this.imageUrl = str2;
        this.planId = l2;
        this.realCountDownTime = i;
        this.isRevise = z;
        this.dbkey = str3;
        this.isEnd = z2;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final Boolean getPub() {
        return this.pub;
    }

    public final Long getBeginTime() {
        return this.beginTime;
    }

    public final Integer getTotalTime() {
        return this.totalTime;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final Long getPlanId() {
        return this.planId;
    }

    public final int getRealCountDownTime() {
        return this.realCountDownTime;
    }

    public final boolean isRevise() {
        return this.isRevise;
    }

    public final void setRealCountDownTime(int i) {
        this.realCountDownTime = i;
    }

    public final void setRevise(boolean z) {
        this.isRevise = z;
    }

    public final String getDbkey() {
        return this.dbkey;
    }

    public final boolean isEnd() {
        return this.isEnd;
    }
}
