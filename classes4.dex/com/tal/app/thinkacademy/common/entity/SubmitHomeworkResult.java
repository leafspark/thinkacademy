package com.tal.app.thinkacademy.common.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0002\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006#"}, d2 = {"Lcom/tal/app/thinkacademy/common/entity/SubmitHomeworkResult;", "", "isShow", "", "submitCoin", "", "earlySubmitCoin", "earlyTime", "", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getEarlySubmitCoin", "()Ljava/lang/Integer;", "setEarlySubmitCoin", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getEarlyTime", "()Ljava/lang/String;", "setEarlyTime", "(Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "setShow", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSubmitCoin", "setSubmitCoin", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/tal/app/thinkacademy/common/entity/SubmitHomeworkResult;", "equals", "other", "hashCode", "toString", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitHomeworkResult.kt */
public final class SubmitHomeworkResult {
    private Integer earlySubmitCoin;
    private String earlyTime;
    private Boolean isShow;
    private Integer submitCoin;

    public SubmitHomeworkResult() {
        this((Boolean) null, (Integer) null, (Integer) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SubmitHomeworkResult copy$default(SubmitHomeworkResult submitHomeworkResult, Boolean bool, Integer num, Integer num2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = submitHomeworkResult.isShow;
        }
        if ((i & 2) != 0) {
            num = submitHomeworkResult.submitCoin;
        }
        if ((i & 4) != 0) {
            num2 = submitHomeworkResult.earlySubmitCoin;
        }
        if ((i & 8) != 0) {
            str = submitHomeworkResult.earlyTime;
        }
        return submitHomeworkResult.copy(bool, num, num2, str);
    }

    public final Boolean component1() {
        return this.isShow;
    }

    public final Integer component2() {
        return this.submitCoin;
    }

    public final Integer component3() {
        return this.earlySubmitCoin;
    }

    public final String component4() {
        return this.earlyTime;
    }

    public final SubmitHomeworkResult copy(Boolean bool, Integer num, Integer num2, String str) {
        return new SubmitHomeworkResult(bool, num, num2, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitHomeworkResult)) {
            return false;
        }
        SubmitHomeworkResult submitHomeworkResult = (SubmitHomeworkResult) obj;
        return Intrinsics.areEqual(this.isShow, submitHomeworkResult.isShow) && Intrinsics.areEqual(this.submitCoin, submitHomeworkResult.submitCoin) && Intrinsics.areEqual(this.earlySubmitCoin, submitHomeworkResult.earlySubmitCoin) && Intrinsics.areEqual(this.earlyTime, submitHomeworkResult.earlyTime);
    }

    public int hashCode() {
        Boolean bool = this.isShow;
        int i = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.submitCoin;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.earlySubmitCoin;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.earlyTime;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "SubmitHomeworkResult(isShow=" + this.isShow + ", submitCoin=" + this.submitCoin + ", earlySubmitCoin=" + this.earlySubmitCoin + ", earlyTime=" + this.earlyTime + ')';
    }

    public SubmitHomeworkResult(Boolean bool, Integer num, Integer num2, String str) {
        this.isShow = bool;
        this.submitCoin = num;
        this.earlySubmitCoin = num2;
        this.earlyTime = str;
    }

    public final Boolean isShow() {
        return this.isShow;
    }

    public final void setShow(Boolean bool) {
        this.isShow = bool;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubmitHomeworkResult(Boolean bool, Integer num, Integer num2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : bool, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? 0 : num2, (i & 8) != 0 ? "" : str);
    }

    public final Integer getSubmitCoin() {
        return this.submitCoin;
    }

    public final void setSubmitCoin(Integer num) {
        this.submitCoin = num;
    }

    public final Integer getEarlySubmitCoin() {
        return this.earlySubmitCoin;
    }

    public final void setEarlySubmitCoin(Integer num) {
        this.earlySubmitCoin = num;
    }

    public final String getEarlyTime() {
        return this.earlyTime;
    }

    public final void setEarlyTime(String str) {
        this.earlyTime = str;
    }
}
