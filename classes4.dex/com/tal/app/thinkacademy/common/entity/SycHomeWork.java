package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/SycHomeWork;", "", "paperId", "", "state", "syncType", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getPaperId", "()Ljava/lang/String;", "getState", "getSyncType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/common/entity/SycHomeWork;", "equals", "", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SycHomeWork.kt */
public final class SycHomeWork {
    private final String paperId;
    private final String state;
    private final Integer syncType;

    public static /* synthetic */ SycHomeWork copy$default(SycHomeWork sycHomeWork, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sycHomeWork.paperId;
        }
        if ((i & 2) != 0) {
            str2 = sycHomeWork.state;
        }
        if ((i & 4) != 0) {
            num = sycHomeWork.syncType;
        }
        return sycHomeWork.copy(str, str2, num);
    }

    public final String component1() {
        return this.paperId;
    }

    public final String component2() {
        return this.state;
    }

    public final Integer component3() {
        return this.syncType;
    }

    public final SycHomeWork copy(String str, String str2, Integer num) {
        return new SycHomeWork(str, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SycHomeWork)) {
            return false;
        }
        SycHomeWork sycHomeWork = (SycHomeWork) obj;
        return Intrinsics.areEqual(this.paperId, sycHomeWork.paperId) && Intrinsics.areEqual(this.state, sycHomeWork.state) && Intrinsics.areEqual(this.syncType, sycHomeWork.syncType);
    }

    public int hashCode() {
        String str = this.paperId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.state;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.syncType;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SycHomeWork(paperId=" + this.paperId + ", state=" + this.state + ", syncType=" + this.syncType + ')';
    }

    public SycHomeWork(String str, String str2, Integer num) {
        this.paperId = str;
        this.state = str2;
        this.syncType = num;
    }

    public final String getPaperId() {
        return this.paperId;
    }

    public final String getState() {
        return this.state;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SycHomeWork(String str, String str2, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? 0 : num);
    }

    public final Integer getSyncType() {
        return this.syncType;
    }
}
