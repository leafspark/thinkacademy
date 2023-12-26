package com.tal.app.thinkacademy.common.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J'\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/ParentAuditCloudData;", "", "lookOther", "", "school", "", "(Ljava/lang/String;Ljava/util/List;)V", "getLookOther", "()Ljava/lang/String;", "getSchool", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ParentAuditCloudData.kt */
public final class ParentAuditCloudData {
    private final String lookOther;
    private final List<String> school;

    public static /* synthetic */ ParentAuditCloudData copy$default(ParentAuditCloudData parentAuditCloudData, String str, List<String> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = parentAuditCloudData.lookOther;
        }
        if ((i & 2) != 0) {
            list = parentAuditCloudData.school;
        }
        return parentAuditCloudData.copy(str, list);
    }

    public final String component1() {
        return this.lookOther;
    }

    public final List<String> component2() {
        return this.school;
    }

    public final ParentAuditCloudData copy(String str, List<String> list) {
        return new ParentAuditCloudData(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParentAuditCloudData)) {
            return false;
        }
        ParentAuditCloudData parentAuditCloudData = (ParentAuditCloudData) obj;
        return Intrinsics.areEqual(this.lookOther, parentAuditCloudData.lookOther) && Intrinsics.areEqual(this.school, parentAuditCloudData.school);
    }

    public int hashCode() {
        String str = this.lookOther;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.school;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ParentAuditCloudData(lookOther=" + this.lookOther + ", school=" + this.school + ')';
    }

    public ParentAuditCloudData(String str, List<String> list) {
        this.lookOther = str;
        this.school = list;
    }

    public final String getLookOther() {
        return this.lookOther;
    }

    public final List<String> getSchool() {
        return this.school;
    }
}
