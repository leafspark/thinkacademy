package com.tal.app.thinkacademy.live.business.randomcallnew.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJJ\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\t\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallEndBean;", "", "interactId", "", "pub", "", "type", "recoverVideo", "", "isOnStage", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getInteractId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPub", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRecoverVideo", "getType", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/live/business/randomcallnew/bean/RandomCallEndBean;", "equals", "other", "hashCode", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RandomCallEndBean.kt */
public final class RandomCallEndBean {
    private final String interactId;
    private final Boolean isOnStage;
    private final Integer pub;
    private final Boolean recoverVideo;
    private final String type;

    public static /* synthetic */ RandomCallEndBean copy$default(RandomCallEndBean randomCallEndBean, String str, Integer num, String str2, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = randomCallEndBean.interactId;
        }
        if ((i & 2) != 0) {
            num = randomCallEndBean.pub;
        }
        Integer num2 = num;
        if ((i & 4) != 0) {
            str2 = randomCallEndBean.type;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            bool = randomCallEndBean.recoverVideo;
        }
        Boolean bool3 = bool;
        if ((i & 16) != 0) {
            bool2 = randomCallEndBean.isOnStage;
        }
        return randomCallEndBean.copy(str, num2, str3, bool3, bool2);
    }

    public final String component1() {
        return this.interactId;
    }

    public final Integer component2() {
        return this.pub;
    }

    public final String component3() {
        return this.type;
    }

    public final Boolean component4() {
        return this.recoverVideo;
    }

    public final Boolean component5() {
        return this.isOnStage;
    }

    public final RandomCallEndBean copy(String str, Integer num, String str2, Boolean bool, Boolean bool2) {
        return new RandomCallEndBean(str, num, str2, bool, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RandomCallEndBean)) {
            return false;
        }
        RandomCallEndBean randomCallEndBean = (RandomCallEndBean) obj;
        return Intrinsics.areEqual(this.interactId, randomCallEndBean.interactId) && Intrinsics.areEqual(this.pub, randomCallEndBean.pub) && Intrinsics.areEqual(this.type, randomCallEndBean.type) && Intrinsics.areEqual(this.recoverVideo, randomCallEndBean.recoverVideo) && Intrinsics.areEqual(this.isOnStage, randomCallEndBean.isOnStage);
    }

    public int hashCode() {
        String str = this.interactId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.pub;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.type;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.recoverVideo;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isOnStage;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "RandomCallEndBean(interactId=" + this.interactId + ", pub=" + this.pub + ", type=" + this.type + ", recoverVideo=" + this.recoverVideo + ", isOnStage=" + this.isOnStage + ')';
    }

    public RandomCallEndBean(String str, Integer num, String str2, Boolean bool, Boolean bool2) {
        this.interactId = str;
        this.pub = num;
        this.type = str2;
        this.recoverVideo = bool;
        this.isOnStage = bool2;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final Integer getPub() {
        return this.pub;
    }

    public final String getType() {
        return this.type;
    }

    public final Boolean getRecoverVideo() {
        return this.recoverVideo;
    }

    public final Boolean isOnStage() {
        return this.isOnStage;
    }
}
