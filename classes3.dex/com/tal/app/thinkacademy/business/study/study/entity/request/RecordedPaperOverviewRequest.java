package com.tal.app.thinkacademy.business.study.study.entity.request;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J<\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/request/RecordedPaperOverviewRequest;", "", "entityId", "", "platform", "bindType", "", "homeworkType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "getBindType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEntityId", "()Ljava/lang/String;", "getHomeworkType", "()I", "getPlatform", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)Lcom/tal/app/thinkacademy/business/study/study/entity/request/RecordedPaperOverviewRequest;", "equals", "", "other", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RecordedPaperOverviewRequest.kt */
public final class RecordedPaperOverviewRequest {
    private final Integer bindType;
    private final String entityId;
    private final int homeworkType;
    private final String platform;

    public static /* synthetic */ RecordedPaperOverviewRequest copy$default(RecordedPaperOverviewRequest recordedPaperOverviewRequest, String str, String str2, Integer num, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = recordedPaperOverviewRequest.entityId;
        }
        if ((i2 & 2) != 0) {
            str2 = recordedPaperOverviewRequest.platform;
        }
        if ((i2 & 4) != 0) {
            num = recordedPaperOverviewRequest.bindType;
        }
        if ((i2 & 8) != 0) {
            i = recordedPaperOverviewRequest.homeworkType;
        }
        return recordedPaperOverviewRequest.copy(str, str2, num, i);
    }

    public final String component1() {
        return this.entityId;
    }

    public final String component2() {
        return this.platform;
    }

    public final Integer component3() {
        return this.bindType;
    }

    public final int component4() {
        return this.homeworkType;
    }

    public final RecordedPaperOverviewRequest copy(String str, String str2, Integer num, int i) {
        return new RecordedPaperOverviewRequest(str, str2, num, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RecordedPaperOverviewRequest)) {
            return false;
        }
        RecordedPaperOverviewRequest recordedPaperOverviewRequest = (RecordedPaperOverviewRequest) obj;
        return Intrinsics.areEqual((Object) this.entityId, (Object) recordedPaperOverviewRequest.entityId) && Intrinsics.areEqual((Object) this.platform, (Object) recordedPaperOverviewRequest.platform) && Intrinsics.areEqual((Object) this.bindType, (Object) recordedPaperOverviewRequest.bindType) && this.homeworkType == recordedPaperOverviewRequest.homeworkType;
    }

    public int hashCode() {
        String str = this.entityId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.platform;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.bindType;
        if (num != null) {
            i = num.hashCode();
        }
        return ((hashCode2 + i) * 31) + this.homeworkType;
    }

    public String toString() {
        return "RecordedPaperOverviewRequest(entityId=" + this.entityId + ", platform=" + this.platform + ", bindType=" + this.bindType + ", homeworkType=" + this.homeworkType + ')';
    }

    public RecordedPaperOverviewRequest(String str, String str2, Integer num, int i) {
        this.entityId = str;
        this.platform = str2;
        this.bindType = num;
        this.homeworkType = i;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final String getPlatform() {
        return this.platform;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecordedPaperOverviewRequest(String str, String str2, Integer num, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 1 : num, (i2 & 8) != 0 ? 0 : i);
    }

    public final Integer getBindType() {
        return this.bindType;
    }

    public final int getHomeworkType() {
        return this.homeworkType;
    }
}
