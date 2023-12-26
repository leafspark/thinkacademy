package com.tal.app.thinkacademy.live.business.homework.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JU\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006&"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/homework/entity/HomeworkDetailMsg;", "", "correctStatus", "", "pictureUrl", "", "", "interactId", "tagType", "newCorrectStatus", "rewardType", "rightCoin", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;III)V", "getCorrectStatus", "()I", "setCorrectStatus", "(I)V", "getInteractId", "()Ljava/lang/String;", "getNewCorrectStatus", "getPictureUrl", "()Ljava/util/List;", "getRewardType", "getRightCoin", "getTagType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeworkDetailMsg.kt */
public final class HomeworkDetailMsg {
    private int correctStatus;
    private final String interactId;
    private final int newCorrectStatus;
    private final List<String> pictureUrl;
    private final int rewardType;
    private final int rightCoin;
    private final String tagType;

    public static /* synthetic */ HomeworkDetailMsg copy$default(HomeworkDetailMsg homeworkDetailMsg, int i, List<String> list, String str, String str2, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = homeworkDetailMsg.correctStatus;
        }
        if ((i5 & 2) != 0) {
            list = homeworkDetailMsg.pictureUrl;
        }
        List<String> list2 = list;
        if ((i5 & 4) != 0) {
            str = homeworkDetailMsg.interactId;
        }
        String str3 = str;
        if ((i5 & 8) != 0) {
            str2 = homeworkDetailMsg.tagType;
        }
        String str4 = str2;
        if ((i5 & 16) != 0) {
            i2 = homeworkDetailMsg.newCorrectStatus;
        }
        int i6 = i2;
        if ((i5 & 32) != 0) {
            i3 = homeworkDetailMsg.rewardType;
        }
        int i7 = i3;
        if ((i5 & 64) != 0) {
            i4 = homeworkDetailMsg.rightCoin;
        }
        return homeworkDetailMsg.copy(i, list2, str3, str4, i6, i7, i4);
    }

    public final int component1() {
        return this.correctStatus;
    }

    public final List<String> component2() {
        return this.pictureUrl;
    }

    public final String component3() {
        return this.interactId;
    }

    public final String component4() {
        return this.tagType;
    }

    public final int component5() {
        return this.newCorrectStatus;
    }

    public final int component6() {
        return this.rewardType;
    }

    public final int component7() {
        return this.rightCoin;
    }

    public final HomeworkDetailMsg copy(int i, List<String> list, String str, String str2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(list, "pictureUrl");
        Intrinsics.checkNotNullParameter(str, "interactId");
        Intrinsics.checkNotNullParameter(str2, "tagType");
        return new HomeworkDetailMsg(i, list, str, str2, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HomeworkDetailMsg)) {
            return false;
        }
        HomeworkDetailMsg homeworkDetailMsg = (HomeworkDetailMsg) obj;
        return this.correctStatus == homeworkDetailMsg.correctStatus && Intrinsics.areEqual(this.pictureUrl, homeworkDetailMsg.pictureUrl) && Intrinsics.areEqual(this.interactId, homeworkDetailMsg.interactId) && Intrinsics.areEqual(this.tagType, homeworkDetailMsg.tagType) && this.newCorrectStatus == homeworkDetailMsg.newCorrectStatus && this.rewardType == homeworkDetailMsg.rewardType && this.rightCoin == homeworkDetailMsg.rightCoin;
    }

    public int hashCode() {
        return (((((((((((this.correctStatus * 31) + this.pictureUrl.hashCode()) * 31) + this.interactId.hashCode()) * 31) + this.tagType.hashCode()) * 31) + this.newCorrectStatus) * 31) + this.rewardType) * 31) + this.rightCoin;
    }

    public String toString() {
        return "HomeworkDetailMsg(correctStatus=" + this.correctStatus + ", pictureUrl=" + this.pictureUrl + ", interactId=" + this.interactId + ", tagType=" + this.tagType + ", newCorrectStatus=" + this.newCorrectStatus + ", rewardType=" + this.rewardType + ", rightCoin=" + this.rightCoin + ')';
    }

    public HomeworkDetailMsg(int i, List<String> list, String str, String str2, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(list, "pictureUrl");
        Intrinsics.checkNotNullParameter(str, "interactId");
        Intrinsics.checkNotNullParameter(str2, "tagType");
        this.correctStatus = i;
        this.pictureUrl = list;
        this.interactId = str;
        this.tagType = str2;
        this.newCorrectStatus = i2;
        this.rewardType = i3;
        this.rightCoin = i4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeworkDetailMsg(int i, List list, String str, String str2, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, list, (i5 & 4) != 0 ? "" : str, (i5 & 8) != 0 ? "" : str2, (i5 & 16) != 0 ? -1 : i2, (i5 & 32) != 0 ? 0 : i3, (i5 & 64) != 0 ? 0 : i4);
    }

    public final int getCorrectStatus() {
        return this.correctStatus;
    }

    public final void setCorrectStatus(int i) {
        this.correctStatus = i;
    }

    public final List<String> getPictureUrl() {
        return this.pictureUrl;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final String getTagType() {
        return this.tagType;
    }

    public final int getNewCorrectStatus() {
        return this.newCorrectStatus;
    }

    public final int getRewardType() {
        return this.rewardType;
    }

    public final int getRightCoin() {
        return this.rightCoin;
    }
}
