package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/PaperOverviewRequest;", "", "paperId", "", "planId", "", "homeworkType", "classId", "platform", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getClassId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHomeworkType", "getPaperId", "()Ljava/lang/String;", "getPlanId", "getPlatform", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/business/study/study/entity/request/PaperOverviewRequest;", "equals", "", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PaperOverviewRequest.kt */
public final class PaperOverviewRequest {
    private final Integer classId;
    private final Integer homeworkType;
    private final String paperId;
    private final Integer planId;
    private final String platform;

    public static /* synthetic */ PaperOverviewRequest copy$default(PaperOverviewRequest paperOverviewRequest, String str, Integer num, Integer num2, Integer num3, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = paperOverviewRequest.paperId;
        }
        if ((i & 2) != 0) {
            num = paperOverviewRequest.planId;
        }
        Integer num4 = num;
        if ((i & 4) != 0) {
            num2 = paperOverviewRequest.homeworkType;
        }
        Integer num5 = num2;
        if ((i & 8) != 0) {
            num3 = paperOverviewRequest.classId;
        }
        Integer num6 = num3;
        if ((i & 16) != 0) {
            str2 = paperOverviewRequest.platform;
        }
        return paperOverviewRequest.copy(str, num4, num5, num6, str2);
    }

    public final String component1() {
        return this.paperId;
    }

    public final Integer component2() {
        return this.planId;
    }

    public final Integer component3() {
        return this.homeworkType;
    }

    public final Integer component4() {
        return this.classId;
    }

    public final String component5() {
        return this.platform;
    }

    public final PaperOverviewRequest copy(String str, Integer num, Integer num2, Integer num3, String str2) {
        return new PaperOverviewRequest(str, num, num2, num3, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaperOverviewRequest)) {
            return false;
        }
        PaperOverviewRequest paperOverviewRequest = (PaperOverviewRequest) obj;
        return Intrinsics.areEqual((Object) this.paperId, (Object) paperOverviewRequest.paperId) && Intrinsics.areEqual((Object) this.planId, (Object) paperOverviewRequest.planId) && Intrinsics.areEqual((Object) this.homeworkType, (Object) paperOverviewRequest.homeworkType) && Intrinsics.areEqual((Object) this.classId, (Object) paperOverviewRequest.classId) && Intrinsics.areEqual((Object) this.platform, (Object) paperOverviewRequest.platform);
    }

    public int hashCode() {
        String str = this.paperId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.planId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.homeworkType;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.classId;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.platform;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "PaperOverviewRequest(paperId=" + this.paperId + ", planId=" + this.planId + ", homeworkType=" + this.homeworkType + ", classId=" + this.classId + ", platform=" + this.platform + ')';
    }

    public PaperOverviewRequest(String str, Integer num, Integer num2, Integer num3, String str2) {
        this.paperId = str;
        this.planId = num;
        this.homeworkType = num2;
        this.classId = num3;
        this.platform = str2;
    }

    public final String getPaperId() {
        return this.paperId;
    }

    public final Integer getPlanId() {
        return this.planId;
    }

    public final Integer getHomeworkType() {
        return this.homeworkType;
    }

    public final Integer getClassId() {
        return this.classId;
    }

    public final String getPlatform() {
        return this.platform;
    }
}
