package com.tal.app.thinkacademy.live.business.schulte.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJJ\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableStartBean;", "", "interactId", "", "pub", "", "level", "category", "random", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getCategory", "()Ljava/lang/String;", "getInteractId", "getLevel", "getPub", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getRandom", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/tal/app/thinkacademy/live/business/schulte/bean/SchulteTableStartBean;", "equals", "other", "hashCode", "", "toString", "bus_livebusiness_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SchulteTableStartBean.kt */
public final class SchulteTableStartBean {
    private final String category;
    private final String interactId;
    private final String level;
    private final Boolean pub;
    private final Boolean random;

    public static /* synthetic */ SchulteTableStartBean copy$default(SchulteTableStartBean schulteTableStartBean, String str, Boolean bool, String str2, String str3, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = schulteTableStartBean.interactId;
        }
        if ((i & 2) != 0) {
            bool = schulteTableStartBean.pub;
        }
        Boolean bool3 = bool;
        if ((i & 4) != 0) {
            str2 = schulteTableStartBean.level;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = schulteTableStartBean.category;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            bool2 = schulteTableStartBean.random;
        }
        return schulteTableStartBean.copy(str, bool3, str4, str5, bool2);
    }

    public final String component1() {
        return this.interactId;
    }

    public final Boolean component2() {
        return this.pub;
    }

    public final String component3() {
        return this.level;
    }

    public final String component4() {
        return this.category;
    }

    public final Boolean component5() {
        return this.random;
    }

    public final SchulteTableStartBean copy(String str, Boolean bool, String str2, String str3, Boolean bool2) {
        return new SchulteTableStartBean(str, bool, str2, str3, bool2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SchulteTableStartBean)) {
            return false;
        }
        SchulteTableStartBean schulteTableStartBean = (SchulteTableStartBean) obj;
        return Intrinsics.areEqual(this.interactId, schulteTableStartBean.interactId) && Intrinsics.areEqual(this.pub, schulteTableStartBean.pub) && Intrinsics.areEqual(this.level, schulteTableStartBean.level) && Intrinsics.areEqual(this.category, schulteTableStartBean.category) && Intrinsics.areEqual(this.random, schulteTableStartBean.random);
    }

    public int hashCode() {
        String str = this.interactId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.pub;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.level;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.category;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool2 = this.random;
        if (bool2 != null) {
            i = bool2.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "SchulteTableStartBean(interactId=" + this.interactId + ", pub=" + this.pub + ", level=" + this.level + ", category=" + this.category + ", random=" + this.random + ')';
    }

    public SchulteTableStartBean(String str, Boolean bool, String str2, String str3, Boolean bool2) {
        this.interactId = str;
        this.pub = bool;
        this.level = str2;
        this.category = str3;
        this.random = bool2;
    }

    public final String getInteractId() {
        return this.interactId;
    }

    public final Boolean getPub() {
        return this.pub;
    }

    public final String getLevel() {
        return this.level;
    }

    public final String getCategory() {
        return this.category;
    }

    public final Boolean getRandom() {
        return this.random;
    }
}
