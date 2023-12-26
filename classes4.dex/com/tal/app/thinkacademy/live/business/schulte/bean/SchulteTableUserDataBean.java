package com.tal.app.thinkacademy.live.business.schulte.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\b\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableUserDataBean;", "", "bestDuration", "", "curDuration", "isFirst", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBestDuration", "()Ljava/lang/String;", "getCurDuration", "setCurDuration", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableUserDataBean.kt */
public final class SchulteTableUserDataBean {
    private final String bestDuration;
    private String curDuration;
    private final String isFirst;

    public static /* synthetic */ SchulteTableUserDataBean copy$default(SchulteTableUserDataBean schulteTableUserDataBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schulteTableUserDataBean.bestDuration;
        }
        if ((i & 2) != 0) {
            str2 = schulteTableUserDataBean.curDuration;
        }
        if ((i & 4) != 0) {
            str3 = schulteTableUserDataBean.isFirst;
        }
        return schulteTableUserDataBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.bestDuration;
    }

    public final String component2() {
        return this.curDuration;
    }

    public final String component3() {
        return this.isFirst;
    }

    public final SchulteTableUserDataBean copy(String str, String str2, String str3) {
        return new SchulteTableUserDataBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchulteTableUserDataBean)) {
            return false;
        }
        SchulteTableUserDataBean schulteTableUserDataBean = (SchulteTableUserDataBean) obj;
        return Intrinsics.areEqual(this.bestDuration, schulteTableUserDataBean.bestDuration) && Intrinsics.areEqual(this.curDuration, schulteTableUserDataBean.curDuration) && Intrinsics.areEqual(this.isFirst, schulteTableUserDataBean.isFirst);
    }

    public int hashCode() {
        String str = this.bestDuration;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.curDuration;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.isFirst;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "SchulteTableUserDataBean(bestDuration=" + this.bestDuration + ", curDuration=" + this.curDuration + ", isFirst=" + this.isFirst + ')';
    }

    public SchulteTableUserDataBean(String str, String str2, String str3) {
        this.bestDuration = str;
        this.curDuration = str2;
        this.isFirst = str3;
    }

    public final String getBestDuration() {
        return this.bestDuration;
    }

    public final String getCurDuration() {
        return this.curDuration;
    }

    public final void setCurDuration(String str) {
        this.curDuration = str;
    }

    public final String isFirst() {
        return this.isFirst;
    }
}
