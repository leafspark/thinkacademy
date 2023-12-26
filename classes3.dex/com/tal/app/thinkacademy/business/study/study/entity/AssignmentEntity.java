package com.tal.app.thinkacademy.business.study.study.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0006HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006$"}, d2 = {"Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;", "Ljava/io/Serializable;", "title", "", "endTime", "status", "", "url", "sourceType", "jumpParams", "Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;)V", "getEndTime", "()Ljava/lang/String;", "getJumpParams", "()Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;", "getSourceType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/tal/app/thinkacademy/business/study/study/entity/JumpParamsEntity;)Lcom/tal/app/thinkacademy/business/study/study/entity/AssignmentEntity;", "equals", "", "other", "", "hashCode", "toString", "bus_study_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClassCalendarEntity.kt */
public final class AssignmentEntity implements Serializable {
    private final String endTime;
    private final JumpParamsEntity jumpParams;
    private final Integer sourceType;
    private final Integer status;
    private final String title;
    private final String url;

    public static /* synthetic */ AssignmentEntity copy$default(AssignmentEntity assignmentEntity, String str, String str2, Integer num, String str3, Integer num2, JumpParamsEntity jumpParamsEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = assignmentEntity.title;
        }
        if ((i & 2) != 0) {
            str2 = assignmentEntity.endTime;
        }
        String str4 = str2;
        if ((i & 4) != 0) {
            num = assignmentEntity.status;
        }
        Integer num3 = num;
        if ((i & 8) != 0) {
            str3 = assignmentEntity.url;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            num2 = assignmentEntity.sourceType;
        }
        Integer num4 = num2;
        if ((i & 32) != 0) {
            jumpParamsEntity = assignmentEntity.jumpParams;
        }
        return assignmentEntity.copy(str, str4, num3, str5, num4, jumpParamsEntity);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.endTime;
    }

    public final Integer component3() {
        return this.status;
    }

    public final String component4() {
        return this.url;
    }

    public final Integer component5() {
        return this.sourceType;
    }

    public final JumpParamsEntity component6() {
        return this.jumpParams;
    }

    public final AssignmentEntity copy(String str, String str2, Integer num, String str3, Integer num2, JumpParamsEntity jumpParamsEntity) {
        return new AssignmentEntity(str, str2, num, str3, num2, jumpParamsEntity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AssignmentEntity)) {
            return false;
        }
        AssignmentEntity assignmentEntity = (AssignmentEntity) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) assignmentEntity.title) && Intrinsics.areEqual((Object) this.endTime, (Object) assignmentEntity.endTime) && Intrinsics.areEqual((Object) this.status, (Object) assignmentEntity.status) && Intrinsics.areEqual((Object) this.url, (Object) assignmentEntity.url) && Intrinsics.areEqual((Object) this.sourceType, (Object) assignmentEntity.sourceType) && Intrinsics.areEqual((Object) this.jumpParams, (Object) assignmentEntity.jumpParams);
    }

    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.endTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.status;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.url;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.sourceType;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        JumpParamsEntity jumpParamsEntity = this.jumpParams;
        if (jumpParamsEntity != null) {
            i = jumpParamsEntity.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "AssignmentEntity(title=" + this.title + ", endTime=" + this.endTime + ", status=" + this.status + ", url=" + this.url + ", sourceType=" + this.sourceType + ", jumpParams=" + this.jumpParams + ')';
    }

    public AssignmentEntity(String str, String str2, Integer num, String str3, Integer num2, JumpParamsEntity jumpParamsEntity) {
        this.title = str;
        this.endTime = str2;
        this.status = num;
        this.url = str3;
        this.sourceType = num2;
        this.jumpParams = jumpParamsEntity;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AssignmentEntity(String str, String str2, Integer num, String str3, Integer num2, JumpParamsEntity jumpParamsEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0 : num, str3, (i & 16) != 0 ? 0 : num2, jumpParamsEntity);
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Integer getSourceType() {
        return this.sourceType;
    }

    public final JumpParamsEntity getJumpParams() {
        return this.jumpParams;
    }
}
