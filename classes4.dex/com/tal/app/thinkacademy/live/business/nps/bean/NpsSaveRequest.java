package com.tal.app.thinkacademy.live.business.nps.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/nps/bean/NpsSaveRequest;", "", "planId", "", "tagList", "", "", "score", "remark", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;)V", "getPlanId", "()Ljava/lang/String;", "getRemark", "getScore", "()I", "getTagList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NpsSaveRequest.kt */
public final class NpsSaveRequest {
    private final String planId;
    private final String remark;
    private final int score;
    private final List<Integer> tagList;

    public static /* synthetic */ NpsSaveRequest copy$default(NpsSaveRequest npsSaveRequest, String str, List<Integer> list, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = npsSaveRequest.planId;
        }
        if ((i2 & 2) != 0) {
            list = npsSaveRequest.tagList;
        }
        if ((i2 & 4) != 0) {
            i = npsSaveRequest.score;
        }
        if ((i2 & 8) != 0) {
            str2 = npsSaveRequest.remark;
        }
        return npsSaveRequest.copy(str, list, i, str2);
    }

    public final String component1() {
        return this.planId;
    }

    public final List<Integer> component2() {
        return this.tagList;
    }

    public final int component3() {
        return this.score;
    }

    public final String component4() {
        return this.remark;
    }

    public final NpsSaveRequest copy(String str, List<Integer> list, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "planId");
        return new NpsSaveRequest(str, list, i, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NpsSaveRequest)) {
            return false;
        }
        NpsSaveRequest npsSaveRequest = (NpsSaveRequest) obj;
        return Intrinsics.areEqual(this.planId, npsSaveRequest.planId) && Intrinsics.areEqual(this.tagList, npsSaveRequest.tagList) && this.score == npsSaveRequest.score && Intrinsics.areEqual(this.remark, npsSaveRequest.remark);
    }

    public int hashCode() {
        int hashCode = this.planId.hashCode() * 31;
        List<Integer> list = this.tagList;
        int i = 0;
        int hashCode2 = (((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.score) * 31;
        String str = this.remark;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "NpsSaveRequest(planId=" + this.planId + ", tagList=" + this.tagList + ", score=" + this.score + ", remark=" + this.remark + ')';
    }

    public NpsSaveRequest(String str, List<Integer> list, int i, String str2) {
        Intrinsics.checkNotNullParameter(str, "planId");
        this.planId = str;
        this.tagList = list;
        this.score = i;
        this.remark = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NpsSaveRequest(String str, List list, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : list, i, (i2 & 8) != 0 ? null : str2);
    }

    public final String getPlanId() {
        return this.planId;
    }

    public final List<Integer> getTagList() {
        return this.tagList;
    }

    public final int getScore() {
        return this.score;
    }

    public final String getRemark() {
        return this.remark;
    }
}
