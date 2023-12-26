package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJJ\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/EnterRequest;", "", "bizId", "", "planId", "courseId", "updateUserInfo", "isParentAudition", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getBizId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCourseId", "getPlanId", "getUpdateUserInfo", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/business/study/study/entity/request/EnterRequest;", "equals", "", "other", "hashCode", "toString", "", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadyRequest.kt */
public final class EnterRequest {
    private final Integer bizId;
    private final Integer courseId;
    private final Integer isParentAudition;
    private final Integer planId;
    private final Integer updateUserInfo;

    public EnterRequest() {
        this((Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ EnterRequest copy$default(EnterRequest enterRequest, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i, Object obj) {
        if ((i & 1) != 0) {
            num = enterRequest.bizId;
        }
        if ((i & 2) != 0) {
            num2 = enterRequest.planId;
        }
        Integer num6 = num2;
        if ((i & 4) != 0) {
            num3 = enterRequest.courseId;
        }
        Integer num7 = num3;
        if ((i & 8) != 0) {
            num4 = enterRequest.updateUserInfo;
        }
        Integer num8 = num4;
        if ((i & 16) != 0) {
            num5 = enterRequest.isParentAudition;
        }
        return enterRequest.copy(num, num6, num7, num8, num5);
    }

    public final Integer component1() {
        return this.bizId;
    }

    public final Integer component2() {
        return this.planId;
    }

    public final Integer component3() {
        return this.courseId;
    }

    public final Integer component4() {
        return this.updateUserInfo;
    }

    public final Integer component5() {
        return this.isParentAudition;
    }

    public final EnterRequest copy(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        return new EnterRequest(num, num2, num3, num4, num5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EnterRequest)) {
            return false;
        }
        EnterRequest enterRequest = (EnterRequest) obj;
        return Intrinsics.areEqual((Object) this.bizId, (Object) enterRequest.bizId) && Intrinsics.areEqual((Object) this.planId, (Object) enterRequest.planId) && Intrinsics.areEqual((Object) this.courseId, (Object) enterRequest.courseId) && Intrinsics.areEqual((Object) this.updateUserInfo, (Object) enterRequest.updateUserInfo) && Intrinsics.areEqual((Object) this.isParentAudition, (Object) enterRequest.isParentAudition);
    }

    public int hashCode() {
        Integer num = this.bizId;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.planId;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.courseId;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.updateUserInfo;
        int hashCode4 = (hashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.isParentAudition;
        if (num5 != null) {
            i = num5.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "EnterRequest(bizId=" + this.bizId + ", planId=" + this.planId + ", courseId=" + this.courseId + ", updateUserInfo=" + this.updateUserInfo + ", isParentAudition=" + this.isParentAudition + ')';
    }

    public EnterRequest(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.bizId = num;
        this.planId = num2;
        this.courseId = num3;
        this.updateUserInfo = num4;
        this.isParentAudition = num5;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EnterRequest(java.lang.Integer r5, java.lang.Integer r6, java.lang.Integer r7, java.lang.Integer r8, java.lang.Integer r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            if (r11 == 0) goto L_0x000b
            r11 = r0
            goto L_0x000c
        L_0x000b:
            r11 = r5
        L_0x000c:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x0012
            r1 = r0
            goto L_0x0013
        L_0x0012:
            r1 = r6
        L_0x0013:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0019
            r2 = r0
            goto L_0x001a
        L_0x0019:
            r2 = r7
        L_0x001a:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x0020
            r3 = r0
            goto L_0x0021
        L_0x0020:
            r3 = r8
        L_0x0021:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0027
            r10 = r0
            goto L_0x0028
        L_0x0027:
            r10 = r9
        L_0x0028:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.business.study.study.entity.request.EnterRequest.<init>(java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Integer getBizId() {
        return this.bizId;
    }

    public final Integer getPlanId() {
        return this.planId;
    }

    public final Integer getCourseId() {
        return this.courseId;
    }

    public final Integer getUpdateUserInfo() {
        return this.updateUserInfo;
    }

    public final Integer isParentAudition() {
        return this.isParentAudition;
    }
}
