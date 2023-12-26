package com.tal.app.thinkacademy.live.business.interactivegames.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003JJ\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0002\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006!"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameJsSubmitData;", "", "isRight", "", "rightRate", "userAnswer", "", "", "userAnswerResult", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "()Ljava/lang/Integer;", "setRight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRightRate", "setRightRate", "getUserAnswer", "()Ljava/util/List;", "setUserAnswer", "(Ljava/util/List;)V", "getUserAnswerResult", "setUserAnswerResult", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/GameJsSubmitData;", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: GameJsSubmitData.kt */
public final class GameJsSubmitData {
    private Integer isRight;
    private Integer rightRate;
    private List<String> userAnswer;
    private List<Integer> userAnswerResult;

    public GameJsSubmitData() {
        this((Integer) null, (Integer) null, (List) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GameJsSubmitData copy$default(GameJsSubmitData gameJsSubmitData, Integer num, Integer num2, List<String> list, List<Integer> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = gameJsSubmitData.isRight;
        }
        if ((i & 2) != 0) {
            num2 = gameJsSubmitData.rightRate;
        }
        if ((i & 4) != 0) {
            list = gameJsSubmitData.userAnswer;
        }
        if ((i & 8) != 0) {
            list2 = gameJsSubmitData.userAnswerResult;
        }
        return gameJsSubmitData.copy(num, num2, list, list2);
    }

    public final Integer component1() {
        return this.isRight;
    }

    public final Integer component2() {
        return this.rightRate;
    }

    public final List<String> component3() {
        return this.userAnswer;
    }

    public final List<Integer> component4() {
        return this.userAnswerResult;
    }

    public final GameJsSubmitData copy(Integer num, Integer num2, List<String> list, List<Integer> list2) {
        return new GameJsSubmitData(num, num2, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GameJsSubmitData)) {
            return false;
        }
        GameJsSubmitData gameJsSubmitData = (GameJsSubmitData) obj;
        return Intrinsics.areEqual(this.isRight, gameJsSubmitData.isRight) && Intrinsics.areEqual(this.rightRate, gameJsSubmitData.rightRate) && Intrinsics.areEqual(this.userAnswer, gameJsSubmitData.userAnswer) && Intrinsics.areEqual(this.userAnswerResult, gameJsSubmitData.userAnswerResult);
    }

    public int hashCode() {
        Integer num = this.isRight;
        int i = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.rightRate;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        List<String> list = this.userAnswer;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<Integer> list2 = this.userAnswerResult;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "GameJsSubmitData(isRight=" + this.isRight + ", rightRate=" + this.rightRate + ", userAnswer=" + this.userAnswer + ", userAnswerResult=" + this.userAnswerResult + ')';
    }

    public GameJsSubmitData(Integer num, Integer num2, List<String> list, List<Integer> list2) {
        this.isRight = num;
        this.rightRate = num2;
        this.userAnswer = list;
        this.userAnswerResult = list2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GameJsSubmitData(Integer num, Integer num2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? 0 : num2, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2);
    }

    public final Integer isRight() {
        return this.isRight;
    }

    public final void setRight(Integer num) {
        this.isRight = num;
    }

    public final Integer getRightRate() {
        return this.rightRate;
    }

    public final void setRightRate(Integer num) {
        this.rightRate = num;
    }

    public final List<String> getUserAnswer() {
        return this.userAnswer;
    }

    public final void setUserAnswer(List<String> list) {
        this.userAnswer = list;
    }

    public final List<Integer> getUserAnswerResult() {
        return this.userAnswerResult;
    }

    public final void setUserAnswerResult(List<Integer> list) {
        this.userAnswerResult = list;
    }
}
