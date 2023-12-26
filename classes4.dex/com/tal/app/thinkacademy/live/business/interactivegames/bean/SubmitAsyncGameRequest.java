package com.tal.app.thinkacademy.live.business.interactivegames.bean;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J\u0011\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003JV\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u0014¨\u0006,"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/SubmitAsyncGameRequest;", "", "planId", "", "interactId", "", "classId", "", "gameImages", "", "userAnswerResult", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getClassId", "()Ljava/lang/Integer;", "setClassId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGameImages", "()Ljava/util/List;", "setGameImages", "(Ljava/util/List;)V", "getInteractId", "()Ljava/lang/String;", "setInteractId", "(Ljava/lang/String;)V", "getPlanId", "()Ljava/lang/Long;", "setPlanId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getUserAnswerResult", "setUserAnswerResult", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lcom/tal/app/thinkacademy/live/business/interactivegames/bean/SubmitAsyncGameRequest;", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SubmitAsyncGameRequest.kt */
public final class SubmitAsyncGameRequest {
    private Integer classId;
    private List<String> gameImages;
    private String interactId;
    private Long planId;
    private List<Integer> userAnswerResult;

    public static /* synthetic */ SubmitAsyncGameRequest copy$default(SubmitAsyncGameRequest submitAsyncGameRequest, Long l, String str, Integer num, List<String> list, List<Integer> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            l = submitAsyncGameRequest.planId;
        }
        if ((i & 2) != 0) {
            str = submitAsyncGameRequest.interactId;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            num = submitAsyncGameRequest.classId;
        }
        Integer num2 = num;
        if ((i & 8) != 0) {
            list = submitAsyncGameRequest.gameImages;
        }
        List<String> list3 = list;
        if ((i & 16) != 0) {
            list2 = submitAsyncGameRequest.userAnswerResult;
        }
        return submitAsyncGameRequest.copy(l, str2, num2, list3, list2);
    }

    public final Long component1() {
        return this.planId;
    }

    public final String component2() {
        return this.interactId;
    }

    public final Integer component3() {
        return this.classId;
    }

    public final List<String> component4() {
        return this.gameImages;
    }

    public final List<Integer> component5() {
        return this.userAnswerResult;
    }

    public final SubmitAsyncGameRequest copy(Long l, String str, Integer num, List<String> list, List<Integer> list2) {
        return new SubmitAsyncGameRequest(l, str, num, list, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubmitAsyncGameRequest)) {
            return false;
        }
        SubmitAsyncGameRequest submitAsyncGameRequest = (SubmitAsyncGameRequest) obj;
        return Intrinsics.areEqual(this.planId, submitAsyncGameRequest.planId) && Intrinsics.areEqual(this.interactId, submitAsyncGameRequest.interactId) && Intrinsics.areEqual(this.classId, submitAsyncGameRequest.classId) && Intrinsics.areEqual(this.gameImages, submitAsyncGameRequest.gameImages) && Intrinsics.areEqual(this.userAnswerResult, submitAsyncGameRequest.userAnswerResult);
    }

    public int hashCode() {
        Long l = this.planId;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.interactId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.classId;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<String> list = this.gameImages;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<Integer> list2 = this.userAnswerResult;
        if (list2 != null) {
            i = list2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "SubmitAsyncGameRequest(planId=" + this.planId + ", interactId=" + this.interactId + ", classId=" + this.classId + ", gameImages=" + this.gameImages + ", userAnswerResult=" + this.userAnswerResult + ')';
    }

    public SubmitAsyncGameRequest(Long l, String str, Integer num, List<String> list, List<Integer> list2) {
        this.planId = l;
        this.interactId = str;
        this.classId = num;
        this.gameImages = list;
        this.userAnswerResult = list2;
    }

    public final Long getPlanId() {
        return this.planId;
    }

    public final void setPlanId(Long l) {
        this.planId = l;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final void setInteractId(String str) {
        this.interactId = str;
    }

    public final Integer getClassId() {
        return this.classId;
    }

    public final void setClassId(Integer num) {
        this.classId = num;
    }

    public final List<String> getGameImages() {
        return this.gameImages;
    }

    public final void setGameImages(List<String> list) {
        this.gameImages = list;
    }

    public final List<Integer> getUserAnswerResult() {
        return this.userAnswerResult;
    }

    public final void setUserAnswerResult(List<Integer> list) {
        this.userAnswerResult = list;
    }
}
