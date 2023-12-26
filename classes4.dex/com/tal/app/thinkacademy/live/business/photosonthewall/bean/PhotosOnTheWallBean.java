package com.tal.app.thinkacademy.live.business.photosonthewall.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JT\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0018\u001a\u00020\bJ\t\u0010#\u001a\u00020\u000bHÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0018\u0010\u000e¨\u0006%"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosOnTheWallBean;", "", "pub", "", "planId", "", "interactId", "totalTime", "", "beginTime", "rewardType", "", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;I)V", "getBeginTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInteractId", "()Ljava/lang/String;", "getPlanId", "getPub", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRewardType", "()I", "getTotalTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;I)Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosOnTheWallBean;", "equals", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotosOnTheWallBean.kt */
public final class PhotosOnTheWallBean {
    private final Long beginTime;
    private final String interactId;
    private final String planId;
    private final Boolean pub;
    private final int rewardType;
    private final Long totalTime;

    public PhotosOnTheWallBean() {
        this((Boolean) null, (String) null, (String) null, (Long) null, (Long) null, 0, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PhotosOnTheWallBean copy$default(PhotosOnTheWallBean photosOnTheWallBean, Boolean bool, String str, String str2, Long l, Long l2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = photosOnTheWallBean.pub;
        }
        if ((i2 & 2) != 0) {
            str = photosOnTheWallBean.planId;
        }
        String str3 = str;
        if ((i2 & 4) != 0) {
            str2 = photosOnTheWallBean.interactId;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            l = photosOnTheWallBean.totalTime;
        }
        Long l3 = l;
        if ((i2 & 16) != 0) {
            l2 = photosOnTheWallBean.beginTime;
        }
        Long l4 = l2;
        if ((i2 & 32) != 0) {
            i = photosOnTheWallBean.rewardType;
        }
        return photosOnTheWallBean.copy(bool, str3, str4, l3, l4, i);
    }

    public final Boolean component1() {
        return this.pub;
    }

    public final String component2() {
        return this.planId;
    }

    public final String component3() {
        return this.interactId;
    }

    public final Long component4() {
        return this.totalTime;
    }

    public final Long component5() {
        return this.beginTime;
    }

    public final int component6() {
        return this.rewardType;
    }

    public final PhotosOnTheWallBean copy(Boolean bool, String str, String str2, Long l, Long l2, int i) {
        return new PhotosOnTheWallBean(bool, str, str2, l, l2, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotosOnTheWallBean)) {
            return false;
        }
        PhotosOnTheWallBean photosOnTheWallBean = (PhotosOnTheWallBean) obj;
        return Intrinsics.areEqual(this.pub, photosOnTheWallBean.pub) && Intrinsics.areEqual(this.planId, photosOnTheWallBean.planId) && Intrinsics.areEqual(this.interactId, photosOnTheWallBean.interactId) && Intrinsics.areEqual(this.totalTime, photosOnTheWallBean.totalTime) && Intrinsics.areEqual(this.beginTime, photosOnTheWallBean.beginTime) && this.rewardType == photosOnTheWallBean.rewardType;
    }

    public int hashCode() {
        Boolean bool = this.pub;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.planId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.interactId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.totalTime;
        int hashCode4 = (hashCode3 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.beginTime;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return ((hashCode4 + i) * 31) + this.rewardType;
    }

    public String toString() {
        return "PhotosOnTheWallBean(pub=" + this.pub + ", planId=" + this.planId + ", interactId=" + this.interactId + ", totalTime=" + this.totalTime + ", beginTime=" + this.beginTime + ", rewardType=" + this.rewardType + ')';
    }

    public PhotosOnTheWallBean(Boolean bool, String str, String str2, Long l, Long l2, int i) {
        this.pub = bool;
        this.planId = str;
        this.interactId = str2;
        this.totalTime = l;
        this.beginTime = l2;
        this.rewardType = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PhotosOnTheWallBean(java.lang.Boolean r6, java.lang.String r7, java.lang.String r8, java.lang.Long r9, java.lang.Long r10, int r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            r0 = 0
            if (r13 == 0) goto L_0x0009
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r0)
        L_0x0009:
            r13 = r12 & 2
            java.lang.String r1 = ""
            if (r13 == 0) goto L_0x0011
            r13 = r1
            goto L_0x0012
        L_0x0011:
            r13 = r7
        L_0x0012:
            r7 = r12 & 4
            if (r7 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = r8
        L_0x0018:
            r7 = r12 & 8
            r2 = 0
            if (r7 == 0) goto L_0x0022
            java.lang.Long r9 = java.lang.Long.valueOf(r2)
        L_0x0022:
            r4 = r9
            r7 = r12 & 16
            if (r7 == 0) goto L_0x002b
            java.lang.Long r10 = java.lang.Long.valueOf(r2)
        L_0x002b:
            r2 = r10
            r7 = r12 & 32
            if (r7 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r0 = r11
        L_0x0032:
            r7 = r5
            r8 = r6
            r9 = r13
            r10 = r1
            r11 = r4
            r12 = r2
            r13 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosOnTheWallBean.<init>(java.lang.Boolean, java.lang.String, java.lang.String, java.lang.Long, java.lang.Long, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Boolean getPub() {
        return this.pub;
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    /* renamed from: getTotalTime  reason: collision with other method in class */
    public final Long m353getTotalTime() {
        return this.totalTime;
    }

    public final Long getBeginTime() {
        return this.beginTime;
    }

    public final int getRewardType() {
        return this.rewardType;
    }

    public final long getTotalTime() {
        Long l = this.totalTime;
        return (l == null ? 0 : l.longValue()) * ((long) 1000);
    }
}
