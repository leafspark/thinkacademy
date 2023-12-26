package com.tal.app.thinkacademy.live.business.exercise;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\bHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/exercise/InteractionData;", "", "countDownTime", "", "quesContent", "", "stuId", "rightCoin", "", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCountDownTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getQuesContent", "()Ljava/lang/String;", "getRightCoin", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStuId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/tal/app/thinkacademy/live/business/exercise/InteractionData;", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InteractionJsBean.kt */
public final class InteractionData {
    private final Long countDownTime;
    private final String quesContent;
    private final Integer rightCoin;
    private final String stuId;

    public static /* synthetic */ InteractionData copy$default(InteractionData interactionData, Long l, String str, String str2, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            l = interactionData.countDownTime;
        }
        if ((i & 2) != 0) {
            str = interactionData.quesContent;
        }
        if ((i & 4) != 0) {
            str2 = interactionData.stuId;
        }
        if ((i & 8) != 0) {
            num = interactionData.rightCoin;
        }
        return interactionData.copy(l, str, str2, num);
    }

    public final Long component1() {
        return this.countDownTime;
    }

    public final String component2() {
        return this.quesContent;
    }

    public final String component3() {
        return this.stuId;
    }

    public final Integer component4() {
        return this.rightCoin;
    }

    public final InteractionData copy(Long l, String str, String str2, Integer num) {
        return new InteractionData(l, str, str2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InteractionData)) {
            return false;
        }
        InteractionData interactionData = (InteractionData) obj;
        return Intrinsics.areEqual(this.countDownTime, interactionData.countDownTime) && Intrinsics.areEqual(this.quesContent, interactionData.quesContent) && Intrinsics.areEqual(this.stuId, interactionData.stuId) && Intrinsics.areEqual(this.rightCoin, interactionData.rightCoin);
    }

    public int hashCode() {
        Long l = this.countDownTime;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.quesContent;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.stuId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.rightCoin;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "InteractionData(countDownTime=" + this.countDownTime + ", quesContent=" + this.quesContent + ", stuId=" + this.stuId + ", rightCoin=" + this.rightCoin + ')';
    }

    public InteractionData(Long l, String str, String str2, Integer num) {
        this.countDownTime = l;
        this.quesContent = str;
        this.stuId = str2;
        this.rightCoin = num;
    }

    public final Long getCountDownTime() {
        return this.countDownTime;
    }

    public final String getQuesContent() {
        return this.quesContent;
    }

    public final Integer getRightCoin() {
        return this.rightCoin;
    }

    public final String getStuId() {
        return this.stuId;
    }
}
