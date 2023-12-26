package com.tal.app.thinkacademy.live.business.photosonthewall.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\fJJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u0007\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0014\u0010\u000f¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosOnTheWallState;", "", "countDownTime", "", "startTime", "interactStatus", "", "isSubmit", "", "IsHandUp", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getIsHandUp", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCountDownTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getInteractStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/live/business/photosonthewall/bean/PhotosOnTheWallState;", "equals", "other", "hashCode", "toString", "", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PhotosOnTheWallState.kt */
public final class PhotosOnTheWallState {
    private final Boolean IsHandUp;
    private final Long countDownTime;
    private final Integer interactStatus;
    private final Boolean isSubmit;
    private final Long startTime;

    public PhotosOnTheWallState() {
        this((Long) null, (Long) null, (Integer) null, (Boolean) null, (Boolean) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ PhotosOnTheWallState copy$default(PhotosOnTheWallState photosOnTheWallState, Long l, Long l2, Integer num, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = photosOnTheWallState.countDownTime;
        }
        if ((i & 2) != 0) {
            l2 = photosOnTheWallState.startTime;
        }
        Long l3 = l2;
        if ((i & 4) != 0) {
            num = photosOnTheWallState.interactStatus;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            bool = photosOnTheWallState.isSubmit;
        }
        Boolean bool3 = bool;
        if ((i & 16) != 0) {
            bool2 = photosOnTheWallState.IsHandUp;
        }
        return photosOnTheWallState.copy(l, l3, num2, bool3, bool2);
    }

    public final Long component1() {
        return this.countDownTime;
    }

    public final Long component2() {
        return this.startTime;
    }

    public final Integer component3() {
        return this.interactStatus;
    }

    public final Boolean component4() {
        return this.isSubmit;
    }

    public final Boolean component5() {
        return this.IsHandUp;
    }

    public final PhotosOnTheWallState copy(Long l, Long l2, Integer num, Boolean bool, Boolean bool2) {
        return new PhotosOnTheWallState(l, l2, num, bool, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhotosOnTheWallState)) {
            return false;
        }
        PhotosOnTheWallState photosOnTheWallState = (PhotosOnTheWallState) obj;
        return Intrinsics.areEqual(this.countDownTime, photosOnTheWallState.countDownTime) && Intrinsics.areEqual(this.startTime, photosOnTheWallState.startTime) && Intrinsics.areEqual(this.interactStatus, photosOnTheWallState.interactStatus) && Intrinsics.areEqual(this.isSubmit, photosOnTheWallState.isSubmit) && Intrinsics.areEqual(this.IsHandUp, photosOnTheWallState.IsHandUp);
    }

    public int hashCode() {
        Long l = this.countDownTime;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.startTime;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Integer num = this.interactStatus;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.isSubmit;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.IsHandUp;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "PhotosOnTheWallState(countDownTime=" + this.countDownTime + ", startTime=" + this.startTime + ", interactStatus=" + this.interactStatus + ", isSubmit=" + this.isSubmit + ", IsHandUp=" + this.IsHandUp + ')';
    }

    public PhotosOnTheWallState(Long l, Long l2, Integer num, Boolean bool, Boolean bool2) {
        this.countDownTime = l;
        this.startTime = l2;
        this.interactStatus = num;
        this.isSubmit = bool;
        this.IsHandUp = bool2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PhotosOnTheWallState(java.lang.Long r4, java.lang.Long r5, java.lang.Integer r6, java.lang.Boolean r7, java.lang.Boolean r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            r0 = 0
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            if (r10 == 0) goto L_0x000c
            r10 = r0
            goto L_0x000d
        L_0x000c:
            r10 = r4
        L_0x000d:
            r4 = r9 & 2
            if (r4 == 0) goto L_0x0012
            goto L_0x0013
        L_0x0012:
            r0 = r5
        L_0x0013:
            r4 = r9 & 4
            if (r4 == 0) goto L_0x001c
            r4 = 3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
        L_0x001c:
            r1 = r6
            r4 = r9 & 8
            if (r4 == 0) goto L_0x0026
            r4 = 1
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r4)
        L_0x0026:
            r2 = r7
            r4 = r9 & 16
            if (r4 == 0) goto L_0x0030
            r4 = 0
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)
        L_0x0030:
            r9 = r8
            r4 = r3
            r5 = r10
            r6 = r0
            r7 = r1
            r8 = r2
            r4.<init>(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.live.business.photosonthewall.bean.PhotosOnTheWallState.<init>(java.lang.Long, java.lang.Long, java.lang.Integer, java.lang.Boolean, java.lang.Boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Long getCountDownTime() {
        return this.countDownTime;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final Integer getInteractStatus() {
        return this.interactStatus;
    }

    public final Boolean isSubmit() {
        return this.isSubmit;
    }

    public final Boolean getIsHandUp() {
        return this.IsHandUp;
    }
}
